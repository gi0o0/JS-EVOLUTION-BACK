package com.jarzsoft.entities;

import java.io.Serializable;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bas_T_Tip_Cta")
public class Bas_T_Tip_Cta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_tip_cta")
	private BigInteger idTipCta;

	@Column(name = "Nom_cta")
	private String NomCta;

	public Bas_T_Tip_Cta() {
	}

	public Bas_T_Tip_Cta(BigInteger idTipCta, String nomCta) {
		super();
		this.idTipCta = idTipCta;
		NomCta = nomCta;
	}

	public BigInteger getIdTipCta() {
		return idTipCta;
	}

	public void setIdTipCta(BigInteger idTipCta) {
		this.idTipCta = idTipCta;
	}

	public String getNomCta() {
		return NomCta;
	}

	public void setNomCta(String nomCta) {
		NomCta = nomCta;
	}

}
