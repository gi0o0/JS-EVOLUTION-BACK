package com.jarzsoft.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOFoclaaso;
import com.jarzsoft.entities.Foclaaso;
import com.jarzsoft.mapper.IFoclaasoMapper;

@Service
public class FoclaasoMapper implements IFoclaasoMapper {

	@Override
	public List<DTOFoclaaso> mapperList(List<Foclaaso> list) {
		List<DTOFoclaaso> response = new ArrayList<DTOFoclaaso>();
		list.stream().forEach(o -> {
			response.add(new DTOFoclaaso(o.getCodInter().toString(), o.getNomClaaso(),
					null != o.getMonto1() ? o.getMonto1().longValueExact() : 0,
					null != o.getMonto2() ? o.getMonto2().longValueExact() : 0,
					null != o.getMonto3() ? o.getMonto3().longValueExact() : 0,
					null != o.getMonto4() ? o.getMonto4().longValueExact() : 0, o.getIndCodeudorMonto1(),
					o.getIndCodeudorMonto2(), o.getIndCodeudorMonto3(), o.getIndCodeudorMonto4(), o.getUsuUltMod(),
					o.getFecUltMod(), o.getFecCrea(), o.getUsuCrea()));

		});

		return response;
	}

}
