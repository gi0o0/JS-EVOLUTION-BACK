package com.jarzsoft.mapper.impl;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOFodataso;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.entities.Fodataso;
import com.jarzsoft.mapper.IFodatasoMapper;

@Service
public class FodatasoMapper implements IFodatasoMapper {

	@Override
	public Fodataso mapperDtoToEntitie(DTOFodataso o) {
		Fodataso out = new Fodataso();
		out.setCelConyuge(o.getCelConyuge());
		out.setCodProfe(o.getCodProfe());
		out.setCodTer(o.getCodTer());
		out.setEmailConyuge(o.getEmailConyuge());
		out.setFec_cump(o.getFec_cump());
		out.setFecIngEmpresa(o.getFecIngEmpresa());
		out.setIndContrato(o.getIndContrato());
		out.setNomCony(o.getNomCony());
		return out;
	}

	@Override
	public DTOFodataso mapperEntitieToDao(Fodataso o) {
		DTOFodataso out = new DTOFodataso();
		out.setCelConyuge(o.getCelConyuge());
		out.setCodProfe(o.getCodProfe());
		out.setCodTer(o.getCodTer());
		out.setEmailConyuge(o.getEmailConyuge());
		out.setFec_cump(o.getFec_cump());
		out.setFecIngEmpresa(o.getFecIngEmpresa());
		out.setIndContrato(o.getIndContrato());
		out.setNomCony(o.getNomCony());
		return out;
	}

	@Override
	public DTOFodataso mapperDaoToDto(DTOWF o, String codTer) {
		DTOFodataso out = new DTOFodataso();
		out.setCelConyuge(o.getCelConyuge());
		out.setCodProfe(o.getCodProfe());
		out.setCodTer(codTer);
		out.setEmailConyuge(o.getEmailConyuge());
		out.setFec_cump(o.getFecCump());
		out.setFecIngEmpresa(o.getFecIngEmpresa());
		out.setIndContrato(o.getIndContrato());
		out.setNomCony(o.getNomCony());
		return out;
	}

}
