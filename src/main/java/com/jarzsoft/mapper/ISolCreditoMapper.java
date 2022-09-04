package com.jarzsoft.mapper;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.entities.SolCredito;

@Service
public interface ISolCreditoMapper {

	public SolCredito mapperDtoToEntitie(DTOSolCredito o);

	public DTOSolCredito mapperEntitieToDao(SolCredito o);

	public DTOSolCredito mapperDaoToDto(DTOWF o, String codTer, String codeudor,String user,String state);

}
