package com.jarzsoft.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOParameter;
import com.jarzsoft.entities.Parametro;
import com.jarzsoft.entities.ParametroKey;
import com.jarzsoft.mapper.IParameterMapper;

@Service
public class ParameterMapper implements IParameterMapper {

	@Override
	public List<DTOParameter> mapperList(List<Parametro> list) {
		List<DTOParameter> response = new ArrayList<DTOParameter>();
		list.stream().forEach(o -> {
			response.add(new DTOParameter(o.getParametroKey().getParam_id() , o.getParametroKey().getParam_text(), o.getValue()));
		});

		return response;
	}

	@Override
	public DTOParameter mapperDaoToDto(Parametro o) {
		return new DTOParameter(o.getParametroKey().getParam_id(), o.getParametroKey().getParam_text(), o.getValue());
	}

	@Override
	public Parametro mapperDtoToDao(DTOParameter o) {

		return new Parametro(new ParametroKey(o.getId(), o.getText()), o.getValue());
	}

}
