package br.ufs.dcomp.revyou.rest;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufs.dcomp.revyou.common.message.ErrorMessage;
import br.ufs.dcomp.revyou.core.FarmsResponse;
import br.ufs.dcomp.revyou.model.dto.CountryCreatedDto;
import br.ufs.dcomp.revyou.model.service.InstitutionService;

/**
 * @author farms
 *
 */
@RestController
@RequestMapping(value = "/institutions", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.HEAD})
public class InstitutionController {

	private final static Logger LOG = LogManager.getLogger(ProjectController.class);
	
	@Autowired
	private InstitutionService institutionService;

	/**
	 * Receive a request from client to get all countries registered.
	 *
	 * @return Response.
	 */
	@GetMapping("/countries")
	public ResponseEntity<?> getAllCountries() {
		try {
			List<CountryCreatedDto> countryCreatedDto = institutionService.getAllCountries();
			return FarmsResponse.ok(countryCreatedDto);
		} catch (Exception ex) {
			LOG.error("", ex);
			return FarmsResponse.error(ErrorMessage.OPERATION_NOT_RESPONDING);
		}
	}
}
