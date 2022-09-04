package com.jarzsoft.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOWWfMov;
import com.jarzsoft.entities.WWfMov;
import com.jarzsoft.mapper.IWWfMovMapper;
import com.jarzsoft.repository.WWfMovRepository;
import com.jarzsoft.service.IWWfMovService;

@Service
public class WWfMovService implements IWWfMovService {

	private final WWfMovRepository wWfMovRepository;

	private final IWWfMovMapper mapper;

	@Autowired
	public WWfMovService(WWfMovRepository wWfMovRepository, IWWfMovMapper mapper) {
		super();
		this.wWfMovRepository = wWfMovRepository;
		this.mapper = mapper;
	}

	@Override
	public DTOWWfMov create(DTOWWfMov o) {

		WWfMov mov = findMovByNumRad(o.getNumeroRadicacion(), o.getIdWf() + "", o.getIdPaso());

		if (mov == null) {
			o.setIdWfMov(wWfMovRepository.getKey());
		} else {
			o.setIdWfMov(mov.getIdWfMov());
		}

		mov = wWfMovRepository.save(mapper.mapperDtoToEntitie(o));

		return mapper.mapperEntitieToDao(mov);
	}

	@Override
	public WWfMov findMovByNumRad(Integer numero_radicacion, String id_wf, String id_paso) {
		return wWfMovRepository.findMovByNumRad(numero_radicacion, id_wf, id_paso);
	}

}
