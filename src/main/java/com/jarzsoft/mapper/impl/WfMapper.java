package com.jarzsoft.mapper.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOFodataso;
import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOTerceros;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.dto.DTOWFCodeu;
import com.jarzsoft.dto.DTOWFFinancialInfo;
import com.jarzsoft.dto.DTOWFPqr;
import com.jarzsoft.dto.DTOWFPrestamos;
import com.jarzsoft.dto.DTOWWfMov;
import com.jarzsoft.mapper.IWfMapper;
import com.jarzsoft.util.Comunes;
import com.jarzsoft.util.EnumWF;

@Service
public class WfMapper implements IWfMapper {

	@Override
	public DTOWF mapperDaoToDto(DTOSolCredito o, DTOTerceros u, DTOTerceros cod, DTOWWfMov mov, DTOFodataso foda,
			DTOFodataso fodaCodeo, Integer stepNow) {
		DTOWF out = new DTOWF();
		if (null != u) {
			out.setAntiEmpresa(Comunes.stringClean(u.getAntiEmpresa()));
			out.setBarrio(Comunes.stringClean(u.getBarrio()));
			out.setBarrioTra(Comunes.stringClean(u.getBarrioTra()));

			out.setCiuDirTrabajo(Comunes.stringToInt(u.getCiuDirTrabajo()));
			out.setCodiCiud(Comunes.stringToInt(u.getCodiCiud()));
			out.setCodiDept(Comunes.stringToInt(u.getCodiDept()));

			out.setDirPaisTer(Comunes.stringToInt(u.getDirPais()));
			out.setDirDepTer(Comunes.stringToInt(u.getDirDep()));
			out.setDirCiuTer(Comunes.stringToInt(u.getDirCiu()));

			out.setDeptDirTrabajo(Comunes.stringToInt(u.getDeptDirTrabajo()));
			out.setDirTeralt(Comunes.stringClean(u.getDirTeralt()));
			out.setDirTerpal(Comunes.stringClean(u.getDirTerpal()));
			out.setEntBan(Comunes.stringClean(u.getEntBan()));
			out.setFaxTer(Comunes.stringClean(u.getFaxter()));
	
			String feExp = Comunes.stringClean(u.getFeExp());
			out.setFeExp(feExp.length() >= 10 ? Comunes.cambiarFormatoFechaDinamic(feExp.substring(0, 10),
					Comunes.FORMAT_YYY_MM_DD, Comunes.FORMAT_MM_DD_YYYY) : feExp);
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
			out.setCodTer(Comunes.stringClean(u.getCodTer() + ""));
			out.setNomCony(Comunes.stringClean(u.getNomCony()));
			out.setCelConyuge(Comunes.stringClean(u.getCelConyuge()));
			out.setEmailConyuge(Comunes.stringClean(u.getEmailConyuge()));
			out.setCargoWf(o.getCargoDeuWf());
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
			codeu.setCodTer(Comunes.stringClean(cod.getCodTer() + ""));
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
			//	codeu.setCargoWf(Comunes.stringClean(fodaCodeo.getCargoCodWf()));
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
			codeu.setCargoWf(o.getCargoCodWf());
			out.setCodeu(codeu);
			

		}

		if (null != foda) {
			out.setEntitie(Comunes.stringToInt((foda.getClaAsoci())));
			out.setFecIngEmpresa(foda.getFecIngEmpresa() != null && !"".equals(foda.getFecIngEmpresa())
					? foda.getFecIngEmpresa().substring(0, 10)
					: "");
			out.setCodProfe(Comunes.stringToInt((foda.getCodProfe())));
			out.setNomCony(Comunes.stringClean(foda.getNomCony()));
			out.setEmailConyuge(Comunes.stringClean(foda.getEmailConyuge()));
			out.setCelConyuge(Comunes.stringClean(foda.getCelConyuge()));
		//	out.setCargoWf(Comunes.stringClean(foda.getCargoDeuWf()));
			out.setSexo(foda.getSexo() != null && !foda.getSexo().equals("0") ? foda.getSexo() : null);
			
			String fecCump = Comunes.stringClean(foda.getFec_cump());
			out.setFecCump(fecCump.length() >= 10 ? Comunes.cambiarFormatoFechaDinamic(fecCump.substring(0, 10),
					Comunes.FORMAT_YYY_MM_DD, Comunes.FORMAT_MM_DD_YYYY) : fecCump);
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
		out.setIdStepNow(stepNow + "");
		out.setSolPagare(o.getSolPagare());
		out.setIdWf(EnumWF.TIPO_WF.IDWF_4.getName());
		out.setTasaInt(o.getTasaInt());
		if (mov != null) {
			out.setIdSubStep("0");
			out.setNextStep(mov.getIdPaso());
			out.setIdStep(mov.getIdPaso());
			out.setComments(mov.getComentarios());
		}
		out.setPerCuota(o.getPerCuota());
		out.setFoticrep(Comunes.stringClean(o.getTipoCredito()));

		DTOWFFinancialInfo financial = new DTOWFFinancialInfo();
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

	@Override
	public DTOWFPqr mapperDaoToDto(DTOWWfMov o) {
		DTOWFPqr out = new DTOWFPqr();

		out.setIdWf(o.getIdWf() + "");
		out.setIdSubStep("0");
		out.setNextStep(o.getIdPaso());
		out.setIdStep(o.getIdPaso());
		out.setComments(o.getComentarios());
		out.setState(o.getEstPaso());
		out.setNumeroRadicacion(o.getNumeroRadicacion());
		out.setIdMov(o.getIdWfMov() + "");
		out.setNitter(o.getNitTer());
		out.setNameWf(o.getNameWf());
		out.setNameStep(o.getNamePaso());
		out.setUsuComercial(o.getUsuComercial());
		out.setFecUltMod(o.getFecUltMod() + "");
		out.setEntitie(o.getEstPasoMov());
		out.setNomTer(o.getNomTer());

		return out;
	}

	@Override
	public DTOWFPqr mapperDaoTerceroToDto(DTOTerceros o, DTOWFPqr out) {

		out.setDoctip(o.getDocTip());
		out.setNomTer(o.getNomTercero());
		out.setLugarDoc(o.getLugarDoc());
		out.setFeExp(o.getFeExp());
		out.setDirTerpal(o.getDirTerpal());
		out.setCodTer(o.getCodTer().toString());
		out.setMailTer(o.getMailTer());

		return out;

	}

	@Override
	public DTOWFPqr mapperDaoToDto(Object[] in) {

		Integer numRad = (int) (double) in[0];
		String idStep = String.valueOf(in[1]);
		String idWf = String.valueOf(in[2]);

		DTOWFPqr out = new DTOWFPqr();

		out.setIdWf(idWf);
		out.setIdSubStep("0");
		out.setNextStep(idStep);
		out.setIdStep(idStep);
		out.setComments(String.valueOf(in[3]));
		out.setState(String.valueOf(in[4]));
		out.setNumeroRadicacion(numRad);
		out.setIdMov(String.valueOf(in[5]));
		out.setNitter(String.valueOf(in[6]));
		out.setNameWf(String.valueOf(in[7]));
		out.setNameStep(String.valueOf(in[8]));
		out.setUsuComercial(String.valueOf(in[10]));
		out.setFecUltMod(String.valueOf(in[9]));
		out.setEntitie(String.valueOf(in[4]));
		out.setNomTer(String.valueOf(in[11]));
		out.setStateType(String.valueOf(in[12]));

		return out;
	}

	@Override
	public DTOWFPqr mapperDaoPrestamoToDto(List<DTOWFPrestamos> prestamos ,  DTOWFPqr out) {
		
		if(null!= prestamos && prestamos.size()>0) {
			DTOWFPrestamos prestamo= prestamos.get(0);			
			out.setIdArea(prestamo.getArea());
			out.setCertificado(Comunes.stateDocsBoolean(prestamo.getIndCer()));
			out.setCertificadoDeuda(Comunes.stateDocsBoolean(prestamo.getIndCerDeu()));
			out.setDerechoPeticion(Comunes.stateDocsBoolean(prestamo.getIndDp()));
			out.setEstadoCuenta(Comunes.stateDocsBoolean(prestamo.getIndEst()));
			out.setPazSalvo(Comunes.stateDocsBoolean(prestamo.getIndPaz()));
			out.setEntitie(prestamo.getClaAsoci());
			
			if(Comunes.stateDocsBoolean(prestamo.getIndDp())) {
				out.setStateType("2");
			}
		
		}				

		return out;
	}

	
	
	
	public DTOWF mapperRowToDto(Object[] r) {
	    DTOWF out = new DTOWF();

	    Integer numRad = (int) (double) r[0];
	    String estado = str(r[1]);
	    String tasaInt = str(r[2]);
	    String tipoCredito = str(r[3]);
	    String tipSolcredito = str(r[4]);
	    String bienAfecta = str(r[5]);
	    String bienHipoteca = str(r[6]);
	    String bienHipAfavor = str(r[7]);
	    String bienNombre = str(r[8]);
	    String bienValor = str(r[9]);
	    String vehPignorado = str(r[10]);
	    String vehMarca = str(r[11]);
	    String vehClase = str(r[12]);
	    String vehModelo = str(r[13]);
	    String vehPlaca = str(r[14]);
	    String vehPigAfavor = str(r[15]);
	    String vehValComercial = str(r[16]);
	    String valorPres = str(r[17]);
	    String nroCuotas = str(r[18]);
	    String nroCuenta = str(r[19]);
	    String refNombre1 = str(r[20]);
	    String refParen1 = str(r[21]);
	    String refMail1 = str(r[22]);
	    String refCel1 = str(r[23]);
	    String refNombre2 = str(r[24]);
	    String refParen2 = str(r[25]);
	    String refMail2 = str(r[26]);
	    String refCel2 = str(r[27]);
	    String refNombre3 = str(r[28]);
	    String refParen3 = str(r[29]);
	    String refMail3 = str(r[30]);
	    String refCel3 = str(r[31]);
	    Object codTerSol = r[32];
	    String observa = str(r[33]);
	    String perCuota = str(r[34]);
	    String indSolCredito = str(r[35]);
	    String solPagare = str(r[36]);
	    String cargoDeuWf = str(r[37]);

	    BigDecimal sueldo = toBigDecimal(r[38]);
	    BigDecimal recargos = toBigDecimal(r[39]);
	    BigDecimal bonos = toBigDecimal(r[40]);
	    BigDecimal compensatorios = toBigDecimal(r[41]);
	    BigDecimal bonificacion = toBigDecimal(r[42]);
	    BigDecimal horasExtras = toBigDecimal(r[43]);
	    BigDecimal otrosPagos1 = toBigDecimal(r[44]);
	    BigDecimal otrosPagos2 = toBigDecimal(r[45]);
	    BigDecimal otrosPagos3 = toBigDecimal(r[46]);
	    BigDecimal salud = toBigDecimal(r[47]);
	    BigDecimal pension = toBigDecimal(r[48]);
	    BigDecimal libranza = toBigDecimal(r[49]);
	    BigDecimal cuotaSindical = toBigDecimal(r[50]);
	    BigDecimal cuotaInterna = toBigDecimal(r[51]);
	    BigDecimal otrosDecuentos1 = toBigDecimal(r[52]);
	    BigDecimal otrosDecuentos2 = toBigDecimal(r[53]);
	    BigDecimal otrosDecuentos3 = toBigDecimal(r[54]);

	    String compraCartera1 = str(r[55]);
	    String entidadCartera1 = str(r[56]);
	    String obligacionCartera1 = str(r[57]);
	    String compraNit1 = str(r[58]);
	    String compraCartera2 = str(r[59]);
	    String entidadCartera2 = str(r[60]);
	    String obligacionCartera2 = str(r[61]);
	    String compraNit2 = str(r[62]);
	    String compraCartera3 = str(r[63]);
	    String entidadCartera3 = str(r[64]);
	    String obligacionCartera3 = str(r[65]);
	    String compraNit3 = str(r[66]);
	    String compraCartera4 = str(r[67]);
	    String entidadCartera4 = str(r[68]);
	    String obligacionCartera4 = str(r[69]);
	    String compraNit4 = str(r[70]);

	    String doctip = str(r[71]);
	    String nitter = str(r[72]);
	    String nomTercero = str(r[73]);
	    String priApellido = str(r[74]);
	    String segApellido = str(r[75]);
	    String lugarDoc = str(r[76]);
	    String mailTer = str(r[77]);
	    String dirTerpal = str(r[78]);
	    String telTer = str(r[79]);
	    String telTer1 = str(r[80]);
	    String telTer2 = str(r[81]);
	    String feExp = str(r[82]);
	    String paisCodigo = str(r[83]);
	    String codiDept = str(r[84]);
	    String codiCiud = str(r[85]);
	    String barrio = str(r[86]);
	    String antiEmpresa = str(r[87]);
	    String tipVivienda = str(r[88]);
	    String dirTeralt = str(r[89]);
	    String barrioTra = str(r[90]);
	    String paisDirTrabajo = str(r[91]);
	    String deptDirTrabajo = str(r[92]);
	    String ciuDirTrabajo = str(r[93]);
	    String faxTer = str(r[94]);
	    String indContrato = str(r[95]);
	    String paramText = str(r[96]);
	    String entBan = str(r[97]);
	    String tipCta = str(r[98]);
	    String idConyuge = str(r[99]);
	    String nomCony = str(r[100]);
	    String emailConyuge = str(r[101]);
	    String celConyuge = str(r[102]);
	    String dirPaisTer = str(r[103]);
	    String dirDepTer = str(r[104]);
	    String dirCiuTer = str(r[105]);
	    Object codTerTer = r[106];

	    Integer pasoActual = r[107] != null ? Integer.valueOf(r[107].toString()) : null;

	    boolean hayTercero = codTerTer != null;

	    if (hayTercero) {
	        out.setAntiEmpresa(Comunes.stringClean(antiEmpresa));
	        out.setBarrio(Comunes.stringClean(barrio));
	        out.setBarrioTra(Comunes.stringClean(barrioTra));
	        out.setCiuDirTrabajo(Comunes.stringToInt(ciuDirTrabajo));
	        out.setCodiCiud(Comunes.stringToInt(codiCiud));
	        out.setCodiDept(Comunes.stringToInt(codiDept));
	        out.setDirPaisTer(Comunes.stringToInt(dirPaisTer));
	        out.setDirDepTer(Comunes.stringToInt(dirDepTer));
	        out.setDirCiuTer(Comunes.stringToInt(dirCiuTer));
	        out.setDeptDirTrabajo(Comunes.stringToInt(deptDirTrabajo));
	        out.setDirTeralt(Comunes.stringClean(dirTeralt));
	        out.setDirTerpal(Comunes.stringClean(dirTerpal));
	        out.setEntBan(Comunes.stringClean(entBan));
	        out.setFaxTer(Comunes.stringClean(faxTer));

	        String feExpClean = Comunes.stringClean(feExp);
	        out.setFeExp(feExpClean.length() >= 10
	                ? Comunes.cambiarFormatoFechaDinamic(feExpClean.substring(0, 10), Comunes.FORMAT_YYY_MM_DD, Comunes.FORMAT_MM_DD_YYYY)
	                : feExpClean);
	        out.setIdConyuge(Comunes.stringClean(idConyuge));
	        out.setIndContrato(Comunes.stringClean(indContrato));
	        out.setLugarDoc(Comunes.stringClean(lugarDoc));
	        out.setMailTer(Comunes.stringClean(mailTer));
	        out.setNomTer(Comunes.stringClean(nomTercero));
	        out.setPaisCodigo(Comunes.stringToInt(paisCodigo));
	        out.setPaisDirTrabajo(Comunes.stringToInt(paisDirTrabajo));
	        out.setParamText(Comunes.stringClean(paramText));
	        out.setPriApellido(Comunes.stringClean(priApellido));
	        out.setSegApellido(Comunes.stringClean(segApellido));
	        out.setTelTer(Comunes.stringClean(telTer));
	        out.setTelTer1(Comunes.stringClean(telTer1));
	        out.setTelTer2(Comunes.stringClean(telTer2));
	        out.setTipCta(Comunes.stringClean(tipCta));
	        out.setTipVivienda(Comunes.stringClean(tipVivienda));
	        out.setDoctip(Comunes.stringToInt(doctip));
	        out.setNitter(Comunes.stringClean(nitter));
	        out.setCodTer(Comunes.stringClean(codTerTer + ""));
	        out.setNomCony(Comunes.stringClean(nomCony));
	        out.setCelConyuge(Comunes.stringClean(celConyuge));
	        out.setEmailConyuge(Comunes.stringClean(emailConyuge));
	        out.setCargoWf(cargoDeuWf);
	    }

	    out.setNumeroRadicacion(numRad);
	    out.setEstado(estado);
	    out.setBienAfecta(bienAfecta);
	    out.setBienHipAFavor(bienHipAfavor);
	    out.setBienHipoteca(bienHipoteca);
	    out.setBienNombre(bienNombre);
	    out.setBienValor(Comunes.stringToInt(bienValor));
	    out.setNroCuotas(Comunes.stringToInt(nroCuotas));
	    out.setRefCel1(refCel1);
	    out.setRefCel2(refCel2);
	    out.setRefCel3(refCel3);
	    out.setRefMail1(refMail1);
	    out.setRefMail2(refMail2);
	    out.setRefMail3(refMail3);
	    out.setRefNombre1(refNombre1);
	    out.setRefNombre2(refNombre2);
	    out.setRefNombre3(refNombre3);
	    out.setRefParen1(refParen1);
	    out.setRefParen2(refParen2);
	    out.setRefParen3(refParen3);
	    out.setTipSolCredito(tipSolcredito);
	    out.setValorPress(Comunes.stringToInt(valorPres));
	    out.setVehClase(vehClase);
	    out.setVehMarca(vehMarca);
	    out.setVehModelo(vehModelo);
	    out.setVehPigAFavor(vehPigAfavor);
	    out.setVehPignorado(vehPignorado);
	    out.setVehPlaca(vehPlaca);
	    out.setVehValVomercial(Comunes.stringToInt(vehValComercial));
	    out.setNumCta(Comunes.stringClean(nroCuenta));
	    out.setComments(observa);
	    out.setIndSolCredito(indSolCredito);
	    out.setIdStepNow(pasoActual + "");
	    out.setSolPagare(solPagare);
	    out.setIdWf(EnumWF.TIPO_WF.IDWF_4.getName());
	    out.setTasaInt(tasaInt);
	    out.setPerCuota(perCuota);
	    out.setFoticrep(Comunes.stringClean(tipoCredito));

	    DTOWFFinancialInfo financial = new DTOWFFinancialInfo();
	    financial.setSueldo(sueldo);
	    financial.setRecargos(recargos);
	    financial.setBonos(bonos);
	    financial.setCompensatorios(compensatorios);
	    financial.setBonificacion(bonificacion);
	    financial.setHoras_extras(horasExtras);
	    financial.setOtros_pagos1(otrosPagos1);
	    financial.setOtros_pagos2(otrosPagos2);
	    financial.setOtros_pagos3(otrosPagos3);
	    financial.setSalud(salud);
	    financial.setPension(pension);
	    financial.setLibranza(libranza);
	    financial.setCuota_sindical(cuotaSindical);
	    financial.setCuota_interna(cuotaInterna);
	    financial.setOtros_decuentos1(otrosDecuentos1);
	    financial.setOtros_decuentos2(otrosDecuentos2);
	    financial.setOtros_decuentos3(otrosDecuentos3);
	    financial.setCompra_cartera1(compraCartera1);
	    financial.setEntidad_cartera1(entidadCartera1);
	    financial.setObligacion_cartera1(obligacionCartera1);
	    financial.setCompra_nit1(compraNit1);
	    financial.setCompra_cartera2(compraCartera2);
	    financial.setEntidad_cartera2(entidadCartera2);
	    financial.setObligacion_cartera2(obligacionCartera2);
	    financial.setCompra_nit2(compraNit2);
	    financial.setCompra_cartera3(compraCartera3);
	    financial.setEntidad_cartera3(entidadCartera3);
	    financial.setObligacion_cartera3(obligacionCartera3);
	    financial.setCompra_nit3(compraNit3);
	    financial.setCompra_cartera4(compraCartera4);
	    financial.setEntidad_cartera4(entidadCartera4);
	    financial.setObligacion_cartera4(obligacionCartera4);
	    financial.setCompra_nit4(compraNit4);
	    out.setFinancial(financial);

	    return out;
	}

	private String str(Object o) {
	    return o == null ? null : o.toString();
	}

	private BigDecimal toBigDecimal(Object o) {
	    return Comunes.validIsNullStringTonumber(o == null ? null : o.toString());
	}

}
