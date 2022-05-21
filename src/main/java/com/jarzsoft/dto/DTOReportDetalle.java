package com.jarzsoft.dto;

public class DTOReportDetalle {
	String idSolicitud;
	String nombreArchivo;
	byte[] archivo;

	public DTOReportDetalle(String idSolicitud, String nombreArchivo, byte[] archivo) {
		super();
		this.idSolicitud = idSolicitud;
		this.nombreArchivo = nombreArchivo;
		this.archivo = archivo;
	}

	public DTOReportDetalle() {
		super();
	}

	public String getIdSolicitud() {
		return idSolicitud;
	}

	public void setIdSolicitud(String idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public byte[] getArchivo() {
		return archivo;
	}

	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}

}
