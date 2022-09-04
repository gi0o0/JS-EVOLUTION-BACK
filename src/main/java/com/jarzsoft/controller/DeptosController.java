package com.jarzsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarzsoft.dto.DTODeptos;
import com.jarzsoft.service.IDeptosService;
import com.jarzsoft.util.Constantes;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constantes.PATH_DEPTOS)
public class DeptosController {

	private final IDeptosService deptosService;

	@Autowired
	public DeptosController(IDeptosService deptosService) {
		super();
		this.deptosService = deptosService;

	}

	@GetMapping(value = "/{id}", produces = "application/json")
	public List<DTODeptos> listarById(@PathVariable("id") Integer id) {
		return deptosService.getAll(id);
	}

}
