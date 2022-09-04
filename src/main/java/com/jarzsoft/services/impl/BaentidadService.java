package com.jarzsoft.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOBaentidad;
import com.jarzsoft.mapper.IBaentidadMapper;
import com.jarzsoft.repository.BaentidadRepository;
import com.jarzsoft.service.IBaEntidadService;

@Service
public class BaentidadService implements IBaEntidadService {

	private final BaentidadRepository baentidadRepository;

	private final IBaentidadMapper baentidadMapper;

	@Autowired
	public BaentidadService(BaentidadRepository baentidadRepository, IBaentidadMapper baentidadMapper) {
		super();
		this.baentidadRepository = baentidadRepository;
		this.baentidadMapper = baentidadMapper;

	}

	@Override
	public List<DTOBaentidad> getAll() {
		return baentidadMapper.mapperList(baentidadRepository.findAll());
	}

}
