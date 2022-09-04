package com.jarzsoft.mapper;

import java.util.List;

import com.jarzsoft.dto.DTOCladoc;
import com.jarzsoft.entities.Cladoc;

public interface ICladocMapper {

	public List<DTOCladoc> mapperList(List<Cladoc> list);

}