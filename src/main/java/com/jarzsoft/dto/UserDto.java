package com.jarzsoft.dto;

import java.util.List;

import com.jarzsoft.model.FuncionalidadSeccionDTO;

public class UserDto {

	private String id;
	private String firstName;
	private String lastName;
	private String login;
	private String token;
	private List<FuncionalidadSeccionDTO> funcionalidades;

	public UserDto() {
		super();
	}

	public UserDto(String id, String firstName, String lastName, String login, String token,
			List<FuncionalidadSeccionDTO> funcionalidades) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = login;
		this.token = token;
		this.funcionalidades = funcionalidades;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<FuncionalidadSeccionDTO> getFuncionalidades() {
		return funcionalidades;
	}

	public void setFuncionalidades(List<FuncionalidadSeccionDTO> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}

}
