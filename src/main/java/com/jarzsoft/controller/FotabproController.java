package com.jarzsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarzsoft.dto.DTOFotabpro;
import com.jarzsoft.service.IFotabproService;
import com.jarzsoft.util.Constantes;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constantes.PATH_FOTABPRO)
public class FotabproController {

	private final IFotabproService fotabproService;

	@Autowired
	public FotabproController(IFotabproService fotabproService) {
		super();
		this.fotabproService = fotabproService;

	}

	@GetMapping(produces = "application/json")
	public List<DTOFotabpro> getAll() {
		return fotabproService.getAll();
	}

}
