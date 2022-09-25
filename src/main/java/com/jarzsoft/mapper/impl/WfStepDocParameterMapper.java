package com.jarzsoft.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOWFParameterStepDoc;
import com.jarzsoft.entities.W_Wf_Pas_Doc;
import com.jarzsoft.entities.W_Wf_Pas_DocPK;
import com.jarzsoft.mapper.IWfStepDocParameterMapper;

@Service
public class WfStepDocParameterMapper implements IWfStepDocParameterMapper {

	@Override
	public List<DTOWFParameterStepDoc> mapperList(List<W_Wf_Pas_Doc> list) {
		List<DTOWFParameterStepDoc> response = new ArrayList<DTOWFParameterStepDoc>();
		list.stream().forEach(o -> {
			response.add(new DTOWFParameterStepDoc(o.getW_Wf_Pas_DocPK().getIdWf(), o.getW_Wf_Pas_DocPK().getIdPaso(),
					o.getW_Wf_Pas_DocPK().getIdDocumento(), o.getNomDocumento(), o.getEnvRec(), o.getUsuUltMod(),
					o.getFecUltMod(), o.getFecCrea(), o.getUsuCrea(),o.getIndObligatorio()));
		});

		return response;
	}

	@Override
	public DTOWFParameterStepDoc mapperDaoToDto(W_Wf_Pas_Doc o) {
		return new DTOWFParameterStepDoc(o.getW_Wf_Pas_DocPK().getIdWf(), o.getW_Wf_Pas_DocPK().getIdPaso(),
				o.getW_Wf_Pas_DocPK().getIdDocumento(), o.getNomDocumento(), o.getEnvRec(), o.getUsuUltMod(),
				o.getFecUltMod(), o.getFecCrea(), o.getUsuCrea(),o.getIndObligatorio());
	}

	@Override
	public W_Wf_Pas_Doc mapperDtoToDao(DTOWFParameterStepDoc o) {

		return new W_Wf_Pas_Doc(new W_Wf_Pas_DocPK(o.getIdWf(), o.getIdPaso(), o.getIdDocumento()), o.getNomDocumento(),
				o.getEnvRec(), o.getUsuUltMod(), o.getFecUltMod(), o.getFecCrea(), o.getUsuCrea());
	}

}
