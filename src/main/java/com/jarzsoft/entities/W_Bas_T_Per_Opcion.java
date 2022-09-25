package com.jarzsoft.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "w_bas_T_Per_Opcion")
public class W_Bas_T_Per_Opcion implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private W_Bas_T_Per_OpcionPK w_Bas_T_Per_OpcionPK;

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

	public W_Bas_T_Per_Opcion() {
	}

	public W_Bas_T_Per_Opcion(W_Bas_T_Per_OpcionPK w_Bas_T_Per_OpcionPK, @Size(max = 10) String usuUltMod,
			Date fecUltMod, Date fecCrea, @Size(max = 10) String usuCrea) {
		super();
		this.w_Bas_T_Per_OpcionPK = w_Bas_T_Per_OpcionPK;
		this.usuUltMod = usuUltMod;
		this.fecUltMod = fecUltMod;
		this.fecCrea = fecCrea;
		this.usuCrea = usuCrea;
	}

	public W_Bas_T_Per_OpcionPK getW_Bas_T_Per_OpcionPK() {
		return w_Bas_T_Per_OpcionPK;
	}

	public void setW_Bas_T_Per_OpcionPK(W_Bas_T_Per_OpcionPK w_Bas_T_Per_OpcionPK) {
		this.w_Bas_T_Per_OpcionPK = w_Bas_T_Per_OpcionPK;
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
