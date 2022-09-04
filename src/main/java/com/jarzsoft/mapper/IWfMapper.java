package com.jarzsoft.mapper;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOTerceros;
import com.jarzsoft.dto.DTOWF;

@Service
public interface IWfMapper {

	public DTOWF mapperDaoToDto(DTOSolCredito o, DTOTerceros u, DTOTerceros cod);

}
