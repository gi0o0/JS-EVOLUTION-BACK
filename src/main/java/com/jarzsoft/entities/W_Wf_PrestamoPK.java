package com.jarzsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class W_Wf_PrestamoPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_wf")
	private Long idWf;

	@Column(name = "numero_radicacion")
	private Long numeroRadicacion;

	@Column(name = "numero_credito")
	private Long numeroCredito;

	public W_Wf_PrestamoPK() {
	}

	public Long getIdWf() {
		return idWf;
	}

	public void setIdWf(Long idWf) {
		this.idWf = idWf;
	}

	public Long getNumeroRadicacion() {
		return numeroRadicacion;
	}

	public void setNumeroRadicacion(Long numeroRadicacion) {
		this.numeroRadicacion = numeroRadicacion;
	}

	public Long getNumeroCredito() {
		return numeroCredito;
	}

	public void setNumeroCredito(Long numeroCredito) {
		this.numeroCredito = numeroCredito;
	}

}
