package com.jarzsoft.dto;

import java.util.Date;

public class DTOWFParameterStepDoc {

	private Long idWf;
	private Long idPaso;
	private Long idDocumento;
	private String nomDocumento;
	private String envRec;
	private String usuUltMod;
	private Date fecUltMod;
	private Date fecCrea;
	private String usuCrea;
	private String indObligatorio;



	public DTOWFParameterStepDoc(Long idWf, Long idPaso, Long idDocumento, String nomDocumento, String envRec,
			String usuUltMod, Date fecUltMod, Date fecCrea, String usuCrea, String indObligatorio) {
		super();
		this.idWf = idWf;
		this.idPaso = idPaso;
		this.idDocumento = idDocumento;
		this.nomDocumento = nomDocumento;
		this.envRec = envRec;
		this.usuUltMod = usuUltMod;
		this.fecUltMod = fecUltMod;
		this.fecCrea = fecCrea;
		this.usuCrea = usuCrea;
		this.indObligatorio = indObligatorio;
	}

	public Long getIdWf() {
		return idWf;
	}

	public void setIdWf(Long idWf) {
		this.idWf = idWf;
	}

	public Long getIdPaso() {
		return idPaso;
	}

	public void setIdPaso(Long idPaso) {
		this.idPaso = idPaso;
	}

	public Long getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(Long idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getNomDocumento() {
		return nomDocumento;
	}

	public void setNomDocumento(String nomDocumento) {
		this.nomDocumento = nomDocumento;
	}

	public String getEnvRec() {
		return envRec;
	}

	public void setEnvRec(String envRec) {
		this.envRec = envRec;
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

	public String getIndObligatorio() {
		return indObligatorio;
	}

	public void setIndObligatorio(String indObligatorio) {
		this.indObligatorio = indObligatorio;
	}

}
