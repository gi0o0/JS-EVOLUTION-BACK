package com.jarzsoft.dto;

public class DTOWfDocs {

	private Long idDocumento;
	private String nomDocumento;
	private String value;

	public DTOWfDocs() {
		super();
	}

	public DTOWfDocs(Long idDocumento, String nomDocumento, String value) {
		super();
		this.idDocumento = idDocumento;
		this.nomDocumento = nomDocumento;
		this.value = value;
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

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
