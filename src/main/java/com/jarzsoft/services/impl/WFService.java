package com.jarzsoft.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.mapper.IWfMapper;
import com.jarzsoft.service.ISolCreditoService;
import com.jarzsoft.service.IStepStrategy;
import com.jarzsoft.service.IWFService;

@Service
public class WFService implements IWFService {

	private final List<IStepStrategy> stepStrategies;

	private final Map<String, IStepStrategy> map;

	private final ISolCreditoService solCreditoService;

	private final IWfMapper mapper;

	@Autowired
	public WFService(List<IStepStrategy> stepStrategies, Map<String, IStepStrategy> map,
			ISolCreditoService solCreditoService, IWfMapper mapper) {
		super();
		this.map = map;
		this.stepStrategies = stepStrategies;
		this.solCreditoService = solCreditoService;
		this.mapper = mapper;
		stepStrategies.forEach(step -> map.put(step.getType(), step));
	}

	@Override
	public DTOWF create(DTOWF o, String user) {

		this.map.get(o.getIdStep()).apply(o, user);
		return o;
	}

	@Override
	public DTOWF getById(Integer id) {
		DTOSolCredito solCredito = solCreditoService.findBynumeroRadicacion(id);

		return mapper.mapperDaoToDto(solCredito, null, null);
	}

}
