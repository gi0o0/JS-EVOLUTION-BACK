package com.jarzsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarzsoft.dto.DTOCladoc;
import com.jarzsoft.service.ICladocService;
import com.jarzsoft.util.Constantes;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constantes.PATH_CLADOC)
public class CladocController {

	private final ICladocService cladocService;

	@Autowired
	public CladocController(ICladocService cladocService) {
		super();
		this.cladocService = cladocService;

	}

	@GetMapping(produces = "application/json")
	public List<DTOCladoc> getAll() {
		return cladocService.getAll();
	}

}