package com.jarzsoft.mapper;

import java.util.List;

import com.jarzsoft.dto.DTOFoclaaso;
import com.jarzsoft.entities.Foclaaso;

public interface IFoclaasoMapper {

	public List<DTOFoclaaso> mapperList(List<Foclaaso> list);

}