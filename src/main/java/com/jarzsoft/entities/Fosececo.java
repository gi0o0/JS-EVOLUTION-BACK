package com.jarzsoft.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "fosececo")
public class Fosececo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotBlank
	@Size(max = 5)
	@Column(name = "codSec")
	private String codSec;

	@NotBlank
	@Size(max = 100)
	@Column(name = "nomSec")
	private String nomSec;

	@Size(max = 10)
	@Column(name = "USU_ULT_MOD")
	private String usuUltMod;

	@Column(name = "FEC_ULT_MOD")
	private Date fecUltMod;

	@Column(name = "fec_crea")
	private Date fecCrea;

	@Size(max = 10)
	@Column(name = "usu_crea")
	private String usuCrea;

	public Fosececo() {
	}

	public Fosececo(String codSec, String nomSec, @Size(max = 10) String usuUltMod, Date fecUltMod, Date fecCrea,
			@Size(max = 10) String usuCrea) {
		super();
		this.codSec = codSec;
		this.nomSec = nomSec;
		this.usuUltMod = usuUltMod;
		this.fecUltMod = fecUltMod;
		this.fecCrea = fecCrea;
		this.usuCrea = usuCrea;

	}
	
	public Fosececo(String codSec, String nomSec) {
		super();
		this.codSec = codSec;
		this.nomSec = nomSec;
	}

	public String getcodSec() {
		return codSec;
	}

	public void setcodSec(String codSec) {
		this.codSec = codSec;
	}

	public String getnomSec() {
		return nomSec;
	}

	public void setnomSec(String nomSec) {
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
