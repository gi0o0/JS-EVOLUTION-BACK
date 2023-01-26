package com.jarzsoft.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOCiudad;
import com.jarzsoft.entities.Ciudades;
import com.jarzsoft.mapper.ICiudadesMapper;

@Service
public class CiudadesMapper implements ICiudadesMapper {

	@Override
	public List<DTOCiudad> mapperList(List<Ciudades> list) {
		List<DTOCiudad> response = new ArrayList<DTOCiudad>();
		list.stream().forEach(o -> {
			response.add(new DTOCiudad(o.getCodiCiud() + "", null != o.getNombCiud() ? o.getNombCiud().trim() : ""));

		});

		return response;
	}

	@Override
	public DTOCiudad mapperEntitieToDto(Ciudades o) {
	
		return new DTOCiudad(o.getCodiCiud() + "", null != o.getNombCiud() ? o.getNombCiud().trim() : "");
	}

}
