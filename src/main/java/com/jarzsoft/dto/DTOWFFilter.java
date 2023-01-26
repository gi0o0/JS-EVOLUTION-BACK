package com.jarzsoft.dto;

public class DTOWFFilter {

	private String fechaInit;
	private String fechaFin;
	private String entitie;
	private String asesor;
	private String estado;
	private String sector;

	public DTOWFFilter() {
		super();
	}

	public DTOWFFilter(String fechaInit, String fechaFin, String entitie, String asesor, String estado, String sector) {
		super();
		this.fechaInit = fechaInit;
		this.fechaFin = fechaFin;
		this.entitie = entitie;
		this.asesor = asesor;
		this.estado = estado;
		this.sector = sector;
	}

	public String getFechaInit() {
		return fechaInit;
	}

	public void setFechaInit(String fechaInit) {
		this.fechaInit = fechaInit;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getEntitie() {
		return entitie;
	}

	public void setEntitie(String entitie) {
		this.entitie = entitie;
	}

	public String getAsesor() {
		return asesor;
	}

	public void setAsesor(String asesor) {
		this.asesor = asesor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

}
