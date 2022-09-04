package com.jarzsoft.dto;

public class DTOFotipcre {

	private String codigoCredito;
	private String nomEvolution;

	public DTOFotipcre() {
		super();
	}

	public DTOFotipcre(String codigoCredito, String nomEvolution) {
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
