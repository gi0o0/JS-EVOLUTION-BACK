package com.jarzsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarzsoft.dto.DTOFilesUser;
import com.jarzsoft.service.IFilesUserService;
import com.jarzsoft.util.Constantes;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constantes.PATH_FILESUSERS)
public class FilesUserController {

	private final IFilesUserService service;

	@Autowired
	public FilesUserController(IFilesUserService service) {
		super();
		this.service = service;

	}

	@GetMapping(value = "/{user}/application/{idapplication}/doc/{id}/name/{name}", produces = "application/json")
	public List<DTOFilesUser> listFiles(@PathVariable("user") String user,
			@PathVariable("idapplication") String idapplication, @PathVariable("id") String id,@PathVariable("name") String name) {
		return service.listAll(user, idapplication, id,name);
	}

	@GetMapping(value = "/{id}/application/{step}", produces = "application/json")
	public List<DTOFilesUser> listFilesByStep(@PathVariable("id") String id, @PathVariable("step") String step) {
		return service.listAllByIdRedAndStep(id, step);
	}

	@GetMapping(value = "/{id}/application", produces = "application/json")
	public List<DTOFilesUser> listFilesByIdRad(@PathVariable("id") String id) {
		return service.listAllById(id);
	}

}
