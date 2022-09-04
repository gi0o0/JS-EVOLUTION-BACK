package com.jarzsoft.mapper;

import java.util.List;

import com.jarzsoft.dto.DTODeptos;
import com.jarzsoft.entities.Deptos;

public interface IDeptosMapper {

	public List<DTODeptos> mapperList(List<Deptos> list);

}