package com.jarzsoft.dto;

import java.util.Date;

public class DTOOpcionesPerfil {

	private String idRole;
	private String idOption;
	private String usuUltMod;
	private Date fecUltMod;
	private Date fecCrea;
	private String usuCrea;

	public DTOOpcionesPerfil() {
		super();
	}

	public DTOOpcionesPerfil(String idRole, String idOption, String usuUltMod, Date fecUltMod, Date fecCrea,
			String usuCrea) {
		super();
		this.idRole = idRole;
		this.idOption = idOption;
		this.usuUltMod = usuUltMod;
		this.fecUltMod = fecUltMod;
		this.fecCrea = fecCrea;
		this.usuCrea = usuCrea;
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

	public String getIdRole() {
		return idRole;
	}

	public void setIdRole(String idRole) {
		this.idRole = idRole;
	}

	public String getIdOption() {
		return idOption;
	}

	public void setIdOption(String idOption) {
		this.idOption = idOption;
	}

}
