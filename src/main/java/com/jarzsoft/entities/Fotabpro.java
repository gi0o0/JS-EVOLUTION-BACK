package com.jarzsoft.entities;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "fotabpro")
public class Fotabpro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Size(max = 8)
	@Column(name = "cod_inter")
	private BigInteger codInter;

	@Size(max = 30)
	@Column(name = "nom_profe")
	private String nomProfe;

	public Fotabpro() {
	}

	public Fotabpro(@Size(max = 8) BigInteger codInter, @Size(max = 30) String nomProfe) {
		super();
		this.codInter = codInter;
		this.nomProfe = nomProfe;
	}

	public BigInteger getCodInter() {
		return codInter;
	}

	public void setCodInter(BigInteger codInter) {
		this.codInter = codInter;
	}

	public String getNomProfe() {
		return nomProfe;
	}

	public void setNomProfe(String nomProfe) {
		this.nomProfe = nomProfe;
	}

}
