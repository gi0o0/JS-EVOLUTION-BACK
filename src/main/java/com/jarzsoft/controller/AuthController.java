package com.jarzsoft.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarzsoft.payload.request.LoginRequest;
import com.jarzsoft.payload.request.SignupRequest;
import com.jarzsoft.payload.request.SignupTokenRequest;
import com.jarzsoft.service.IAuthService;
import com.jarzsoft.util.Constantes;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(Constantes.PATH_AUTH)
public class AuthController {

	private final IAuthService authService;

	@Autowired
	public AuthController(IAuthService authService) {
		super();
		this.authService = authService;
	}

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		return ResponseEntity.ok(authService.authenticateUser(loginRequest));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
		return ResponseEntity.ok(authService.signUp(signUpRequest));
	}

	@PostMapping("/signup/token")
	public ResponseEntity<?> registerUserByToken(@RequestBody SignupTokenRequest signupTokenRequest) {
		return ResponseEntity.ok(authService.signUpBytoken(signupTokenRequest));
	}
}
