package com.jarzsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarzsoft.dto.DTOFoclaaso;
import com.jarzsoft.service.IFoclaasoService;
import com.jarzsoft.util.Constantes;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constantes.PATH_FOCLAASO)
public class FoclaasoController {

	private final IFoclaasoService foclaasoService;

	@Autowired
	public FoclaasoController(IFoclaasoService foclaasoService) {
		super();
		this.foclaasoService = foclaasoService;

	}

	@GetMapping(produces = "application/json")
	public List<DTOFoclaaso> getcompanies(@RequestAttribute(name = "user") String user) {
		return foclaasoService.getCompaniesByUser(user);
	}

}