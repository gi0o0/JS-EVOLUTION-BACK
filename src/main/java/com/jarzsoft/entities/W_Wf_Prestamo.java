package com.jarzsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "w_wf_prestamo")
public class W_Wf_Prestamo implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private W_Wf_PrestamoPK w_Wf_PrestamoPK;

	@Size(max = 2)
	@Column(name = "ind_est")
	private String indEst;

	@Size(max = 2)
	@Column(name = "ind_cer")
	private String indCer;

	@Size(max = 2)
	@Column(name = "ind_cer_deu")
	private String indCerDeu;

	@Size(max = 2)
	@Column(name = "ind_paz")
	private String indPaz;

	@Size(max = 2)
	@Column(name = "ind_dp")
	private String indDp;

	@Size(max = 10)
	@Column(name = "cla_asoci")
	private String claAsoci;

	public W_Wf_Prestamo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public W_Wf_Prestamo(W_Wf_PrestamoPK w_Wf_PrestamoPK, @Size(max = 2) String indEst, @Size(max = 2) String indCer,
			@Size(max = 2) String indCerDeu, @Size(max = 2) String indPaz, @Size(max = 2) String indDp,
			@Size(max = 10) String claAsoci) {
		super();
		this.w_Wf_PrestamoPK = w_Wf_PrestamoPK;
		this.indEst = indEst;
		this.indCer = indCer;
		this.indCerDeu = indCerDeu;
		this.indPaz = indPaz;
		this.indDp = indDp;
		this.claAsoci = claAsoci;
	}

	public W_Wf_PrestamoPK getW_Wf_PrestamoPK() {
		return w_Wf_PrestamoPK;
	}

	public void setW_Wf_PrestamoPK(W_Wf_PrestamoPK w_Wf_PrestamoPK) {
		this.w_Wf_PrestamoPK = w_Wf_PrestamoPK;
	}

	public String getIndEst() {
		return indEst;
	}

	public void setIndEst(String indEst) {
		this.indEst = indEst;
	}

	public String getIndCer() {
		return indCer;
	}

	public void setIndCer(String indCer) {
		this.indCer = indCer;
	}

	public String getIndCerDeu() {
		return indCerDeu;
	}

	public void setIndCerDeu(String indCerDeu) {
		this.indCerDeu = indCerDeu;
	}

	public String getIndPaz() {
		return indPaz;
	}

	public void setIndPaz(String indPaz) {
		this.indPaz = indPaz;
	}

	public String getIndDp() {
		return indDp;
	}

	public void setIndDp(String indDp) {
		this.indDp = indDp;
	}

	public String getClaAsoci() {
		return claAsoci;
	}

	public void setClaAsoci(String claAsoci) {
		this.claAsoci = claAsoci;
	}

}
