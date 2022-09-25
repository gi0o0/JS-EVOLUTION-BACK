package com.jarzsoft.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOFodataso;
import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOTerceros;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.dto.DTOWFParameterStep;
import com.jarzsoft.dto.DTOWWfMov;
import com.jarzsoft.mapper.IWfMapper;
import com.jarzsoft.service.IFodatasoService;
import com.jarzsoft.service.ISolCreditoService;
import com.jarzsoft.service.IStepStrategy;
import com.jarzsoft.service.ITercerosService;
import com.jarzsoft.service.IWFParameterService;
import com.jarzsoft.service.IWFService;
import com.jarzsoft.service.IWWfMovService;
import com.jarzsoft.util.EnumWF;

@Service
public class WFService implements IWFService {

	private final Map<String, IStepStrategy> map;

	private final ISolCreditoService solCreditoService;

	private final IWWfMovService wWfMovService;

	private final ITercerosService tercerosService;

	private final IFodatasoService fodatasoService;

	private final IWFParameterService wpParameterService;

	private final IWfMapper mapper;

	@Autowired
	public WFService(List<IStepStrategy> stepStrategies, Map<String, IStepStrategy> map,
			ISolCreditoService solCreditoService, IWfMapper mapper, IWWfMovService wWfMovService,
			ITercerosService tercerosService, IFodatasoService fodatasoService,
			IWFParameterService wpParameterService) {
		super();
		this.map = map;
		this.solCreditoService = solCreditoService;
		this.mapper = mapper;
		this.wWfMovService = wWfMovService;
		this.tercerosService = tercerosService;
		this.fodatasoService = fodatasoService;
		this.wpParameterService = wpParameterService;
		stepStrategies.forEach(step -> map.put(step.getType(), step));
	}

	@Override
	public DTOWF create(DTOWF o, String user) {

		this.map.get(o.getNextStep()).apply(o, user);
		return o;
	}

	@Override
	public DTOWF getById(Integer id) {
		DTOSolCredito solCredito = solCreditoService.findBynumeroRadicacion(id);
		return mapper.mapperDaoToDto(solCredito, null, null, null, null, null);
	}

	@Override
	public List<DTOWF> listAllByUser(String user) {
		return mapper.mapperDaosToDtos(solCreditoService.findByUser(user));

	}

	@Override
	public DTOWF updateState(DTOWF o) {
		solCreditoService.updateState(o.getNumeroRadicacion(), o.getEstado());
		return o;
	}

	@Override
	public DTOWF getByNumRadAndStep(Integer numRad, Integer idStep) {

		DTOSolCredito solCredito = solCreditoService.findBynumeroRadicacion(numRad);
		DTOWWfMov move = wWfMovService.findMovByNumRadAndStep(numRad, EnumWF.TIPO_WF.IDWF_4.getName(),
				idStep.toString());

		DTOTerceros client = null;
		DTOFodataso foda = null;
		if (null != solCredito.getCodTer()) {
			client = tercerosService.findByCodter(solCredito.getCodTer());
			foda = fodatasoService.getByCodTer(solCredito.getCodTer());
		}

		DTOTerceros codeo = null;
		DTOFodataso fodaCodeo = null;
		if (null != solCredito.getCodeudor1()) {
			codeo = tercerosService.findByCodter(solCredito.getCodeudor1());
			fodaCodeo = fodatasoService.getByCodTer(solCredito.getCodeudor1());
		}

		return mapper.mapperDaoToDto(solCredito, client, codeo, move, foda, fodaCodeo);
	}

	@Override
	public List<DTOWFParameterStep> stepsbyNumRad(Integer numRad) {

		return wpParameterService.stepsbyNumRad(numRad);
	}

}
