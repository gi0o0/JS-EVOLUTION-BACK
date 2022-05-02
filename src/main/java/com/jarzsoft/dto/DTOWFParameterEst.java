package com.jarzsoft.dto;

import java.util.Date;

public class DTOWFParameterEst {

	private Long idWf;
	private Long idEstado;
	private String nomEstado;
	private boolean indInicio;
	private boolean indFinal;
	private Long ordEstado;
	private String usuUltMod;
	private Date fecUltMod;
	private Date fecCrea;
	private String usuCrea;

	public DTOWFParameterEst() {
		super();
	}

	public DTOWFParameterEst(Long idWf, Long idEstado, String nomEstado, boolean indInicio, boolean indFinal,
			Long ordEstado, String usuUltMod, Date fecUltMod, Date fecCrea, String usuCrea) {
		super();
		this.idWf = idWf;
		this.idEstado = idEstado;
		this.nomEstado = nomEstado;
		this.indInicio = indInicio;
		this.indFinal = indFinal;
		this.ordEstado = ordEstado;
		this.usuUltMod = usuUltMod;
		this.fecUltMod = fecUltMod;
		this.fecCrea = fecCrea;
		this.usuCrea = usuCrea;
	}

	public Long getIdWf() {
		return idWf;
	}

	public void setIdWf(Long idWf) {
		this.idWf = idWf;
	}

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public String getNomEstado() {
		return nomEstado;
	}

	public void setNomEstado(String nomEstado) {
		this.nomEstado = nomEstado;
	}

	public boolean isIndInicio() {
		return indInicio;
	}

	public void setIndInicio(boolean indInicio) {
		this.indInicio = indInicio;
	}

	public boolean isIndFinal() {
		return indFinal;
	}

	public void setIndFinal(boolean indFinal) {
		this.indFinal = indFinal;
	}

	public Long getOrdEstado() {
		return ordEstado;
	}

	public void setOrdEstado(Long ordEstado) {
		this.ordEstado = ordEstado;
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
	
	

}
