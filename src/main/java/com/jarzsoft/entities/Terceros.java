package com.jarzsoft.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "web.terceros")
public class Terceros implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codter")
	private BigDecimal codTer;

	@Size(max = 60)
	@Column(name = "mailter")
	private String mailTer;

	public Terceros() {
	}

	public Terceros(BigDecimal codTer, @Size(max = 60) String mailTer) {
		super();

		this.codTer = codTer;
		this.mailTer = mailTer;

	}

	public BigDecimal getCodTer() {
		return codTer;
	}

	public void setCodTer(BigDecimal codTer) {
		this.codTer = codTer;
	}

	public String getMailTer() {
		return mailTer;
	}

	public void setMailTer(String mailTer) {
		this.mailTer = mailTer;
	}

}
