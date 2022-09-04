package com.jarzsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarzsoft.dto.DTOWF;
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

}
