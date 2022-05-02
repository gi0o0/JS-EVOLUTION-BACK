package com.jarzsoft.mapper;

import java.util.List;

import com.jarzsoft.dto.DTOWFParameterStepDoc;
import com.jarzsoft.entities.W_Wf_Pas_Doc;

public interface IWfStepDocParameterMapper {

	public List<DTOWFParameterStepDoc> mapperList(List<W_Wf_Pas_Doc> list);

	public DTOWFParameterStepDoc mapperDaoToDto(W_Wf_Pas_Doc o);

	public W_Wf_Pas_Doc mapperDtoToDao(DTOWFParameterStepDoc o);

}
