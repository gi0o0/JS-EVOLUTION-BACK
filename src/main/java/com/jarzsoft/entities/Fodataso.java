package com.jarzsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "fodataso")
public class Fodataso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "cod_ter")
	private String codTer;

	@Column(name = "fec_ing_empresa")
	private String fecIngEmpresa;

	@Column(name = "fec_cump")
	private String fec_cump;

	@Column(name = "cod_profe")
	private String codProfe;

	@Column(name = "nom_cony")
	private String nomCony;

	@Column(name = "emailconyuge")
	private String emailConyuge;

	@Column(name = "celconyuge")
	private String celConyuge;

	@Column(name = "ind_contrato")
	private String indContrato;

	@Column(name = "cod_emple")
	private String codEmple;

	@Column(name = "Cla_asoci")
	private String claAsoci;

	@Column(name = "cargo_deu_wf")
	private String cargoDeuWf;

	@Column(name = "cargo_cod_wf")
	private String cargoCodWf;

	@Column(name = "activo")
	private String activo;
	
	@Column(name = "sexo")
	private String sexo;
	
	

	public Fodataso() {
	}

	@PrePersist
	public void prePersist() {

		this.activo = "0";

	}

	@PreUpdate
	public void preUpdate() {
		 this.activo = "0";
	}

	public String getCodTer() {
		return codTer;
	}

	public void setCodTer(String codTer) {
		this.codTer = codTer;
	}

	public String getFecIngEmpresa() {
		return fecIngEmpresa;
	}

	public void setFecIngEmpresa(String fecIngEmpresa) {
		this.fecIngEmpresa = fecIngEmpresa;
	}

	public String getFec_cump() {
		return fec_cump;
	}

	public void setFec_cump(String fec_cump) {
		this.fec_cump = fec_cump;
	}

	public String getCodProfe() {
		return codProfe;
	}

	public void setCodProfe(String codProfe) {
		this.codProfe = codProfe;
	}

	public String getNomCony() {
		return nomCony;
	}

	public void setNomCony(String nomCony) {
		this.nomCony = nomCony;
	}

	public String getEmailConyuge() {
		return emailConyuge;
	}

	public void setEmailConyuge(String emailConyuge) {
		this.emailConyuge = emailConyuge;
	}

	public String getCelConyuge() {
		return celConyuge;
	}

	public void setCelConyuge(String celConyuge) {
		this.celConyuge = celConyuge;
	}

	public String getIndContrato() {
		return indContrato;
	}

	public void setIndContrato(String indContrato) {
		this.indContrato = indContrato;
	}

	public String getCodEmple() {
		return codEmple;
	}

	public void setCodEmple(String codEmple) {
		this.codEmple = codEmple;
	}

	public String getClaAsoci() {
		return claAsoci;
	}

	public void setClaAsoci(String claAsoci) {
		this.claAsoci = claAsoci;
	}

	public String getCargoDeuWf() {
		return cargoDeuWf;
	}

	public void setCargoDeuWf(String cargoDeuWf) {
		this.cargoDeuWf = cargoDeuWf;
	}

	public String getCargoCodWf() {
		return cargoCodWf;
	}

	public void setCargoCodWf(String cargoCodWf) {
		this.cargoCodWf = cargoCodWf;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	

}
