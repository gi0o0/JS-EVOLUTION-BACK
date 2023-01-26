package com.jarzsoft.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOCiudad;
import com.jarzsoft.mapper.ICiudadesMapper;
import com.jarzsoft.repository.CiudadesRepository;
import com.jarzsoft.service.ICiudadesService;

@Service
public class CiudadesService implements ICiudadesService {

	private final CiudadesRepository ciudadesRepository;

	private final ICiudadesMapper ciudadesMapper;

	@Autowired
	public CiudadesService(CiudadesRepository ciudadesRepository, ICiudadesMapper ciudadesMapper) {
		super();
		this.ciudadesRepository = ciudadesRepository;
		this.ciudadesMapper = ciudadesMapper;

	}

	@Override
	public List<DTOCiudad> getAll(Integer idPais, Integer idDeptos) {
		return ciudadesMapper.mapperList(ciudadesRepository.findAll(idPais, idDeptos));
	}

	@Override
	public DTOCiudad getCiudad(Integer idCiudad) {
		return ciudadesMapper.mapperEntitieToDto(ciudadesRepository.findById(idCiudad).get());
	}

}
