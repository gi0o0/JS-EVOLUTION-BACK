package com.jarzsoft.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOWFParameterStepAut;
import com.jarzsoft.entities.W_Wf_Pas_Aut;
import com.jarzsoft.entities.W_Wf_Pas_AutPK;
import com.jarzsoft.mapper.IWfStepAutParameterMapper;

@Service
public class WfStepAutParameterMapper implements IWfStepAutParameterMapper {

	@Override
	public List<DTOWFParameterStepAut> mapperList(List<W_Wf_Pas_Aut> list) {
		List<DTOWFParameterStepAut> response = new ArrayList<DTOWFParameterStepAut>();
		list.stream().forEach(o -> {
			response.add(new DTOWFParameterStepAut(o.getW_Wf_Pas_AutPK().getIdWf(), o.getW_Wf_Pas_AutPK().getIdPaso(),
					o.getW_Wf_Pas_AutPK().getUsuario(),"", o.getUsuUltMod(), o.getFecUltMod(), o.getFecCrea(),
					o.getUsuCrea(),false));
		});

		return response;
	}

	@Override
	public DTOWFParameterStepAut mapperDaoToDto(W_Wf_Pas_Aut o) {
		return new DTOWFParameterStepAut(o.getW_Wf_Pas_AutPK().getIdWf(), o.getW_Wf_Pas_AutPK().getIdPaso(),
				o.getW_Wf_Pas_AutPK().getUsuario(),"", o.getUsuUltMod(), o.getFecUltMod(), o.getFecCrea(), o.getUsuCrea(),false);
	}

	@Override
	public W_Wf_Pas_Aut mapperDtoToDao(DTOWFParameterStepAut o) {

		return new W_Wf_Pas_Aut(new W_Wf_Pas_AutPK(o.getIdWf(), o.getIdPaso(), o.getUsuario()), o.getUsuUltMod(),
				o.getFecUltMod(), o.getFecCrea(), o.getUsuCrea());
	}

}
