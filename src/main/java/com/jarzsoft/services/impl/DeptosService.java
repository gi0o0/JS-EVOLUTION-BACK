package com.jarzsoft.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTODeptos;
import com.jarzsoft.mapper.IDeptosMapper;
import com.jarzsoft.repository.DeptosRepository;
import com.jarzsoft.service.IDeptosService;

@Service
public class DeptosService implements IDeptosService {

	private final DeptosRepository deptosRepository;

	private final IDeptosMapper deptosMapper;

	@Autowired
	public DeptosService(DeptosRepository deptosRepository, IDeptosMapper deptosMapper) {
		super();
		this.deptosRepository = deptosRepository;
		this.deptosMapper = deptosMapper;

	}

	@Override
	public List<DTODeptos> getAll(Integer id) {
		return deptosMapper.mapperList(deptosRepository.findAll(id));
	}

}
