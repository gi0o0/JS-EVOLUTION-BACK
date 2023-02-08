package com.jarzsoft.mapper;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOTerceros;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.entities.Terceros;

@Service
public interface ITercerosMapper {

	public Terceros mapperDtoToEntitie(DTOTerceros o);

	public DTOTerceros mapperEntitieToDao(Terceros o);

	public DTOTerceros mapperDaoToDtoUser(DTOWF o);

	public DTOTerceros mapperDaoToDtoCodeo(DTOWF o);

	public List<DTOTerceros> mapperList(List<Terceros> list);

}
