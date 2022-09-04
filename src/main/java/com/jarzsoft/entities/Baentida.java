package com.jarzsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "baentida")
public class Baentida implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codent")
	private String codEnt;

	@Column(name = "noment")
	private String noment;

	public Baentida() {
	}

	public Baentida(String codEnt, String noment) {
		super();
		this.codEnt = codEnt;
		this.noment = noment;
	}

	public String getCodEnt() {
		return codEnt;
	}

	public void setCodEnt(String codEnt) {
		this.codEnt = codEnt;
	}

	public String getNoment() {
		return noment;
	}

	public void setNoment(String noment) {
		this.noment = noment;
	}

}
