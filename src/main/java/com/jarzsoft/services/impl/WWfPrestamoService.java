package com.jarzsoft.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOWFPrestamos;
import com.jarzsoft.entities.W_Wf_Prestamo;
import com.jarzsoft.mapper.IWWfPrestamoMapper;
import com.jarzsoft.repository.W_Wf_PrestamosRepository;
import com.jarzsoft.service.IWFPrestamoService;

@Service
public class WWfPrestamoService implements IWFPrestamoService {

	private final W_Wf_PrestamosRepository prestamosRepository;

	private final IWWfPrestamoMapper mapper;

	@Autowired
	public WWfPrestamoService(W_Wf_PrestamosRepository prestamosRepository, IWWfPrestamoMapper mapper) {
		super();
		this.prestamosRepository = prestamosRepository;
		this.mapper = mapper;

	}

	@Override
	public DTOWFPrestamos create(DTOWFPrestamos o) {

		W_Wf_Prestamo oldMov = prestamosRepository.save(mapper.mapperDtoToEntitie(o));
		return mapper.mapperEntitieToDao(oldMov);
	}

	@Override
	public List<DTOWFPrestamos> getByWfAndNumRad(Integer id, Integer num_rad) {
		return mapper.mapperListEntitieToListDao(prestamosRepository.findByWfByNumRad(id, num_rad));
	}
}
