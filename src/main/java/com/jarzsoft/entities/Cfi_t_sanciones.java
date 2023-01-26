package com.jarzsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cfi_t_sanciones")
public class Cfi_t_sanciones implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "consecsancion")
	private String consecsancion;

	@Column(name = "codter")
	private String codter;

	public Cfi_t_sanciones() {
	}

}
