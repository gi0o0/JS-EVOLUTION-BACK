package com.jarzsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarzsoft.dto.DTOFosececo;
import com.jarzsoft.service.IFosececoService;
import com.jarzsoft.util.Constantes;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constantes.PATH_ECONOMICSECTOR)
public class FosececoController {

	private final IFosececoService fosececoService;

	@Autowired
	public FosececoController(IFosececoService fosececoService) {
		super();
		this.fosececoService = fosececoService;

	}

	@GetMapping(produces = "application/json")
	public List<DTOFosececo> listar() {
		return fosececoService.listAll();
	}

	@PostMapping(produces = "application/json", consumes = "application/json")
	public DTOFosececo create(@RequestBody DTOFosececo obj, @RequestAttribute(name = "user") String user) {
		obj.setUsuCrea(user);

		return fosececoService.create(obj);
	}

	@PutMapping(produces = "application/json", consumes = "application/json")
	public DTOFosececo update(@RequestBody DTOFosececo obj, @RequestAttribute(name = "user") String user) {
		obj.setUsuCrea(user);

		return fosececoService.update(obj);
	}

	@DeleteMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> delete(@PathVariable("id") String id) {
		return ResponseEntity.ok(fosececoService.delete(id));
	}
}
