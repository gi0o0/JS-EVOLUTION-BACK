package com.jarzsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "cladoc")
public class Cladoc implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Size(max = 9)
	@Column(name = "codtip")
	private String codTip;

	@NotBlank
	@Size(max = 40)
	@Column(name = "nomtip")
	private String nomTip;

	public Cladoc() {
	}

	public Cladoc(@Size(max = 9) String codTip, @NotBlank @Size(max = 40) String nomTip) {
		super();
		this.codTip = codTip;
		this.nomTip = nomTip;
	}

	public String getCodTip() {
		return codTip;
	}

	public void setCodTip(String codTip) {
		this.codTip = codTip;
	}

	public String getNomTip() {
		return nomTip;
	}

	public void setNomTip(String nomTip) {
		this.nomTip = nomTip;
	}

}
