package com.jarzsoft.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOPaises;
import com.jarzsoft.entities.Paises;
import com.jarzsoft.mapper.IPaisesMapper;

@Service
public class PaisesMapper implements IPaisesMapper {

	@Override
	public List<DTOPaises> mapperList(List<Paises> list) {
		List<DTOPaises> response = new ArrayList<DTOPaises>();
		list.stream().forEach(o -> {
			response.add(new DTOPaises(o.getCodTip() + "", null != o.getPaisNombre() ? o.getPaisNombre().trim() : ""));

		});

		return response;
	}

}
