package com.jarzsoft.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.entities.SolCredito;

@Service
public interface ISolCreditoMapper {

	SolCredito mapperDtoToEntitie(DTOSolCredito o);

	DTOSolCredito mapperEntitieToDao(SolCredito o);

	DTOSolCredito mapperDaoToDto(DTOWF o, String codTer, String codeudor, String user, String state, String solPagare);

	DTOSolCredito mapperDaoToDtoFinancial(DTOWF o, DTOSolCredito credito);

	List<DTOSolCredito> mapperEntitiesToDaos(List<Object[]> o);

}
