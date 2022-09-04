package com.jarzsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ciudades")
public class Ciudades implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codiciud")
	private Integer codiCiud;

	@Column(name = "nombciud")
	private String nombCiud;

	public Ciudades() {
	}

	public Ciudades(Integer codiCiud, String nombCiud) {
		super();
		this.codiCiud = codiCiud;
		this.nombCiud = nombCiud;
	}

	public Integer getCodiCiud() {
		return codiCiud;
	}

	public void setCodiCiud(Integer codiCiud) {
		this.codiCiud = codiCiud;
	}

	public String getNombCiud() {
		return nombCiud;
	}

	public void setNombCiud(String nombCiud) {
		this.nombCiud = nombCiud;
	}

}
