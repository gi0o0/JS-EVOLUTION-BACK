package com.jarzsoft.dto;

public class DTOWalletUser {

	private String numeroCredito;
	private String saldoCapital;
	private String saldoK;
	private String indicador;
	private String nomClaaso;
	private String nomClaasoCod;
	private String marcacionn;
	private String estPersonaDeu;
	private String estPersonaCoDeu;
	private String estCredito;

	public DTOWalletUser() {
		super();
	}

	public DTOWalletUser(String numeroCredito, String saldoCapital, String saldoK, String indicador, String nomClaaso,
			String nomClaasoCod, String marcacionn, String estPersonaDeu, String estPersonaCoDeu, String estCredito) {
		super();
		this.numeroCredito = numeroCredito;
		this.saldoCapital = saldoCapital;
		this.saldoK = saldoK;
		this.indicador = indicador;
		this.nomClaaso = nomClaaso;
		this.nomClaasoCod = nomClaasoCod;
		this.marcacionn = marcacionn;
		this.estPersonaDeu = estPersonaDeu;
		this.estPersonaCoDeu = estPersonaCoDeu;
		this.estCredito = estCredito;
	}

	public String getNumeroCredito() {
		return numeroCredito;
	}

	public void setNumeroCredito(String numeroCredito) {
		this.numeroCredito = numeroCredito;
	}

	public String getSaldoCapital() {
		return saldoCapital;
	}

	public void setSaldoCapital(String saldoCapital) {
		this.saldoCapital = saldoCapital;
	}

	public String getSaldoK() {
		return saldoK;
	}

	public void setSaldoK(String saldoK) {
		this.saldoK = saldoK;
	}

	public String getIndicador() {
		return indicador;
	}

	public void setIndicador(String indicador) {
		this.indicador = indicador;
	}

	public String getNomClaaso() {
		return nomClaaso;
	}

	public void setNomClaaso(String nomClaaso) {
		this.nomClaaso = nomClaaso;
	}

	public String getNomClaasoCod() {
		return nomClaasoCod;
	}

	public void setNomClaasoCod(String nomClaasoCod) {
		this.nomClaasoCod = nomClaasoCod;
	}

	public String getMarcacionn() {
		return marcacionn;
	}

	public void setMarcacionn(String marcacionn) {
		this.marcacionn = marcacionn;
	}

	public String getEstPersonaDeu() {
		return estPersonaDeu;
	}

	public void setEstPersonaDeu(String estPersonaDeu) {
		this.estPersonaDeu = estPersonaDeu;
	}

	public String getEstPersonaCoDeu() {
		return estPersonaCoDeu;
	}

	public void setEstPersonaCoDeu(String estPersonaCoDeu) {
		this.estPersonaCoDeu = estPersonaCoDeu;
	}

	public String getEstCredito() {
		return estCredito;
	}

	public void setEstCredito(String estCredito) {
		this.estCredito = estCredito;
	}

}
