package com.jarzsoft.dto;

public class DTOPaises {

	private String id;
	private String name;

	public DTOPaises() {
		super();
	}

	public DTOPaises(String id, String name) {
		super();
		this.id = id;
		this.name = name;
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

}
