package com.jarzsoft.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.entities.Parametro;
import com.jarzsoft.exception.PageNoFoundException;
import com.jarzsoft.repository.ParametroRepository;
import com.jarzsoft.service.ISolCreditoService;
import com.jarzsoft.service.IStepStrategy;
import com.jarzsoft.service.IWWfMovService;
import com.jarzsoft.util.EnumStates;
import com.jarzsoft.util.EnumSteps;
import com.jarzsoft.util.SendEmail;

@Component
public class WFStep_8Service implements IStepStrategy {

	private final IWWfMovService wWfMovService;

	private final ISolCreditoService solCreditoService;

	private final ParametroRepository parametroRepository;

	private final SendEmail sendEmail;

	@Autowired
	public WFStep_8Service(IWWfMovService wWfMovService, ISolCreditoService solCreditoService,
			ParametroRepository parametroRepository, SendEmail sendEmail) {
		super();

		this.wWfMovService = wWfMovService;
		this.solCreditoService = solCreditoService;
		this.parametroRepository = parametroRepository;
		this.sendEmail = sendEmail;

	}

	@Override
	public DTOWF apply(DTOWF o, String user) {

		DTOSolCredito credito = solCreditoService.findBynumeroRadicacion(o.getNumeroRadicacion());
		if (null != credito) {
			solCreditoService.updateState(o.getNumeroRadicacion(), EnumStates.TIPO_ESTADO.STATE_9.getName());
			credito.setEstado(o.getEstado());
			credito.setObserva(o.getComments());
			wWfMovService.createMovWithSteps(credito, user, EnumSteps.TIPO_PASO.STEP_8.getName(), o.getIsUpdate());
			o.setNextStep(EnumSteps.TIPO_PASO.STEP_END.getName());
			sendEmail(o.getMailTer());

		} else {
			throw new PageNoFoundException("Solicitud no Existe");
		}

		return o;

	}

	@Override
	public String getType() {
		return EnumSteps.TIPO_PASO.STEP_8.getName();
	}

	private void sendEmail(String email) {

		String asunto_email = "";
		String text_email = "";


		List<Parametro> parametroList = parametroRepository.findByParamId("EMAIL_WK4_STEP8");

		for (Parametro parametro : parametroList) {
			String value = parametro.getParametroKey().getParam_text();
			if ("ASUNTO".equals(value)) {
				asunto_email = parametro.getValue();
			} else if ("TEXT".equals(value)) {
				text_email = parametro.getValue();
			} 
		}

		sendEmail.Send(email, asunto_email, text_email, null);
	}

}
