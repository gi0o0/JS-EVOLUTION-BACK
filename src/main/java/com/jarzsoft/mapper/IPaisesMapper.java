package com.jarzsoft.mapper;

import java.util.List;

import com.jarzsoft.dto.DTOPaises;
import com.jarzsoft.entities.Paises;

public interface IPaisesMapper {

	public List<DTOPaises> mapperList(List<Paises> list);

}