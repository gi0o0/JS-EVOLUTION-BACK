package com.jarzsoft.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "w_wf_est")
public class W_Wf_Est implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private W_Wf_EstPK w_Wf_EstPK;

	@Size(max = 100)
	@Column(name = "nom_estado")
	private String nomEstado;

	@Size(max = 5)
	@Column(name = "ind_inicio")
	private String indInicio;

	@Size(max = 5)
	@Column(name = "ind_Final")
	private String indFinal;

	@Column(name = "ord_estado")
	private Long ordEstado;

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

	public W_Wf_Est() {
	}

	public W_Wf_Est(W_Wf_EstPK w_Wf_EstPK, @Size(max = 100) String nomEstado, @Size(max = 5) String indInicio,
			@Size(max = 5) String indFinal, Long ordEstado, @Size(max = 10) String usuUltMod, Date fecUltMod,
			Date fecCrea, @Size(max = 10) String usuCrea) {
		super();
		this.w_Wf_EstPK = w_Wf_EstPK;
		this.nomEstado = nomEstado;
		this.indInicio = indInicio;
		this.indFinal = indFinal;
		this.ordEstado = ordEstado;
		this.usuUltMod = usuUltMod;
		this.fecUltMod = fecUltMod;
		this.fecCrea = fecCrea;
		this.usuCrea = usuCrea;
	}

	public W_Wf_EstPK getW_Wf_EstPK() {
		return w_Wf_EstPK;
	}

	public void setW_Wf_EstPK(W_Wf_EstPK w_Wf_EstPK) {
		this.w_Wf_EstPK = w_Wf_EstPK;
	}

	public String getNomEstado() {
		return nomEstado;
	}

	public void setNomEstado(String nomEstado) {
		this.nomEstado = nomEstado;
	}

	public String getIndInicio() {
		return indInicio;
	}

	public void setIndInicio(String indInicio) {
		this.indInicio = indInicio;
	}

	public String getIndFinal() {
		return indFinal;
	}

	public void setIndFinal(String indFinal) {
		this.indFinal = indFinal;
	}

	public Long getOrdEstado() {
		return ordEstado;
	}

	public void setOrdEstado(Long ordEstado) {
		this.ordEstado = ordEstado;
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
