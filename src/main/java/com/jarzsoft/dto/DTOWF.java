package com.jarzsoft.dto;

public class DTOWF {

	private String idWf;
	private String idStep;
	private String idSubStep;
	private String nextStep;
	private Integer numeroRadicacion;
	private String entitie;
	private String tipSolCredito;
	private String valorPress;
	private String foticrep;
	private String perCuota;
	private String doctip;
	private String nitter;
	private String nomTer;
	private String priApellido;
	private String segApellido;
	private String lugarDoc;
	private String mailTer;
	private String dirTerpal;
	private String telTer;
	private String telTer1;
	private String telTer2;
	private String paisCodigo;
	private String codiDept;
	private String codiCiud;
	private String barrio;
	private String fecIngEmpresa;
	private String antiEmpresa;
	private String fecCump;
	private String tipVivienda;
	private String dirTeralt;
	private String barrioTra;
	private String paisDirTrabajo;
	private String deptDirTrabajo;
	private String codiciuDirTrabajoCiud;
	private String faxTer;
	private String codProfe;
	private String indContrato;
	private String paramText;
	private String entBan;
	private String tipCta;
	private String numCta;
	private String idConyuge;
	private String nomCony;
	private String emailConyuge;
	private String celConyuge;
	private String nroCuotas;
	private String refNombre1;
	private String refParen1;
	private String refMail1;
	private String refCel1;
	private String refNombre2;
	private String refParen2;
	private String refMail2;
	private String refCel2;
	private String refNombre3;
	private String refParen3;
	private String refMail3;
	private String refCel3;
	private String bienNombre;
	private String bienValor;
	private String bienAfecta;
	private String bienHipoteca;
	private String bienHipAFavor;
	private String vehMarca;
	private String vehClase;
	private String vehModelo;
	private String vehPlaca;
	private String vehPignorado;
	private String vehPigAFavor;
	private String vehValVomercial;
	private DTOWFCodeu codeu;
	private String comments;
	private String token;
	private String estado;

	public DTOWF() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTOWF(String idWf, String entitie, String tipSolCredito, String valorPress, String foticrep, String perCuota,
			String doctip, String nitter, String nomTer, String priApellido, String segApellido, String lugarDoc,
			String mailTer, String dirTerpal, String telTer, String telTer1, String telTer2, String paisCodigo,
			String codiDept, String codiCiud, String barrio, String fecIngEmpresa, String antiEmpresa, String fecCump,
			String tipVivienda, String dirTeralt, String barrioTra, String paisDirTrabajo, String deptDirTrabajo,
			String codiciuDirTrabajoCiud, String faxTer, String codProfe, String indContrato, String paramText,
			String entBan, String tipCta, String numCta, String idConyuge, String nomCony, String emailConyuge,
			String celConyuge, String nroCuotas, String refNombre1, String refParen1, String refMail1, String refCel1,
			String refNombre2, String refParen2, String refMail2, String refCel2, String refNombre3, String refParen3,
			String refMail3, String refCel13, String bienNombre, String bienValor, String bienAfecta,
			String bienHipoteca, String bienHipAFavor, String vehMarca, String vehClase, String vehModelo,
			String vehPlaca, String vehPignorado, String vehPigAFavor, String vehValVomercial, DTOWFCodeu codeu,
			String comments) {
		super();
		this.idWf = idWf;
		this.entitie = entitie;
		this.tipSolCredito = tipSolCredito;
		this.valorPress = valorPress;
		this.foticrep = foticrep;
		this.perCuota = perCuota;
		this.doctip = doctip;
		this.nitter = nitter;
		this.nomTer = nomTer;
		this.priApellido = priApellido;
		this.segApellido = segApellido;
		this.lugarDoc = lugarDoc;
		this.mailTer = mailTer;
		this.dirTerpal = dirTerpal;
		this.telTer = telTer;
		this.telTer1 = telTer1;
		this.telTer2 = telTer2;
		this.paisCodigo = paisCodigo;
		this.codiDept = codiDept;
		this.codiCiud = codiCiud;
		this.barrio = barrio;
		this.fecIngEmpresa = fecIngEmpresa;
		this.antiEmpresa = antiEmpresa;
		this.fecCump = fecCump;
		this.tipVivienda = tipVivienda;
		this.dirTeralt = dirTeralt;
		this.barrioTra = barrioTra;
		this.paisDirTrabajo = paisDirTrabajo;
		this.deptDirTrabajo = deptDirTrabajo;
		this.codiciuDirTrabajoCiud = codiciuDirTrabajoCiud;
		this.faxTer = faxTer;
		this.codProfe = codProfe;
		this.indContrato = indContrato;
		this.paramText = paramText;
		this.entBan = entBan;
		this.tipCta = tipCta;
		this.numCta = numCta;
		this.idConyuge = idConyuge;
		this.nomCony = nomCony;
		this.emailConyuge = emailConyuge;
		this.celConyuge = celConyuge;
		this.nroCuotas = nroCuotas;
		this.refNombre1 = refNombre1;
		this.refParen1 = refParen1;
		this.refMail1 = refMail1;
		this.refCel1 = refCel1;
		this.refNombre2 = refNombre2;
		this.refParen2 = refParen2;
		this.refMail2 = refMail2;
		this.refCel2 = refCel2;
		this.refNombre3 = refNombre3;
		this.refParen3 = refParen3;
		this.refMail3 = refMail3;
		this.refCel3 = refCel13;
		this.bienNombre = bienNombre;
		this.bienValor = bienValor;
		this.bienAfecta = bienAfecta;
		this.bienHipoteca = bienHipoteca;
		this.bienHipAFavor = bienHipAFavor;
		this.vehMarca = vehMarca;
		this.vehClase = vehClase;
		this.vehModelo = vehModelo;
		this.vehPlaca = vehPlaca;
		this.vehPignorado = vehPignorado;
		this.vehPigAFavor = vehPigAFavor;
		this.vehValVomercial = vehValVomercial;
		this.codeu = codeu;
		this.comments = comments;
	}

	public String getIdWf() {
		return idWf;
	}

	public void setIdWf(String idWf) {
		this.idWf = idWf;
	}

	public String getEntitie() {
		return entitie;
	}

	public void setEntitie(String entitie) {
		this.entitie = entitie;
	}

	public String getTipSolCredito() {
		return tipSolCredito;
	}

	public void setTipSolCredito(String tipSolCredito) {
		this.tipSolCredito = tipSolCredito;
	}

	public String getValorPress() {
		return valorPress;
	}

	public void setValorPress(String valorPress) {
		this.valorPress = valorPress;
	}

	public String getFoticrep() {
		return foticrep;
	}

	public void setFoticrep(String foticrep) {
		this.foticrep = foticrep;
	}

	public String getPerCuota() {
		return perCuota;
	}

	public void setPerCuota(String perCuota) {
		this.perCuota = perCuota;
	}

	public String getDoctip() {
		return doctip;
	}

	public void setDoctip(String doctip) {
		this.doctip = doctip;
	}

	public String getNitter() {
		return nitter;
	}

	public void setNitter(String nitter) {
		this.nitter = nitter;
	}

	public String getNomTer() {
		return nomTer;
	}

	public void setNomTer(String nomTer) {
		this.nomTer = nomTer;
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

	public String getTelTer() {
		return telTer;
	}

	public void setTelTer(String telTer) {
		this.telTer = telTer;
	}

	public String getTelTer1() {
		return telTer1;
	}

	public void setTelTer1(String telTer1) {
		this.telTer1 = telTer1;
	}

	public String getTelTer2() {
		return telTer2;
	}

	public void setTelTer2(String telTer2) {
		this.telTer2 = telTer2;
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

	public String getFecIngEmpresa() {
		return fecIngEmpresa;
	}

	public void setFecIngEmpresa(String fecIngEmpresa) {
		this.fecIngEmpresa = fecIngEmpresa;
	}

	public String getAntiEmpresa() {
		return antiEmpresa;
	}

	public void setAntiEmpresa(String antiEmpresa) {
		this.antiEmpresa = antiEmpresa;
	}

	public String getFecCump() {
		return fecCump;
	}

	public void setFecCump(String fecCump) {
		this.fecCump = fecCump;
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

	public String getCodiciuDirTrabajoCiud() {
		return codiciuDirTrabajoCiud;
	}

	public void setCodiciuDirTrabajoCiud(String codiciuDirTrabajoCiud) {
		this.codiciuDirTrabajoCiud = codiciuDirTrabajoCiud;
	}

	public String getFaxTer() {
		return faxTer;
	}

	public void setFaxTer(String faxTer) {
		this.faxTer = faxTer;
	}

	public String getCodProfe() {
		return codProfe;
	}

	public void setCodProfe(String codProfe) {
		this.codProfe = codProfe;
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

	public String getNroCuotas() {
		return nroCuotas;
	}

	public void setNroCuotas(String nroCuotas) {
		this.nroCuotas = nroCuotas;
	}

	public String getRefNombre1() {
		return refNombre1;
	}

	public void setRefNombre1(String refNombre1) {
		this.refNombre1 = refNombre1;
	}

	public String getRefParen1() {
		return refParen1;
	}

	public void setRefParen1(String refParen1) {
		this.refParen1 = refParen1;
	}

	public String getRefMail1() {
		return refMail1;
	}

	public void setRefMail1(String refMail1) {
		this.refMail1 = refMail1;
	}

	public String getRefCel1() {
		return refCel1;
	}

	public void setRefCel1(String refCel1) {
		this.refCel1 = refCel1;
	}

	public String getRefNombre2() {
		return refNombre2;
	}

	public void setRefNombre2(String refNombre2) {
		this.refNombre2 = refNombre2;
	}

	public String getRefParen2() {
		return refParen2;
	}

	public void setRefParen2(String refParen2) {
		this.refParen2 = refParen2;
	}

	public String getRefMail2() {
		return refMail2;
	}

	public void setRefMail2(String refMail2) {
		this.refMail2 = refMail2;
	}

	public String getRefCel2() {
		return refCel2;
	}

	public void setRefCel2(String refCel2) {
		this.refCel2 = refCel2;
	}

	public String getRefNombre3() {
		return refNombre3;
	}

	public void setRefNombre3(String refNombre3) {
		this.refNombre3 = refNombre3;
	}

	public String getRefParen3() {
		return refParen3;
	}

	public void setRefParen3(String refParen3) {
		this.refParen3 = refParen3;
	}

	public String getRefMail3() {
		return refMail3;
	}

	public void setRefMail3(String refMail3) {
		this.refMail3 = refMail3;
	}

	public String getRefCel3() {
		return refCel3;
	}

	public void setRefCel3(String refCel3) {
		this.refCel3 = refCel3;
	}

	public String getBienNombre() {
		return bienNombre;
	}

	public void setBienNombre(String bienNombre) {
		this.bienNombre = bienNombre;
	}

	public String getBienValor() {
		return bienValor;
	}

	public void setBienValor(String bienValor) {
		this.bienValor = bienValor;
	}

	public String getBienAfecta() {
		return bienAfecta;
	}

	public void setBienAfecta(String bienAfecta) {
		this.bienAfecta = bienAfecta;
	}

	public String getBienHipoteca() {
		return bienHipoteca;
	}

	public void setBienHipoteca(String bienHipoteca) {
		this.bienHipoteca = bienHipoteca;
	}

	public String getBienHipAFavor() {
		return bienHipAFavor;
	}

	public void setBienHipAFavor(String bienHipAFavor) {
		this.bienHipAFavor = bienHipAFavor;
	}

	public String getVehMarca() {
		return vehMarca;
	}

	public void setVehMarca(String vehMarca) {
		this.vehMarca = vehMarca;
	}

	public String getVehClase() {
		return vehClase;
	}

	public void setVehClase(String vehClase) {
		this.vehClase = vehClase;
	}

	public String getVehModelo() {
		return vehModelo;
	}

	public void setVehModelo(String vehModelo) {
		this.vehModelo = vehModelo;
	}

	public String getVehPlaca() {
		return vehPlaca;
	}

	public void setVehPlaca(String vehPlaca) {
		this.vehPlaca = vehPlaca;
	}

	public String getVehPignorado() {
		return vehPignorado;
	}

	public void setVehPignorado(String vehPignorado) {
		this.vehPignorado = vehPignorado;
	}

	public String getVehPigAFavor() {
		return vehPigAFavor;
	}

	public void setVehPigAFavor(String vehPigAFavor) {
		this.vehPigAFavor = vehPigAFavor;
	}

	public String getVehValVomercial() {
		return vehValVomercial;
	}

	public void setVehValVomercial(String vehValVomercial) {
		this.vehValVomercial = vehValVomercial;
	}

	public DTOWFCodeu getCodeu() {
		return codeu;
	}

	public void setCodeu(DTOWFCodeu codeu) {
		this.codeu = codeu;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getNumeroRadicacion() {
		return numeroRadicacion;
	}

	public void setNumeroRadicacion(Integer numeroRadicacion) {
		this.numeroRadicacion = numeroRadicacion;
	}

	public String getIdStep() {
		return idStep;
	}

	public void setIdStep(String idStep) {
		this.idStep = idStep;
	}

	public String getIdSubStep() {
		return idSubStep;
	}

	public void setIdSubStep(String idSubStep) {
		this.idSubStep = idSubStep;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getNextStep() {
		return nextStep;
	}

	public void setNextStep(String nextStep) {
		this.nextStep = nextStep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
