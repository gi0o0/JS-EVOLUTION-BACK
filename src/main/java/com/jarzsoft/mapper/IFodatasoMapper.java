package com.jarzsoft.mapper;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOFodataso;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.entities.Fodataso;

@Service
public interface IFodatasoMapper {

	public Fodataso mapperDtoToEntitie(DTOFodataso o);

	public DTOFodataso mapperEntitieToDao(Fodataso o);

	public DTOFodataso mapperDaoToDto(DTOWF o, String codTer);
	
	public DTOFodataso mapperDaoToDtoCodeo(DTOWF o, String codTer);

}
