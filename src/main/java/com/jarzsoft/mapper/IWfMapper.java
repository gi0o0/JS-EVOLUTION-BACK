package com.jarzsoft.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOFodataso;
import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOTerceros;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.dto.DTOWFPqr;
import com.jarzsoft.dto.DTOWFPrestamos;
import com.jarzsoft.dto.DTOWWfMov;

@Service
public interface IWfMapper {

	DTOWF mapperDaoToDto(DTOSolCredito o, DTOTerceros u, DTOTerceros cod, DTOWWfMov mov, DTOFodataso foda,
			DTOFodataso fodaCodeo, Integer stepNow);

	DTOWFPqr mapperDaoToDto(DTOWWfMov mov);
	
	DTOWFPqr mapperDaoToDto(Object[] in);

	DTOWFPqr mapperDaoTerceroToDto(DTOTerceros o , DTOWFPqr out);
	
	DTOWFPqr mapperDaoPrestamoToDto(List<DTOWFPrestamos> prestamos,  DTOWFPqr out);

}
