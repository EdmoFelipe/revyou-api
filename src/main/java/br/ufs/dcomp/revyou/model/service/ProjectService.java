package br.ufs.dcomp.revyou.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.ufs.dcomp.revyou.common.message.ErrorMessage;
import br.ufs.dcomp.revyou.core.FarmsException;
import br.ufs.dcomp.revyou.enums.ReviewEnum;
import br.ufs.dcomp.revyou.model.dao.InstitutionDao;
import br.ufs.dcomp.revyou.model.dao.ProjectDao;
import br.ufs.dcomp.revyou.model.dto.ProjectCreateDto;
import br.ufs.dcomp.revyou.model.dto.ProjectCreatedDto;
import br.ufs.dcomp.revyou.model.entity.Institution;
import br.ufs.dcomp.revyou.model.entity.Project;

/**
 * @author farms
 *
 */
@Component
public class ProjectService {

	@Autowired
	private ProjectDao projectDao;
	@Autowired
	private InstitutionDao institutionDao;

	/**
	 * Save a project
	 * 
	 * @param projectCreateDto
	 * @return ProjectCreatedDto
	 * @throws FarmsException
	 */
	@Transactional(rollbackFor = FarmsException.class)
	public Boolean save(ProjectCreateDto projectCreateDto) throws FarmsException {
		Project project_verify = projectDao.getByDsKey(projectCreateDto.getDsKey());

		if (project_verify != null) {
			throw new FarmsException(ErrorMessage.KEY_ALREADY_IN_USE);
		}

		Project project = new Project();
		project.setDsKey(projectCreateDto.getDsKey());
		project.setDsTitle(projectCreateDto.getDsTitle());
		project.setDsProject(projectCreateDto.getDsProject());
		project.setTpReview(ReviewEnum.fromCode(projectCreateDto.getTpReview()));
		projectDao.save(project);

		Institution institution = new Institution();
		institution.setProject(project);
		institution.setCountry(projectCreateDto.getCountry());
		institution.setDsAbbreviation(projectCreateDto.getDsAbbreviation());
		institution.setNmInstitution(projectCreateDto.getNmInstitution());
		institutionDao.save(institution);

		return true;
	}

	/**
	 * Update a project
	 * 
	 * @param projectCreatedDto
	 * @return boolean
	 * @throws FarmsException
	 */
	@Transactional(rollbackFor = FarmsException.class)
	public boolean update(ProjectCreatedDto projectCreatedDto) throws FarmsException {
		Project project = projectDao.get(projectCreatedDto.getIdProject());
		project.setDsTitle(projectCreatedDto.getDsTitle());
		project.setDsProject(projectCreatedDto.getDsProject());
		project.setTpReview(ReviewEnum.fromCode(projectCreatedDto.getTpReview()));
		projectDao.update(project);
		return true;
	}

	/**
	 * Search a project by dsKey.
	 * 
	 * @param dsKey
	 * @return project
	 */
	public ProjectCreatedDto getByDsKey(String dsKey) {
		Project project = projectDao.getByDsKey(dsKey);
		ProjectCreatedDto projectCreatedDto = new ProjectCreatedDto(project);
		return projectCreatedDto;
	}
	
	public List<ProjectCreatedDto> getProjects() {
		List<Project> projects = projectDao.getProjects();
		List<ProjectCreatedDto> dtos = new ArrayList<>();
		projects.forEach(project -> dtos.add(new ProjectCreatedDto(project)));
		return dtos;
	}
}