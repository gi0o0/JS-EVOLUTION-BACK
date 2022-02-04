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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarzsoft.config.JwtTokenUtil;
import com.jarzsoft.dto.DTOProfile;
import com.jarzsoft.service.IProfileService;
import com.jarzsoft.util.Constantes;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constantes.PATH_PROFILE)
public class ProfileController {

	private final IProfileService profileService;

	private final JwtTokenUtil jwtTokenUtil;

	@Autowired
	public ProfileController(IProfileService profileService, JwtTokenUtil jwtTokenUtil) {
		super();
		this.profileService = profileService;
		this.jwtTokenUtil = jwtTokenUtil;

	}

	@GetMapping(produces = "application/json")
	public List<DTOProfile> listarPerfiles() {
		return profileService.listAll();
	}

	@PostMapping(produces = "application/json", consumes = "application/json")
	public DTOProfile create(@RequestBody DTOProfile profile, @RequestHeader(name = "Authorization") String token) {
		profile.setUsuCrea(jwtTokenUtil.getUsernameFromToken(token.substring(7)).trim());
		return profileService.create(profile);
	}

	@PutMapping(produces = "application/json", consumes = "application/json")
	public DTOProfile update(@RequestBody DTOProfile profile, @RequestHeader(name = "Authorization") String token) {
		profile.setUsuCrea(jwtTokenUtil.getUsernameFromToken(token.substring(7)).trim());
		return profileService.update(profile);
	}

	@DeleteMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(profileService.delete(id));
	}

}
