package com.jarzsoft.services.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOTerceros;
import com.jarzsoft.entities.Terceros;
import com.jarzsoft.mapper.ITercerosMapper;
import com.jarzsoft.repository.TercerosRepository;
import com.jarzsoft.service.ITercerosService;

@Service
public class TercerosService implements ITercerosService {

	private final TercerosRepository tercerosRepository;

	private final ITercerosMapper mapper;

	@Autowired
	public TercerosService(TercerosRepository tercerosRepository, ITercerosMapper mapper) {
		super();
		this.tercerosRepository = tercerosRepository;
		this.mapper = mapper;
	}

	@Override
	public DTOTerceros create(DTOTerceros o, String user) {
		Terceros externalUser = findTerByNiter(o.getNitTer());

		if (externalUser == null) {
			o.setCodTer(new BigDecimal(tercerosRepository.getKey() + ""));
		} else {
			o.setCodTer(externalUser.getCodTer());
		}

		externalUser = tercerosRepository.save(mapper.mapperDtoToEntitie(o));

		return mapper.mapperEntitieToDao(externalUser);
	}

	@Override
	public DTOTerceros findByNiter(String nitTer) {
		return mapper.mapperEntitieToDao(findTerByNiter(nitTer));
	}

	private Terceros findTerByNiter(String nitTer) {
		return tercerosRepository.findByNiter(nitTer);
	}

	@Override
	public DTOTerceros findByCodter(String codTer) {
		return mapper.mapperEntitieToDao(tercerosRepository.findByCodter(codTer));
	}

}
