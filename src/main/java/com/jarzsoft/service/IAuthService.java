package com.jarzsoft.service;

import org.springframework.http.ResponseEntity;

import com.jarzsoft.payload.request.LoginRequest;
import com.jarzsoft.payload.request.SignupRequest;
import com.jarzsoft.payload.request.SignupTokenRequest;

public interface IAuthService {

	ResponseEntity<Object> signUp(SignupRequest signUpRequest);
	
	ResponseEntity<Object> signUpBytoken(SignupTokenRequest signupTokenRequest);

	ResponseEntity<Object> authenticateUser(LoginRequest loginRequest);

}
