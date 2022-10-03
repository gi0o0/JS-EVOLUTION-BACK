package com.jarzsoft.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "W_Bas_Usuario")
public class W_Bas_Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Size(max = 11)
	@Column(name = "Usuario")
	private String usuario;

	@Size(max = 100)
	@Column(name = "Nom_Usuario")
	private String nom_usuario;

	@Size(max = 100)
	@Column(name = "Clave")
	private String clave;

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

	@Size(max = 10)
	@Column(name = "USU_ULT_MOD")
	private String usuUltMod;

	@Column(name = "FEC_ULT_MOD")
	private Date fecUltMod;

	@Column(name = "fec_crea")
	private Date fecCrea;

	@Size(max = 10)
	@Column(name = "usu_crea")
	private String usuCrea;

	@Size(max = 1)
	@Column(name = "estado")
	private String estado;

	public W_Bas_Usuario() {
	}

	public W_Bas_Usuario(String usuario, @Size(max = 100) String nom_usuario, @Size(max = 100) String clave, int codTer,
			BigDecimal clave1, @Size(max = 200) String clave_link, @Size(max = 200) String clave_global,
			@Size(max = 50) String date_mod, @Size(max = 2) String clave_umbral,
			@Size(max = 200) String clave_global_his, @Size(max = 1) String tipoAut, int codPerfil, String estado) {
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
		this.estado = estado;
	}
	
	public W_Bas_Usuario(String usuario, String nom_usuario, String clave, int codTer, BigDecimal clave1,
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
	
	@PrePersist
	public void prePersist() {
		this.clave = "N";
	

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

	public String getNom_usuario() {
		return nom_usuario;
	}

	public void setNom_usuario(String nom_Usuario) {
		this.nom_usuario = nom_Usuario;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
