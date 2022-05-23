package com.jarzsoft.dto;

import java.util.Date;

import org.springframework.web.context.request.RequestContextHolder;

import com.jarzsoft.util.FechaUtils;

public class LogArchivoDTO {
	private String timestamp;
	private String solucion;
	private String aplicacion;
	private String componente;
	private String idTransaccion;
	private String documento;
	private String tipo;
	private String tipoDocumento;
	private String correo;
	private String asunto;
	private String mensaje;
	private String evento;
	private String acción;
	private String funcionalidad;

	public LogArchivoDTO(String componente, String tipo, String evento,String documento,String tipoDocumento,String acción, String funcionalidad ) {
		super();

		this.timestamp = FechaUtils.getFechaStringTimestamp(new Date());
		this.solucion = "JARZ";
		this.aplicacion = "JARZ_SOFT";
		this.componente = componente;
		this.idTransaccion = RequestContextHolder.currentRequestAttributes().getSessionId();
		this.tipo = tipo;
		this.correo = "-";
		this.asunto = "-";
		this.mensaje = "-";
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.evento = evento;
		this.acción = acción;
		this.funcionalidad = funcionalidad;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(timestamp);
		sb.append("|").append(solucion);
		sb.append("|").append(aplicacion);
		sb.append("|").append(componente);
		sb.append("|").append(idTransaccion);
		sb.append("|").append(tipo);
		sb.append("|").append(correo);
		sb.append("|").append(asunto);
		sb.append("|").append(mensaje);
		sb.append("|");
		sb.append(getEventoString());
		return sb.toString();
	}

	private String getEventoString() {
		StringBuilder sbError = new StringBuilder();
		sbError.append("[");
		if (evento != null)
			sbError.append(evento + ",");
		sbError.append("]");
		return sbError.toString().replace(",]", "]");
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getSolucion() {
		return solucion;
	}

	public void setSolucion(String solucion) {
		this.solucion = solucion;
	}

	public String getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}

	public String getComponente() {
		return componente;
	}

	public void setComponente(String componente) {
		this.componente = componente;
	}

	public String getIdTransaccion() {
		return idTransaccion;
	}

	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getEvento() {
		return evento;
	}

	public void setEvento(String evento) {
		this.evento = evento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getAcción() {
		return acción;
	}

	public void setAcción(String acción) {
		this.acción = acción;
	}

	public String getFuncionalidad() {
		return funcionalidad;
	}

	public void setFuncionalidad(String funcionalidad) {
		this.funcionalidad = funcionalidad;
	}
	

}