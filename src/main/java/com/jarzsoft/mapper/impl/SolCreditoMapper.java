package com.jarzsoft.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.entities.SolCredito;
import com.jarzsoft.mapper.ISolCreditoMapper;
import com.jarzsoft.util.Comunes;

@Service
public class SolCreditoMapper implements ISolCreditoMapper {

	private final Comunes comunes;

	@Autowired
	public SolCreditoMapper(Comunes comunes) {
		super();

		this.comunes = comunes;
	}

	@Override
	public SolCredito mapperDtoToEntitie(DTOSolCredito o) {
		SolCredito out = new SolCredito();
		out.setBienAfecta(o.getBienAfecta());
		out.setBienAfectaCod(o.getBienAfectaCod());
		out.setBienHipAfavor(o.getBienHipAfavor());
		out.setBienHipAfavorCod(o.getBienHipAfavorCod());
		out.setBienHipoteca(o.getBienHipoteca());
		out.setBienHipotecaCod(o.getBienHipotecaCod());
		out.setBienNombre(o.getBienNombre());
		out.setBienNombreCod(o.getBienNombreCod());
		out.setBienValor(o.getBienValor());
		out.setBienValorCod(o.getBienValorCod());
		out.setCodeudor1(o.getCodeudor1());
		out.setCodTer(o.getCodTer());
		out.setNroCuotas(o.getNroCuotas());
		out.setNumeroRadicacion(o.getNumeroRadicacion());
		out.setRefCel1(o.getRefCel1());
		out.setRefCel1Cod(o.getRefCel1Cod());
		out.setRefCel2(o.getRefCel2());
		out.setRefCel2Cod(o.getRefCel2Cod());
		out.setRefCel3(o.getRefCel3());
		out.setRefCel3Cod(o.getRefCel3Cod());
		out.setRefMail1(o.getRefMail1());
		out.setRefMail1Cod(o.getRefMail1Cod());
		out.setRefMail2(o.getRefMail2());
		out.setRefMail2Cod(o.getRefMail2Cod());
		out.setRefMail3(o.getRefMail3());
		out.setRefMail3Cod(o.getRefMail3Cod());
		out.setRefNombre1(o.getRefNombre1());
		out.setRefNombre1Cod(o.getRefNombre1Cod());
		out.setRefNombre2(o.getRefNombre2());
		out.setRefNombre2Cod(o.getRefNombre2Cod());
		out.setRefNombre3(o.getRefNombre3());
		out.setRefNombre3Cod(o.getRefNombre3Cod());
		out.setRefParen1(o.getRefParen1());
		out.setRefParen1Cod(o.getRefParen1Cod());
		out.setRefParen2(o.getRefParen2());
		out.setRefParen2Cod(o.getRefParen2Cod());
		out.setRefParen3(o.getRefParen3());
		out.setRefParen3Cod(o.getRefParen3Cod());
		out.setTipoCredito(o.getTipoCredito());
		out.setValorPres(o.getValorPres());
		out.setVehClase(o.getVehClase());
		out.setVehClaseCod(o.getVehClaseCod());
		out.setVehMarca(o.getVehMarca());
		out.setVehModelo(o.getVehModelo());
		out.setVehMarcaCod(o.getVehMarcaCod());
		out.setVehModeloCod(o.getVehModeloCod());
		out.setVehPigAfavor(o.getVehPigAfavor());
		out.setVehPigAfavorCod(o.getVehPigAfavorCod());
		out.setVehPignorado(o.getVehPignorado());
		out.setVehPignoradoCod(o.getVehPignoradoCod());
		out.setVehPlaca(o.getVehPlaca());
		out.setVehPlacaCod(o.getVehPlacaCod());
		out.setVehValComercial(o.getVehValComercial());
		out.setVehValComercialCod(o.getVehValComercialCod());
		out.setObsCentrales(o.getObsCentrales());
		out.setNroCuenta(o.getNroCuenta());
		out.setValorAdmo(o.getValorAdmo());
		out.setValorInte(o.getValorInte());
		out.setValorNeto(o.getValorNeto());
		out.setValorCuot(o.getValorCuot());
		out.setSaldo(o.getSaldo());
		out.setEstado(o.getEstado());
		out.setTipo(o.getTipo());
		out.setTasaInt(o.getTasaInt());
		out.setObserva(o.getObserva());
		out.setFechaSoli(o.getFechaSoli());
		out.setCodterAsesor(o.getCodterAsesor());
		out.setTipSolcredito(o.getTipSolcredito());

		out.setSueldo(o.getSueldo());
		out.setRecargos(o.getRecargos());
		out.setBonos(o.getBonos());
		out.setCompensatorios(o.getCompensatorios());
		out.setBonificacion(o.getBonificacion());
		out.setHorasExtras(o.getHorasExtras());
		out.setOtrosPagos1(o.getOtrosPagos1());
		out.setOtrosPagos2(o.getOtrosPagos2());
		out.setOtrosPagos3(o.getOtrosPagos3());
		out.setSalud(o.getSalud());
		out.setPension(o.getPension());
		out.setLibranza(o.getLibranza());
		out.setCuotaSindical(o.getCuotaSindical());
		out.setCuotaInterna(o.getCuotaInterna());
		out.setOtrosDecuentos1(o.getOtrosDecuentos1());
		out.setOtrosDecuentos2(o.getOtrosDecuentos2());
		out.setOtrosDecuentos3(o.getOtrosDecuentos3());
		out.setCompraCartera1(o.getCompraCartera1());
		out.setEntidadCartera1(o.getEntidadCartera1());
		out.setObligacionCartera1(o.getObligacionCartera1());
		out.setCompraNit1(o.getCompraNit1());
		out.setCompraCartera2(o.getCompraCartera2());
		out.setEntidadCartera2(o.getEntidadCartera2());
		out.setObligacionCartera2(o.getObligacionCartera2());
		out.setCompraNit2(o.getCompraNit2());
		out.setCompraCartera3(o.getCompraCartera3());
		out.setEntidadCartera3(o.getEntidadCartera3());
		out.setObligacionCartera3(o.getObligacionCartera3());
		out.setCompraNit3(o.getCompraNit3());
		out.setCompraCartera4(o.getCompraCartera4());
		out.setEntidadCartera4(o.getEntidadCartera4());
		out.setObligacionCartera4(o.getObligacionCartera4());
		out.setCompraNit4(o.getCompraNit4());
		out.setPerCuota(o.getPerCuota());

		return out;
	}

	@Override
	public DTOSolCredito mapperEntitieToDao(SolCredito o) {
		DTOSolCredito out = new DTOSolCredito();
		if(null!=o) {
		out.setBienAfecta(o.getBienAfecta());
		out.setBienAfectaCod(o.getBienAfectaCod());
		out.setBienHipAfavor(o.getBienHipAfavor());
		out.setBienHipAfavorCod(o.getBienHipAfavorCod());
		out.setBienHipoteca(o.getBienHipoteca());
		out.setBienHipotecaCod(o.getBienHipotecaCod());
		out.setBienNombre(o.getBienNombre());
		out.setBienNombreCod(o.getBienNombreCod());
		out.setBienValor(o.getBienValor());
		out.setBienValorCod(o.getBienValorCod());
		out.setCodeudor1(o.getCodeudor1());
		out.setCodTer(o.getCodTer());
		out.setNroCuotas(o.getNroCuotas());
		out.setNumeroRadicacion(o.getNumeroRadicacion());
		out.setRefCel1(o.getRefCel1());
		out.setRefCel1Cod(o.getRefCel1Cod());
		out.setRefCel2(o.getRefCel2());
		out.setRefCel2Cod(o.getRefCel2Cod());
		out.setRefCel3(o.getRefCel3());
		out.setRefCel3Cod(o.getRefCel1Cod());
		out.setRefMail1(o.getRefMail1());
		out.setRefMail1Cod(o.getRefMail1Cod());
		out.setRefMail2(o.getRefMail2());
		out.setRefMail2Cod(o.getRefMail2Cod());
		out.setRefMail3(o.getRefMail3());
		out.setRefMail3Cod(o.getRefMail3Cod());
		out.setRefNombre1(o.getRefNombre1());
		out.setRefNombre1Cod(o.getRefNombre1Cod());
		out.setRefNombre2(o.getRefNombre2());
		out.setRefNombre2Cod(o.getRefNombre2Cod());
		out.setRefNombre3(o.getRefNombre3());
		out.setRefNombre3Cod(o.getRefNombre3Cod());
		out.setRefParen1(o.getRefParen1());
		out.setRefParen1Cod(o.getRefParen1Cod());
		out.setRefParen2(o.getRefParen2());
		out.setRefParen2Cod(o.getRefParen2Cod());
		out.setRefParen3(o.getRefParen3());
		out.setRefParen3Cod(o.getRefParen3Cod());
		out.setTipoCredito(o.getTipoCredito());
		out.setTipSolcredito(o.getTipSolcredito());
		out.setValorPres(o.getValorPres());
		out.setVehClase(o.getVehClase());
		out.setVehClaseCod(o.getVehClaseCod());
		out.setVehMarca(o.getVehMarca());
		out.setVehModelo(o.getVehModelo());
		out.setVehMarcaCod(o.getVehMarcaCod());
		out.setVehModeloCod(o.getVehModeloCod());
		out.setVehPigAfavor(o.getVehPigAfavor());
		out.setVehPigAfavorCod(o.getVehPigAfavorCod());
		out.setVehPignorado(o.getVehPignorado());
		out.setVehPignoradoCod(o.getVehPignoradoCod());
		out.setVehPlaca(o.getVehPlaca());
		out.setVehPlacaCod(o.getVehPlacaCod());
		out.setVehValComercial(o.getVehValComercial());
		out.setVehValComercialCod(o.getVehValComercialCod());
		out.setObsCentrales(o.getObsCentrales());
		out.setNroCuenta(o.getNroCuenta());
		out.setValorAdmo(o.getValorAdmo());
		out.setValorInte(o.getValorInte());
		out.setValorNeto(o.getValorNeto());
		out.setValorCuot(o.getValorCuot());
		out.setSaldo(o.getSaldo());
		out.setEstado(o.getEstado());
		out.setTipo(o.getTipo());
		out.setTasaInt(o.getTasaInt());
		out.setObserva(o.getObserva());
		out.setCodterAsesor(o.getCodterAsesor());
		out.setSueldo(o.getSueldo());
		out.setRecargos(o.getRecargos());
		out.setBonos(o.getBonos());
		out.setCompensatorios(o.getCompensatorios());
		out.setBonificacion(o.getBonificacion());
		out.setHorasExtras(o.getHorasExtras());
		out.setOtrosPagos1(o.getOtrosPagos1());
		out.setOtrosPagos2(o.getOtrosPagos2());
		out.setOtrosPagos3(o.getOtrosPagos3());
		out.setSalud(o.getSalud());
		out.setPension(o.getPension());
		out.setLibranza(o.getLibranza());
		out.setCuotaSindical(o.getCuotaSindical());
		out.setCuotaInterna(o.getCuotaInterna());
		out.setOtrosDecuentos1(o.getOtrosDecuentos1());
		out.setOtrosDecuentos2(o.getOtrosDecuentos2());
		out.setOtrosDecuentos3(o.getOtrosDecuentos3());
		out.setCompraCartera1(o.getCompraCartera1());
		out.setEntidadCartera1(o.getEntidadCartera1());
		out.setObligacionCartera1(o.getObligacionCartera1());
		out.setCompraNit1(o.getCompraNit1());
		out.setCompraCartera2(o.getCompraCartera2());
		out.setEntidadCartera2(o.getEntidadCartera2());
		out.setObligacionCartera2(o.getObligacionCartera2());
		out.setCompraNit2(o.getCompraNit2());
		out.setCompraCartera3(o.getCompraCartera3());
		out.setEntidadCartera3(o.getEntidadCartera3());
		out.setObligacionCartera3(o.getObligacionCartera3());
		out.setCompraNit3(o.getCompraNit3());
		out.setCompraCartera4(o.getCompraCartera4());
		out.setEntidadCartera4(o.getEntidadCartera4());
		out.setObligacionCartera4(o.getObligacionCartera4());
		out.setCompraNit4(o.getCompraNit4());
		out.setPerCuota(o.getPerCuota());
		}
		return out;
	}

	@Override
	public DTOSolCredito mapperDaoToDto(DTOWF o, String codTer, String codeudor, String user, String state) {
	
		DTOSolCredito out = new DTOSolCredito();
		out.setBienAfecta(o.getBienAfecta());
		out.setBienAfectaCod(o.getCodeu().getBienAfecta());
		out.setBienHipAfavor(o.getBienHipAFavor());
		out.setBienHipAfavorCod(o.getCodeu().getBienHipAFavor());
		out.setBienHipoteca(o.getBienHipoteca());
		out.setBienHipotecaCod(o.getCodeu().getBienHipoteca());
		out.setBienNombre(o.getBienNombre());
		out.setBienNombreCod(o.getCodeu().getBienNombre());
	
		out.setBienValor(Comunes.stringToInt(o.getBienValor()));
		out.setBienValorCod(Comunes.stringToInt(o.getCodeu().getBienValor()));
	
		out.setCodeudor1(codeudor);
		out.setCodTer(codTer);
		out.setNroCuotas(o.getNroCuotas());
		out.setNumeroRadicacion(o.getNumeroRadicacion());
		out.setRefCel1(o.getRefCel1());
		out.setRefCel2(o.getRefCel2());
		out.setRefCel1Cod(o.getCodeu().getRefCel1());
		out.setRefCel2Cod(o.getCodeu().getRefCel2());
		out.setRefCel3(o.getRefCel3());
		out.setRefCel3Cod(o.getCodeu().getRefCel3());
		out.setRefMail1(o.getRefMail1());
		out.setRefMail1Cod(o.getCodeu().getRefMail1());
		out.setRefMail2(o.getRefMail2());
		out.setRefMail2Cod(o.getCodeu().getRefMail2());
		out.setRefMail3(o.getRefMail3());
		out.setRefMail3Cod(o.getCodeu().getRefMail3());
		out.setRefNombre1(o.getRefNombre1());
		out.setRefNombre1Cod(o.getCodeu().getRefNombre1());
		out.setRefNombre2(o.getRefNombre2());
		out.setRefNombre2Cod(o.getCodeu().getRefNombre2());
		out.setRefNombre3(o.getRefNombre3());
		out.setRefNombre3Cod(o.getCodeu().getRefNombre3());
		out.setRefParen1(o.getRefParen1());
		out.setRefParen1Cod(o.getCodeu().getRefParen1());
		out.setRefParen2(o.getRefParen2());
		out.setRefParen2Cod(o.getCodeu().getRefParen2());
		out.setRefParen3(o.getRefParen3());
		out.setRefParen3Cod(o.getCodeu().getRefParen3());
		out.setTipoCredito(o.getFoticrep());
		out.setTipSolcredito(o.getTipSolCredito());
		out.setValorPres(o.getValorPress());
		out.setVehClase(o.getVehClase());
		out.setVehClaseCod(o.getCodeu().getVehClase());
		out.setVehMarca(o.getVehMarca());
		out.setVehMarcaCod(o.getCodeu().getVehMarca());
		out.setVehModelo(o.getVehModelo());
		out.setVehModeloCod(o.getCodeu().getVehModelo());
		out.setVehPigAfavor(o.getVehPigAFavor());
		out.setVehPigAfavorCod(o.getCodeu().getVehPigAFavor());
		out.setVehPignorado(o.getVehPignorado());
		out.setVehPignoradoCod(o.getCodeu().getVehPignorado());
		out.setVehPlaca(o.getVehPlaca());
		out.setVehPlacaCod(o.getCodeu().getVehPlaca());
		out.setVehValComercial(Comunes.stringToInt(o.getVehValVomercial()));
		out.setVehValComercialCod(Comunes.stringToInt(o.getCodeu().getVehValVomercial()));
		out.setObsCentrales(o.getComments());
		out.setNroCuenta(o.getNumCta());
		out.setValorAdmo("0");
		out.setValorInte("0");
		out.setValorNeto("0");
		out.setValorCuot("0");
		out.setSaldo("0");
		out.setEstado(state);
		out.setTipo(" ");
		out.setTasaInt("0");
		out.setObserva(o.getComments());
		out.setPerCuota(o.getPerCuota());

		out.setSueldo(Comunes.validIsNullNumber(o.getFinancial().getSueldo()));
		out.setRecargos(Comunes.validIsNullNumber(o.getFinancial().getRecargos() ));
		out.setBonos(Comunes.validIsNullNumber(o.getFinancial().getBonos() ));
		out.setCompensatorios(Comunes.validIsNullNumber(o.getFinancial().getCompensatorios() ));
		out.setBonificacion(Comunes.validIsNullNumber(o.getFinancial().getBonificacion() ));
		out.setHorasExtras(Comunes.validIsNullNumber(o.getFinancial().getHoras_extras() ));
		out.setOtrosPagos1(Comunes.validIsNullNumber(o.getFinancial().getOtros_pagos1() ));
		out.setOtrosPagos2(Comunes.validIsNullNumber(o.getFinancial().getOtros_pagos2() ));
		out.setOtrosPagos3(Comunes.validIsNullNumber(o.getFinancial().getOtros_pagos3() ));
		out.setSalud(Comunes.validIsNullNumber(o.getFinancial().getSalud() ));
		out.setPension(Comunes.validIsNullNumber(o.getFinancial().getPension() ));
		out.setLibranza(Comunes.validIsNullNumber(o.getFinancial().getLibranza() ));
		out.setCuotaSindical(Comunes.validIsNullNumber(o.getFinancial().getCuota_sindical() ));
		out.setCuotaInterna(Comunes.validIsNullNumber(o.getFinancial().getCuota_interna() ));
		out.setOtrosDecuentos1(Comunes.validIsNullNumber(o.getFinancial().getOtros_decuentos1()));
		out.setOtrosDecuentos2(Comunes.validIsNullNumber(o.getFinancial().getOtros_decuentos2() ));
		out.setOtrosDecuentos3(Comunes.validIsNullNumber(o.getFinancial().getOtros_decuentos3() ));
		out.setCompraCartera1(Comunes.validIsNullNumber(o.getFinancial().getCompra_cartera1() ));
		out.setEntidadCartera1(Comunes.validIsNullNumber(o.getFinancial().getEntidad_cartera1() ));
		out.setObligacionCartera1(Comunes.validIsNullNumber(o.getFinancial().getObligacion_cartera1() ));
		out.setCompraNit1(Comunes.validIsNullNumber(o.getFinancial().getCompra_nit1() ));
		out.setCompraCartera2(Comunes.validIsNullNumber(o.getFinancial().getCompra_cartera2() ));
		out.setEntidadCartera2(Comunes.validIsNullNumber(o.getFinancial().getEntidad_cartera2() ));
		out.setObligacionCartera2(Comunes.validIsNullNumber(o.getFinancial().getObligacion_cartera2() ));
		out.setCompraNit2(Comunes.validIsNullNumber(o.getFinancial().getCompra_nit2()));
		out.setCompraCartera3(Comunes.validIsNullNumber(o.getFinancial().getCompra_cartera3() ));
		out.setEntidadCartera3(Comunes.validIsNullNumber(o.getFinancial().getEntidad_cartera3() ));
		out.setObligacionCartera3(Comunes.validIsNullNumber(o.getFinancial().getObligacion_cartera3() ));
		out.setCompraNit3(Comunes.validIsNullNumber(o.getFinancial().getCompra_nit3() ));
		out.setCompraCartera4(Comunes.validIsNullNumber(o.getFinancial().getCompra_cartera4() ));
		out.setEntidadCartera4(Comunes.validIsNullNumber(o.getFinancial().getEntidad_cartera4()));
		out.setObligacionCartera4(Comunes.validIsNullNumber(o.getFinancial().getObligacion_cartera4() ));
		out.setCompraNit4(Comunes.validIsNullNumber(o.getFinancial().getCompra_nit4() ));

		out.setCodterAsesor(user);

		return out;
	}

	@Override
	public DTOSolCredito mapperDaoToDtoFinancial(DTOWF o, DTOSolCredito credito) {

		credito.setSueldo(comunes.validIsNullNumber(o.getFinancial().getSueldo()));
		credito.setRecargos(comunes.validIsNullNumber(o.getFinancial().getRecargos()));
		credito.setBonos(comunes.validIsNullNumber(o.getFinancial().getBonos()));
		credito.setCompensatorios(comunes.validIsNullNumber(o.getFinancial().getCompensatorios()));
		credito.setBonificacion(comunes.validIsNullNumber(o.getFinancial().getBonificacion()));
		credito.setHorasExtras(comunes.validIsNullNumber(o.getFinancial().getHoras_extras()));
		credito.setOtrosPagos1(comunes.validIsNullNumber(o.getFinancial().getOtros_pagos1()));
		credito.setOtrosPagos2(comunes.validIsNullNumber(o.getFinancial().getOtros_pagos2()));
		credito.setOtrosPagos3(comunes.validIsNullNumber(o.getFinancial().getOtros_pagos3()));
		credito.setSalud(comunes.validIsNullNumber(o.getFinancial().getSalud()));
		credito.setPension(comunes.validIsNullNumber(o.getFinancial().getPension()));
		credito.setLibranza(comunes.validIsNullNumber(o.getFinancial().getLibranza()));
		credito.setCuotaSindical(comunes.validIsNullNumber(o.getFinancial().getCuota_sindical()));
		credito.setCuotaInterna(comunes.validIsNullNumber(o.getFinancial().getCuota_interna()));
		credito.setOtrosDecuentos1(comunes.validIsNullNumber(o.getFinancial().getOtros_decuentos1()));
		credito.setOtrosDecuentos2(comunes.validIsNullNumber(o.getFinancial().getOtros_decuentos2()));
		credito.setOtrosDecuentos3(comunes.validIsNullNumber(o.getFinancial().getOtros_decuentos3()));
		credito.setCompraCartera1(comunes.validIsNullNumber(o.getFinancial().getCompra_cartera1()));
		credito.setEntidadCartera1(comunes.validIsNullNumber(o.getFinancial().getEntidad_cartera1()));
		credito.setObligacionCartera1(comunes.validIsNullNumber(o.getFinancial().getObligacion_cartera1()));
		credito.setCompraNit1(comunes.validIsNullNumber(o.getFinancial().getCompra_nit1()));
		credito.setCompraCartera2(comunes.validIsNullNumber(o.getFinancial().getCompra_cartera2()));
		credito.setEntidadCartera2(comunes.validIsNullNumber(o.getFinancial().getEntidad_cartera2()));
		credito.setObligacionCartera2(comunes.validIsNullNumber(o.getFinancial().getObligacion_cartera2()));
		credito.setCompraNit2(comunes.validIsNullNumber(o.getFinancial().getCompra_nit2()));
		credito.setCompraCartera3(comunes.validIsNullNumber(o.getFinancial().getCompra_cartera3()));
		credito.setEntidadCartera3(comunes.validIsNullNumber(o.getFinancial().getEntidad_cartera3()));
		credito.setObligacionCartera3(comunes.validIsNullNumber(o.getFinancial().getObligacion_cartera3()));
		credito.setCompraNit3(comunes.validIsNullNumber(o.getFinancial().getCompra_nit3()));
		credito.setCompraCartera4(comunes.validIsNullNumber(o.getFinancial().getCompra_cartera4()));
		credito.setEntidadCartera4(comunes.validIsNullNumber(o.getFinancial().getEntidad_cartera4()));
		credito.setObligacionCartera4(comunes.validIsNullNumber(o.getFinancial().getObligacion_cartera4()));
		credito.setCompraNit4(comunes.validIsNullNumber(o.getFinancial().getCompra_nit4()));

		return credito;
	}

	@Override
	public List<DTOSolCredito> mapperEntitiesToDaos(List<Object[]> o) {
		List<DTOSolCredito> out = new ArrayList<>();
		for (Object[] in : o) {
			SolCredito sol = new SolCredito();
			sol.setNumeroRadicacion((int)Double.parseDouble(in[0].toString()));
			sol.setEstado(in[1].toString());
			out.add(mapperEntitieToDao(sol));
		}

		return out;
	}

}
