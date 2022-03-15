package com.jarzsoft.dto;

import java.util.Date;

public class DTOFosececo {

	private String codSec;
	private String nomSec;
	private String usuUltMod;
	private Date fecUltMod;
	private Date fecCrea;
	private String usuCrea;

	public DTOFosececo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTOFosececo(String codSec, String nomSec, String usuUltMod, Date fecUltMod, Date fecCrea, String usuCrea) {
		super();
		this.codSec = codSec;
		this.nomSec = nomSec;
		this.usuUltMod = usuUltMod;
		this.fecUltMod = fecUltMod;
		this.fecCrea = fecCrea;
		this.usuCrea = usuCrea;
	}

	public DTOFosececo(String codSec, String nomSec) {
		super();
		this.codSec = codSec;
		this.nomSec = nomSec;
	}

	public String getCodSec() {
		return codSec;
	}

	public void setCodSec(String codSec) {
		this.codSec = codSec;
	}

	public String getNomSec() {
		return nomSec;
	}

	public void setNomSec(String nomSec) {
		this.nomSec = nomSec;
	}

	public String getUsuUltMod() {
		return usuUltMod;
	}

	public void setUsuUltMod(String usuUltMod) {
		this.usuUltMod = usuUltMod;
	}

	public Date getFecUltMod() {
		return fecUltMod;
	}

	public void setFecUltMod(Date fecUltMod) {
		this.fecUltMod = fecUltMod;
	}

	public Date getFecCrea() {
		return fecCrea;
	}

	public void setFecCrea(Date fecCrea) {
		this.fecCrea = fecCrea;
	}

	public String getUsuCrea() {
		return usuCrea;
	}

	public void setUsuCrea(String usuCrea) {
		this.usuCrea = usuCrea;
	}

}
