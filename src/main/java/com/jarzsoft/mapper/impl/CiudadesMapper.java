package com.jarzsoft.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOCiudades;
import com.jarzsoft.entities.Ciudades;
import com.jarzsoft.mapper.ICiudadesMapper;

@Service
public class CiudadesMapper implements ICiudadesMapper {

	@Override
	public List<DTOCiudades> mapperList(List<Ciudades> list) {
		List<DTOCiudades> response = new ArrayList<DTOCiudades>();
		list.stream().forEach(o -> {
			response.add(new DTOCiudades(o.getCodiCiud() + "", null != o.getNombCiud() ? o.getNombCiud().trim() : ""));

		});

		return response;
	}

}
