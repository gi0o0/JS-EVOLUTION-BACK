package com.jarzsoft.mapper;

import java.util.List;

import com.jarzsoft.dto.DTOFotabpro;
import com.jarzsoft.entities.Fotabpro;

public interface IFotabproMapper {

	public List<DTOFotabpro> mapperList(List<Fotabpro> list);

}