package com.jarzsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarzsoft.dto.DTOParameter;
import com.jarzsoft.service.IParameterService;
import com.jarzsoft.util.Constantes;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constantes.PATH_PARAMETER)
public class ParameterController {

	private final IParameterService parameterService;

	@Autowired
	public ParameterController(IParameterService parameterService) {
		super();
		this.parameterService = parameterService;

	}

	@GetMapping(produces = "application/json")
	public List<DTOParameter> listarPerfiles() {
		return parameterService.listAll();
	}

	@PostMapping(produces = "application/json", consumes = "application/json")
	public DTOParameter create(@RequestBody DTOParameter profile) {

		return parameterService.create(profile);
	}

	@PutMapping(produces = "application/json", consumes = "application/json")
	public DTOParameter update(@RequestBody DTOParameter profile) {

		return parameterService.update(profile);
	}

	@DeleteMapping(produces = "application/json", consumes = "application/json")
	public DTOParameter delete(@RequestBody DTOParameter profile) {

		return parameterService.delete(profile);
	}

}
