package com.jarzsoft.dto;

public class DTOStepsState {

	private String codTer;
	private String numeroRadicacion;
	private String usuario;
	private String usuarioC;
	private String fecha;
	private String idPaso;
	private String comentarios;
	private String estPaso;
	private String numCredito;
	private String numDoc;
	private String tipoDocu;

	public DTOStepsState() {
		super();
	}

	public DTOStepsState(String codTer, String numeroRadicacion, String usuario, String usuarioC, String fecha,
			String idPaso, String comentarios, String estPaso, String numCredito, String numDoc, String tipoDocu) {
		super();
		this.codTer = codTer;
		this.numeroRadicacion = numeroRadicacion;
		this.usuario = usuario;
		this.usuarioC = usuarioC;
		this.fecha = fecha;
		this.idPaso = idPaso;
		this.comentarios = comentarios;
		this.estPaso = estPaso;
		this.numCredito = numCredito;
		this.numDoc = numDoc;
		this.tipoDocu = tipoDocu;
	}

	public String getCodTer() {
		return codTer;
	}

	public void setCodTer(String codTer) {
		this.codTer = codTer;
	}

	public String getNumeroRadicacion() {
		return numeroRadicacion;
	}

	public void setNumeroRadicacion(String numeroRadicacion) {
		this.numeroRadicacion = numeroRadicacion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getUsuarioC() {
		return usuarioC;
	}

	public void setUsuarioC(String usuarioC) {
		this.usuarioC = usuarioC;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getIdPaso() {
		return idPaso;
	}

	public void setIdPaso(String idPaso) {
		this.idPaso = idPaso;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getEstPaso() {
		return estPaso;
	}

	public void setEstPaso(String estPaso) {
		this.estPaso = estPaso;
	}

	public String getNumCredito() {
		return numCredito;
	}

	public void setNumCredito(String numCredito) {
		this.numCredito = numCredito;
	}

	public String getNumDoc() {
		return numDoc;
	}

	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}

	public String getTipoDocu() {
		return tipoDocu;
	}

	public void setTipoDocu(String tipoDocu) {
		this.tipoDocu = tipoDocu;
	}

}
