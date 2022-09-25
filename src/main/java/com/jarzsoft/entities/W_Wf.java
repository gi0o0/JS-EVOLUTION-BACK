package com.jarzsoft.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "w_wf")
public class W_Wf implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_wf")
	private Long idWf;

	@Size(max = 100)
	@Column(name = "nom_wf")
	private String nomWf;

	@Size(max = 1)
	@Column(name = "tip_wf")
	private String tipWf;

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

	public W_Wf() {
	}

	public W_Wf(Long idWf, @Size(max = 100) String nomWf, @Size(max = 1) String tipWf, @Size(max = 10) String usuUltMod,
			Date fecUltMod, Date fecCrea, @Size(max = 10) String usuCrea) {
		super();
		this.idWf = idWf;
		this.nomWf = nomWf;
		this.tipWf = tipWf;
		this.usuUltMod = usuUltMod;
		this.fecUltMod = fecUltMod;
		this.fecCrea = fecCrea;
		this.usuCrea = usuCrea;
	}

	public Long getIdWf() {
		return idWf;
	}

	public void setIdWf(Long idWf) {
		this.idWf = idWf;
	}

	public String getNomWf() {
		return nomWf;
	}

	public void setNomWf(String nomWf) {
		this.nomWf = nomWf;
	}

	public String getTipWf() {
		return tipWf;
	}

	public void setTipWf(String tipWf) {
		this.tipWf = tipWf;
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
