package com.jarzsoft.mapper;

import java.util.List;

import com.jarzsoft.dto.DTOWFParameter;
import com.jarzsoft.entities.W_Wf;

public interface IWfParameterMapper {

	public List<DTOWFParameter> mapperList(List<W_Wf> list);

	public DTOWFParameter mapperDaoToDto(W_Wf o);

	public W_Wf mapperDtoToDao(DTOWFParameter o);

}
