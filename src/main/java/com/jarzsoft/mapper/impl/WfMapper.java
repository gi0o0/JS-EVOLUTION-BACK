package com.jarzsoft.mapper.impl;


import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOFodataso;
import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOTerceros;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.dto.DTOWFCodeu;
import com.jarzsoft.dto.DTOWFFinancialInfo;
import com.jarzsoft.dto.DTOWWfMov;
import com.jarzsoft.mapper.IWfMapper;
import com.jarzsoft.util.Comunes;
import com.jarzsoft.util.EnumWF;

@Service
public class WfMapper implements IWfMapper {

	@Override
	public DTOWF mapperDaoToDto(DTOSolCredito o, DTOTerceros u, DTOTerceros cod, DTOWWfMov mov, DTOFodataso foda,
			DTOFodataso fodaCodeo,Integer stepNow) {
		DTOWF out = new DTOWF();
		if (null != u) {
			out.setAntiEmpresa(Comunes.stringClean(u.getAntiEmpresa()));
			out.setBarrio(Comunes.stringClean(u.getBarrio()));
			out.setBarrioTra(Comunes.stringClean(u.getBarrioTra()));
			out.setCiuDirTrabajo(Comunes.stringToInt(u.getCiuDirTrabajo()));
			out.setCodiCiud(Comunes.stringToInt(u.getCodiCiud()));
			out.setCodiDept(Comunes.stringToInt(u.getCodiDept()));
			out.setDeptDirTrabajo(Comunes.stringToInt(u.getDeptDirTrabajo()));
			out.setDirTeralt(Comunes.stringClean(u.getDirTeralt()));
			out.setDirTerpal(Comunes.stringClean(u.getDirTerpal()));
			out.setEntBan(Comunes.stringClean(u.getEntBan()));
			out.setFaxTer(Comunes.stringClean(u.getFaxter()));
			
			String fecExpDoc=Comunes.stringClean(u.getFecExpDoc());
			String feExp=Comunes.stringClean(u.getFeExp());

			out.setFecCump(fecExpDoc.length()>=10?Comunes.cambiarFormatoFechaDinamic(fecExpDoc.substring(0, 10),Comunes.FORMAT_YYY_MM_DD,Comunes.FORMAT_MM_DD_YYYY):fecExpDoc);
			out.setFeExp(feExp.length()>=10?Comunes.cambiarFormatoFechaDinamic(feExp.substring(0, 10),Comunes.FORMAT_YYY_MM_DD,Comunes.FORMAT_MM_DD_YYYY):feExp);
			out.setIdConyuge(Comunes.stringClean(u.getIdConyuge()));
			out.setIndContrato(Comunes.stringClean(u.getIndContrato()));
			out.setLugarDoc(Comunes.stringClean(u.getLugarDoc()));
			out.setMailTer(Comunes.stringClean(u.getMailTer()));
			out.setNomTer(Comunes.stringClean(u.getNomTercero()));
			out.setNumCta(Comunes.stringClean(u.getNumCta()));
			out.setPaisCodigo(Comunes.stringToInt(u.getPaisCodigo()));
			out.setPaisDirTrabajo(Comunes.stringToInt(u.getPaisDirTrabajo()));
			out.setParamText(Comunes.stringClean(u.getParamText()));
			out.setPriApellido(Comunes.stringClean(u.getPriApellido()));
			out.setSegApellido(Comunes.stringClean(u.getSegApellido()));
			out.setTelTer(Comunes.stringClean(u.getTelter()));
			out.setTelTer1(Comunes.stringClean(u.getTelter1()));
			out.setTelTer2(Comunes.stringClean(u.getTelter2()));
			out.setTipCta(Comunes.stringClean(u.getTipCta()));
			out.setTipVivienda(Comunes.stringClean(u.getTipVivienda()));
			out.setDoctip(Comunes.stringToInt((u.getDocTip())));
			out.setNitter(Comunes.stringClean(u.getNitTer()));
			out.setCodTer(Comunes.stringClean(u.getCodTer()+""));
			out.setNomCony(Comunes.stringClean(u.getNomCony()));
			out.setCelConyuge(Comunes.stringClean(u.getCelConyuge()));
			out.setEmailConyuge(Comunes.stringClean(u.getEmailConyuge()));
		}
		if (null != cod) {
			DTOWFCodeu codeu = new DTOWFCodeu();
			codeu.setAntiEmpresa(Comunes.stringClean(cod.getAntiEmpresa()));
			codeu.setBarrio(Comunes.stringClean(cod.getBarrio()));
			codeu.setBarrioTra(Comunes.stringClean(cod.getBarrioTra()));
			codeu.setCiuDirTrabajo(Comunes.stringToInt(cod.getCiuDirTrabajo()));
			codeu.setCodiCiud(Comunes.stringToInt(cod.getCodiCiud()));
			codeu.setCodiDept(Comunes.stringToInt(cod.getCodiDept()));
			codeu.setDeptDirTrabajo(Comunes.stringToInt(cod.getDeptDirTrabajo()));
			codeu.setDirTeralt(Comunes.stringClean(cod.getDirTeralt()));
			codeu.setDirTerpal(Comunes.stringClean(cod.getDirTerpal()));
			codeu.setFaxTer(Comunes.stringClean(cod.getFaxter()));
			codeu.setIdConyuge(Comunes.stringClean(cod.getIdConyuge()));
			codeu.setIndContrato(Comunes.stringClean(cod.getIndContrato()));
			codeu.setLugarDoc(Comunes.stringClean(cod.getLugarDoc()));
			codeu.setMailTer(Comunes.stringClean(cod.getMailTer()));
			codeu.setNomTer(Comunes.stringClean(cod.getNomTercero()));
			codeu.setPaisCodigo(Comunes.stringToInt(cod.getPaisCodigo()));
			codeu.setPaisDirTrabajo(Comunes.stringToInt((cod.getPaisDirTrabajo())));
			codeu.setParamText(Comunes.stringClean(cod.getParamText()));
			codeu.setPriApellido(Comunes.stringClean(cod.getPriApellido()));
			codeu.setSegApellido(Comunes.stringClean(cod.getSegApellido()));
			codeu.setTelTer(Comunes.stringClean(cod.getTelter()));
			codeu.setTipVivienda(Comunes.stringClean(cod.getTipVivienda()));
			codeu.setDoctip(Comunes.stringToInt(cod.getDocTip()));
			codeu.setNitter(Comunes.stringClean(cod.getNitTer()));
			codeu.setCodTer(Comunes.stringClean(cod.getCodTer()+""));
			codeu.setNomCony(Comunes.stringClean(cod.getNomCony()));
			codeu.setCelConyuge(Comunes.stringClean(cod.getCelConyuge()));
			codeu.setEmailConyuge(Comunes.stringClean(cod.getEmailConyuge()));
			codeu.setFeExp(cod.getFeExp());
			codeu.setEmpresaCod(o.getEmpresaCod());
			if (null != fodaCodeo) {

				
				codeu.setCodProfe(Comunes.stringToInt((fodaCodeo.getCodProfe())));
				codeu.setNomCony(Comunes.stringClean(fodaCodeo.getNomCony()));
				codeu.setEmailConyuge(Comunes.stringClean(fodaCodeo.getEmailConyuge()));
				codeu.setCelConyuge(Comunes.stringClean(fodaCodeo.getCelConyuge()));
				codeu.setCargoWf(Comunes.stringClean(fodaCodeo.getCargoCodWf()));
			}

			codeu.setRefCel1(Comunes.stringClean(o.getRefCel1Cod()));
			codeu.setRefCel2(Comunes.stringClean(o.getRefCel2Cod()));
			codeu.setRefCel3(Comunes.stringClean(o.getRefCel3Cod()));
			codeu.setRefMail1(Comunes.stringClean(o.getRefMail1Cod()));
			codeu.setRefMail2(Comunes.stringClean(o.getRefMail2Cod()));
			codeu.setRefMail3(Comunes.stringClean(o.getRefMail3Cod()));
			codeu.setRefNombre1(Comunes.stringClean(o.getRefNombre1Cod()));
			codeu.setRefNombre2(Comunes.stringClean(o.getRefNombre2Cod()));
			codeu.setRefNombre3(Comunes.stringClean(o.getRefNombre3Cod()));
			codeu.setRefParen1(Comunes.stringClean(o.getRefParen1Cod()));
			codeu.setRefParen2(Comunes.stringClean(o.getRefParen2Cod()));
			codeu.setRefParen3(Comunes.stringClean(o.getRefParen3Cod()));

			codeu.setVehClase(Comunes.stringClean(o.getVehClaseCod()));
			codeu.setVehMarca(Comunes.stringClean(o.getVehMarcaCod()));
			codeu.setVehModelo(Comunes.stringClean(o.getVehModeloCod()));
			codeu.setVehPigAFavor(Comunes.stringClean(o.getVehPigAfavorCod()));
			codeu.setVehPignorado(Comunes.stringClean(o.getVehPignoradoCod()));
			codeu.setVehPlaca(Comunes.stringClean(o.getVehPlacaCod()));
			codeu.setVehValVomercial(Comunes.stringToInt(o.getVehValComercialCod()));

			codeu.setBienAfecta(Comunes.stringClean(o.getBienAfectaCod()));
			codeu.setBienHipAFavor(Comunes.stringClean(o.getBienHipAfavorCod()));
			codeu.setBienHipoteca(Comunes.stringClean(o.getBienHipotecaCod()));
			codeu.setBienNombre(Comunes.stringClean(o.getBienNombreCod()));
			codeu.setBienValor(Comunes.stringToInt(o.getBienValorCod()));

			out.setCodeu(codeu);

		}

		if (null != foda) {
			out.setEntitie(Comunes.stringToInt((foda.getClaAsoci())));
			out.setFecIngEmpresa(foda.getFecIngEmpresa()!=null&&!"".equals(foda.getFecIngEmpresa())?foda.getFecIngEmpresa().substring(0, 10):"");
			out.setCodProfe(Comunes.stringToInt((foda.getCodProfe())));
			out.setNomCony(Comunes.stringClean(foda.getNomCony()));
			out.setEmailConyuge(Comunes.stringClean(foda.getEmailConyuge()));
			out.setCelConyuge(Comunes.stringClean(foda.getCelConyuge()));
			out.setCargoWf(Comunes.stringClean(foda.getCargoDeuWf()));
			out.setSexo(foda.getSexo()!=null&&!foda.getSexo().equals("0")?foda.getSexo():null);
		}

		out.setNumeroRadicacion(o.getNumeroRadicacion());
		out.setEstado(o.getEstado());
		out.setBienAfecta(o.getBienAfecta());
		out.setBienHipAFavor(o.getBienHipAfavor());
		out.setBienHipoteca(o.getBienHipoteca());
		out.setBienNombre(o.getBienNombre());
		out.setBienValor(Comunes.stringToInt(o.getBienValor()));
		out.setNroCuotas(Comunes.stringToInt(o.getNroCuotas()));
		out.setNumeroRadicacion(o.getNumeroRadicacion());
		out.setRefCel1(o.getRefCel1());
		out.setRefCel2(o.getRefCel2());
		out.setRefCel3(o.getRefCel3());
		out.setRefMail1(o.getRefMail1());
		out.setRefMail2(o.getRefMail2());
		out.setRefMail3(o.getRefMail3());
		out.setRefNombre1(o.getRefNombre1());
		out.setRefNombre2(o.getRefNombre2());
		out.setRefNombre3(o.getRefNombre3());
		out.setRefParen1(o.getRefParen1());
		out.setRefParen2(o.getRefParen2());
		out.setRefParen3(o.getRefParen3());
		out.setTipSolCredito(o.getTipSolcredito());
		out.setValorPress(Comunes.stringToInt(o.getValorPres()));
		out.setVehClase(o.getVehClase());
		out.setVehMarca(o.getVehMarca());
		out.setVehModelo(o.getVehModelo());
		out.setVehPigAFavor(o.getVehPigAfavor());
		out.setVehPignorado(o.getVehPignorado());
		out.setVehPlaca(o.getVehPlaca());
		out.setVehValVomercial(Comunes.stringToInt(o.getVehValComercial()));
		out.setNumCta(Comunes.stringClean(o.getNroCuenta()));
		out.setComments(o.getObserva());
		out.setIndSolCredito(o.getIndSolCredito());
		out.setIdStepNow(stepNow+"");
		out.setSolPagare(o.getSolPagare());
		

		if (mov != null) {
			out.setIdWf(EnumWF.TIPO_WF.IDWF_4.getName());
			out.setIdSubStep("0");
			out.setNextStep(mov.getIdPaso());
			out.setIdStep(mov.getIdPaso());
			out.setComments(mov.getComentarios());
		}
		out.setPerCuota(o.getPerCuota());
		out.setFoticrep(Comunes.stringClean(o.getTipoCredito()));
		
		
		
		DTOWFFinancialInfo financial =new DTOWFFinancialInfo();
		financial.setSueldo(Comunes.validIsNullStringTonumber(o.getSueldo()));
		financial.setRecargos(Comunes.validIsNullStringTonumber(o.getRecargos()));
		financial.setBonos(Comunes.validIsNullStringTonumber(o.getBonos()));
		financial.setCompensatorios(Comunes.validIsNullStringTonumber(o.getCompensatorios()));
		financial.setBonificacion(Comunes.validIsNullStringTonumber(o.getBonificacion()));
		financial.setHoras_extras(Comunes.validIsNullStringTonumber(o.getHorasExtras()));
		financial.setOtros_pagos1(Comunes.validIsNullStringTonumber(o.getOtrosPagos1()));
		financial.setOtros_pagos2(Comunes.validIsNullStringTonumber(o.getOtrosPagos2()));
		financial.setOtros_pagos3(Comunes.validIsNullStringTonumber(o.getOtrosPagos3()));
		financial.setSalud(Comunes.validIsNullStringTonumber(o.getSalud()));
		financial.setPension(Comunes.validIsNullStringTonumber(o.getPension()));
		financial.setLibranza(Comunes.validIsNullStringTonumber(o.getLibranza()));
		financial.setCuota_sindical(Comunes.validIsNullStringTonumber(o.getCuotaSindical()));
		financial.setCuota_interna(Comunes.validIsNullStringTonumber(o.getCuotaInterna()));
		financial.setOtros_decuentos1(Comunes.validIsNullStringTonumber(o.getOtrosDecuentos1()));
		financial.setOtros_decuentos2(Comunes.validIsNullStringTonumber(o.getOtrosDecuentos2()));
		financial.setOtros_decuentos3(Comunes.validIsNullStringTonumber(o.getOtrosDecuentos3()));
		financial.setCompra_cartera1(Comunes.validIsNullNumber(o.getCompraCartera1()));
		financial.setEntidad_cartera1(Comunes.validIsNullNumber(o.getEntidadCartera1()));
		financial.setObligacion_cartera1(Comunes.validIsNullNumber(o.getObligacionCartera1()));
		financial.setCompra_nit1(Comunes.validIsNullNumber(o.getCompraNit1()));
		financial.setCompra_cartera2(Comunes.validIsNullNumber(o.getCompraCartera2()));
		financial.setEntidad_cartera2(Comunes.validIsNullNumber(o.getEntidadCartera2()));
		financial.setObligacion_cartera2(Comunes.validIsNullNumber(o.getObligacionCartera2()));
		financial.setCompra_nit2(Comunes.validIsNullNumber(o.getCompraNit2()));
		financial.setCompra_cartera3(Comunes.validIsNullNumber(o.getCompraCartera3()));
		financial.setEntidad_cartera3(Comunes.validIsNullNumber(o.getEntidadCartera3()));
		financial.setObligacion_cartera3(Comunes.validIsNullNumber(o.getObligacionCartera3()));
		financial.setCompra_nit3(Comunes.validIsNullNumber(o.getCompraNit3()));
		financial.setCompra_cartera4(Comunes.validIsNullNumber(o.getCompraCartera4()));
		financial.setEntidad_cartera4(Comunes.validIsNullNumber(o.getEntidadCartera4()));
		financial.setObligacion_cartera4(Comunes.validIsNullNumber(o.getObligacionCartera4()));
		financial.setCompra_nit4(Comunes.validIsNullNumber(o.getCompraNit4()));
		out.setFinancial(financial);

		return out;
	}



}
