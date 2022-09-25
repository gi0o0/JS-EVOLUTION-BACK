package com.jarzsoft.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "foclaaso")
public class Foclaaso implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@NotBlank
	@Size(max = 8)
	@Column(name = "cod_inter")
	private BigInteger codInter;

	@NotBlank
	@Size(max = 30)
	@Column(name = "nom_claaso")
	private String nomClaaso;

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

	@Column(name = "monto1")
	private BigInteger monto1;

	@Column(name = "monto2")
	private BigInteger monto2;

	@Column(name = "monto3")
	private BigInteger monto3;

	@Column(name = "monto4")
	private BigInteger monto4;

	@Column(name = "valor_respeta")
	private BigDecimal valorRespeta;

	@Column(name = "porcentaje_respeta")
	private BigDecimal porcentajeRespeta;

	@Column(name = "indcodeudormonto1")
	private String indCodeudorMonto1;

	@Column(name = "indcodeudormonto2")
	private String indCodeudorMonto2;

	@Column(name = "indcodeudormonto3")
	private String indCodeudorMonto3;

	@Column(name = "indcodeudormonto4")
	private String indCodeudorMonto4;

	public Foclaaso() {
	}

	public Foclaaso(@NotBlank @Size(max = 8) BigInteger codInter, @NotBlank @Size(max = 30) String nomClaaso,
			@Size(max = 10) String usuUltMod, Date fecUltMod, Date fecCrea, @Size(max = 10) String usuCrea,
			BigInteger monto1, BigInteger monto2, BigInteger monto3, BigInteger monto4) {
		super();
		this.codInter = codInter;
		this.nomClaaso = nomClaaso;
		this.usuUltMod = usuUltMod;
		this.fecUltMod = fecUltMod;
		this.fecCrea = fecCrea;
		this.usuCrea = usuCrea;
		this.monto1 = monto1;
		this.monto2 = monto2;
		this.monto3 = monto3;
		this.monto4 = monto4;
	}

	public BigInteger getCodInter() {
		return codInter;
	}

	public void setCodInter(BigInteger codInter) {
		this.codInter = codInter;
	}

	public String getNomClaaso() {
		return nomClaaso;
	}

	public void setNomClaaso(String nomClaaso) {
		this.nomClaaso = nomClaaso;
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

	public BigInteger getMonto1() {
		return monto1;
	}

	public void setMonto1(BigInteger monto1) {
		this.monto1 = monto1;
	}

	public BigInteger getMonto2() {
		return monto2;
	}

	public void setMonto2(BigInteger monto2) {
		this.monto2 = monto2;
	}

	public BigInteger getMonto3() {
		return monto3;
	}

	public void setMonto3(BigInteger monto3) {
		this.monto3 = monto3;
	}

	public BigInteger getMonto4() {
		return monto4;
	}

	public void setMonto4(BigInteger monto4) {
		this.monto4 = monto4;
	}

	public String getIndCodeudorMonto1() {
		return indCodeudorMonto1;
	}

	public void setIndCodeudorMonto1(String indCodeudorMonto1) {
		this.indCodeudorMonto1 = indCodeudorMonto1;
	}

	public String getIndCodeudorMonto2() {
		return indCodeudorMonto2;
	}

	public void setIndCodeudorMonto2(String indCodeudorMonto2) {
		this.indCodeudorMonto2 = indCodeudorMonto2;
	}

	public String getIndCodeudorMonto3() {
		return indCodeudorMonto3;
	}

	public void setIndCodeudorMonto3(String indCodeudorMonto3) {
		this.indCodeudorMonto3 = indCodeudorMonto3;
	}

	public String getIndCodeudorMonto4() {
		return indCodeudorMonto4;
	}

	public void setIndCodeudorMonto4(String indCodeudorMonto4) {
		this.indCodeudorMonto4 = indCodeudorMonto4;
	}

	public BigDecimal getValorRespeta() {
		return valorRespeta;
	}

	public void setValorRespeta(BigDecimal valorRespeta) {
		this.valorRespeta = valorRespeta;
	}

	public BigDecimal getPorcentajeRespeta() {
		return porcentajeRespeta;
	}

	public void setPorcentajeRespeta(BigDecimal porcentajeRespeta) {
		this.porcentajeRespeta = porcentajeRespeta;
	}

}
