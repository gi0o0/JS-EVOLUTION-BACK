package com.jarzsoft.mapper;

import java.util.List;

import com.jarzsoft.dto.DTOCiudad;
import com.jarzsoft.entities.Ciudades;

public interface ICiudadesMapper {

	public List<DTOCiudad> mapperList(List<Ciudades> list);

	public DTOCiudad mapperEntitieToDto(Ciudades o);

}