package com.jarzsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarzsoft.dto.DTOUser;
import com.jarzsoft.service.IUserService;
import com.jarzsoft.util.Constantes;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constantes.PATH_USER)
public class UserController {

	private final IUserService userService;

	@Autowired
	public UserController(IUserService userService) {
		super();
		this.userService = userService;

	}

	@GetMapping(produces = "application/json")
	public List<DTOUser> listAll() {
		return userService.listAll();
	}

	@PutMapping(value = "/profile", produces = "application/json", consumes = "application/json")
	public DTOUser update(@RequestBody DTOUser profile, @RequestAttribute(name = "user") String user) {
		profile.setUsuCrea(user);
		return userService.updateProfile(profile);
	}

}
