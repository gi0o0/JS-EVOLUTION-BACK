package com.jarzsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class W_Bas_T_Per_OpcionPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "codperfil")
	private int codPerfil;

	@Column(name = "cod_Opcion")
	private int codOpcion;

	public W_Bas_T_Per_OpcionPK() {
	}

	public W_Bas_T_Per_OpcionPK(int codPerfil, int codOpcion) {
		super();
		this.codPerfil = codPerfil;
		this.codOpcion = codOpcion;

	}

	public int getCodPerfil() {
		return codPerfil;
	}

	public void setCodPerfil(int codPerfil) {
		this.codPerfil = codPerfil;
	}

	public int getCodOpcion() {
		return codOpcion;
	}

	public void setCodOpcion(int codOpcion) {
		this.codOpcion = codOpcion;
	}

}
