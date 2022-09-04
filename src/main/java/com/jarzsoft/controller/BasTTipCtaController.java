package com.jarzsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarzsoft.dto.DTOBasTTipCta;
import com.jarzsoft.service.IBasTTipCtaService;
import com.jarzsoft.util.Constantes;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constantes.PATH_ACCOUNT_TYPE)
public class BasTTipCtaController {

	private final IBasTTipCtaService basTTipCtaService;

	@Autowired
	public BasTTipCtaController(IBasTTipCtaService basTTipCtaService) {
		super();
		this.basTTipCtaService = basTTipCtaService;
	}

	@GetMapping(produces = "application/json")
	public List<DTOBasTTipCta> getAll() {
		return basTTipCtaService.getAll();
	}

}
