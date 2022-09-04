package com.jarzsoft.mapper;

import java.util.List;

import com.jarzsoft.dto.DTOFotipcre;
import com.jarzsoft.entities.Fotipcre;

public interface IFotipcreMapper {

	public List<DTOFotipcre> mapperList(List<Fotipcre> list);

}