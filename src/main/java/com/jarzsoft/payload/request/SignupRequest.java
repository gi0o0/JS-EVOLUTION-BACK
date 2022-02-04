package com.jarzsoft.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SignupRequest {

	@NotBlank
	@Size(max = 11)
	private String usuario;

	@Pattern(regexp = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", message = "Email be valid")
	private String email;

	public SignupRequest(@NotBlank @Size(max = 11) String usuario, String email) {
		super();
		this.usuario = usuario;
		this.email = email;
	}

	public SignupRequest() {
		super();
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
