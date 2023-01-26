package com.jarzsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarzsoft.dto.DTOCiudad;
import com.jarzsoft.service.ICiudadesService;
import com.jarzsoft.util.Constantes;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constantes.PATH_CITIES)
public class CiudadesController {

	private final ICiudadesService ciudadesService;

	@Autowired
	public CiudadesController(ICiudadesService ciudadesService) {
		super();
		this.ciudadesService = ciudadesService;

	}

	@GetMapping(value = "/{id_pais}/{id_deptos}", produces = "application/json")
	public List<DTOCiudad> listarById(@PathVariable("id_pais") Integer idPais,
			@PathVariable("id_deptos") Integer idDeptos) {
		return ciudadesService.getAll(idPais, idDeptos);
	}

}
