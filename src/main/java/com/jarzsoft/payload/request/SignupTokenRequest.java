package com.jarzsoft.payload.request;

import javax.validation.constraints.NotBlank;

public class SignupTokenRequest {

	@NotBlank
	private String token;

	@NotBlank
	private String password;

	public SignupTokenRequest(@NotBlank String token, String password) {
		super();
		this.token = token;
		this.password = password;
	}

	public SignupTokenRequest() {
		super();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
