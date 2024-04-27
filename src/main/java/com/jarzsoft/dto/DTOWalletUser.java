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
	private String nomTer;
	private String scheme;
	private String valorCuot;
	private String vSolicita;
	private String nroCuotas;
	private String cuoCau;
	private String cuoPag;
	private String cuoMora;

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

	public DTOWalletUser(String numeroCredito, String saldoCapital, String saldoK, String indicador, String nomClaaso,
			String nomClaasoCod, String marcacionn, String estPersonaDeu, String estPersonaCoDeu, String estCredito,
			String nomTer, String scheme, String valorCuot, String vSolicita, String nroCuotas) {
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
		this.nomTer = nomTer;
		this.scheme = scheme;
		this.valorCuot = valorCuot;
		this.vSolicita = vSolicita;
		this.nroCuotas = nroCuotas;
	}

	public String getNomTer() {
		return nomTer;
	}

	public void setNomTer(String nomTer) {
		this.nomTer = nomTer;
	}

	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
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

	public String getValorCuot() {
		return valorCuot;
	}

	public void setValorCuot(String valorCuot) {
		this.valorCuot = valorCuot;
	}

	public String getvSolicita() {
		return vSolicita;
	}

	public void setvSolicita(String vSolicita) {
		this.vSolicita = vSolicita;
	}

	public String getNroCuotas() {
		return nroCuotas;
	}

	public void setNroCuotas(String nroCuotas) {
		this.nroCuotas = nroCuotas;
	}

	public String getCuoCau() {
		return cuoCau;
	}

	public void setCuoCau(String cuoCau) {
		this.cuoCau = cuoCau;
	}

	public String getCuoPag() {
		return cuoPag;
	}

	public void setCuoPag(String cuoPag) {
		this.cuoPag = cuoPag;
	}

	public String getCuoMora() {
		return cuoMora;
	}

	public void setCuoMora(String cuoMora) {
		this.cuoMora = cuoMora;
	}


}
