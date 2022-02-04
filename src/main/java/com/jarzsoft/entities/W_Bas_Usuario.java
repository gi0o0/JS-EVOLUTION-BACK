package com.jarzsoft.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "web.W_Bas_Usuario")
public class W_Bas_Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Usuario")
	private String usuario;

	@Size(max = 11)
	@Column(name = "Nom_Usuario")
	private String nom_Usuario;

	@Size(max = 100)
	@Column(name = "Clave")
	private String Clave;

	@Column(name = "CodTer")
	private int codTer;

	@Column(name = "clave1")
	private BigDecimal clave1;

	@Size(max = 200)
	@Column(name = "clave_link")
	private String clave_link;

	@Size(max = 200)
	@Column(name = "clave_global")
	private String clave_global;

	@Size(max = 50)
	@Column(name = "date_mod")
	private String date_mod;

	@Size(max = 2)
	@Column(name = "clave_umbral")
	private String clave_umbral;

	@Size(max = 200)
	@Column(name = "clave_global_his")
	private String clave_global_his;

	@Size(max = 1)
	@Column(name = "TipoAut")
	private String tipoAut;

	@Column(name = "codperfil")
	private int codPerfil;

	public W_Bas_Usuario() {
	}

	public W_Bas_Usuario(String usuario, @Size(max = 11) String nom_Usuario, @Size(max = 100) String clave, int codTer,
			BigDecimal clave1, @Size(max = 200) String clave_link, @Size(max = 200) String clave_global,
			@Size(max = 50) String date_mod, @Size(max = 2) String clave_umbral,
			@Size(max = 200) String clave_global_his, @Size(max = 1) String tipoAut, int codPerfil) {
		super();
		this.usuario = usuario;
		this.nom_Usuario = nom_Usuario;
		Clave = clave;
		this.codTer = codTer;
		this.clave1 = clave1;
		this.clave_link = clave_link;
		this.clave_global = clave_global;
		this.date_mod = date_mod;
		this.clave_umbral = clave_umbral;
		this.clave_global_his = clave_global_his;
		this.tipoAut = tipoAut;
		this.codPerfil = codPerfil;
	}

	public W_Bas_Usuario(String usuario) {
		super();
		this.usuario = usuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNom_Usuario() {
		return nom_Usuario;
	}

	public void setNom_Usuario(String nom_Usuario) {
		this.nom_Usuario = nom_Usuario;
	}

	public String getClave() {
		return Clave;
	}

	public void setClave(String clave) {
		Clave = clave;
	}

	public int getCodTer() {
		return codTer;
	}

	public void setCodTer(int codTer) {
		this.codTer = codTer;
	}

	public BigDecimal getClave1() {
		return clave1;
	}

	public void setClave1(BigDecimal clave1) {
		this.clave1 = clave1;
	}

	public String getClave_link() {
		return clave_link;
	}

	public void setClave_link(String clave_link) {
		this.clave_link = clave_link;
	}

	public String getClave_global() {
		return clave_global;
	}

	public void setClave_global(String clave_global) {
		this.clave_global = clave_global;
	}

	public String getDate_mod() {
		return date_mod;
	}

	public void setDate_mod(String date_mod) {
		this.date_mod = date_mod;
	}

	public String getClave_umbral() {
		return clave_umbral;
	}

	public void setClave_umbral(String clave_umbral) {
		this.clave_umbral = clave_umbral;
	}

	public String getClave_global_his() {
		return clave_global_his;
	}

	public void setClave_global_his(String clave_global_his) {
		this.clave_global_his = clave_global_his;
	}

	public String getTipoAut() {
		return tipoAut;
	}

	public void setTipoAut(String tipoAut) {
		this.tipoAut = tipoAut;
	}

	public int getCodPerfil() {
		return codPerfil;
	}

	public void setCodPerfil(int codPerfil) {
		this.codPerfil = codPerfil;
	}

}
