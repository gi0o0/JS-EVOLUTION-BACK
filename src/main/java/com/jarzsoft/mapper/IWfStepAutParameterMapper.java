package com.jarzsoft.mapper;

import java.util.List;

import com.jarzsoft.dto.DTOWFParameterStepAut;
import com.jarzsoft.entities.W_Wf_Pas_Aut;

public interface IWfStepAutParameterMapper {

	public List<DTOWFParameterStepAut> mapperList(List<W_Wf_Pas_Aut> list);

	public DTOWFParameterStepAut mapperDaoToDto(W_Wf_Pas_Aut o);

	public W_Wf_Pas_Aut mapperDtoToDao(DTOWFParameterStepAut o);

}
