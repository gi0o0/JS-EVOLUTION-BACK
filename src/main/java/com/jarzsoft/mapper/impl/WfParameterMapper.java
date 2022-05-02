package com.jarzsoft.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOWFParameter;
import com.jarzsoft.entities.W_Wf;
import com.jarzsoft.mapper.IWfParameterMapper;

@Service
public class WfParameterMapper implements IWfParameterMapper {

	@Override
	public List<DTOWFParameter> mapperList(List<W_Wf> list) {
		List<DTOWFParameter> response = new ArrayList<DTOWFParameter>();
		list.stream().forEach(o -> {
			response.add(new DTOWFParameter(o.getIdWf() + "", o.getNomWf(), o.getTipWf(), o.getUsuUltMod(),
					o.getFecUltMod(), o.getFecCrea(), o.getUsuCrea()));
		});

		return response;
	}

	@Override
	public DTOWFParameter mapperDaoToDto(W_Wf o) {
		return new DTOWFParameter(o.getIdWf() + "", o.getNomWf(), o.getTipWf(), o.getUsuUltMod(), o.getFecUltMod(),
				o.getFecCrea(), o.getUsuCrea());
	}

	@Override
	public W_Wf mapperDtoToDao(DTOWFParameter o) {

		return new W_Wf(Long.parseLong(o.getId()), o.getName(), o.getType(), o.getUsuUltMod(), o.getFecUltMod(),
				o.getFecCrea(), o.getUsuCrea());
	}

}
