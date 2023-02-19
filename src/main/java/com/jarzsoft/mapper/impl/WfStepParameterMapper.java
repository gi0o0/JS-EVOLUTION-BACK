package com.jarzsoft.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOWFParameterStep;
import com.jarzsoft.dto.DTOWalletUser;
import com.jarzsoft.entities.W_Wf_Pasos;
import com.jarzsoft.entities.W_Wf_PasosPK;
import com.jarzsoft.mapper.IWfStepParameterMapper;

@Service
public class WfStepParameterMapper implements IWfStepParameterMapper {

	@Override
	public List<DTOWFParameterStep> mapperList(List<W_Wf_Pasos> list) {
		List<DTOWFParameterStep> response = new ArrayList<DTOWFParameterStep>();
		list.stream().forEach(o -> {
			response.add(new DTOWFParameterStep(o.getW_Wf_PasosPK().getIdWf(), o.getW_Wf_PasosPK().getIdPaso(),
					o.getNomPaso(), o.getEmail1(), o.getEmail2(), o.getEmail3(), o.getSolAutoriza(),
					o.getSolDocumentos(), o.getOrdPaso(), o.getEnvCorreoPaso(), o.getEnvCorreoAutoriza(),
					o.getAsuntoCorreo(), o.getTextoCorreo(), o.getTiempoAlerta1(), o.getTiempoAlerta2(),
					o.getTiempoAlerta3(), o.getUsuUltMod(), o.getFecUltMod(), o.getFecCrea(), o.getUsuCrea()));
		});

		return response;
	}

	@Override
	public DTOWFParameterStep mapperDaoToDto(W_Wf_Pasos o) {
		return new DTOWFParameterStep(o.getW_Wf_PasosPK().getIdWf(), o.getW_Wf_PasosPK().getIdPaso(), o.getNomPaso(),
				o.getEmail1(), o.getEmail2(), o.getEmail3(), o.getSolAutoriza(), o.getSolDocumentos(), o.getOrdPaso(),
				o.getEnvCorreoPaso(), o.getEnvCorreoAutoriza(), o.getAsuntoCorreo(), o.getTextoCorreo(),
				o.getTiempoAlerta1(), o.getTiempoAlerta2(), o.getTiempoAlerta3(), o.getUsuUltMod(), o.getFecUltMod(),
				o.getFecCrea(), o.getUsuCrea());
	}

	@Override
	public W_Wf_Pasos mapperDtoToDao(DTOWFParameterStep o) {

		return new W_Wf_Pasos(new W_Wf_PasosPK(o.getIdWf(), o.getIdPaso()), o.getNomPaso(), o.getEmail1(),
				o.getEmail2(), o.getEmail3(), o.getSolAutoriza(), o.getSolDocumentos(), o.getOrdPaso(),
				o.getEnvCorreoPaso(), o.getEnvCorreoAutoriza(), o.getAsuntoCorreo(), o.getTextoCorreo(),
				o.getTiempoAlerta1(), o.getTiempoAlerta2(), o.getTiempoAlerta3(), o.getUsuUltMod(), o.getFecUltMod(),
				o.getFecCrea(), o.getUsuCrea());
	}

	@Override
	public List<DTOWalletUser> mapperEntitiePortafolioToDto(List<Object[]> o) {
	
		List<DTOWalletUser> response = new ArrayList<DTOWalletUser>();
		
		o.stream().forEach(obj -> {
			response.add(new DTOWalletUser(String.valueOf(obj[3]),String.valueOf(obj[40]),String.valueOf(obj[127]),String.valueOf(obj[128]),String.valueOf(obj[110]),String.valueOf(obj[118]),String.valueOf(obj[121]),String.valueOf(obj[119]),String.valueOf(obj[120]),String.valueOf(obj[16])));
		});
		
		return response;
	}

}
