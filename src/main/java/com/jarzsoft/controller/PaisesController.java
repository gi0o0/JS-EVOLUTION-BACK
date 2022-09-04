package com.jarzsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarzsoft.dto.DTOPaises;
import com.jarzsoft.service.IPaisesService;
import com.jarzsoft.util.Constantes;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constantes.PATH_COUNTRIES)
public class PaisesController {

	private final IPaisesService paisesService;

	@Autowired
	public PaisesController(IPaisesService paisesService) {
		super();
		this.paisesService = paisesService;

	}

	@GetMapping(produces = "application/json")
	public List<DTOPaises> getAll() {
		return paisesService.getAll();
	}

}