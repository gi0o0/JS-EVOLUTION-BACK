package com.jarzsoft.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "web.w_bas_T_Perfil")
public class W_Bas_T_Perfil implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codperfil")
	private Long codPerfil;

	@Size(max = 50)
	@Column(name = "nomperfil")
	private String nomPerfil;

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

	public W_Bas_T_Perfil() {
	}

	public W_Bas_T_Perfil(Long codPerfil, @Size(max = 50) String nomPerfil, @Size(max = 10) String usuUltMod,
			Date fecUltMod, Date fecCrea, @Size(max = 10) String usuCrea) {
		super();
		this.codPerfil = codPerfil;
		this.nomPerfil = nomPerfil;
		this.usuUltMod = usuUltMod;
		this.fecUltMod = fecUltMod;
		this.fecCrea = fecCrea;
		this.usuCrea = usuCrea;
	}

	public Long getCodPerfil() {
		return codPerfil;
	}

	public void setCodPerfil(Long codPerfil) {
		this.codPerfil = codPerfil;
	}

	public String getNomPerfil() {
		return nomPerfil;
	}

	public void setNomPerfil(String nomPerfil) {
		this.nomPerfil = nomPerfil;
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
