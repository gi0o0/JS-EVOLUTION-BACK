package com.jarzsoft.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOCladoc;
import com.jarzsoft.entities.Cladoc;
import com.jarzsoft.mapper.ICladocMapper;

@Service
public class CladocMapper implements ICladocMapper {

	@Override
	public List<DTOCladoc> mapperList(List<Cladoc> list) {
		List<DTOCladoc> response = new ArrayList<DTOCladoc>();
		list.stream().forEach(o -> {
			response.add(new DTOCladoc(o.getCodTip(), o.getNomTip()));

		});

		return response;
	}

}
