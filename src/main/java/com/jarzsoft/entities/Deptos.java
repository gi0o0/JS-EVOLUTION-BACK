package com.jarzsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "deptos")
public class Deptos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codidept")
	private Integer codiDept;

	@Column(name = "nombdept")
	private String nombDept;


	public Deptos() {
	}

	public Deptos(Integer codiDept, String nombDept) {
		super();
		this.codiDept = codiDept;
		this.nombDept = nombDept;
	}

	public Integer getCodiDept() {
		return codiDept;
	}

	public void setCodiDept(Integer codiDept) {
		this.codiDept = codiDept;
	}

	public String getNombDept() {
		return nombDept;
	}

	public void setNombDept(String nombDept) {
		this.nombDept = nombDept;
	}



}
