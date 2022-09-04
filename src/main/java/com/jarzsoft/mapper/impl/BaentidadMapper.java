package com.jarzsoft.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOBaentidad;
import com.jarzsoft.entities.Baentida;
import com.jarzsoft.mapper.IBaentidadMapper;

@Service
public class BaentidadMapper implements IBaentidadMapper {

	@Override
	public List<DTOBaentidad> mapperList(List<Baentida> list) {
		List<DTOBaentidad> response = new ArrayList<DTOBaentidad>();
		list.stream().forEach(o -> {
			response.add(new DTOBaentidad(o.getCodEnt(), null != o.getNoment() ? o.getNoment().trim() : ""));
		});

		return response;
	}

}
