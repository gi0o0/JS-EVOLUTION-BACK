package com.jarzsoft.mapper;

import java.util.List;

import com.jarzsoft.dto.DTOWFParameterStep;
import com.jarzsoft.entities.W_Wf_Pasos;

public interface IWfStepParameterMapper {

	public List<DTOWFParameterStep> mapperList(List<W_Wf_Pasos> list);

	public DTOWFParameterStep mapperDaoToDto(W_Wf_Pasos o);

	public W_Wf_Pasos mapperDtoToDao(DTOWFParameterStep o);

}
