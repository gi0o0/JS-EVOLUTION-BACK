package com.jarzsoft.services.impl.wf.request;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.entities.Parametro;
import com.jarzsoft.exception.PageNoFoundException;
import com.jarzsoft.repository.ParametroRepository;
import com.jarzsoft.service.IFilesUserService;
import com.jarzsoft.service.ISolCreditoService;
import com.jarzsoft.service.IStepStrategy;
import com.jarzsoft.service.IWWfMovService;
import com.jarzsoft.util.Comunes;
import com.jarzsoft.util.Constantes;
import com.jarzsoft.util.EnumStates;
import com.jarzsoft.util.EnumSteps;
import com.jarzsoft.util.SendEmail;

@Component
public class WFStep_8Service implements IStepStrategy {

	private final IWWfMovService wWfMovService;

	private final ISolCreditoService solCreditoService;

	private final ParametroRepository parametroRepository;

	private final SendEmail sendEmail;

	private final IFilesUserService serviceFile;

	@Autowired
	public WFStep_8Service(IWWfMovService wWfMovService, ISolCreditoService solCreditoService,
			ParametroRepository parametroRepository, SendEmail sendEmail, IFilesUserService serviceFile) {
		super();

		this.wWfMovService = wWfMovService;
		this.solCreditoService = solCreditoService;
		this.parametroRepository = parametroRepository;
		this.sendEmail = sendEmail;
		this.serviceFile = serviceFile;

	}

	@Override
	public DTOWF apply(DTOWF o, String user) {

		DTOSolCredito credito = solCreditoService.findBynumeroRadicacion(o.getNumeroRadicacion());
		if (null != credito) {

			if (null != o.getFiles()) {
				for (int i = 0; i < o.getFiles().size(); i++) {
					serviceFile.create(o.getIdWf() + o.getNumeroRadicacion() + "", getType(), o.getNitter(),
							o.getFiles().get(i));
				}
			}

			solCreditoService.updateState(o.getNumeroRadicacion(), EnumStates.TIPO_ESTADO.STATE_P.getName());
			credito.setEstado(o.getEstado());
			credito.setObserva(o.getComments());
			wWfMovService.createMovWithSteps(credito, user, EnumSteps.TIPO_PASO.STEP_8.getName(), o.getIsUpdate(),
					o.getIdWf());
			o.setNextStep(EnumSteps.TIPO_PASO.STEP_END.getName());
			sendEmail(o.getMailTer(), o.getNumeroRadicacion() + "", o.getEstado());

		} else {
			throw new PageNoFoundException("Solicitud no Existe");
		}

		return o;

	}

	@Override
	public String getType() {
		return EnumSteps.TIPO_PASO.STEP_8.getName();
	}

	private void sendEmail(String email, String idWf, String estado) {

		String asunto_email = "";
		String text_email = "";

		String stateRequest = Constantes.STATUS_APPROVED;
		if ("10".equals(estado))
			stateRequest = Constantes.STATUS_DENIED;

		List<Parametro> parametroList = parametroRepository.findByParamId("EMAIL_WK4_STEP8");

		for (Parametro parametro : parametroList) {
			String value = parametro.getParametroKey().getParam_text();
			if ("ASUNTO".equals(value)) {
				asunto_email = parametro.getValue();
			} else if ("TEXT".equals(value)) {
				text_email = parametro.getValue();
			}
		}
		String asunto = String.format(asunto_email, idWf);
		sendEmail.Send(email, asunto, Comunes.getTextoFormat(text_email, stateRequest), null, "");
	}

}
