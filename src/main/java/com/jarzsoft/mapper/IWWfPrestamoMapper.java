package com.jarzsoft.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOWFPqr;
import com.jarzsoft.dto.DTOWFPrestamos;
import com.jarzsoft.entities.W_Wf_Prestamo;

@Service
public interface IWWfPrestamoMapper {

	public W_Wf_Prestamo mapperDtoToEntitie(DTOWFPrestamos o);

	public DTOWFPrestamos mapperEntitieToDao(W_Wf_Prestamo o);

	public DTOWFPrestamos mapperEntitieWfToDao(DTOWFPqr o, String numCredito);
	
	public List<DTOWFPrestamos> mapperListEntitieToListDao(List<Object[]> o);

}
