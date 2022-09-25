package com.jarzsoft.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "terceros")
public class Terceros implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "codter")
	private BigDecimal codTer;

	@Column(name = "doctip")
	private String docTip;

	@Column(name = "nitter")
	private String nitTer;

	@Column(name = "nom_tercero")
	private String nomTercero;

	@Column(name = "nomter")
	private String nomTer;

	@Column(name = "pri_apellido")
	private String priApellido;

	@Column(name = "seg_apellido")
	private String segApellido;

	@Column(name = "lugardoc")
	private String lugarDoc;

	@Size(max = 60)
	@Column(name = "mailter")
	private String mailTer;

	@Column(name = "dirterpal")
	private String dirTerpal;

	@Column(name = "telter")
	private String telter;

	@Column(name = "tel1ter")
	private String telter1;

	@Column(name = "tel2ter")
	private String telter2;

	@Column(name = "fe_exp")
	private String feExp;

	@Column(name = "pais_codigo")
	private String paisCodigo;

	@Column(name = "codidept")
	private String codiDept;

	@Column(name = "codiciud")
	private String codiCiud;

	@Column(name = "barrio")
	private String barrio;

	@Column(name = "anti_empresa")
	private String antiEmpresa;

	@Column(name = "tipvivienda")
	private String tipVivienda;

	@Column(name = "dirteralt")
	private String dirTeralt;

	@Column(name = "barrio_tra")
	private String barrioTra;

	@Column(name = "pais_dir_trabajo")
	private String paisDirTrabajo;

	@Column(name = "dept_dir_trabajo")
	private String deptDirTrabajo;

	@Column(name = "ciu_dir_trabajo")
	private String ciuDirTrabajo;

	@Column(name = "faxter")
	private String faxter;

	@Column(name = "ind_contrato")
	private String indContrato;

	@Column(name = "param_text")
	private String paramText;

	@Column(name = "param_id")
	private String paramId;

	@Column(name = "ent_ban")
	private String entBan;

	@Column(name = "tip_cta")
	private String tipCta;

	@Column(name = "num_cta")
	private String numCta;

	@Column(name = "idconyuge")
	private String idConyuge;

	@Column(name = "nom_cony")
	private String nomCony;

	@Column(name = "emailconyuge")
	private String emailConyuge;

	@Column(name = "celconyuge")
	private String celConyuge;

	@Column(name = "ind_sec_economico")
	private String indSecEconomico;

	public Terceros() {
	}

	public Terceros(BigDecimal codTer, String docTip, String nitTer, String nomTercero, String priApellido,
			String segApellido, String lugarDoc, @Size(max = 60) String mailTer, String dirTerpal, String telter,
			String telter1, String telter2, String feExp, String paisCodigo, String codiDept, String codiCiud,
			String barrio, String antiEmpresa, String tipVivienda, String dirTeralt, String barrioTra,
			String paisDirTrabajo, String deptDirTrabajo, String ciuDirTrabajo, String faxter, String indContrato,
			String paramText, String entBan, String tipCta, String numCta, String idConyuge) {
		super();
		this.codTer = codTer;
		this.docTip = docTip;
		this.nitTer = nitTer;
		this.nomTercero = nomTercero;
		this.priApellido = priApellido;
		this.segApellido = segApellido;
		this.lugarDoc = lugarDoc;
		this.mailTer = mailTer;
		this.dirTerpal = dirTerpal;
		this.telter = telter;
		this.telter1 = telter1;
		this.telter2 = telter2;
		this.feExp = feExp;
		this.paisCodigo = paisCodigo;
		this.codiDept = codiDept;
		this.codiCiud = codiCiud;
		this.barrio = barrio;
		this.antiEmpresa = antiEmpresa;
		this.tipVivienda = tipVivienda;
		this.dirTeralt = dirTeralt;
		this.barrioTra = barrioTra;
		this.paisDirTrabajo = paisDirTrabajo;
		this.deptDirTrabajo = deptDirTrabajo;
		this.ciuDirTrabajo = ciuDirTrabajo;
		this.faxter = faxter;
		this.indContrato = indContrato;
		this.paramText = paramText;
		this.entBan = entBan;
		this.tipCta = tipCta;
		this.numCta = numCta;
		this.idConyuge = idConyuge;
	}

	public String getDocTip() {
		return docTip;
	}

	public void setDocTip(String docTip) {
		this.docTip = docTip;
	}

	public String getNitTer() {
		return nitTer;
	}

	public void setNitTer(String nitTer) {
		this.nitTer = nitTer;
	}

	public BigDecimal getCodTer() {
		return codTer;
	}

	public void setCodTer(BigDecimal codTer) {
		this.codTer = codTer;
	}

	public String getNomTercero() {
		return nomTercero;
	}

	public void setNomTercero(String nomTercero) {
		this.nomTercero = nomTercero;
	}

	public String getPriApellido() {
		return priApellido;
	}

	public void setPriApellido(String priApellido) {
		this.priApellido = priApellido;
	}

	public String getSegApellido() {
		return segApellido;
	}

	public void setSegApellido(String segApellido) {
		this.segApellido = segApellido;
	}

	public String getLugarDoc() {
		return lugarDoc;
	}

	public void setLugarDoc(String lugarDoc) {
		this.lugarDoc = lugarDoc;
	}

	public String getMailTer() {
		return mailTer;
	}

	public void setMailTer(String mailTer) {
		this.mailTer = mailTer;
	}

	public String getDirTerpal() {
		return dirTerpal;
	}

	public void setDirTerpal(String dirTerpal) {
		this.dirTerpal = dirTerpal;
	}

	public String getTelter() {
		return telter;
	}

	public void setTelter(String telter) {
		this.telter = telter;
	}

	public String getTelter1() {
		return telter1;
	}

	public void setTelter1(String telter1) {
		this.telter1 = telter1;
	}

	public String getTelter2() {
		return telter2;
	}

	public void setTelter2(String telter2) {
		this.telter2 = telter2;
	}

	public String getFeExp() {
		return feExp;
	}

	public void setFeExp(String feExp) {
		this.feExp = feExp;
	}

	public String getPaisCodigo() {
		return paisCodigo;
	}

	public void setPaisCodigo(String paisCodigo) {
		this.paisCodigo = paisCodigo;
	}

	public String getCodiDept() {
		return codiDept;
	}

	public void setCodiDept(String codiDept) {
		this.codiDept = codiDept;
	}

	public String getCodiCiud() {
		return codiCiud;
	}

	public void setCodiCiud(String codiCiud) {
		this.codiCiud = codiCiud;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getAntiEmpresa() {
		return antiEmpresa;
	}

	public void setAntiEmpresa(String antiEmpresa) {
		this.antiEmpresa = antiEmpresa;
	}

	public String getTipVivienda() {
		return tipVivienda;
	}

	public void setTipVivienda(String tipVivienda) {
		this.tipVivienda = tipVivienda;
	}

	public String getDirTeralt() {
		return dirTeralt;
	}

	public void setDirTeralt(String dirTeralt) {
		this.dirTeralt = dirTeralt;
	}

	public String getBarrioTra() {
		return barrioTra;
	}

	public void setBarrioTra(String barrioTra) {
		this.barrioTra = barrioTra;
	}

	public String getPaisDirTrabajo() {
		return paisDirTrabajo;
	}

	public void setPaisDirTrabajo(String paisDirTrabajo) {
		this.paisDirTrabajo = paisDirTrabajo;
	}

	public String getDeptDirTrabajo() {
		return deptDirTrabajo;
	}

	public void setDeptDirTrabajo(String deptDirTrabajo) {
		this.deptDirTrabajo = deptDirTrabajo;
	}

	public String getCiuDirTrabajo() {
		return ciuDirTrabajo;
	}

	public void setCiuDirTrabajo(String ciuDirTrabajo) {
		this.ciuDirTrabajo = ciuDirTrabajo;
	}

	public String getFaxter() {
		return faxter;
	}

	public void setFaxter(String faxter) {
		this.faxter = faxter;
	}

	public String getIndContrato() {
		return indContrato;
	}

	public void setIndContrato(String indContrato) {
		this.indContrato = indContrato;
	}

	public String getParamText() {
		return paramText;
	}

	public void setParamText(String paramText) {
		this.paramText = paramText;
	}

	public String getEntBan() {
		return entBan;
	}

	public void setEntBan(String entBan) {
		this.entBan = entBan;
	}

	public String getTipCta() {
		return tipCta;
	}

	public void setTipCta(String tipCta) {
		this.tipCta = tipCta;
	}

	public String getNumCta() {
		return numCta;
	}

	public void setNumCta(String numCta) {
		this.numCta = numCta;
	}

	public String getIdConyuge() {
		return idConyuge;
	}

	public void setIdConyuge(String idConyuge) {
		this.idConyuge = idConyuge;
	}

	public String getNomTer() {
		return nomTer;
	}

	public void setNomTer(String nomTer) {
		this.nomTer = nomTer;
	}

	public String getParamId() {
		return paramId;
	}

	public void setParamId(String paramId) {
		this.paramId = paramId;
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

	public String getIndSecEconomico() {
		return indSecEconomico;
	}

	public void setIndSecEconomico(String indSecEconomico) {
		this.indSecEconomico = indSecEconomico;
	}

}
