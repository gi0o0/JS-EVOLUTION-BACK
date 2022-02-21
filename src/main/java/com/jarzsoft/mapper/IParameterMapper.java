package com.jarzsoft.mapper;

import java.util.List;

import com.jarzsoft.dto.DTOParameter;
import com.jarzsoft.entities.Parametro;

public interface IParameterMapper {

	public List<DTOParameter> mapperList(List<Parametro> list);

	public DTOParameter mapperDaoToDto(Parametro o);

	public Parametro mapperDtoToDao(DTOParameter o);

}
