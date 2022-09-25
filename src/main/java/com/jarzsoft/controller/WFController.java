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

import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.dto.DTOWFParameterStep;
import com.jarzsoft.service.IWFService;
import com.jarzsoft.util.Constantes;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constantes.PATH_WF)
public class WFController {

	private final IWFService service;

	@Autowired
	public WFController(IWFService service) {
		super();
		this.service = service;

	}

	@PostMapping(produces = "application/json", consumes = "application/json")
	public DTOWF createEst(@RequestBody DTOWF o, @RequestAttribute(name = "user") String user) {

		return service.create(o, user);
	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public DTOWF getById(@PathVariable("id") Integer id) {
		return service.getById(id);
	}

	@GetMapping(value = "/{num_rad}/step/{id_step}", produces = "application/json")
	public DTOWF getByNumRadAndStep(@PathVariable("num_rad") Integer numTad, @PathVariable("id_step") Integer idStep) {
		return service.getByNumRadAndStep(numTad, idStep);
	}

	@GetMapping(produces = "application/json")
	public List<DTOWF> listAllByUser(@RequestAttribute(name = "user") String user) {
		return service.listAllByUser(user);
	}

	@PutMapping(value = "/state", produces = "application/json", consumes = "application/json")
	public DTOWF putState(@RequestBody DTOWF o) {
		return service.updateState(o);
	}
	
	@GetMapping(value = "/{num_rad}/steps", produces = "application/json")
	public List<DTOWFParameterStep> stepsbyNumRad(@PathVariable("num_rad") Integer numRad) {
		return service.stepsbyNumRad(numRad);
	}

}
