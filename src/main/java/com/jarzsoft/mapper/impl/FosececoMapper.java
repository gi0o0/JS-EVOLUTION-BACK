package com.jarzsoft.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOFosececo;
import com.jarzsoft.entities.Fosececo;
import com.jarzsoft.mapper.IFosececoMapper;

@Service
public class FosececoMapper implements IFosececoMapper {

	@Override
	public List<DTOFosececo> mapperList(List<Fosececo> list) {
		List<DTOFosececo> response = new ArrayList<DTOFosececo>();
		list.stream().forEach(o -> {
			response.add(new DTOFosececo(o.getcodSec(), o.getnomSec(), o.getUsuUltMod(), o.getFecUltMod(),
					o.getFecCrea(), o.getUsuCrea()));

		});

		return response;
	}

	@Override
	public DTOFosececo mapperDaoToDto(Fosececo o) {
		return new DTOFosececo(o.getcodSec(), o.getnomSec(), o.getUsuUltMod(), o.getFecUltMod(), o.getFecCrea(),
				o.getUsuCrea());
	}

	@Override
	public Fosececo mapperDtoToDao(DTOFosececo o) {

		return new Fosececo(o.getCodSec(), o.getNomSec(), o.getUsuUltMod(), o.getFecUltMod(), o.getFecCrea(),
				o.getUsuCrea());
	}
	
	@Override
	public Fosececo mapperDtoToDao(String o) {

		return new Fosececo(o, "");
	}

}
