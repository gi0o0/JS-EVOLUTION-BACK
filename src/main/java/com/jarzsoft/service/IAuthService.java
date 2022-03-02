package com.jarzsoft.service;

import org.springframework.http.ResponseEntity;

import com.jarzsoft.dto.UserDto;
import com.jarzsoft.payload.request.LoginRequest;
import com.jarzsoft.payload.request.SignupRequest;
import com.jarzsoft.payload.request.SignupTokenRequest;

public interface IAuthService {

	ResponseEntity<Object> signUp(SignupRequest signUpRequest);

	ResponseEntity<Object> signUpBytoken(SignupTokenRequest signupTokenRequest);

	UserDto authenticateUser(LoginRequest loginRequest);

	String createToken(UserDto user);

	UserDto findByToken(String userId, String hmac);

}
