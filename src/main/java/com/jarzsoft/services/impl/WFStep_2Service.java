package com.jarzsoft.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOTerceros;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.entities.Parametro;
import com.jarzsoft.entities.WWfMov;
import com.jarzsoft.mapper.IFodatasoMapper;
import com.jarzsoft.mapper.ISolCreditoMapper;
import com.jarzsoft.mapper.ITercerosMapper;
import com.jarzsoft.mapper.IWWfMovMapper;
import com.jarzsoft.repository.ParametroRepository;
import com.jarzsoft.repository.W_Bas_UsuarioRepository;
import com.jarzsoft.repository.W_Wf_Pas_AutRepository;
import com.jarzsoft.repository.W_Wf_PasosRepository;
import com.jarzsoft.service.IFodatasoService;
import com.jarzsoft.service.ISolCreditoService;
import com.jarzsoft.service.IStepStrategy;
import com.jarzsoft.service.ITercerosService;
import com.jarzsoft.service.IWWfMovService;
import com.jarzsoft.util.Comunes;
import com.jarzsoft.util.EnumStates;
import com.jarzsoft.util.EnumSteps;
import com.jarzsoft.util.EnumSubSteps;
import com.jarzsoft.util.EnumWF;
import com.jarzsoft.util.SendEmail;

@Component
public class WFStep_2Service implements IStepStrategy {

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

	private final ParametroRepository parametroRepository;

	private final Comunes comunes;

	@Autowired
	public WFStep_2Service(ITercerosService tercerosService, ITercerosMapper tercerosMapper,
			ISolCreditoService solCreditoService, ISolCreditoMapper solCreditoMapper,
			W_Bas_UsuarioRepository usuarioRepository, IFodatasoService fodatasoService, IFodatasoMapper fodatasoMapper,
			W_Wf_PasosRepository wWfPasosRepository, SendEmail sendEmail, IWWfMovService wWfMovService,
			IWWfMovMapper wWfMovMapper, W_Wf_Pas_AutRepository w_Wf_Pas_AutRepository,
			ParametroRepository parametroRepository, Comunes comunes) {
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
		this.parametroRepository = parametroRepository;
		this.comunes = comunes;

	}

	@Override
	public DTOWF apply(DTOWF o, String user) {
		if (o.getIdSubStep().equals(EnumSubSteps.TIPO_SUB_PASO.SUB_STEP_1.getName())) {
			return signature(o, user);
		}
		if (o.getIdSubStep().equals(EnumSubSteps.TIPO_SUB_PASO.SUB_STEP_2.getName())) {
			return check(o, user);
		}

		return o;
	}

	private DTOWF signature(DTOWF o, String user) {
		Integer numRad = o.getNumeroRadicacion();
		DTOSolCredito externalUser = solCreditoService.findBynumeroRadicacion(o.getNumeroRadicacion());

		if (null != externalUser) {
			DTOTerceros ter=tercerosService.findByCodter(externalUser.getCodTer());
			String codeLink = comunes.generarHashPassword(numRad + "");
			solCreditoService.modificarClaveLink(numRad, codeLink);
			sendEmail(ter.getMailTer().trim(), codeLink);
		}
		return o;
	}

	private DTOWF check(DTOWF o, String user) {

		DTOSolCredito externalUser = solCreditoService.findByHash(o.getToken());

		if (null != externalUser) {
			Integer numRad = externalUser.getNumeroRadicacion();

			WWfMov mov = wWfMovService.findMovByNumRad(numRad, EnumWF.TIPO_WF.IDWF_4.getName(),
					EnumSteps.TIPO_PASO.STEP_2.getName());
			if (null != mov) {
				String state = EnumStates.TIPO_ESTADO.STATE_4.getName();
				mov.setEstPaso(state);
				wWfMovService.create(wWfMovMapper.mapperEntitieToDao(mov));
				solCreditoService.updateState(numRad, state);
				solCreditoService.modificarClaveLink(numRad, "");
			} else {
				throw new RuntimeException("Email verification error");
			}

		} else {
			throw new RuntimeException("Email verification error");
		}
		return o;
	}

	@Override
	public String getType() {
		return EnumSteps.TIPO_PASO.STEP_2.getName();
	}

	private void sendEmail(String email, String hash) {

		String asunto_email = "";
		String text_email = "";
		String link_email = "";

		List<Parametro> parametroList = parametroRepository.findByParamId("EMAIL_TER");

		for (Parametro parametro : parametroList) {
			String value = parametro.getParametroKey().getParam_text();
			if ("ASUNTO".equals(value)) {
				asunto_email = parametro.getValue();
			} else if ("TEXT".equals(value)) {
				text_email = parametro.getValue();
			} else if ("LINK".equals(value)) {
				link_email = parametro.getValue();
			}
		}

		sendEmail.Send(email, asunto_email, text_email + "\n\n" + link_email + hash);
	}

}