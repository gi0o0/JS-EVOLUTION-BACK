package com.jarzsoft.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTODeptos;
import com.jarzsoft.entities.Deptos;
import com.jarzsoft.mapper.IDeptosMapper;

@Service
public class DeptosMapper implements IDeptosMapper {

	@Override
	public List<DTODeptos> mapperList(List<Deptos> list) {
		List<DTODeptos> response = new ArrayList<DTODeptos>();
		list.stream().forEach(o -> {
			response.add(new DTODeptos(o.getCodiDept() + "", null != o.getNombDept() ? o.getNombDept().trim() : ""));

		});

		return response;
	}

}
