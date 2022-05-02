package com.jarzsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class W_Wf_EstPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_wf")
	private Long idWf;

	@Column(name = "id_estado")
	private Long idEstado;

	public W_Wf_EstPK() {
	}

	public W_Wf_EstPK(Long idWf, Long idEstado) {
		super();
		this.idWf = idWf;
		this.idEstado = idEstado;
	}

	public Long getIdWf() {
		return idWf;
	}

	public void setIdWf(Long idWf) {
		this.idWf = idWf;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

}