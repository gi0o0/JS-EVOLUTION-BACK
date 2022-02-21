package com.jarzsoft.dto;

public class DTOOpciones {

	private String id;
	private String name;
	private String enabled;

	public DTOOpciones() {
		super();
	}

	public DTOOpciones(String id, String name, String enabled) {
		super();
		this.id = id;
		this.name = name;
		this.enabled = enabled;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

}
