package com.jarzsoft.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "web.w_wf_pasos")
public class W_Wf_Pasos implements Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private W_Wf_PasosPK w_Wf_PasosPK;

	@Size(max = 100)
	@Column(name = "nom_paso")
	private String nomPaso;

	@Size(max = 200)
	@Column(name = "email1")
	private String email1;

	@Size(max = 200)
	@Column(name = "email2")
	private String email2;

	@Size(max = 200)
	@Column(name = "email3")
	private String email3;

	@Size(max = 5)
	@Column(name = "sol_autoriza")
	private String solAutoriza;

	@Size(max = 5)
	@Column(name = "sol_documentos")
	private String solDocumentos;

	@Column(name = "ord_paso")
	private Long ordPaso;

	@Size(max = 5)
	@Column(name = "env_correo_paso")
	private String envCorreoPaso;

	@Size(max = 5)
	@Column(name = "env_correo_autoriza")
	private String envCorreoAutoriza;

	@Size(max = 100)
	@Column(name = "asunto_correo")
	private String asuntoCorreo;

	@Size(max = 100)
	@Column(name = "texto_correo")
	private String textoCorreo;

	@Column(name = "tiempo_alerta1")
	private Long tiempoAlerta1;

	@Column(name = "tiempo_alerta2")
	private Long tiempoAlerta2;

	@Column(name = "tiempo_alerta3")
	private Long tiempoAlerta3;

	@Size(max = 10)
	@Column(name = "USU_ULT_MOD")
	private String usuUltMod;

	@Column(name = "FEC_ULT_MOD")
	private Date fecUltMod;

	@Column(name = "fec_crea")
	private Date fecCrea;

	@Size(max = 10)
	@Column(name = "usu_crea")
	private String usuCrea;

	public W_Wf_Pasos() {
	}

	public W_Wf_Pasos(W_Wf_PasosPK w_Wf_PasosPK, @Size(max = 100) String nomPaso, @Size(max = 200) String email1,
			@Size(max = 200) String email2, @Size(max = 200) String email3, @Size(max = 1) String solAutoriza,
			@Size(max = 1) String solDocumentos, Long ordPaso, @Size(max = 1) String envCorreoPaso,
			@Size(max = 1) String envCorreoAutoriza, @Size(max = 100) String asuntoCorreo,
			@Size(max = 100) String textoCorreo, Long tiempoAlerta1, Long tiempoAlerta2, Long tiempoAlerta3,
			@Size(max = 10) String usuUltMod, Date fecUltMod, Date fecCrea, @Size(max = 10) String usuCrea) {
		super();
		this.w_Wf_PasosPK = w_Wf_PasosPK;
		this.nomPaso = nomPaso;
		this.email1 = email1;
		this.email2 = email2;
		this.email3 = email3;
		this.solAutoriza = solAutoriza;
		this.solDocumentos = solDocumentos;
		this.ordPaso = ordPaso;
		this.envCorreoPaso = envCorreoPaso;
		this.envCorreoAutoriza = envCorreoAutoriza;
		this.asuntoCorreo = asuntoCorreo;
		this.textoCorreo = textoCorreo;
		this.tiempoAlerta1 = tiempoAlerta1;
		this.tiempoAlerta2 = tiempoAlerta2;
		this.tiempoAlerta3 = tiempoAlerta3;
		this.usuUltMod = usuUltMod;
		this.fecUltMod = fecUltMod;
		this.fecCrea = fecCrea;
		this.usuCrea = usuCrea;
	}

	public W_Wf_PasosPK getW_Wf_PasosPK() {
		return w_Wf_PasosPK;
	}

	public void setW_Wf_PasosPK(W_Wf_PasosPK w_Wf_PasosPK) {
		this.w_Wf_PasosPK = w_Wf_PasosPK;
	}

	public String getNomPaso() {
		return nomPaso;
	}

	public void setNomPaso(String nomPaso) {
		this.nomPaso = nomPaso;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getEmail3() {
		return email3;
	}

	public void setEmail3(String email3) {
		this.email3 = email3;
	}

	public String getSolAutoriza() {
		return solAutoriza;
	}

	public void setSolAutoriza(String solAutoriza) {
		this.solAutoriza = solAutoriza;
	}

	public String getSolDocumentos() {
		return solDocumentos;
	}

	public void setSolDocumentos(String solDocumentos) {
		this.solDocumentos = solDocumentos;
	}

	public Long getOrdPaso() {
		return ordPaso;
	}

	public void setOrdPaso(Long ordPaso) {
		this.ordPaso = ordPaso;
	}

	public String getEnvCorreoPaso() {
		return envCorreoPaso;
	}

	public void setEnvCorreoPaso(String envCorreoPaso) {
		this.envCorreoPaso = envCorreoPaso;
	}

	public String getEnvCorreoAutoriza() {
		return envCorreoAutoriza;
	}

	public void setEnvCorreoAutoriza(String envCorreoAutoriza) {
		this.envCorreoAutoriza = envCorreoAutoriza;
	}

	public String getAsuntoCorreo() {
		return asuntoCorreo;
	}

	public void setAsuntoCorreo(String asuntoCorreo) {
		this.asuntoCorreo = asuntoCorreo;
	}

	public String getTextoCorreo() {
		return textoCorreo;
	}

	public void setTextoCorreo(String textoCorreo) {
		this.textoCorreo = textoCorreo;
	}

	public Long getTiempoAlerta1() {
		return tiempoAlerta1;
	}

	public void setTiempoAlerta1(Long tiempoAlerta1) {
		this.tiempoAlerta1 = tiempoAlerta1;
	}

	public Long getTiempoAlerta2() {
		return tiempoAlerta2;
	}

	public void setTiempoAlerta2(Long tiempoAlerta2) {
		this.tiempoAlerta2 = tiempoAlerta2;
	}

	public Long getTiempoAlerta3() {
		return tiempoAlerta3;
	}

	public void setTiempoAlerta3(Long tiempoAlerta3) {
		this.tiempoAlerta3 = tiempoAlerta3;
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
