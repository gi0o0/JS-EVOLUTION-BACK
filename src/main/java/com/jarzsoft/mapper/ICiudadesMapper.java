package com.jarzsoft.mapper;

import java.util.List;

import com.jarzsoft.dto.DTOCiudades;
import com.jarzsoft.entities.Ciudades;

public interface ICiudadesMapper {

	public List<DTOCiudades> mapperList(List<Ciudades> list);

}