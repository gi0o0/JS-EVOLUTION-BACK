package com.jarzsoft.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOFotabpro;
import com.jarzsoft.entities.Fotabpro;
import com.jarzsoft.mapper.IFotabproMapper;

@Service
public class FotabproMapper implements IFotabproMapper {

	@Override
	public List<DTOFotabpro> mapperList(List<Fotabpro> list) {
		List<DTOFotabpro> response = new ArrayList<DTOFotabpro>();
		list.stream().forEach(o -> {
			response.add(
					new DTOFotabpro(o.getCodInter().toString(), null != o.getNomProfe() ? o.getNomProfe().trim() : ""));

		});

		return response;
	}

}
