package com.jarzsoft.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOTerceros;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.mapper.IFodatasoMapper;
import com.jarzsoft.mapper.ISolCreditoMapper;
import com.jarzsoft.mapper.ITercerosMapper;
import com.jarzsoft.repository.W_Bas_UsuarioRepository;
import com.jarzsoft.service.IFodatasoService;
import com.jarzsoft.service.ISolCreditoService;
import com.jarzsoft.service.IStepStrategy;
import com.jarzsoft.service.ITercerosService;
import com.jarzsoft.service.IWWfMovService;
import com.jarzsoft.util.EnumStates;
import com.jarzsoft.util.EnumSteps;

@Component
public class WFStep_1Service implements IStepStrategy {

	private final ITercerosService tercerosService;

	private final ITercerosMapper tercerosMapper;

	private final ISolCreditoService solCreditoService;

	private final ISolCreditoMapper solCreditoMapper;

	private final W_Bas_UsuarioRepository usuarioRepository;

	private final IFodatasoService fodatasoService;

	private final IFodatasoMapper fodatasoMapper;

	private final IWWfMovService wWfMovService;

	@Autowired
	public WFStep_1Service(ITercerosService tercerosService, ITercerosMapper tercerosMapper,
			ISolCreditoService solCreditoService, ISolCreditoMapper solCreditoMapper,
			W_Bas_UsuarioRepository usuarioRepository, IFodatasoService fodatasoService, IFodatasoMapper fodatasoMapper,
			IWWfMovService wWfMovService) {
		super();
		this.tercerosService = tercerosService;
		this.tercerosMapper = tercerosMapper;
		this.solCreditoService = solCreditoService;
		this.solCreditoMapper = solCreditoMapper;
		this.usuarioRepository = usuarioRepository;
		this.fodatasoService = fodatasoService;
		this.fodatasoMapper = fodatasoMapper;
		this.wWfMovService = wWfMovService;

	}

	@Override
	public DTOWF apply(DTOWF o, String user) {

		DTOTerceros userCredit = tercerosService.create(tercerosMapper.mapperDaoToDtoUser(o), user);
		o.setCodTer(userCredit.getCodTer() + "");
		String idCodeudor = "";
		fodatasoService.create(fodatasoMapper.mapperDaoToDto(o, userCredit.getCodTer().toString()));

		if (null != o.getCodeu()) {
			DTOTerceros userCodeo = tercerosService.create(tercerosMapper.mapperDaoToDtoCodeo(o), user);
			idCodeudor = userCodeo.getCodTer().toString();
			o.getCodeu().setCodTer(idCodeudor);
			fodatasoService.create(fodatasoMapper.mapperDaoToDtoCodeo(o, idCodeudor));
		}
		List<Object[]> usuario = usuarioRepository.findByUsuario(user);

		DTOSolCredito out = solCreditoService
				.create(solCreditoMapper.mapperDaoToDto(o, userCredit.getCodTer().toString(), idCodeudor,
						usuario.get(0)[2].toString(), EnumStates.TIPO_ESTADO.STATE_S.getName()));

		o.setNumeroRadicacion(out.getNumeroRadicacion());

		if (EnumStates.TIPO_ESTADO.STATE_S.getName().equals(out.getEstado()) && !o.getIsUpdate()) {
			out.setEstado(EnumStates.TIPO_ESTADO.STATE_2.getName());
			wWfMovService.createMovWithSteps(out, user, EnumSteps.TIPO_PASO.STEP_1.getName(), o.getIsUpdate());
			String state = EnumStates.TIPO_ESTADO.STATE_3.getName();
			solCreditoService.updateState(out.getNumeroRadicacion(), state);
			out.setEstado(state);
			wWfMovService.createMovWithSteps(out, user, EnumSteps.TIPO_PASO.STEP_2.getName(), o.getIsUpdate());
		}

		o.setNextStep(EnumSteps.TIPO_PASO.STEP_2.getName());
		return o;
	}

	@Override
	public String getType() {
		return EnumSteps.TIPO_PASO.STEP_1.getName();
	}

}
