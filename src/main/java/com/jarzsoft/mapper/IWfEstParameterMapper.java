package com.jarzsoft.mapper;

import java.util.List;

import com.jarzsoft.dto.DTOWFParameterEst;
import com.jarzsoft.entities.W_Wf_Est;

public interface IWfEstParameterMapper {

	public List<DTOWFParameterEst> mapperList(List<W_Wf_Est> list);

	public DTOWFParameterEst mapperDaoToDto(W_Wf_Est o);

	public W_Wf_Est mapperDtoToDao(DTOWFParameterEst o);

}
