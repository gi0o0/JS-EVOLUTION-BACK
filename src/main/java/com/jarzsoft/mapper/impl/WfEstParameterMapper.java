package com.jarzsoft.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOWFParameterEst;
import com.jarzsoft.entities.W_Wf_Est;
import com.jarzsoft.entities.W_Wf_EstPK;
import com.jarzsoft.mapper.IWfEstParameterMapper;

@Service
public class WfEstParameterMapper implements IWfEstParameterMapper {

	@Override
	public List<DTOWFParameterEst> mapperList(List<W_Wf_Est> list) {
		List<DTOWFParameterEst> response = new ArrayList<DTOWFParameterEst>();
		list.stream().forEach(o -> {
			response.add(new DTOWFParameterEst(o.getW_Wf_EstPK().getIdWf(), o.getW_Wf_EstPK().getIdEstado(),
					o.getNomEstado(),Boolean.parseBoolean(o.getIndInicio()), Boolean.parseBoolean(o.getIndFinal()), o.getOrdEstado(), o.getUsuUltMod(),
					o.getFecUltMod(), o.getFecCrea(), o.getUsuCrea()));
		});

		return response;
	}

	@Override
	public DTOWFParameterEst mapperDaoToDto(W_Wf_Est o) {
		return new DTOWFParameterEst(o.getW_Wf_EstPK().getIdWf(), o.getW_Wf_EstPK().getIdEstado(), o.getNomEstado(),
				Boolean.parseBoolean(o.getIndInicio()), Boolean.parseBoolean(o.getIndFinal()), o.getOrdEstado(), o.getUsuUltMod(), o.getFecUltMod(), o.getFecCrea(),
				o.getUsuCrea());
	}

	@Override
	public W_Wf_Est mapperDtoToDao(DTOWFParameterEst o) {

		return new W_Wf_Est(new W_Wf_EstPK(o.getIdWf(), o.getIdEstado()), o.getNomEstado(), o.isIndInicio()+"",
				o.isIndFinal()+"", o.getOrdEstado(), o.getUsuUltMod(), o.getFecUltMod(), o.getFecCrea(), o.getUsuCrea());
	}

}
