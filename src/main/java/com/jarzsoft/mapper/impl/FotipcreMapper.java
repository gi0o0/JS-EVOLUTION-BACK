package com.jarzsoft.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOFotipcre;
import com.jarzsoft.entities.Fotipcre;
import com.jarzsoft.mapper.IFotipcreMapper;

@Service
public class FotipcreMapper implements IFotipcreMapper {

	@Override
	public List<DTOFotipcre> mapperList(List<Fotipcre> list) {
		List<DTOFotipcre> response = new ArrayList<DTOFotipcre>();
		list.stream().forEach(o -> {
			response.add(new DTOFotipcre(o.getCodigoCredito(), o.getNomEvolution()));

			
		});

		return response;
	}

}
