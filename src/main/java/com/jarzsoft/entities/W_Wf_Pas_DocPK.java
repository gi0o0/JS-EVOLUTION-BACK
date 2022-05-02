package com.jarzsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class W_Wf_Pas_DocPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_wf")
	private Long idWf;

	@Column(name = "id_paso")
	private Long idPaso;

	@Column(name = "id_documento")
	private Long idDocumento;

	public W_Wf_Pas_DocPK() {
	}

	public W_Wf_Pas_DocPK(Long idWf, Long idPaso, Long idDocumento) {
		super();
		this.idWf = idWf;
		this.idPaso = idPaso;
		this.idDocumento = idDocumento;
	}

	public Long getIdWf() {
		return idWf;
	}

	public void setIdWf(Long idWf) {
		this.idWf = idWf;
	}

	public Long getIdPaso() {
		return idPaso;
	}

	public void setIdPaso(Long idPaso) {
		this.idPaso = idPaso;
	}

	public Long getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(Long idDocumento) {
		this.idDocumento = idDocumento;
	}

}
