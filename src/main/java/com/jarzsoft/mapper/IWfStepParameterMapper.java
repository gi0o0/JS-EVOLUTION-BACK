package com.jarzsoft.mapper;

import java.util.List;

import com.jarzsoft.dto.DTOStepsState;
import com.jarzsoft.dto.DTOWFParameterStep;
import com.jarzsoft.dto.DTOWalletUser;
import com.jarzsoft.entities.W_Wf_Pasos;

public interface IWfStepParameterMapper {

	public List<DTOWFParameterStep> mapperList(List<W_Wf_Pasos> list);

	public DTOWFParameterStep mapperDaoToDto(W_Wf_Pasos o);

	public W_Wf_Pasos mapperDtoToDao(DTOWFParameterStep o);

	public List<DTOWalletUser> mapperEntitiePortafolioToDto(List<Object[]> o);

	public List<DTOStepsState> mapperEntitieSteptStateToDto(List<Object[]> o);

	public List<DTOWalletUser> mapperEntitiePortafolioToDtoFull(List<Object[]> o);

}
