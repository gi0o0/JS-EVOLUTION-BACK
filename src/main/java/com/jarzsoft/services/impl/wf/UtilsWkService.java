package com.jarzsoft.services.impl.wf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOWFPqr;
import com.jarzsoft.entities.Parametro;
import com.jarzsoft.repository.ParametroRepository;
import com.jarzsoft.util.EnumStates;
import com.jarzsoft.util.SendEmail;

@Component
public class UtilsWkService {

	private final SendEmail sendEmail;
	private final ParametroRepository parametroRepository;

	@Autowired
	UtilsWkService(

			SendEmail sendEmail, ParametroRepository parametroRepository) {
		super();
		this.sendEmail = sendEmail;

		this.parametroRepository = parametroRepository;

	}

	public void sendEmail(String email, String hash, String idWk) {

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

		sendEmail.Send(email, asunto_email, text_email + "\n\n" + link_email + hash + "," + idWk, null);
	}

	public DTOSolCredito createSolCredito(DTOWFPqr o, Integer numRad, String estado) {
		DTOSolCredito out = new DTOSolCredito();
		out.setObserva(o.getComments());
		out.setEstado(estado);
		out.setCodTer(o.getCodTer());
		out.setNumeroRadicacion(numRad);
		out.setCodTer(o.getNitter());
		out.setTipSolcredito(o.getEntitie());

		return out;
	}

}
