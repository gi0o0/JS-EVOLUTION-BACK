package com.jarzsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarzsoft.config.JwtTokenUtil;
import com.jarzsoft.dto.DTOUser;
import com.jarzsoft.service.IUserService;
import com.jarzsoft.util.Constantes;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constantes.PATH_USER)
public class UserController {

	private final IUserService userService;

	private final JwtTokenUtil jwtTokenUtil;

	@Autowired
	public UserController(IUserService userService, JwtTokenUtil jwtTokenUtil) {
		super();
		this.userService = userService;
		this.jwtTokenUtil = jwtTokenUtil;

	}

	@GetMapping(produces = "application/json")
	public List<DTOUser> listAll() {
		return userService.listAll();
	}


	@PutMapping(value = "/profile", produces = "application/json", consumes = "application/json")
	public DTOUser update(@RequestBody DTOUser profile, @RequestHeader(name = "Authorization") String token) {
		profile.setUsuCrea(jwtTokenUtil.getUsernameFromToken(token.substring(7)).trim());
		return userService.updateProfile(profile);
	}

}
