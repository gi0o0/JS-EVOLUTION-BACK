package com.jarzsoft.mapper.impl;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOTerceros;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.dto.DTOWFCodeu;
import com.jarzsoft.mapper.IWfMapper;

@Service
public class WfMapper implements IWfMapper {

	@Override
	public DTOWF mapperDaoToDto(DTOSolCredito o, DTOTerceros u, DTOTerceros cod) {
		DTOWF out = new DTOWF();
		if (null != u) {
			out.setAntiEmpresa(u.getAntiEmpresa());
			out.setBarrio(u.getBarrio());
			out.setBarrioTra(u.getBarrioTra());
			out.setCodiciuDirTrabajoCiud(u.getCiuDirTrabajo());
			out.setCodiCiud(u.getCodiCiud());
			out.setCodiDept(u.getCodiDept());
			out.setDeptDirTrabajo(u.getDeptDirTrabajo());
			out.setDirTeralt(u.getDirTeralt());
			out.setDirTerpal(u.getDirTerpal());
			out.setEntBan(u.getEntBan());
			out.setFaxTer(u.getFaxter());
			out.setFecCump(u.getFeExp());
			out.setIdConyuge(u.getIdConyuge());
			out.setIndContrato(u.getIndContrato());
			out.setLugarDoc(u.getLugarDoc());
			out.setMailTer(u.getMailTer());
			out.setNomTer(u.getNomTercero());
			out.setNumCta(u.getNumCta());
			out.setPaisCodigo(u.getPaisCodigo());
			out.setPaisDirTrabajo(u.getPaisDirTrabajo());
			out.setParamText(u.getParamText());
			out.setPriApellido(u.getPriApellido());
			out.setSegApellido(u.getSegApellido());
			out.setTelTer(u.getTelter());
			out.setTelTer1(u.getTelter1());
			out.setTelTer2(u.getTelter2());
			out.setTipCta(u.getTipCta());
			out.setTipVivienda(u.getTipVivienda());
			out.setDoctip(u.getDocTip());
			out.setNitter(u.getNitTer());
			out.setNomCony(u.getNomCony());
			out.setCelConyuge(u.getCelConyuge());
			out.setEmailConyuge(u.getEmailConyuge());
		}
		if (null != cod) {
			DTOWFCodeu codeu = new DTOWFCodeu();
			codeu.setAntiEmpresa(cod.getAntiEmpresa());
			codeu.setBarrio(cod.getBarrio());
			codeu.setBarrioTra(cod.getBarrioTra());
			codeu.setCodiciuDirTrabajoCiud(cod.getCiuDirTrabajo());
			codeu.setCodiCiud(cod.getCodiCiud());
			codeu.setCodiDept(cod.getCodiDept());
			codeu.setDeptDirTrabajo(cod.getDeptDirTrabajo());
			codeu.setDirTeralt(cod.getDirTeralt());
			codeu.setDirTerpal(cod.getDirTerpal());
			codeu.setFaxTer(cod.getFaxter());
			codeu.setIdConyuge(cod.getIdConyuge());
			codeu.setIndContrato(cod.getIndContrato());
			codeu.setLugarDoc(cod.getLugarDoc());
			codeu.setMailTer(cod.getMailTer());
			codeu.setNomTer(cod.getNomTercero());
			codeu.setPaisCodigo(cod.getPaisCodigo());
			codeu.setPaisDirTrabajo(cod.getPaisDirTrabajo());
			codeu.setParamText(cod.getParamText());
			codeu.setPriApellido(cod.getPriApellido());
			codeu.setSegApellido(cod.getSegApellido());
			codeu.setTelTer(cod.getTelter());
			codeu.setTipVivienda(cod.getTipVivienda());
			codeu.setDoctip(cod.getDocTip());
			codeu.setNitter(cod.getNitTer());
			codeu.setNomCony(cod.getNomCony());
			codeu.setCelConyuge(cod.getCelConyuge());
			codeu.setEmailConyuge(cod.getEmailConyuge());

			/*out.setBienHipAfavorCod(o.getCodeu().getBienHipAFavor());
			out.setBienHipotecaCod(o.getCodeu().getBienHipoteca());
			out.setBienNombreCod(o.getCodeu().getBienNombre());
			out.setBienValorCod(o.getCodeu().getBienValor());
			out.setRefCel1Cod(o.getCodeu().getRefCel1());
			out.setRefCel2Cod(o.getCodeu().getRefCel2());
			out.setRefCel3Cod(o.getCodeu().getRefCel3());
			out.setRefMail1Cod(o.getCodeu().getRefMail1());
			out.setRefMail2Cod(o.getCodeu().getRefMail2());
			out.setRefMail3Cod(o.getCodeu().getRefMail3());
			out.setRefNombre1Cod(o.getCodeu().getRefNombre1());
			out.setRefNombre2Cod(o.getCodeu().getRefNombre2());
			out.setRefNombre3Cod(o.getCodeu().getRefNombre3());
			out.setRefParen1Cod(o.getCodeu().getRefParen1());
			out.setRefParen2Cod(o.getCodeu().getRefParen2());
			out.setRefParen3Cod(o.getCodeu().getRefParen3());
			out.setVehClaseCod(o.getCodeu().getVehClase());
			out.setVehMarcaCod(o.getCodeu().getVehMarca());
			out.setVehModeloCod(o.getCodeu().getVehModelo());
			out.setVehPigAfavorCod(o.getCodeu().getVehPigAFavor());
			out.setVehPignoradoCod(o.getCodeu().getVehPignorado());
			out.setVehPlacaCod(o.getCodeu().getVehPlaca());
			out.setVehValComercialCod(o.getCodeu().getVehValVomercial());	*/

			out.setCodeu(codeu);

		}
		out.setNumeroRadicacion(o.getNumeroRadicacion());
		out.setEstado(o.getEstado());

		out.setBienAfecta(o.getBienAfecta());

		out.setBienHipAFavor(o.getBienHipAfavor());

		out.setBienHipoteca(o.getBienHipoteca());

		out.setBienNombre(o.getBienNombre());

		out.setBienValor(o.getBienValor());

		out.setNroCuotas(o.getNroCuotas());
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
		out.setValorPress(o.getValorPres());
		out.setVehClase(o.getVehClase());

		out.setVehMarca(o.getVehMarca());

		out.setVehModelo(o.getVehModelo());

		out.setVehPigAFavor(o.getVehPigAfavor());

		out.setVehPignorado(o.getVehPignorado());

		out.setVehPlaca(o.getVehPlaca());

		out.setVehValVomercial(o.getVehValComercial());

		out.setNumCta(o.getNroCuenta());
		out.setComments(o.getObserva());

		return out;
	}

}
