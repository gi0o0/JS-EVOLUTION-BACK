package com.jarzsoft.mapper;

import java.util.List;

import com.jarzsoft.dto.DTOFosececo;
import com.jarzsoft.entities.Fosececo;

public interface IFosececoMapper {

	public List<DTOFosececo> mapperList(List<Fosececo> list);

	public DTOFosececo mapperDaoToDto(Fosececo o);

	public Fosececo mapperDtoToDao(DTOFosececo o);
	
	public Fosececo mapperDtoToDao(String o);

}
