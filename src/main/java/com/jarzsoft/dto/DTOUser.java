package com.jarzsoft.dto;

import java.util.Date;

public class DTOUser {

	private String id;
	private String name;
	private String idProfile;
	private String usuUltMod;
	private Date fecUltMod;
	private Date fecCrea;
	private String usuCrea;

	public DTOUser() {
		super();
	}

	public DTOUser(String id, String name, String idProfile, String usuUltMod, Date fecUltMod, Date fecCrea,
			String usuCrea) {
		super();
		this.id = id;
		this.name = name;
		this.idProfile = idProfile;
		this.usuUltMod = usuUltMod;
		this.fecUltMod = fecUltMod;
		this.fecCrea = fecCrea;
		this.usuCrea = usuCrea;
	}

	public DTOUser(String id, String name, String idProfile) {
		super();
		this.id = id;
		this.name = name;
		this.idProfile = idProfile;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdProfile() {
		return idProfile;
	}

	public void setIdProfile(String idProfile) {
		this.idProfile = idProfile;
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
