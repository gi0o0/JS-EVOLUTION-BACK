package com.jarzsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ParametroKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "param_id", nullable = false)
	private String param_id;

	@Column(name = "param_text", nullable = false)
	private String param_text;

	public ParametroKey() {
		super();
	}

	public ParametroKey(String param_id, String param_text) {
		super();
		this.param_id = param_id;
		this.param_text = param_text;
	}

	public String getParam_id() {
		return param_id;
	}

	public void setParam_id(String param_id) {
		this.param_id = param_id;
	}

	public String getParam_text() {
		return param_text;
	}

	public void setParam_text(String param_text) {
		this.param_text = param_text;
	}

}
