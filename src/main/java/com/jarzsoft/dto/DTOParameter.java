package com.jarzsoft.dto;

public class DTOParameter {

	private String id;
	private String text;
	private String value;

	public DTOParameter() {
		super();
	}

	public DTOParameter(String id, String text, String value) {
		super();
		this.id = id;
		this.text = text;
		this.value = value;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
