package com.jarzsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "w_men_opcion")
public class W_Men_Opcion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "numero_Sistema")
	private int numeroSistema;

	@Column(name = "cod_Opcion")
	private int codOpcion;

	@Column(name = "Nom_opcion")
	private String nomOpcion;

	@Column(name = "nom_Pro_Ejecuta")
	private String nomProEjecuta;

	@Column(name = "tip_Opcion")
	private String tipOpcion;

	public W_Men_Opcion() {
	}

	public W_Men_Opcion(int numeroSistema, int codOpcion, String nomOpcion, String nomProEjecuta, String tipOpcion) {
		super();
		this.numeroSistema = numeroSistema;
		this.codOpcion = codOpcion;
		this.nomOpcion = nomOpcion;
		this.nomProEjecuta = nomProEjecuta;
		this.tipOpcion = tipOpcion;
	}

	public int getNumeroSistema() {
		return numeroSistema;
	}

	public void setNumeroSistema(int numeroSistema) {
		this.numeroSistema = numeroSistema;
	}

	public int getCodOpcion() {
		return codOpcion;
	}

	public void setCodOpcion(int codOpcion) {
		this.codOpcion = codOpcion;
	}

	public String getNomOpcion() {
		return nomOpcion;
	}

	public void setNomOpcion(String nomOpcion) {
		this.nomOpcion = nomOpcion;
	}

	public String getNomProEjecuta() {
		return nomProEjecuta;
	}

	public void setNomProEjecuta(String nomProEjecuta) {
		this.nomProEjecuta = nomProEjecuta;
	}

	public String getTipOpcion() {
		return tipOpcion;
	}

	public void setTipOpcion(String tipOpcion) {
		this.tipOpcion = tipOpcion;
	}

}
