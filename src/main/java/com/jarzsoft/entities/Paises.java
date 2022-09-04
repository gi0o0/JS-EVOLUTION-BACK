package com.jarzsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paises")
public class Paises implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "pais_codigo")
	private Integer codTip;

	@Column(name = "pais_nombre")
	private String paisNombre;


	public Paises() {
	}

	public Paises(Integer codTip, String paisNombre) {
		super();
		this.codTip = codTip;
		this.paisNombre = paisNombre;
	}

	public Integer getCodTip() {
		return codTip;
	}

	public void setCodTip(Integer codTip) {
		this.codTip = codTip;
	}

	public String getPaisNombre() {
		return paisNombre;
	}

	public void setPaisNombre(String paisNombre) {
		this.paisNombre = paisNombre;
	}


}
