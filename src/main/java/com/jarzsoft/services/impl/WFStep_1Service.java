package com.jarzsoft.services.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOTerceros;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.dto.DTOWWfMov;
import com.jarzsoft.entities.W_Wf_Pas_Aut;
import com.jarzsoft.entities.W_Wf_Pasos;
import com.jarzsoft.mapper.IFodatasoMapper;
import com.jarzsoft.mapper.ISolCreditoMapper;
import com.jarzsoft.mapper.ITercerosMapper;
import com.jarzsoft.mapper.IWWfMovMapper;
import com.jarzsoft.repository.W_Bas_UsuarioRepository;
import com.jarzsoft.repository.W_Wf_Pas_AutRepository;
import com.jarzsoft.repository.W_Wf_PasosRepository;
import com.jarzsoft.service.IFodatasoService;
import com.jarzsoft.service.ISolCreditoService;
import com.jarzsoft.service.IStepStrategy;
import com.jarzsoft.service.ITercerosService;
import com.jarzsoft.service.IWWfMovService;
import com.jarzsoft.util.Constantes;
import com.jarzsoft.util.EnumStates;
import com.jarzsoft.util.EnumSteps;
import com.jarzsoft.util.EnumWF;
import com.jarzsoft.util.SendEmail;

@Component
public class WFStep_1Service implements IStepStrategy {

	private final ITercerosService tercerosService;

	private final ITercerosMapper tercerosMapper;

	private final ISolCreditoService solCreditoService;

	private final ISolCreditoMapper solCreditoMapper;

	private final W_Bas_UsuarioRepository usuarioRepository;

	private final IFodatasoService fodatasoService;

	private final IFodatasoMapper fodatasoMapper;

	private final W_Wf_PasosRepository wWfPasosRepository;

	private final SendEmail sendEmail;

	private final IWWfMovService wWfMovService;

	private final IWWfMovMapper wWfMovMapper;

	private final W_Wf_Pas_AutRepository w_Wf_Pas_AutRepository;

	@Autowired
	public WFStep_1Service(ITercerosService tercerosService, ITercerosMapper tercerosMapper,
			ISolCreditoService solCreditoService, ISolCreditoMapper solCreditoMapper,
			W_Bas_UsuarioRepository usuarioRepository, IFodatasoService fodatasoService, IFodatasoMapper fodatasoMapper,
			W_Wf_PasosRepository wWfPasosRepository, SendEmail sendEmail, IWWfMovService wWfMovService,
			IWWfMovMapper wWfMovMapper, W_Wf_Pas_AutRepository w_Wf_Pas_AutRepository) {
		super();
		this.tercerosService = tercerosService;
		this.tercerosMapper = tercerosMapper;
		this.solCreditoService = solCreditoService;
		this.solCreditoMapper = solCreditoMapper;
		this.usuarioRepository = usuarioRepository;
		this.fodatasoService = fodatasoService;
		this.fodatasoMapper = fodatasoMapper;
		this.wWfPasosRepository = wWfPasosRepository;
		this.sendEmail = sendEmail;
		this.wWfMovService = wWfMovService;
		this.wWfMovMapper = wWfMovMapper;
		this.w_Wf_Pas_AutRepository = w_Wf_Pas_AutRepository;

	}

	@Override
	public DTOWF apply(DTOWF o, String user) {
		DTOTerceros userCredit = tercerosService.create(tercerosMapper.mapperDaoToDtoUser(o), user);
		String idCodeudor = "";

		if (null != o.getCodeu()) {
			DTOTerceros userCodeo = tercerosService.create(tercerosMapper.mapperDaoToDtoCodeo(o), user);
			idCodeudor = userCodeo.getCodTer().toString();

			fodatasoService.create(fodatasoMapper.mapperDaoToDto(o, idCodeudor));
		}
		List<Object[]> usuario = usuarioRepository.findByUsuario(user);

		DTOSolCredito out = solCreditoService
				.create(solCreditoMapper.mapperDaoToDto(o, userCredit.getCodTer().toString(), idCodeudor,
						usuario.get(0)[2].toString(), EnumStates.TIPO_ESTADO.STATE_S.getName()));

		o.setNumeroRadicacion(out.getNumeroRadicacion());

		if (EnumStates.TIPO_ESTADO.STATE_S.getName().equals(out.getEstado())) {
			W_Wf_Pasos step = wWfPasosRepository.findByIdStep(EnumSteps.TIPO_PASO.STEP_1.getName());
			String state = "";
			if (null != step) {
				if (Constantes.isOK.equals(step.getEnvCorreoPaso())) {
					sendEmail.Send(step.getEmail1(), step.getAsuntoCorreo(), step.getTextoCorreo());
					sendEmail.Send(step.getEmail2(), step.getAsuntoCorreo(), step.getTextoCorreo());
				}
				if (Constantes.isOK.equals(step.getEnvCorreoAutoriza())) {
					sendEmail.Send(step.getEmail3(), step.getAsuntoCorreo(), step.getTextoCorreo());
					sendEmail.Send(step.getEmail2(), step.getAsuntoCorreo(), step.getTextoCorreo());
					state = EnumStates.TIPO_ESTADO.STATE_2.getName();
				} else {
					state = EnumStates.TIPO_ESTADO.STATE_1.getName();
				}
				solCreditoService.updateState(out.getNumeroRadicacion(), state);
				out.setEstado(state);
				List<W_Wf_Pas_Aut> auts = w_Wf_Pas_AutRepository.findByWfAndStep(EnumWF.TIPO_WF.IDWF_4.getName(),
						EnumSteps.TIPO_PASO.STEP_1.getName());
				HashMap<String, String> users = new HashMap<String, String>();

				for (int i = 0; i < auts.size(); i++) {
					int j = i + 1;
					users.put("user" + j, auts.get(i).getW_Wf_Pas_AutPK().getUsuario());
				}

				DTOWWfMov mov = wWfMovService.create(
						wWfMovMapper.mapperDaoToDto(out, step, user, Integer.parseInt(EnumWF.TIPO_WF.IDWF_4.getName()),
								null, EnumSteps.TIPO_PASO.STEP_1.getName(), users));
				if (null != mov) {
					state = EnumStates.TIPO_ESTADO.STATE_3.getName();
					solCreditoService.updateState(out.getNumeroRadicacion(), state);
					out.setEstado(state);
					mov = wWfMovService.create(wWfMovMapper.mapperDaoToDto(out, step, user,
							Integer.parseInt(EnumWF.TIPO_WF.IDWF_4.getName()), null,
							EnumSteps.TIPO_PASO.STEP_2.getName(), users));
				}
			}
		}

		o.setNextStep( EnumSteps.TIPO_PASO.STEP_2.getName());
		return o;
	}

	@Override
	public String getType() {
		return EnumSteps.TIPO_PASO.STEP_1.getName();
	}

}
