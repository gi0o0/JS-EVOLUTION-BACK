package com.jarzsoft.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOPaises;
import com.jarzsoft.mapper.IPaisesMapper;
import com.jarzsoft.repository.PaisesRepository;
import com.jarzsoft.service.IPaisesService;

@Service
public class PaisesService implements IPaisesService {

	private final PaisesRepository paisesRepository;

	private final IPaisesMapper paisesMapper;

	@Autowired
	public PaisesService(PaisesRepository paisesRepository, IPaisesMapper paisesMapper) {
		super();
		this.paisesRepository = paisesRepository;
		this.paisesMapper = paisesMapper;

	}

	@Override
	public List<DTOPaises> getAll() {
		return paisesMapper.mapperList(paisesRepository.findAll());
	}

}
