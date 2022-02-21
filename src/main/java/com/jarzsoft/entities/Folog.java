package com.jarzsoft.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "web.folog")
public class Folog implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Column(name = "nom_usu")
	private String nom_usu;
	
	@Id
	@Column(name = "fec_ini")
	private Date fec_ini;

	@Column(name = "fec_fin")
	private Date fec_fin;

	@Column(name = "hor_ini")
	private String hor_ini;

	@Column(name = "hor_fin")
	private String hor_fin;

	@Size(max = 11)
	@Column(name = "modulo")
	private String modulo;

	@Size(max = 100)
	@Column(name = "opcion")
	private String opcion;

	public Folog() {
	}

	public Folog(String nom_usu, Date fec_ini, Date fec_fin, String hor_ini, String hor_fin,
			@Size(max = 11) String modulo, @Size(max = 100) String opcion) {
		super();
		this.nom_usu = nom_usu;
		this.fec_ini = fec_ini;
		this.fec_fin = fec_fin;
		this.hor_ini = hor_ini;
		this.hor_fin = hor_fin;
		this.modulo = modulo;
		this.opcion = opcion;
	}

	public String getNom_usu() {
		return nom_usu;
	}

	public void setNom_usu(String nom_usu) {
		this.nom_usu = nom_usu;
	}

	public Date getFec_ini() {
		return fec_ini;
	}

	public void setFec_ini(Date fec_ini) {
		this.fec_ini = fec_ini;
	}

	public Date getFec_fin() {
		return fec_fin;
	}

	public void setFec_fin(Date fec_fin) {
		this.fec_fin = fec_fin;
	}

	public String getHor_ini() {
		return hor_ini;
	}

	public void setHor_ini(String hor_ini) {
		this.hor_ini = hor_ini;
	}

	public String getHor_fin() {
		return hor_fin;
	}

	public void setHor_fin(String hor_fin) {
		this.hor_fin = hor_fin;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public String getOpcion() {
		return opcion;
	}

	public void setOpcion(String opcion) {
		this.opcion = opcion;
	}

}
