package com.jarzsoft.mapper.impl;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOFodataso;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.entities.Fodataso;
import com.jarzsoft.mapper.IFodatasoMapper;
import com.jarzsoft.util.FechaUtils;

@Service
public class FodatasoMapper implements IFodatasoMapper {

	@Override
	public Fodataso mapperDtoToEntitie(DTOFodataso o) {
		Fodataso out = new Fodataso();
		out.setCelConyuge(o.getCelConyuge());
		out.setCodProfe(o.getCodProfe());
		out.setCodTer(o.getCodTer());
		out.setEmailConyuge(o.getEmailConyuge());
		out.setFec_cump(FechaUtils.getFechaActualStringAStringYYYYDDMM(o.getFec_cump()));
		out.setFecIngEmpresa(FechaUtils.getFechaActualStringAStringYYYYDDMM(o.getFecIngEmpresa()));
		out.setIndContrato(o.getIndContrato());
		out.setNomCony(o.getNomCony());
		out.setClaAsoci(o.getClaAsoci());
		out.setCodEmple(o.getCodEmple());
		out.setCargoDeuWf(o.getCargoDeuWf());
		out.setCargoCodWf(o.getCargoCodWf());
		out.setSexo(o.getSexo());
		return out;
	}

	@Override
	public DTOFodataso mapperEntitieToDao(Fodataso o) {
		DTOFodataso out = new DTOFodataso();
		if (o != null) {
			out.setCelConyuge(o.getCelConyuge());
			out.setCodProfe(o.getCodProfe());
			out.setCodTer(o.getCodTer());
			out.setEmailConyuge(o.getEmailConyuge());
			out.setFec_cump(o.getFec_cump());
			out.setFecIngEmpresa(o.getFecIngEmpresa());
			out.setIndContrato(o.getIndContrato());
			out.setNomCony(o.getNomCony());
			out.setClaAsoci(o.getClaAsoci());
			out.setCargoDeuWf(o.getCargoDeuWf());
			out.setCargoCodWf(o.getCargoCodWf());
			out.setSexo(o.getSexo());
		}
		return out;
	}

	@Override
	public DTOFodataso mapperDaoToDto(DTOWF o, String codTer) {
		DTOFodataso out = new DTOFodataso();
		out.setCelConyuge(o.getCelConyuge());
	//	out.setCodProfe(o.getCodProfe());
		out.setCodTer(codTer);
		out.setEmailConyuge(o.getEmailConyuge());
		out.setFec_cump(FechaUtils.getFechaActualStringAStringYYYYDDMM(o.getFecCump()));
		out.setFecIngEmpresa(FechaUtils.getFechaActualStringAStringYYYYDDMM(o.getFecIngEmpresa()));
		out.setIndContrato(o.getIndContrato());
		out.setNomCony(o.getNomCony());
		out.setClaAsoci(o.getEntitie());
		out.setCodEmple(o.getNitter());
		out.setCargoDeuWf(o.getCargoWf());	
		out.setSexo(o.getSexo());
		return out;
	}

	@Override
	public DTOFodataso mapperDaoToDtoCodeo(DTOWF o, String codTer) {
		DTOFodataso out = new DTOFodataso();
		out.setCelConyuge(o.getCodeu().getCelConyuge());
	//	out.setCodProfe(o.getCodeu().getCodProfe());
		out.setCodTer(codTer);
		out.setEmailConyuge(o.getCodeu().getEmailConyuge());
		out.setFec_cump(FechaUtils.getFechaActualStringAStringYYYYDDMM(o.getCodeu().getFeExp()));
		out.setIndContrato(o.getCodeu().getIndContrato());
		out.setNomCony(o.getCodeu().getNomCony());
		out.setCodEmple(o.getCodeu().getNitter());
		out.setCargoCodWf(o.getCodeu().getCargoWf());
		out.setSexo(o.getSexo());
		return out;
	}

}
