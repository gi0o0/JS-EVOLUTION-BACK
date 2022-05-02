package com.jarzsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
public class W_Wf_Pas_AutPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "id_wf")
	private Long idWf;

	@Column(name = "id_paso")
	private Long idPaso;

	@Size(max = 11)
	@Column(name = "usuario")
	private String usuario;

	public W_Wf_Pas_AutPK() {
	}

	public W_Wf_Pas_AutPK(Long idWf, Long idPaso, @Size(max = 11) String usuario) {
		super();
		this.idWf = idWf;
		this.idPaso = idPaso;
		this.usuario = usuario;
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
