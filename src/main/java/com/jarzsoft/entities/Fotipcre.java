package com.jarzsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "fotipcre")
public class Fotipcre implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Size(max = 2)
	@Column(name = "codigo_credito")
	private String codigoCredito;

	@NotBlank
	@Size(max = 100)
	@Column(name = "nom_evolution")
	private String nomEvolution;

	public Fotipcre() {
	}

	public Fotipcre(@Size(max = 2) String codigoCredito, @NotBlank @Size(max = 100) String nomEvolution) {
		super();
		this.codigoCredito = codigoCredito;
		this.nomEvolution = nomEvolution;
	}

	public String getCodigoCredito() {
		return codigoCredito;
	}

	public void setCodigoCredito(String codigoCredito) {
		this.codigoCredito = codigoCredito;
	}

	public String getNomEvolution() {
		return nomEvolution;
	}

	public void setNomEvolution(String nomEvolution) {
		this.nomEvolution = nomEvolution;
	}

}
