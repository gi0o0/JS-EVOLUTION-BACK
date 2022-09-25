package com.jarzsoft.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOFodataso;
import com.jarzsoft.entities.Fodataso;
import com.jarzsoft.mapper.IFodatasoMapper;
import com.jarzsoft.repository.FodatasoRepository;
import com.jarzsoft.service.IFodatasoService;

@Service
public class FodatasoService implements IFodatasoService {

	private final FodatasoRepository fodatasoRepository;

	private final IFodatasoMapper mapper;

	@Autowired
	public FodatasoService(FodatasoRepository fodatasoRepository, IFodatasoMapper mapper) {
		super();
		this.fodatasoRepository = fodatasoRepository;
		this.mapper = mapper;
	}

	@Override
	public DTOFodataso create(DTOFodataso o) {

		Fodataso fodataso = fodatasoRepository.save(mapper.mapperDtoToEntitie(o));

		return mapper.mapperEntitieToDao(fodataso);
	}

	@Override
	public DTOFodataso getByCodTer(String codTer) {
		return mapper.mapperEntitieToDao(fodatasoRepository.findByCodTer(codTer));
	}

}
