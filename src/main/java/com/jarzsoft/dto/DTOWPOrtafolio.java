package com.jarzsoft.dto;

import java.util.ArrayList;
import java.util.Date;

public class DTOWPOrtafolio {

	private Long idWf;
	private Long idPaso;
	private String nomPaso;
	private String email1;
	private String email2;
	private String email3;
	private String solAutoriza;
	private String solDocumentos;
	private Long ordPaso;
	private String envCorreoPaso;
	private String envCorreoAutoriza;
	private String asuntoCorreo;
	private String textoCorreo;
	private Long tiempoAlerta1;
	private Long tiempoAlerta2;
	private Long tiempoAlerta3;
	private ArrayList<DTOWFParameterStepAut> auts;
	private ArrayList<DTOWFParameterStepDoc> docs;
	private String usuUltMod;
	private Date fecUltMod;
	private Date fecCrea;
	private String usuCrea;

	public DTOWPOrtafolio() {
		super();
	}

	public DTOWPOrtafolio(Long idWf, Long idPaso, String nomPaso, String email1, String email2, String email3,
			String solAutoriza, String solDocumentos, Long ordPaso, String envCorreoPaso, String envCorreoAutoriza,
			String asuntoCorreo, String textoCorreo, Long tiempoAlerta1, Long tiempoAlerta2, Long tiempoAlerta3,
			String usuUltMod,
			Date fecUltMod, Date fecCrea, String usuCrea) {
		super();
		this.idWf = idWf;
		this.idPaso = idPaso;
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

	public ArrayList<DTOWFParameterStepAut> getAuts() {
		return auts;
	}

	public void setAuts(ArrayList<DTOWFParameterStepAut> auts) {
		this.auts = auts;
	}

	public ArrayList<DTOWFParameterStepDoc> getDocs() {
		return docs;
	}

	public void setDocs(ArrayList<DTOWFParameterStepDoc> docs) {
		this.docs = docs;
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
