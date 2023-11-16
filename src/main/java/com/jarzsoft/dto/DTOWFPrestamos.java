package com.jarzsoft.dto;

public class DTOWFPrestamos {

	private Long idWf;

	private Long numeroRadicacion;

	private Long numeroCredito;

	private String indEst;

	private String indCer;

	private String indCerDeu;

	private String indPaz;

	private String indDp;

	private String claAsoci;

	private String area;

	public DTOWFPrestamos() {
		super();
	}

	public DTOWFPrestamos(Long idWf, Long numeroRadicacion, Long numeroCredito, String indEst, String indCer,
			String indCerDeu, String indPaz, String indDp, String claAsoci, String area) {
		super();
		this.idWf = idWf;
		this.numeroRadicacion = numeroRadicacion;
		this.numeroCredito = numeroCredito;
		this.indEst = indEst;
		this.indCer = indCer;
		this.indCerDeu = indCerDeu;
		this.indPaz = indPaz;
		this.indDp = indDp;
		this.claAsoci = claAsoci;
		this.area = area;
	}

	public Long getIdWf() {
		return idWf;
	}

	public void setIdWf(Long idWf) {
		this.idWf = idWf;
	}

	public Long getNumeroRadicacion() {
		return numeroRadicacion;
	}

	public void setNumeroRadicacion(Long numeroRadicacion) {
		this.numeroRadicacion = numeroRadicacion;
	}

	public Long getNumeroCredito() {
		return numeroCredito;
	}

	public void setNumeroCredito(Long numeroCredito) {
		this.numeroCredito = numeroCredito;
	}

	public String getIndEst() {
		return indEst;
	}

	public void setIndEst(String indEst) {
		this.indEst = indEst;
	}

	public String getIndCer() {
		return indCer;
	}

	public void setIndCer(String indCer) {
		this.indCer = indCer;
	}

	public String getIndCerDeu() {
		return indCerDeu;
	}

	public void setIndCerDeu(String indCerDeu) {
		this.indCerDeu = indCerDeu;
	}

	public String getIndPaz() {
		return indPaz;
	}

	public void setIndPaz(String indPaz) {
		this.indPaz = indPaz;
	}

	public String getIndDp() {
		return indDp;
	}

	public void setIndDp(String indDp) {
		this.indDp = indDp;
	}

	public String getClaAsoci() {
		return claAsoci;
	}

	public void setClaAsoci(String claAsoci) {
		this.claAsoci = claAsoci;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
