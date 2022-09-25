package com.jarzsoft.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Parametro")
public class Parametro implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ParametroKey parametroKey;

	@NotBlank
	@Size(max = 200)
	private String value;

	public Parametro() {
		super();
	}

	public Parametro(ParametroKey parametroKey, @NotBlank @Size(max = 200) String value) {
		super();
		this.parametroKey = parametroKey;
		this.value = value;
	}

	public ParametroKey getParametroKey() {
		return parametroKey;
	}

	public void setParametroKey(ParametroKey parametroKey) {
		this.parametroKey = parametroKey;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
