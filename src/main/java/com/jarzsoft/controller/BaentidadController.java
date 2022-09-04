package com.jarzsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarzsoft.dto.DTOBaentidad;
import com.jarzsoft.service.IBaEntidadService;
import com.jarzsoft.util.Constantes;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constantes.PATH_BAENTIDAD)
public class BaentidadController {

	private final IBaEntidadService baEntidadService;

	@Autowired
	public BaentidadController(IBaEntidadService baEntidadService) {
		super();
		this.baEntidadService = baEntidadService;

	}

	@GetMapping(produces = "application/json")
	public List<DTOBaentidad> getAll() {
		return baEntidadService.getAll();
	}

}
