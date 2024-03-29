package com.jarzsoft.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "w_wf_pas_doc")
public class W_Wf_Pas_Doc implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private W_Wf_Pas_DocPK w_Wf_Pas_DocPK;

	@Size(max = 100)
	@Column(name = "nom_documento")
	private String nomDocumento;

	@Size(max = 5)
	@Column(name = "env_rec")
	private String envRec;

	@Size(max = 1)
	@Column(name = "Ind_obligatorio")
	private String indObligatorio;

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

	public W_Wf_Pas_Doc() {
	}

	public W_Wf_Pas_Doc(W_Wf_Pas_DocPK w_Wf_Pas_DocPK, @Size(max = 100) String nomDocumento,
			@Size(max = 5) String envRec, @Size(max = 10) String usuUltMod, Date fecUltMod, Date fecCrea,
			@Size(max = 10) String usuCrea, String indObligatorio) {
		super();
		this.w_Wf_Pas_DocPK = w_Wf_Pas_DocPK;
		this.nomDocumento = nomDocumento;
		this.envRec = envRec;
		this.usuUltMod = usuUltMod;
		this.fecUltMod = fecUltMod;
		this.fecCrea = fecCrea;
		this.usuCrea = usuCrea;
		this.indObligatorio = indObligatorio;
	}

	public W_Wf_Pas_DocPK getW_Wf_Pas_DocPK() {
		return w_Wf_Pas_DocPK;
	}

	public void setW_Wf_Pas_DocPK(W_Wf_Pas_DocPK w_Wf_Pas_DocPK) {
		this.w_Wf_Pas_DocPK = w_Wf_Pas_DocPK;
	}

	public String getNomDocumento() {
		return nomDocumento;
	}

	public void setNomDocumento(String nomDocumento) {
		this.nomDocumento = nomDocumento;
	}

	public String getEnvRec() {
		return envRec;
	}

	public void setEnvRec(String envRec) {
		this.envRec = envRec;
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

	public String getIndObligatorio() {
		return indObligatorio;
	}

	public void setIndObligatorio(String indObligatorio) {
		this.indObligatorio = indObligatorio;
	}

}
