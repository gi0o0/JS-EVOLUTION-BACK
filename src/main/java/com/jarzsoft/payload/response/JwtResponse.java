package com.jarzsoft.payload.response;

import java.util.List;

import com.jarzsoft.model.FuncionalidadSeccionDTO;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String user;
	private String username;

	private List<FuncionalidadSeccionDTO> funcionalidades;

	public JwtResponse(String token, String user, String username, List<FuncionalidadSeccionDTO> funcionalidades) {
		super();
		this.token = token;
		this.user = user;
		this.username = username;
		this.funcionalidades = funcionalidades;
	}

	public JwtResponse() {
		super();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<FuncionalidadSeccionDTO> getFuncionalidades() {
		return funcionalidades;
	}

	public void setFuncionalidades(List<FuncionalidadSeccionDTO> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}

}
