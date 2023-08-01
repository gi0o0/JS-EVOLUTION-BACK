package com.jarzsoft.dto;

import java.util.List;

public class DTOWFPqr {

	private String idWf;
	private String nameWf;
	private Boolean isUpdate;
	private String idStep;
	private String nameStep;
	private String idStepNow;
	private String idSubStep;
	private String idMov;
	private String nextStep;
	private Integer numeroRadicacion;
	private String entitie;
	private String company;
	private String doctip;
	private String codTer;
	private String nitter;
	private String nomTer;
	private String lugarDoc;
	private String feExp;
	private String mailTer;
	private String dirTerpal;
	private List<DTOWfDocs> files;
	private List<DTOFilesUser> filesEmail;
	private Boolean isRequiredFiles;
	private Boolean isRequiredEmail;
	private String token;
	private String comments;
	private String state;
	private String walletType;
	private String stateType;
	private List<DTOWWfMov> movs;

	private Boolean estadoCuenta;
	private Boolean certificadoDeuda;
	private Boolean pazSalvo;
	private Boolean certificado;
	private Boolean derechoPeticion;
	private List<String> credtis;

	private String usuComercial;
	private String fecUltMod;

	public DTOWFPqr() {
		super();
	}

	public DTOWFPqr(String idWf, Boolean isUpdate, String idStep, String idStepNow, String idSubStep, String nextStep,
			String entitie, String doctip, String codTer, String nitter, String nomTer, String lugarDoc, String feExp,
			String mailTer, String dirTerpal, List<DTOWfDocs> files, Boolean isRequiredFiles, String token,
			String comments) {
		super();
		this.idWf = idWf;
		this.isUpdate = isUpdate;
		this.idStep = idStep;
		this.idStepNow = idStepNow;
		this.idSubStep = idSubStep;
		this.nextStep = nextStep;
		this.entitie = entitie;
		this.doctip = doctip;
		this.codTer = codTer;
		this.nitter = nitter;
		this.nomTer = nomTer;
		this.lugarDoc = lugarDoc;
		this.feExp = feExp;
		this.mailTer = mailTer;
		this.dirTerpal = dirTerpal;
		this.files = files;
		this.isRequiredFiles = isRequiredFiles;
		this.token = token;
		this.comments = comments;
	}

	public String getIdWf() {
		return idWf;
	}

	public void setIdWf(String idWf) {
		this.idWf = idWf;
	}

	public Boolean getIsUpdate() {
		return isUpdate;
	}

	public void setIsUpdate(Boolean isUpdate) {
		this.isUpdate = isUpdate;
	}

	public String getIdStep() {
		return idStep;
	}

	public void setIdStep(String idStep) {
		this.idStep = idStep;
	}

	public String getIdStepNow() {
		return idStepNow;
	}

	public void setIdStepNow(String idStepNow) {
		this.idStepNow = idStepNow;
	}

	public String getIdSubStep() {
		return idSubStep;
	}

	public void setIdSubStep(String idSubStep) {
		this.idSubStep = idSubStep;
	}

	public String getNextStep() {
		return nextStep;
	}

	public void setNextStep(String nextStep) {
		this.nextStep = nextStep;
	}

	public String getEntitie() {
		return entitie;
	}

	public void setEntitie(String entitie) {
		this.entitie = entitie;
	}

	public String getDoctip() {
		return doctip;
	}

	public void setDoctip(String doctip) {
		this.doctip = doctip;
	}

	public String getCodTer() {
		return codTer;
	}

	public void setCodTer(String codTer) {
		this.codTer = codTer;
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

	public String getLugarDoc() {
		return lugarDoc;
	}

	public void setLugarDoc(String lugarDoc) {
		this.lugarDoc = lugarDoc;
	}

	public String getFeExp() {
		return feExp;
	}

	public void setFeExp(String feExp) {
		this.feExp = feExp;
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

	public List<DTOWfDocs> getFiles() {
		return files;
	}

	public void setFiles(List<DTOWfDocs> files) {
		this.files = files;
	}

	public Boolean getIsRequiredFiles() {
		return isRequiredFiles;
	}

	public void setIsRequiredFiles(Boolean isRequiredFiles) {
		this.isRequiredFiles = isRequiredFiles;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Boolean getIsRequiredEmail() {
		return isRequiredEmail;
	}

	public void setIsRequiredEmail(Boolean isRequiredEmail) {
		this.isRequiredEmail = isRequiredEmail;
	}

	public Integer getNumeroRadicacion() {
		return numeroRadicacion;
	}

	public void setNumeroRadicacion(Integer numeroRadicacion) {
		this.numeroRadicacion = numeroRadicacion;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Boolean getEstadoCuenta() {
		return estadoCuenta;
	}

	public void setEstadoCuenta(Boolean estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	public Boolean getCertificadoDeuda() {
		return certificadoDeuda;
	}

	public void setCertificadoDeuda(Boolean certificadoDeuda) {
		this.certificadoDeuda = certificadoDeuda;
	}

	public Boolean getPazSalvo() {
		return pazSalvo;
	}

	public void setPazSalvo(Boolean pazSalvo) {
		this.pazSalvo = pazSalvo;
	}

	public Boolean getCertificado() {
		return certificado;
	}

	public void setCertificado(Boolean certificado) {
		this.certificado = certificado;
	}

	public Boolean getDerechoPeticion() {
		return derechoPeticion;
	}

	public void setDerechoPeticion(Boolean derechoPeticion) {
		this.derechoPeticion = derechoPeticion;
	}

	public List<String> getCredtis() {
		return credtis;
	}

	public void setCredtis(List<String> credtis) {
		this.credtis = credtis;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getWalletType() {
		return walletType;
	}

	public void setWalletType(String walletType) {
		this.walletType = walletType;
	}

	public String getStateType() {
		return stateType;
	}

	public void setStateType(String stateType) {
		this.stateType = stateType;
	}

	public String getIdMov() {
		return idMov;
	}

	public void setIdMov(String idMov) {
		this.idMov = idMov;
	}

	public List<DTOWWfMov> getMovs() {
		return movs;
	}

	public void setMovs(List<DTOWWfMov> movs) {
		this.movs = movs;
	}

	public String getNameWf() {
		return nameWf;
	}

	public void setNameWf(String nameWf) {
		this.nameWf = nameWf;
	}

	public String getNameStep() {
		return nameStep;
	}

	public void setNameStep(String nameStep) {
		this.nameStep = nameStep;
	}

	public String getUsuComercial() {
		return usuComercial;
	}

	public void setUsuComercial(String usuComercial) {
		this.usuComercial = usuComercial;
	}

	public String getFecUltMod() {
		return fecUltMod;
	}

	public void setFecUltMod(String fecUltMod) {
		this.fecUltMod = fecUltMod;
	}

	public List<DTOFilesUser> getFilesEmail() {
		return filesEmail;
	}

	public void setFilesEmail(List<DTOFilesUser> filesEmail) {
		this.filesEmail = filesEmail;
	}

}
