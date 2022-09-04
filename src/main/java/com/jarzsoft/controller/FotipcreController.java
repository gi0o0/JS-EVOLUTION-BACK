package com.jarzsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarzsoft.dto.DTOFotipcre;
import com.jarzsoft.service.IFotipcreService;
import com.jarzsoft.util.Constantes;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constantes.PATH_FOTIPCRE)
public class FotipcreController {

	private final IFotipcreService fotipcreService;

	@Autowired
	public FotipcreController(IFotipcreService fotipcreService) {
		super();
		this.fotipcreService = fotipcreService;

	}

	@GetMapping(produces = "application/json")
	public List<DTOFotipcre> getAll() {
		return fotipcreService.getAll();
	}

}