package com.jarzsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarzsoft.dto.DTOWFFilter;
import com.jarzsoft.dto.DTOWFParameterStep;
import com.jarzsoft.dto.DTOWFPqr;
import com.jarzsoft.dto.DTOWalletUser;
import com.jarzsoft.service.IWFPqrService;
import com.jarzsoft.util.Constantes;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constantes.PATH_WF_PQR)
public class WFPqrController {

	private final IWFPqrService service;

	@Autowired
	public WFPqrController(IWFPqrService service) {
		super();
		this.service = service;
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public DTOWFPqr getById(@PathVariable("id") Integer id) {
		return service.getById(id);
	}

	@GetMapping(value = "/{num_rad}/step/{id_step}/wf/{id_wf}", produces = "application/json")
	public DTOWFPqr getByNumRadAndStep(@PathVariable("num_rad") Integer numTad,
			@PathVariable("id_step") Integer idStep,@PathVariable("id_wf") Integer idWf) {
		return service.getByNumRadAndStep(numTad, idStep, idWf);
	}

	@GetMapping(produces = "application/json")
	public List<DTOWFPqr> listAllByUser(@RequestAttribute(name = "user") String user) {
		return service.listAllByUser(user);
	}

	@GetMapping(value = "{id_wf}/rad/{num_rad}/steps", produces = "application/json")
	public List<DTOWFParameterStep> stepsbyNumRad(@PathVariable("id_wf") Integer idWf,@PathVariable("num_rad") Integer numRad) {
		return service.stepsbyNumRad(idWf,numRad);
	}

	@GetMapping(value = "/{cod_ter}/portafolio/{wf}", produces = "application/json")
	public List<DTOWalletUser> getPortafolio(@PathVariable("cod_ter") String codTer, @PathVariable("wf") String wf) {
		return service.getPortafolio(codTer, wf);
	}

	@PutMapping(value = "/state", produces = "application/json", consumes = "application/json")
	public DTOWFPqr putState(@RequestBody DTOWFPqr o) {
		return service.updateState(o);
	}

	@PostMapping(produces = "application/json", consumes = "application/json")
	public DTOWFPqr createEst(@RequestBody DTOWFPqr o, @RequestAttribute(name = "user") String user) {
		return service.create(o, user);
	}
	
	@PostMapping(value = "/filter", produces = "application/json", consumes = "application/json")
	public List<DTOWFPqr> listAllByFilters(@RequestBody DTOWFFilter o, @RequestAttribute(name = "user") String user) {
		return service.listAllByFilters(o, user);
	}

}
