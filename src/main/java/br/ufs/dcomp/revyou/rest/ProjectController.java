package br.ufs.dcomp.revyou.rest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufs.dcomp.revyou.common.message.ErrorMessage;
import br.ufs.dcomp.revyou.common.message.SuccessMessage;
import br.ufs.dcomp.revyou.core.FarmsException;
import br.ufs.dcomp.revyou.core.FarmsResponse;
import br.ufs.dcomp.revyou.model.dto.InstitutionCreatedDto;
import br.ufs.dcomp.revyou.model.dto.ProjectCreateDto;
import br.ufs.dcomp.revyou.model.dto.ProjectCreatedDto;
import br.ufs.dcomp.revyou.model.service.InstitutionService;
import br.ufs.dcomp.revyou.model.service.ProjectService;

@RestController
@RequestMapping(value = "/projects", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.HEAD})
public class ProjectController {
	
	private final static Logger LOG = LogManager.getLogger(ProjectController.class);

	@Autowired
	private ProjectService projectService;
	@Autowired
	private InstitutionService institutuionService;

	/**
	 * Receive a request from client to create a project.
	 *
	 * @param projectCreateDto
	 * @return Response
	 */
	@PostMapping
	public ResponseEntity<?> createProject(@RequestBody ProjectCreateDto projectCreateDto) {
		try {
			Boolean bool = projectService.save(projectCreateDto);
			return FarmsResponse.ok(SuccessMessage.PROJECT_REGISTERED, bool);
		} catch (FarmsException fe) {
			return FarmsResponse.error(fe.getErrorMessage());
		} catch (Exception ex) {
			LOG.error("", ex);
			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
		}
	}

	/**
	 * Receive a request from client to update a project.
	 *
	 * @param projectCreatedDto
	 * @return Response
	 */
	@PutMapping
	public ResponseEntity<?> updateProject(ProjectCreatedDto projectCreatedDto) {
		try {
			Boolean bool = projectService.update(projectCreatedDto);
			return FarmsResponse.ok(SuccessMessage.PROJECT_UPDATED, bool);
		} catch (FarmsException fe) {
			return FarmsResponse.error(fe.getErrorMessage());
		} catch (Exception ex) {
			LOG.error("", ex);
			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
		}
	}

	/**
	 * Receive a request from client to get a project.
	 *
	 * @param dsKey
	 * @return Response
	 */
	@GetMapping("/{dsKey}")
	public ResponseEntity<?> getProjectByDsKey(@PathVariable String dsKey) {
		try {
			ProjectCreatedDto projectCreatedDto = projectService.getByDsKey(dsKey);
			return FarmsResponse.ok(projectCreatedDto);
		} catch (Exception ex) {
			LOG.error("", ex);
			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
		}
	}


	/**
	 * Get all institutions of a project.
	 *
	 * @param dsKey
	 * @return Response
	 */
	@GetMapping("/{dsKey}/institutions")
	public ResponseEntity<?> getInstitutionsByDsKeyProject(@PathVariable String dsKey) {
		if (dsKey.equals("null")) {
			return null;
		}

		try {
			List<InstitutionCreatedDto> institutionCreatedDtos = institutuionService.getByDsKeyProject(dsKey);
			return FarmsResponse.ok(institutionCreatedDtos);
		} catch (Exception ex) {
			LOG.error("", ex);
			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
		}
	}
	
	/**
	 * Get all projects
	 *
	 * @return Response
	 */
	@GetMapping
	public ResponseEntity<?> getProjects() {
		try {
			return FarmsResponse.ok(projectService.getProjects());
		} catch (Exception ex) {
			LOG.error("", ex);
			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
		}
	}
}
