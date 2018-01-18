package br.ufs.dcomp.revyou.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ufs.dcomp.revyou.common.message.ErrorMessage;
import br.ufs.dcomp.revyou.core.FarmsException;
import br.ufs.dcomp.revyou.model.dao.InstitutionDao;
import br.ufs.dcomp.revyou.model.dao.ProjectDao;
import br.ufs.dcomp.revyou.model.dto.CountryCreatedDto;
import br.ufs.dcomp.revyou.model.dto.InstitutionCreateDto;
import br.ufs.dcomp.revyou.model.dto.InstitutionCreatedDto;
import br.ufs.dcomp.revyou.model.entity.Country;
import br.ufs.dcomp.revyou.model.entity.Institution;
import br.ufs.dcomp.revyou.model.entity.Project;

/**
 * @author farms
 *
 */
@Component
public class InstitutionService {

    @Autowired
    private InstitutionDao institutionDao;
    @Autowired
    private ProjectDao projectDao;

    /**
     * Get all institutions by dskey project
     *
     * @param dsKey
     * @return List
     */
    public List<InstitutionCreatedDto> getByDsKeyProject(String dsKey) {
        List<InstitutionCreatedDto> institutionCreatedDto = new ArrayList<>();
        List<Institution> institutions = institutionDao.getByDsKeyProject(dsKey);
        if (institutions != null) {
            institutions.forEach((institution) -> {
                institutionCreatedDto.add(new InstitutionCreatedDto(institution));
            });
        }
        return institutionCreatedDto;
    }

    /**
     * Get all countries registered
     *
     * @return List
     */
    public List<CountryCreatedDto> getAllCountries() {
        List<CountryCreatedDto> countryCreatedDto = new ArrayList<>();
        List<Country> countries = institutionDao.getAllCountries();
        if (countries != null) {
            countries.forEach((country) -> {
                countryCreatedDto.add(new CountryCreatedDto(country));
            });
        }
        return countryCreatedDto;
    }

    /**
     * Save institution
     *
     * @param institutionCreateDto
     * @return boolean
     */
    public boolean save(InstitutionCreateDto institutionCreateDto) {
        Institution institution = new Institution();
        institution.setDsAbbreviation(institutionCreateDto.getDsAbbreviation());
        institution.setNmInstitution(institutionCreateDto.getNmInstitution());
        institution.setCountry(institutionCreateDto.getCountry());

        Project project = projectDao.getByDsKey(institutionCreateDto.getDsKey());

        institution.setProject(project);

        institutionDao.save(institution);

        return true;
    }

    /**
     * Update a institution
     *
     * @param institutionCreatedDto
     * @return boolean
     * @throws FarmsException
     */
    public Boolean update(InstitutionCreatedDto institutionCreatedDto) throws FarmsException {
        Institution institution = institutionDao.get(institutionCreatedDto.getIdInstitution());
        institution.setCountry(institutionCreatedDto.getCountry());
        institution.setDsAbbreviation(institutionCreatedDto.getDsAbbreviation());
        institution.setNmInstitution(institutionCreatedDto.getNmInstitution());
        institution.setProject(projectDao.getByDsKey(institutionCreatedDto.getDsKey()));
        institutionDao.update(institution);
        return true;
    }

    /**
     * Get a institution by name x project
     *
     * @param nmInstitution
     * @param dsKey
     * @return
     */
    public InstitutionCreatedDto getInstitutionByName(String nmInstitution, String dsKey) {
        Institution institution = institutionDao.getByName(nmInstitution, projectDao.getByDsKey(dsKey).getIdProject());
        InstitutionCreatedDto institutionCreatedDto = new InstitutionCreatedDto(institution);
        return institutionCreatedDto;
    }

    /**
     * Delete institution from project
     *
     * @param dsKey
     * @param idInstitution
     * @return
     * @throws br.ufs.dcomp.farms.core.FarmsException
     */
    public Boolean deleteInstitution(String dsKey, Long idInstitution) throws FarmsException {

        Long idProject = projectDao.getByDsKey(dsKey).getIdProject();
        if (institutionDao.countInstitutions(idProject) == 1) {
            throw new FarmsException(ErrorMessage.INSTITUTION_NOT_DELETED);
        } else {
            institutionDao.deleteInstitution(idProject, idInstitution);
        }
        return true;
    }

}
