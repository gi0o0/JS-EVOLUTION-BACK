package com.jarzsoft.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "SOL_CREDITO")
public class SolCredito implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "NUMERO_RADICACION")
	private Integer numeroRadicacion;

	@Column(name = "saldo")
	private String saldo;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "tasa_int")
	private String tasaInt;

	@Column(name = "estado")
	private String estado;

	@Column(name = "valor_admo")
	private String valorAdmo;

	@Column(name = "valor_cuot")
	private String valorCuot;

	@Column(name = "valor_inte")
	private String valorInte;

	@Column(name = "valor_neto")
	private String valorNeto;

	@Column(name = "obs_centrales")
	private String obsCentrales;

	@Column(name = "codter_asesor")
	private String codterAsesor;

	@Column(name = "tipo_credito")
	private String tipoCredito;

	@Column(name = "tip_Sol_credito")
	private String tipSolcredito;

	@Column(name = "bien_afecta")
	private String bienAfecta;

	@Column(name = "bien_hipoteca")
	private String bienHipoteca;

	@Column(name = "veh_pignorado")
	private String vehPignorado;

	@Column(name = "valor_pres")
	private String valorPres;

	@Column(name = "nro_cuotas")
	private String nroCuotas;

	@Column(name = "nro_cuenta")
	private String nroCuenta;

	@Column(name = "ref_nombre_1")
	private String refNombre1;

	@Column(name = "ref_paren_1")
	private String refParen1;

	@Column(name = "ref_mail_1")
	private String refMail1;

	@Column(name = "ref_cel_1")
	private String refCel1;

	@Column(name = "ref_nombre_2")
	private String refNombre2;

	@Column(name = "ref_paren_2")
	private String refParen2;

	@Column(name = "ref_mail_2")
	private String refMail2;

	@Column(name = "ref_cel_2")
	private String refCel2;

	@Column(name = "ref_nombre_3")
	private String refNombre3;

	@Column(name = "ref_paren_3")
	private String refParen3;

	@Column(name = "ref_mail_3")
	private String refMail3;

	@Column(name = "ref_cel_3")
	private String refCel3;

	@Column(name = "bien_nombre")
	private String bienNombre;

	@Column(name = "bien_valor")
	private String bienValor;

	@Column(name = "bien__hip_a_favor")
	private String bienHipAfavor;

	@Column(name = "veh_marca")
	private String vehMarca;

	@Column(name = "veh_marca_cod")
	private String vehMarcaCod;

	@Column(name = "veh_clase")
	private String vehClase;

	@Column(name = "veh_modelo")
	private String vehModelo;

	@Column(name = "veh_modelo_cod")
	private String vehModeloCod;

	@Column(name = "veh_placa")
	private String vehPlaca;

	@Column(name = "veh_pig_a_favor")
	private String vehPigAfavor;

	@Column(name = "veh_val_comercial")
	private String vehValComercial;

	@Column(name = "bien_hipoteca_cod")
	private String bienHipotecaCod;

	@Column(name = "bien_afecta_cod")
	private String bienAfectaCod;

	@Column(name = "veh_pignorado_cod")
	private String vehPignoradoCod;

	@Column(name = "ref_nombre_1_cod")
	private String refNombre1Cod;

	@Column(name = "ref_paren_1_cod")
	private String refParen1Cod;

	@Column(name = "ref_mail_1_cod")
	private String refMail1Cod;

	@Column(name = "ref_cel_1_cod")
	private String refCel1Cod;

	@Column(name = "ref_nombre_2_cod")
	private String refNombre2Cod;

	@Column(name = "ref_paren_2_cod")
	private String refParen2Cod;

	@Column(name = "ref_mail_2_cod")
	private String refMail2Cod;

	@Column(name = "ref_cel_2_cod")
	private String refCel2Cod;

	@Column(name = "ref_nombre_3_cod")
	private String refNombre3Cod;

	@Column(name = "ref_paren_3_cod")
	private String refParen3Cod;

	@Column(name = "ref_mail_3_cod")
	private String refMail3Cod;

	@Column(name = "ref_cel_3_cod")
	private String refCel3Cod;

	@Column(name = "bien_nombre_cod")
	private String bienNombreCod;

	@Column(name = "bien_valor_cod")
	private String bienValorCod;

	@Column(name = "bien__hip_a_favor_cod")
	private String bienHipAfavorCod;

	@Column(name = "veh_clase_cod")
	private String vehClaseCod;

	@Column(name = "veh_placa_cod")
	private String vehPlacaCod;

	@Column(name = "veh_val_comercial_cod")
	private String vehValComercialCod;

	@Column(name = "veh_pig_a_favor_cod")
	private String vehPigAfavorCod;

	@Column(name = "codter")
	private String codTer;

	@Column(name = "codeudor1")
	private String codeudor1;

	@Column(name = "fecha_soli")
	private Date fechaSoli;

	@Column(name = "fecha_ini")
	private Date fechaIni;

	@Column(name = "fecha_fin")
	private Date fechaFin;

	@Column(name = "modalidad")
	private String modalidad;

	@Column(name = "codeudor2")
	private String codeudor2;

	@Column(name = "codeudor3")
	private String codeudor3;

	@Column(name = "codeudor4")
	private String codeudor4;

	@Column(name = "v_solicita")
	private String vSolicita;

	@Column(name = "fecha_apr")
	private Date fechaApr;

	@Column(name = "maxsoli")
	private String maxSoli;

	@Column(name = "prometri")
	private String prometri;

	@Column(name = "por_admin")
	private String porAdmin;

	@Column(name = "credito_minimo")
	private String creditoMinimo;

	@Column(name = "credito_maximo")
	private String creditoMaximo;

	@Column(name = "forma_pago")
	private String formaPago;

	@Column(name = "nro_oficina")
	private String nroOficina;

	@Column(name = "observa")
	private String observa;

	@Column(name = "garantias")
	private String garantias;

	@Column(name = "tip_garantia")
	private String tipGarantia;

	@Column(name = "clave_link")
	private String claveLink;

	public SolCredito() {
	}

	public SolCredito(Integer numeroRadicacion, String bienAfecta, String bienHipoteca, String vehPignorado,
			String valorPres, String nroCuotas, String refNombre1, String refParen1, String refMail1, String refCel1,
			String refNombre2, String refParen2, String refMail2, String refCel2, String refNombre3, String refParen3,
			String refMail3, String refCel3, String bienNombre, String bienValor, String bienHipAfavor, String vehMarca,
			String vehClase, String vehModelo, String vehPlaca, String vehPigAfavor, String vehValComercial,
			String bienHipotecaCod, String bienAfectaCod, String vehPignoradoCod, String refNombre1Cod,
			String refParen1Cod, String refMail1Cod, String refCel1Cod, String refNombre2Cod, String refParen2Cod,
			String refMail2Cod, String refCel2Cod, String refNombre3Cod, String refParen3Cod, String refMail3Cod,
			String refCel3Cod, String bienNombreCod, String bienValorCod, String bienHipAfavorCod, String vehClaseCod,
			String vehPlacaCod, String vehValComercialCod, String vehPigAfavorCod, String codTer, String codeudor1) {
		super();
		this.numeroRadicacion = numeroRadicacion;
		this.bienAfecta = bienAfecta;
		this.bienHipoteca = bienHipoteca;
		this.vehPignorado = vehPignorado;
		this.valorPres = valorPres;
		this.nroCuotas = nroCuotas;
		this.refNombre1 = refNombre1;
		this.refParen1 = refParen1;
		this.refMail1 = refMail1;
		this.refCel1 = refCel1;
		this.refNombre2 = refNombre2;
		this.refParen2 = refParen2;
		this.refMail2 = refMail2;
		this.refCel2 = refCel2;
		this.refNombre3 = refNombre3;
		this.refParen3 = refParen3;
		this.refMail3 = refMail3;
		this.refCel3 = refCel3;
		this.bienNombre = bienNombre;
		this.bienValor = bienValor;
		this.bienHipAfavor = bienHipAfavor;
		this.vehMarca = vehMarca;
		this.vehClase = vehClase;
		this.vehModelo = vehModelo;
		this.vehPlaca = vehPlaca;
		this.vehPigAfavor = vehPigAfavor;
		this.vehValComercial = vehValComercial;
		this.bienHipotecaCod = bienHipotecaCod;
		this.bienAfectaCod = bienAfectaCod;
		this.vehPignoradoCod = vehPignoradoCod;
		this.refNombre1Cod = refNombre1Cod;
		this.refParen1Cod = refParen1Cod;
		this.refMail1Cod = refMail1Cod;
		this.refCel1Cod = refCel1Cod;
		this.refNombre2Cod = refNombre2Cod;
		this.refParen2Cod = refParen2Cod;
		this.refMail2Cod = refMail2Cod;
		this.refCel2Cod = refCel2Cod;
		this.refNombre3Cod = refNombre3Cod;
		this.refParen3Cod = refParen3Cod;
		this.refMail3Cod = refMail3Cod;
		this.refCel3Cod = refCel3Cod;
		this.bienNombreCod = bienNombreCod;
		this.bienValorCod = bienValorCod;
		this.bienHipAfavorCod = bienHipAfavorCod;
		this.vehClaseCod = vehClaseCod;
		this.vehPlacaCod = vehPlacaCod;
		this.vehValComercialCod = vehValComercialCod;
		this.vehPigAfavorCod = vehPigAfavorCod;
		this.codTer = codTer;
		this.codeudor1 = codeudor1;

	}

	@PrePersist
	public void prePersist() {
		Date now = new Date();
		this.fechaSoli = now;
		this.fechaIni = now;
		this.fechaFin = now;
		this.modalidad = " ";
		this.codeudor2 = "0";
		this.codeudor3 = "0";
		this.codeudor4 = "0";
		this.vSolicita = "0";
		this.fechaApr = now;
		this.maxSoli = "0";
		this.prometri = "0";
		this.porAdmin = "0";
		this.creditoMinimo = "0";
		this.creditoMaximo = "0";
		this.formaPago = "0";
		this.nroOficina = "0";
		this.garantias = " ";
		this.tipGarantia = "P";

	}

	@PreUpdate
	public void preUpdate() {
		Date now = new Date();
		this.fechaIni = now;
		this.fechaFin = now;
		this.modalidad = " ";
		this.codeudor2 = "0";
		this.codeudor3 = "0";
		this.codeudor4 = "0";
		this.vSolicita = "0";
		this.fechaApr = now;
		this.maxSoli = "0";
		this.prometri = "0";
		this.porAdmin = "0";
		this.creditoMinimo = "0";
		this.creditoMaximo = "0";
		this.formaPago = "0";
		this.nroOficina = "0";
		this.garantias = " ";
		this.tipGarantia = "P";

	}

	public Integer getNumeroRadicacion() {
		return numeroRadicacion;
	}

	public void setNumeroRadicacion(Integer numeroRadicacion) {
		this.numeroRadicacion = numeroRadicacion;
	}

	public String getBienAfecta() {
		return bienAfecta;
	}

	public void setBienAfecta(String bienAfecta) {
		this.bienAfecta = bienAfecta;
	}

	public String getBienHipoteca() {
		return bienHipoteca;
	}

	public void setBienHipoteca(String bienHipoteca) {
		this.bienHipoteca = bienHipoteca;
	}

	public String getVehPignorado() {
		return vehPignorado;
	}

	public void setVehPignorado(String vehPignorado) {
		this.vehPignorado = vehPignorado;
	}

	public String getValorPres() {
		return valorPres;
	}

	public void setValorPres(String valorPres) {
		this.valorPres = valorPres;
	}

	public String getNroCuotas() {
		return nroCuotas;
	}

	public void setNroCuotas(String nroCuotas) {
		this.nroCuotas = nroCuotas;
	}

	public String getRefNombre1() {
		return refNombre1;
	}

	public void setRefNombre1(String refNombre1) {
		this.refNombre1 = refNombre1;
	}

	public String getRefParen1() {
		return refParen1;
	}

	public void setRefParen1(String refParen1) {
		this.refParen1 = refParen1;
	}

	public String getRefMail1() {
		return refMail1;
	}

	public void setRefMail1(String refMail1) {
		this.refMail1 = refMail1;
	}

	public String getRefCel1() {
		return refCel1;
	}

	public void setRefCel1(String refCel1) {
		this.refCel1 = refCel1;
	}

	public String getRefNombre2() {
		return refNombre2;
	}

	public void setRefNombre2(String refNombre2) {
		this.refNombre2 = refNombre2;
	}

	public String getRefParen2() {
		return refParen2;
	}

	public void setRefParen2(String refParen2) {
		this.refParen2 = refParen2;
	}

	public String getRefMail2() {
		return refMail2;
	}

	public void setRefMail2(String refMail2) {
		this.refMail2 = refMail2;
	}

	public String getRefCel2() {
		return refCel2;
	}

	public void setRefCel2(String refCel2) {
		this.refCel2 = refCel2;
	}

	public String getRefNombre3() {
		return refNombre3;
	}

	public void setRefNombre3(String refNombre3) {
		this.refNombre3 = refNombre3;
	}

	public String getRefParen3() {
		return refParen3;
	}

	public void setRefParen3(String refParen3) {
		this.refParen3 = refParen3;
	}

	public String getRefMail3() {
		return refMail3;
	}

	public void setRefMail3(String refMail3) {
		this.refMail3 = refMail3;
	}

	public String getRefCel3() {
		return refCel3;
	}

	public void setRefCel3(String refCel3) {
		this.refCel3 = refCel3;
	}

	public String getBienNombre() {
		return bienNombre;
	}

	public void setBienNombre(String bienNombre) {
		this.bienNombre = bienNombre;
	}

	public String getBienValor() {
		return bienValor;
	}

	public void setBienValor(String bienValor) {
		this.bienValor = bienValor;
	}

	public String getBienHipAfavor() {
		return bienHipAfavor;
	}

	public void setBienHipAfavor(String bienHipAfavor) {
		this.bienHipAfavor = bienHipAfavor;
	}

	public String getVehMarca() {
		return vehMarca;
	}

	public void setVehMarca(String vehMarca) {
		this.vehMarca = vehMarca;
	}

	public String getVehClase() {
		return vehClase;
	}

	public void setVehClase(String vehClase) {
		this.vehClase = vehClase;
	}

	public String getVehModelo() {
		return vehModelo;
	}

	public void setVehModelo(String vehModelo) {
		this.vehModelo = vehModelo;
	}

	public String getVehPlaca() {
		return vehPlaca;
	}

	public void setVehPlaca(String vehPlaca) {
		this.vehPlaca = vehPlaca;
	}

	public String getVehPigAfavor() {
		return vehPigAfavor;
	}

	public void setVehPigAfavor(String vehPigAfavor) {
		this.vehPigAfavor = vehPigAfavor;
	}

	public String getVehValComercial() {
		return vehValComercial;
	}

	public void setVehValComercial(String vehValComercial) {
		this.vehValComercial = vehValComercial;
	}

	public String getBienHipotecaCod() {
		return bienHipotecaCod;
	}

	public void setBienHipotecaCod(String bienHipotecaCod) {
		this.bienHipotecaCod = bienHipotecaCod;
	}

	public String getBienAfectaCod() {
		return bienAfectaCod;
	}

	public void setBienAfectaCod(String bienAfectaCod) {
		this.bienAfectaCod = bienAfectaCod;
	}

	public String getVehPignoradoCod() {
		return vehPignoradoCod;
	}

	public void setVehPignoradoCod(String vehPignoradoCod) {
		this.vehPignoradoCod = vehPignoradoCod;
	}

	public String getRefNombre1Cod() {
		return refNombre1Cod;
	}

	public void setRefNombre1Cod(String refNombre1Cod) {
		this.refNombre1Cod = refNombre1Cod;
	}

	public String getRefParen1Cod() {
		return refParen1Cod;
	}

	public void setRefParen1Cod(String refParen1Cod) {
		this.refParen1Cod = refParen1Cod;
	}

	public String getRefMail1Cod() {
		return refMail1Cod;
	}

	public void setRefMail1Cod(String refMail1Cod) {
		this.refMail1Cod = refMail1Cod;
	}

	public String getRefCel1Cod() {
		return refCel1Cod;
	}

	public void setRefCel1Cod(String refCel1Cod) {
		this.refCel1Cod = refCel1Cod;
	}

	public String getRefNombre2Cod() {
		return refNombre2Cod;
	}

	public void setRefNombre2Cod(String refNombre2Cod) {
		this.refNombre2Cod = refNombre2Cod;
	}

	public String getRefParen2Cod() {
		return refParen2Cod;
	}

	public void setRefParen2Cod(String refParen2Cod) {
		this.refParen2Cod = refParen2Cod;
	}

	public String getRefMail2Cod() {
		return refMail2Cod;
	}

	public void setRefMail2Cod(String refMail2Cod) {
		this.refMail2Cod = refMail2Cod;
	}

	public String getRefCel2Cod() {
		return refCel2Cod;
	}

	public void setRefCel2Cod(String refCel2Cod) {
		this.refCel2Cod = refCel2Cod;
	}

	public String getRefNombre3Cod() {
		return refNombre3Cod;
	}

	public void setRefNombre3Cod(String refNombre3Cod) {
		this.refNombre3Cod = refNombre3Cod;
	}

	public String getRefParen3Cod() {
		return refParen3Cod;
	}

	public void setRefParen3Cod(String refParen3Cod) {
		this.refParen3Cod = refParen3Cod;
	}

	public String getRefMail3Cod() {
		return refMail3Cod;
	}

	public void setRefMail3Cod(String refMail3Cod) {
		this.refMail3Cod = refMail3Cod;
	}

	public String getRefCel3Cod() {
		return refCel3Cod;
	}

	public void setRefCel3Cod(String refCel3Cod) {
		this.refCel3Cod = refCel3Cod;
	}

	public String getBienNombreCod() {
		return bienNombreCod;
	}

	public void setBienNombreCod(String bienNombreCod) {
		this.bienNombreCod = bienNombreCod;
	}

	public String getBienValorCod() {
		return bienValorCod;
	}

	public void setBienValorCod(String bienValorCod) {
		this.bienValorCod = bienValorCod;
	}

	public String getBienHipAfavorCod() {
		return bienHipAfavorCod;
	}

	public void setBienHipAfavorCod(String bienHipAfavorCod) {
		this.bienHipAfavorCod = bienHipAfavorCod;
	}

	public String getVehClaseCod() {
		return vehClaseCod;
	}

	public void setVehClaseCod(String vehClaseCod) {
		this.vehClaseCod = vehClaseCod;
	}

	public String getVehPlacaCod() {
		return vehPlacaCod;
	}

	public void setVehPlacaCod(String vehPlacaCod) {
		this.vehPlacaCod = vehPlacaCod;
	}

	public String getVehValComercialCod() {
		return vehValComercialCod;
	}

	public void setVehValComercialCod(String vehValComercialCod) {
		this.vehValComercialCod = vehValComercialCod;
	}

	public String getVehPigAfavorCod() {
		return vehPigAfavorCod;
	}

	public void setVehPigAfavorCod(String vehPigAfavorCod) {
		this.vehPigAfavorCod = vehPigAfavorCod;
	}

	public String getCodTer() {
		return codTer;
	}

	public void setCodTer(String codTer) {
		this.codTer = codTer;
	}

	public String getCodeudor1() {
		return codeudor1;
	}

	public void setCodeudor1(String codeudor1) {
		this.codeudor1 = codeudor1;
	}

	public String getTipoCredito() {
		return tipoCredito;
	}

	public void setTipoCredito(String tipoCredito) {
		this.tipoCredito = tipoCredito;
	}

	public Date getFechaSoli() {
		return fechaSoli;
	}

	public void setFechaSoli(Date fechaSoli) {
		this.fechaSoli = fechaSoli;
	}

	public String getCodterAsesor() {
		return codterAsesor;
	}

	public void setCodterAsesor(String codterAsesor) {
		this.codterAsesor = codterAsesor;
	}

	public String getObsCentrales() {
		return obsCentrales;
	}

	public void setObsCentrales(String obsCentrales) {
		this.obsCentrales = obsCentrales;
	}

	public String getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public String getValorAdmo() {
		return valorAdmo;
	}

	public void setValorAdmo(String valorAdmo) {
		this.valorAdmo = valorAdmo;
	}

	public String getValorInte() {
		return valorInte;
	}

	public void setValorInte(String valorInte) {
		this.valorInte = valorInte;
	}

	public String getValorNeto() {
		return valorNeto;
	}

	public void setValorNeto(String valorNeto) {
		this.valorNeto = valorNeto;
	}

	public String getValorCuot() {
		return valorCuot;
	}

	public void setValorCuot(String valorCuot) {
		this.valorCuot = valorCuot;
	}

	public Date getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getSaldo() {
		return saldo;
	}

	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTasaInt() {
		return tasaInt;
	}

	public void setTasaInt(String tasaInt) {
		this.tasaInt = tasaInt;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public String getObserva() {
		return observa;
	}

	public void setObserva(String observa) {
		this.observa = observa;
	}

	public String getVehMarcaCod() {
		return vehMarcaCod;
	}

	public void setVehMarcaCod(String vehMarcaCod) {
		this.vehMarcaCod = vehMarcaCod;
	}

	public String getVehModeloCod() {
		return vehModeloCod;
	}

	public void setVehModeloCod(String vehModeloCod) {
		this.vehModeloCod = vehModeloCod;
	}

	public String getCodeudor2() {
		return codeudor2;
	}

	public void setCodeudor2(String codeudor2) {
		this.codeudor2 = codeudor2;
	}

	public String getCodeudor3() {
		return codeudor3;
	}

	public void setCodeudor3(String codeudor3) {
		this.codeudor3 = codeudor3;
	}

	public String getCodeudor4() {
		return codeudor4;
	}

	public void setCodeudor4(String codeudor4) {
		this.codeudor4 = codeudor4;
	}

	public String getvSolicita() {
		return vSolicita;
	}

	public void setvSolicita(String vSolicita) {
		this.vSolicita = vSolicita;
	}

	public Date getFechaApr() {
		return fechaApr;
	}

	public void setFechaApr(Date fechaApr) {
		this.fechaApr = fechaApr;
	}

	public String getMaxSoli() {
		return maxSoli;
	}

	public void setMaxSoli(String maxSoli) {
		this.maxSoli = maxSoli;
	}

	public String getPrometri() {
		return prometri;
	}

	public void setPrometri(String prometri) {
		this.prometri = prometri;
	}

	public String getPorAdmin() {
		return porAdmin;
	}

	public void setPorAdmin(String porAdmin) {
		this.porAdmin = porAdmin;
	}

	public String getCreditoMinimo() {
		return creditoMinimo;
	}

	public void setCreditoMinimo(String creditoMinimo) {
		this.creditoMinimo = creditoMinimo;
	}

	public String getCreditoMaximo() {
		return creditoMaximo;
	}

	public void setCreditoMaximo(String creditoMaximo) {
		this.creditoMaximo = creditoMaximo;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public String getNroOficina() {
		return nroOficina;
	}

	public void setNroOficina(String nroOficina) {
		this.nroOficina = nroOficina;
	}

	public String getGarantias() {
		return garantias;
	}

	public void setGarantias(String garantias) {
		this.garantias = garantias;
	}

	public String getTipSolcredito() {
		return tipSolcredito;
	}

	public void setTipSolcredito(String tipSolcredito) {
		this.tipSolcredito = tipSolcredito;
	}

	public String getTipGarantia() {
		return tipGarantia;
	}

	public void setTipGarantia(String tipGarantia) {
		this.tipGarantia = tipGarantia;
	}

	public String getClaveLink() {
		return claveLink;
	}

	public void setClaveLink(String claveLink) {
		this.claveLink = claveLink;
	}

}
