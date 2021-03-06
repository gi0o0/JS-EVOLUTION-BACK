package com.jarzsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarzsoft.dto.DTOOpciones;
import com.jarzsoft.dto.DTOOpcionesPerfil;
import com.jarzsoft.dto.DTOSystem;
import com.jarzsoft.service.ISystemService;
import com.jarzsoft.util.Constantes;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constantes.PATH_SYSTEM)
public class SystemController {

	private final ISystemService systemService;

	@Autowired
	public SystemController(ISystemService systemService) {
		super();
		this.systemService = systemService;

	}

	@GetMapping(produces = "application/json")
	public List<DTOSystem> listAll() {
		return systemService.listAll();
	}

	@GetMapping(value = "/{id}/profile/{id_profile}", produces = "application/json")
	public List<DTOOpciones> delete(@PathVariable("id") String id, @PathVariable("id_profile") String idProfile) {
		return systemService.listOpciones(id, idProfile);
	}

	@PostMapping(value = "/option", produces = "application/json", consumes = "application/json")
	public DTOOpcionesPerfil createOpcRole(@RequestBody DTOOpcionesPerfil r,
			@RequestAttribute(name = "user") String user) {
		r.setUsuCrea(user);
		return systemService.createOption(r);
	}

	@DeleteMapping(value = "/option/{idOption}/profile/{idRole}", produces = "application/json", consumes = "application/json")
	public boolean createOpcRole(@PathVariable("idOption") String idOption, @PathVariable("idRole") String idRole) {
		return systemService.deleteOption(idOption, idRole);
	}

}
