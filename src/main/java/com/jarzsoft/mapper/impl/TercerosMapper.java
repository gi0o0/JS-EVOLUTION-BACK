package com.jarzsoft.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOTerceros;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.entities.Terceros;
import com.jarzsoft.exception.PageNoFoundException;
import com.jarzsoft.mapper.ITercerosMapper;
import com.jarzsoft.util.Comunes;
import com.jarzsoft.util.Constantes;

@Service
public class TercerosMapper implements ITercerosMapper {

	@Override
	public Terceros mapperDtoToEntitie(DTOTerceros o) {
		Terceros out = new Terceros();
		out.setCodTer(o.getCodTer());
		out.setAntiEmpresa(o.getAntiEmpresa());
		out.setBarrio(o.getBarrio());
		out.setBarrioTra(o.getBarrioTra());
		out.setCiuDirTrabajo(o.getCiuDirTrabajo());
		out.setCodiCiud(o.getCodiCiud());
		out.setCodiDept(o.getCodiDept());
		out.setCodTer(o.getCodTer());
		out.setDeptDirTrabajo(o.getDeptDirTrabajo());
		out.setDirTeralt(o.getDirTeralt());
		out.setDirTerpal(o.getDirTerpal());
		out.setEntBan(o.getEntBan());
		out.setFaxter(o.getFaxter());
		out.setFeExp(o.getFeExp());
		out.setFecExpDoc(o.getFecExpDoc());
		out.setIdConyuge(o.getIdConyuge());
		out.setIndContrato(o.getIndContrato());
		out.setLugarDoc(o.getLugarDoc());
		out.setMailTer(o.getMailTer());
		out.setNomTercero(o.getNomTercero());
		out.setNumCta(o.getNumCta());
		out.setPaisCodigo(o.getPaisCodigo());
		out.setPaisDirTrabajo(o.getPaisDirTrabajo());
		out.setParamText(o.getParamText());
		out.setPriApellido(o.getPriApellido());
		out.setSegApellido(o.getSegApellido());
		out.setTelter(o.getTelter());
		out.setTelter1(o.getTelter1());
		out.setTelter2(o.getTelter2());
		out.setTipCta(o.getTipCta());
		out.setTipVivienda(o.getTipVivienda());
		out.setDocTip(o.getDocTip());
		out.setNitTer(o.getNitTer());
		out.setNomTer(o.getPriApellido() + " " + o.getSegApellido() + " " + o.getNomTercero());
		out.setParamId(o.getParamId());
		out.setNomCony(o.getNomCony());
		out.setCelConyuge(o.getCelConyuge());
		out.setEmailConyuge(o.getEmailConyuge());
		out.setIndSecEconomico(o.getIndSecEconomico());

		return out;
	}

	@Override
	public DTOTerceros mapperDaoToDtoUser(DTOWF o) {
		DTOTerceros out = new DTOTerceros();
		out.setAntiEmpresa(o.getAntiEmpresa());
		out.setBarrio(o.getBarrio());
		out.setBarrioTra(o.getBarrioTra());
		out.setCiuDirTrabajo(o.getCiuDirTrabajo());
		out.setCodiCiud(o.getCodiCiud());
		out.setCodiDept(o.getCodiDept());
		out.setDeptDirTrabajo(o.getDeptDirTrabajo());
		out.setDirTeralt(o.getDirTeralt());
		out.setDirTerpal(o.getDirTerpal());
		out.setEntBan(o.getEntBan());
		out.setFaxter(o.getFaxTer());
		out.setFeExp(o.getFeExp());
		out.setFecExpDoc(o.getFecCump());
		out.setIdConyuge(o.getIdConyuge());
		out.setIndContrato(o.getIndContrato());
		out.setLugarDoc(o.getLugarDoc());
		out.setMailTer(o.getMailTer());
		out.setNomTercero(o.getNomTer());
		out.setNumCta(o.getNumCta());
		out.setPaisCodigo(o.getPaisCodigo());
		out.setPaisDirTrabajo(o.getPaisDirTrabajo());
		out.setParamText(o.getParamText());
		out.setPriApellido(o.getPriApellido());
		out.setSegApellido(o.getSegApellido());
		out.setTelter(o.getTelTer());
		out.setTelter1(o.getTelTer1());
		out.setTelter2(o.getTelTer2());
		out.setTipCta(o.getTipCta());
		out.setTipVivienda(o.getTipVivienda());
		out.setDocTip(o.getDoctip());
		out.setNitTer(o.getNitter());
		out.setParamId("EPS");
		out.setIndSecEconomico("10");
		out.setNomCony(o.getNomCony());
		out.setCelConyuge(o.getCelConyuge());
		out.setEmailConyuge(o.getEmailConyuge());
		return out;
	}

	@Override
	public DTOTerceros mapperDaoToDtoCodeo(DTOWF o) {
		DTOTerceros out = new DTOTerceros();
		out.setAntiEmpresa(o.getCodeu().getAntiEmpresa());
		out.setBarrio(o.getCodeu().getBarrio());
		out.setBarrioTra(o.getCodeu().getBarrioTra());
		out.setCiuDirTrabajo(o.getCodeu().getCiuDirTrabajo());
		out.setCodiCiud(o.getCodeu().getCodiCiud());
		out.setCodiDept(o.getCodeu().getCodiDept());
		out.setDeptDirTrabajo(o.getCodeu().getDeptDirTrabajo());
		out.setDirTeralt(o.getCodeu().getDirTeralt());
		out.setDirTerpal(o.getCodeu().getDirTerpal());
		out.setFaxter(o.getCodeu().getFaxTer());
		out.setIdConyuge(o.getCodeu().getIdConyuge());
		out.setIndContrato(o.getCodeu().getIndContrato());
		out.setLugarDoc(o.getCodeu().getLugarDoc());
		out.setMailTer(o.getCodeu().getMailTer());
		out.setNomTercero(o.getCodeu().getNomTer());
		out.setPaisCodigo(o.getCodeu().getPaisCodigo());
		out.setPaisDirTrabajo(o.getCodeu().getPaisDirTrabajo());
		out.setParamText(o.getCodeu().getParamText());
		out.setParamId("EPS");
		out.setIndSecEconomico("10");
		out.setPriApellido(o.getCodeu().getPriApellido());
		out.setSegApellido(o.getCodeu().getSegApellido());
		out.setTelter(o.getCodeu().getTelTer());
		out.setTipVivienda(o.getCodeu().getTipVivienda());
		out.setDocTip(o.getCodeu().getDoctip());
		out.setNitTer(o.getCodeu().getNitter());
		out.setNomCony(o.getCodeu().getNomCony());
		out.setCelConyuge(o.getCodeu().getCelConyuge());
		out.setEmailConyuge(o.getCodeu().getEmailConyuge());
		out.setFeExp(o.getCodeu().getFeExp());

		return out;
	}

	@Override
	public DTOTerceros mapperEntitieToDao(Terceros o) {

		if (null == o) {
			throw new PageNoFoundException(Constantes.MESSAGE_USER_NO_FOUND);
		}

		DTOTerceros out = new DTOTerceros();
		out.setCodTer(o.getCodTer());
		out.setAntiEmpresa(o.getAntiEmpresa());
		out.setBarrio(Comunes.stringClean(o.getBarrio()));
		out.setBarrioTra(Comunes.stringClean(o.getBarrioTra()));
		out.setCiuDirTrabajo(o.getCiuDirTrabajo());
		out.setCodiCiud(Comunes.stringClean(o.getCodiCiud()));
		out.setCodiDept(o.getCodiDept());
		out.setCodTer(o.getCodTer());
		out.setDeptDirTrabajo(Comunes.stringClean(o.getDeptDirTrabajo()));
		out.setDirTeralt(Comunes.stringClean(o.getDirTeralt()));
		out.setDirTerpal(Comunes.stringClean(o.getDirTerpal()));
		out.setEntBan(o.getEntBan());
		out.setFaxter(o.getFaxter());
		out.setFeExp(o.getFeExp());
		out.setFecExpDoc(o.getFecExpDoc());
		out.setIdConyuge(o.getIdConyuge());
		out.setIndContrato(o.getIndContrato());
		out.setLugarDoc(Comunes.stringClean(o.getLugarDoc()));
		out.setMailTer(Comunes.stringClean(o.getMailTer()));
		out.setNomTercero(Comunes.stringClean(o.getNomTercero()));
		out.setNumCta(o.getNumCta());
		out.setPaisCodigo(o.getPaisCodigo());
		out.setPaisDirTrabajo(o.getPaisDirTrabajo());
		out.setParamText(o.getParamText());
		out.setPriApellido(Comunes.stringClean(o.getPriApellido()));
		out.setSegApellido(Comunes.stringClean(o.getSegApellido()));
		out.setTelter(Comunes.stringClean(o.getTelter()));
		out.setTelter1(Comunes.stringClean(o.getTelter1()));
		out.setTelter2(Comunes.stringClean(o.getTelter2()));
		out.setTipCta(o.getTipCta());
		out.setTipVivienda(o.getTipVivienda());
		out.setDocTip(o.getDocTip());
		if (o.getDocTip().indexOf(".") > 0) {
			out.setDocTip(o.getDocTip().substring(0, o.getDocTip().indexOf(".")));
		}

		out.setNitTer(Comunes.stringClean(o.getNitTer()));
		out.setIndSecEconomico(o.getIndSecEconomico());
		return out;
	}

	@Override
	public List<DTOTerceros> mapperList(List<Terceros> list) {

		List<DTOTerceros> response = new ArrayList<DTOTerceros>();
		list.stream().forEach(o -> {
			response.add(new DTOTerceros(o.getCodTer(), o.getNomTercero(), o.getPriApellido(), o.getSegApellido(),
					o.getLugarDoc(), o.getMailTer(), o.getDirTerpal(), o.getTelter(), o.getTelter1(), o.getTelter2(),
					o.getFeExp(), o.getPaisCodigo(), o.getCodiDept(), o.getCodiCiud(), o.getBarrio(),
					o.getAntiEmpresa(), o.getTipVivienda(), "", "", "", "", "", "", "", "", "", "", "", "", "", ""));

		});

		return response;
	}

}
