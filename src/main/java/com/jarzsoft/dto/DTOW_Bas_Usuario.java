package com.jarzsoft.dto;

import java.math.BigDecimal;
import java.util.Date;

public class DTOW_Bas_Usuario {

	private String usuario;
	private String nom_usuario;
	private String clave;
	private int codTer;
	private BigDecimal clave1;
	private String clave_link;
	private String clave_global;
	private String date_mod;
	private String clave_umbral;
	private String clave_global_his;
	private String tipoAut;
	private int codPerfil;
	private String usuUltMod;
	private Date fecUltMod;
	private Date fecCrea;
	private String usuCrea;
	private String estado;
	private String nomperfil;

	public DTOW_Bas_Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DTOW_Bas_Usuario(String usuario, String nom_usuario, String clave, int codTer, BigDecimal clave1,
			String clave_link, String clave_global, String date_mod, String clave_umbral, String clave_global_his,
			String tipoAut, int codPerfil, String usuUltMod, Date fecUltMod, Date fecCrea, String usuCrea,
			String estado)

	{
		super();
		this.usuario = usuario;
		this.nom_usuario = nom_usuario;
		this.clave = clave;
		this.codTer = codTer;
		this.clave1 = clave1;
		this.clave_link = clave_link;
		this.clave_global = clave_global;
		this.date_mod = date_mod;
		this.clave_umbral = clave_umbral;
		this.clave_global_his = clave_global_his;
		this.tipoAut = tipoAut;
		this.codPerfil = codPerfil;
		this.usuUltMod = usuUltMod;
		this.fecUltMod = fecUltMod;
		this.fecCrea = fecCrea;
		this.usuCrea = usuCrea;
		this.estado = estado;
	

	}

	public DTOW_Bas_Usuario(String usuario, String nom_usuario, String clave, int codTer, BigDecimal clave1,
			String clave_link, String clave_global, String date_mod, String clave_umbral, String clave_global_his,
			String tipoAut, int codPerfil, String usuUltMod, Date fecUltMod, Date fecCrea, String usuCrea,
			String estado, String nomperfil)

	{
		super();
		this.usuario = usuario;
		this.nom_usuario = nom_usuario;
		this.clave = clave;
		this.codTer = codTer;
		this.clave1 = clave1;
		this.clave_link = clave_link;
		this.clave_global = clave_global;
		this.date_mod = date_mod;
		this.clave_umbral = clave_umbral;
		this.clave_global_his = clave_global_his;
		this.tipoAut = tipoAut;
		this.codPerfil = codPerfil;
		this.usuUltMod = usuUltMod;
		this.fecUltMod = fecUltMod;
		this.fecCrea = fecCrea;
		this.usuCrea = usuCrea;
		this.estado = estado;
		this.nomperfil = nomperfil;

	}

	public DTOW_Bas_Usuario(String usuario, String estado, int codPerfil) {
		super();
		this.usuario = usuario;
		this.estado = estado;
		this.codPerfil = codPerfil;
	}
	
	public DTOW_Bas_Usuario(String usuario, String nom_usuario, int codter, String estado, int codPerfil, String nomperfil) {
		super();
		this.usuario = usuario;
		this.nom_usuario = nom_usuario;
		this.codTer = codter;
		this.estado = estado;
		this.codPerfil = codPerfil;
		this.nomperfil = nomperfil;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNom_usuario() {
		return nom_usuario;
	}

	public void setNom_usuario(String nom_usuario) {
		this.nom_usuario = nom_usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUsuUltMod() {
		return usuUltMod;
	}

	public void setUsuUltMod(String usuUltMod) {
		this.usuUltMod = usuUltMod;
	}

	public Date getFecUltMod() {
		return fecUltMod;
	}

	public void setFecUltMod(Date fecUltMod) {
		this.fecUltMod = fecUltMod;
	}

	public Date getFecCrea() {
		return fecCrea;
	}

	public void setFecCrea(Date fecCrea) {
		this.fecCrea = fecCrea;
	}

	public String getUsuCrea() {
		return usuCrea;
	}

	public void setUsuCrea(String usuCrea) {
		this.usuCrea = usuCrea;
	}

	
	public String getNomperfil() {
		return nomperfil;
	}

	public void setNomperfil(String nomperfil) {
		this.nomperfil = nomperfil;
	}

	
	
}
