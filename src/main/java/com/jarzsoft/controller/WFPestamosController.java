package com.jarzsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarzsoft.dto.DTOWFPrestamos;
import com.jarzsoft.service.IWFPrestamoService;
import com.jarzsoft.util.Constantes;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constantes.PATH_WF_LOAN)
public class WFPestamosController {

	private final IWFPrestamoService service;

	@Autowired
	public WFPestamosController(IWFPrestamoService service) {
		super();
		this.service = service;
	}

	@GetMapping(value = "/{id}/wf/{num_rad}", produces = "application/json")
	public List<DTOWFPrestamos> getByNumRadAndStep(@PathVariable("id") Integer id,
			@PathVariable("num_rad") Integer num_rad) {
		return service.getByWfAndNumRad(id, num_rad);
	}

}
