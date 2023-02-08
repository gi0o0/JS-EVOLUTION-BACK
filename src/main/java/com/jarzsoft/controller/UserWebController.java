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

import com.jarzsoft.dto.DTOTerceros;
import com.jarzsoft.dto.DTOW_Bas_Usuario;
import com.jarzsoft.service.IUserWebService;
import com.jarzsoft.util.Constantes;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constantes.PATH_USERWEB)
public class UserWebController {

	private final IUserWebService UserWebService;

	@Autowired
	public UserWebController(IUserWebService UserWebService) {
		super();
		this.UserWebService = UserWebService;

	}

	@GetMapping(produces = "application/json")
	public List<DTOW_Bas_Usuario> listar() {
		return UserWebService.listAllObj();
	}

	@GetMapping(value = "/advisers", produces = "application/json")
	public List<DTOTerceros> getByNumRadAndStep() {
		return UserWebService.getAsesores();
	}

	@PostMapping(produces = "application/json", consumes = "application/json")
	public DTOW_Bas_Usuario create(@RequestBody DTOW_Bas_Usuario obj, @RequestAttribute(name = "user") String user) {
		obj.setUsuCrea(user);
		return UserWebService.create(obj);
	}

	@PutMapping(produces = "application/json", consumes = "application/json")
	public DTOW_Bas_Usuario update(@RequestBody DTOW_Bas_Usuario obj, @RequestAttribute(name = "user") String user) {
		obj.setUsuCrea(user);

		return UserWebService.update(obj);
	}

	@DeleteMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> delete(@PathVariable("id") String id) {
		return ResponseEntity.ok(UserWebService.delete(id));
	}
}
