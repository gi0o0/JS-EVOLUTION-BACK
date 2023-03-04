package com.jarzsoft.dto;

import java.math.BigDecimal;

public class DTOWFFinancialInfo {

	private BigDecimal sueldo;
	private BigDecimal recargos;
	private BigDecimal bonos;
	private BigDecimal compensatorios;
	private BigDecimal bonificacion;
	private BigDecimal horas_extras;
	private BigDecimal otros_pagos1;
	private BigDecimal otros_pagos2;
	private BigDecimal otros_pagos3;
	private BigDecimal salud;
	private BigDecimal pension;
	private BigDecimal libranza;
	private BigDecimal cuota_sindical;
	private BigDecimal cuota_interna;
	private BigDecimal otros_decuentos1;
	private BigDecimal otros_decuentos2;
	private BigDecimal otros_decuentos3;

	private String compra_cartera1;
	private String entidad_cartera1;
	private String obligacion_cartera1;
	private String compra_nit1;
	private String compra_cartera2;
	private String entidad_cartera2;
	private String compra_nit2;
	private String obligacion_cartera2;
	private String compra_cartera3;
	private String entidad_cartera3;
	private String compra_nit3;
	private String obligacion_cartera3;
	private String compra_cartera4;
	private String entidad_cartera4;
	private String compra_nit4;
	private String obligacion_cartera4;

	private String valorFuturo;
	private String capacidadEndeudamiento;
	private String valorCuotaEstimada;

	public DTOWFFinancialInfo(BigDecimal sueldo, BigDecimal recargos, BigDecimal bonos, BigDecimal compensatorios,
			BigDecimal bonificacion, BigDecimal horas_extras, BigDecimal otros_pagos1, BigDecimal otros_pagos2,
			BigDecimal otros_pagos3, BigDecimal salud, BigDecimal pension, BigDecimal libranza,
			BigDecimal cuota_sindical, BigDecimal cuota_interna, BigDecimal otros_decuentos1,
			BigDecimal otros_decuentos2, BigDecimal otros_decuentos3, String compra_cartera1, String entidad_cartera1,
			String obligacion_cartera1, String compra_nit1, String compra_cartera2, String entidad_cartera2,
			String compra_nit2, String obligacion_cartera2, String compra_cartera3, String entidad_cartera3,
			String compra_nit3, String obligacion_cartera3, String compra_cartera4, String entidad_cartera4,
			String compra_nit4, String obligacion_cartera4, String valorFuturo, String capacidadEndeudamiento,
			String valorCuotaEstimada) {
		super();
		this.sueldo = sueldo;
		this.recargos = recargos;
		this.bonos = bonos;
		this.compensatorios = compensatorios;
		this.bonificacion = bonificacion;
		this.horas_extras = horas_extras;
		this.otros_pagos1 = otros_pagos1;
		this.otros_pagos2 = otros_pagos2;
		this.otros_pagos3 = otros_pagos3;
		this.salud = salud;
		this.pension = pension;
		this.libranza = libranza;
		this.cuota_sindical = cuota_sindical;
		this.cuota_interna = cuota_interna;
		this.otros_decuentos1 = otros_decuentos1;
		this.otros_decuentos2 = otros_decuentos2;
		this.otros_decuentos3 = otros_decuentos3;
		this.compra_cartera1 = compra_cartera1;
		this.entidad_cartera1 = entidad_cartera1;
		this.obligacion_cartera1 = obligacion_cartera1;
		this.compra_nit1 = compra_nit1;
		this.compra_cartera2 = compra_cartera2;
		this.entidad_cartera2 = entidad_cartera2;
		this.compra_nit2 = compra_nit2;
		this.obligacion_cartera2 = obligacion_cartera2;
		this.compra_cartera3 = compra_cartera3;
		this.entidad_cartera3 = entidad_cartera3;
		this.compra_nit3 = compra_nit3;
		this.obligacion_cartera3 = obligacion_cartera3;
		this.compra_cartera4 = compra_cartera4;
		this.entidad_cartera4 = entidad_cartera4;
		this.compra_nit4 = compra_nit4;
		this.obligacion_cartera4 = obligacion_cartera4;
		this.valorFuturo = valorFuturo;
		this.capacidadEndeudamiento = capacidadEndeudamiento;
		this.valorCuotaEstimada = valorCuotaEstimada;
	}

	public DTOWFFinancialInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getSueldo() {
		return sueldo;
	}

	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}

	public BigDecimal getRecargos() {
		return recargos;
	}

	public void setRecargos(BigDecimal recargos) {
		this.recargos = recargos;
	}

	public BigDecimal getBonos() {
		return bonos;
	}

	public void setBonos(BigDecimal bonos) {
		this.bonos = bonos;
	}

	public BigDecimal getCompensatorios() {
		return compensatorios;
	}

	public void setCompensatorios(BigDecimal compensatorios) {
		this.compensatorios = compensatorios;
	}

	public BigDecimal getBonificacion() {
		return bonificacion;
	}

	public void setBonificacion(BigDecimal bonificacion) {
		this.bonificacion = bonificacion;
	}

	public BigDecimal getHoras_extras() {
		return horas_extras;
	}

	public void setHoras_extras(BigDecimal horas_extras) {
		this.horas_extras = horas_extras;
	}

	public BigDecimal getOtros_pagos1() {
		return otros_pagos1;
	}

	public void setOtros_pagos1(BigDecimal otros_pagos1) {
		this.otros_pagos1 = otros_pagos1;
	}

	public BigDecimal getOtros_pagos2() {
		return otros_pagos2;
	}

	public void setOtros_pagos2(BigDecimal otros_pagos2) {
		this.otros_pagos2 = otros_pagos2;
	}

	public BigDecimal getOtros_pagos3() {
		return otros_pagos3;
	}

	public void setOtros_pagos3(BigDecimal otros_pagos3) {
		this.otros_pagos3 = otros_pagos3;
	}

	public BigDecimal getSalud() {
		return salud;
	}

	public void setSalud(BigDecimal salud) {
		this.salud = salud;
	}

	public BigDecimal getPension() {
		return pension;
	}

	public void setPension(BigDecimal pension) {
		this.pension = pension;
	}

	public BigDecimal getLibranza() {
		return libranza;
	}

	public void setLibranza(BigDecimal libranza) {
		this.libranza = libranza;
	}

	public BigDecimal getCuota_sindical() {
		return cuota_sindical;
	}

	public void setCuota_sindical(BigDecimal cuota_sindical) {
		this.cuota_sindical = cuota_sindical;
	}

	public BigDecimal getCuota_interna() {
		return cuota_interna;
	}

	public void setCuota_interna(BigDecimal cuota_interna) {
		this.cuota_interna = cuota_interna;
	}

	public BigDecimal getOtros_decuentos1() {
		return otros_decuentos1;
	}

	public void setOtros_decuentos1(BigDecimal otros_decuentos1) {
		this.otros_decuentos1 = otros_decuentos1;
	}

	public BigDecimal getOtros_decuentos2() {
		return otros_decuentos2;
	}

	public void setOtros_decuentos2(BigDecimal otros_decuentos2) {
		this.otros_decuentos2 = otros_decuentos2;
	}

	public BigDecimal getOtros_decuentos3() {
		return otros_decuentos3;
	}

	public void setOtros_decuentos3(BigDecimal otros_decuentos3) {
		this.otros_decuentos3 = otros_decuentos3;
	}

	public String getCompra_cartera1() {
		return compra_cartera1;
	}

	public void setCompra_cartera1(String compra_cartera1) {
		this.compra_cartera1 = compra_cartera1;
	}

	public String getEntidad_cartera1() {
		return entidad_cartera1;
	}

	public void setEntidad_cartera1(String entidad_cartera1) {
		this.entidad_cartera1 = entidad_cartera1;
	}

	public String getObligacion_cartera1() {
		return obligacion_cartera1;
	}

	public void setObligacion_cartera1(String obligacion_cartera1) {
		this.obligacion_cartera1 = obligacion_cartera1;
	}

	public String getCompra_nit1() {
		return compra_nit1;
	}

	public void setCompra_nit1(String compra_nit1) {
		this.compra_nit1 = compra_nit1;
	}

	public String getCompra_cartera2() {
		return compra_cartera2;
	}

	public void setCompra_cartera2(String compra_cartera2) {
		this.compra_cartera2 = compra_cartera2;
	}

	public String getEntidad_cartera2() {
		return entidad_cartera2;
	}

	public void setEntidad_cartera2(String entidad_cartera2) {
		this.entidad_cartera2 = entidad_cartera2;
	}

	public String getCompra_nit2() {
		return compra_nit2;
	}

	public void setCompra_nit2(String compra_nit2) {
		this.compra_nit2 = compra_nit2;
	}

	public String getObligacion_cartera2() {
		return obligacion_cartera2;
	}

	public void setObligacion_cartera2(String obligacion_cartera2) {
		this.obligacion_cartera2 = obligacion_cartera2;
	}

	public String getCompra_cartera3() {
		return compra_cartera3;
	}

	public void setCompra_cartera3(String compra_cartera3) {
		this.compra_cartera3 = compra_cartera3;
	}

	public String getEntidad_cartera3() {
		return entidad_cartera3;
	}

	public void setEntidad_cartera3(String entidad_cartera3) {
		this.entidad_cartera3 = entidad_cartera3;
	}

	public String getCompra_nit3() {
		return compra_nit3;
	}

	public void setCompra_nit3(String compra_nit3) {
		this.compra_nit3 = compra_nit3;
	}

	public String getObligacion_cartera3() {
		return obligacion_cartera3;
	}

	public void setObligacion_cartera3(String obligacion_cartera3) {
		this.obligacion_cartera3 = obligacion_cartera3;
	}

	public String getCompra_cartera4() {
		return compra_cartera4;
	}

	public void setCompra_cartera4(String compra_cartera4) {
		this.compra_cartera4 = compra_cartera4;
	}

	public String getEntidad_cartera4() {
		return entidad_cartera4;
	}

	public void setEntidad_cartera4(String entidad_cartera4) {
		this.entidad_cartera4 = entidad_cartera4;
	}

	public String getCompra_nit4() {
		return compra_nit4;
	}

	public void setCompra_nit4(String compra_nit4) {
		this.compra_nit4 = compra_nit4;
	}

	public String getObligacion_cartera4() {
		return obligacion_cartera4;
	}

	public void setObligacion_cartera4(String obligacion_cartera4) {
		this.obligacion_cartera4 = obligacion_cartera4;
	}

	public String getValorFuturo() {
		return valorFuturo;
	}

	public void setValorFuturo(String valorFuturo) {
		this.valorFuturo = valorFuturo;
	}

	public String getCapacidadEndeudamiento() {
		return capacidadEndeudamiento;
	}

	public void setCapacidadEndeudamiento(String capacidadEndeudamiento) {
		this.capacidadEndeudamiento = capacidadEndeudamiento;
	}

	public String getValorCuotaEstimada() {
		return valorCuotaEstimada;
	}

	public void setValorCuotaEstimada(String valorCuotaEstimada) {
		this.valorCuotaEstimada = valorCuotaEstimada;
	}

}
