package com.jarzsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class W_Wf_PasosPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_wf")
	private Long idWf;

	@Column(name = "id_paso")
	private Long idPaso;

	public W_Wf_PasosPK() {
	}

	public W_Wf_PasosPK(Long idWf, Long idPaso) {
		super();
		this.idWf = idWf;
		this.idPaso = idPaso;
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

}
