package com.jarzsoft.services.impl.wf.pqr;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jarzsoft.dto.DTOFilesUser;
import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOWFPqr;
import com.jarzsoft.entities.Parametro;
import com.jarzsoft.entities.Terceros;
import com.jarzsoft.repository.ParametroRepository;
import com.jarzsoft.repository.TercerosRepository;
import com.jarzsoft.service.IFilesUserService;
import com.jarzsoft.service.IStepPqrStrategy;
import com.jarzsoft.service.IWWfMovService;
import com.jarzsoft.services.impl.wf.UtilsWkService;
import com.jarzsoft.util.Comunes;
import com.jarzsoft.util.EnumStates;
import com.jarzsoft.util.EnumSteps;
import com.jarzsoft.util.EnumSubSteps;
import com.jarzsoft.util.EnumWF;
import com.jarzsoft.util.SendEmail;

@Component
public class WFPqrStep_5Service implements IStepPqrStrategy {

	private final IWWfMovService wWfMovService;

	private final IFilesUserService serviceFile;

	private final SendEmail sendEmail;

	private final ParametroRepository parametroRepository;

	private final TercerosRepository tercerosRepository;

	private final UtilsWkService utilsWkService;

	@Autowired
	public WFPqrStep_5Service(IWWfMovService wWfMovService, IFilesUserService serviceFile, SendEmail sendEmail,
			ParametroRepository parametroRepository, UtilsWkService utilsWkService,
			TercerosRepository tercerosRepository) {
		super();

		this.wWfMovService = wWfMovService;
		this.serviceFile = serviceFile;
		this.sendEmail = sendEmail;
		this.parametroRepository = parametroRepository;
		this.utilsWkService = utilsWkService;
		this.tercerosRepository = tercerosRepository;

	}

	@Override
	public String getType() {
		return EnumSteps.TIPO_PASO.STEP_5.getName();
	}

	@Override
	public DTOWFPqr apply(DTOWFPqr o, String user) {

		if (o.getIdSubStep().equals(EnumSubSteps.TIPO_SUB_PASO.SUB_STEP_1.getName())) {
			return sendEmails(o, user);
		}
		if (o.getIdSubStep().equals(EnumSubSteps.TIPO_SUB_PASO.SUB_STEP_2.getName())) {
			return createMove(o, user);
		}

		return o;

	}

	private DTOWFPqr sendEmails(DTOWFPqr o, String user) {

		String asunto_email = "";
		String text_email = "";
		String emailUser = o.getMailTer();
		String emailsCc = "";
		String paramaterEmail = "EMAIL_WK1_STEP5";

		if (EnumWF.TIPO_WF.IDWF_2.getName().equals(o.getIdWf())) {
			paramaterEmail = "EMAIL_WK2_STEP5";
		}

		List<Parametro> parametroList = parametroRepository.findByParamId(paramaterEmail);

		for (Parametro parametro : parametroList) {
			String value = parametro.getParametroKey().getParam_text();
			if ("ASUNTO".equals(value)) {
				asunto_email = parametro.getValue();
			} else if ("TEXT".equals(value)) {
				text_email = parametro.getValue();
			}
		}

		ArrayList<String> reportes = new ArrayList<>();

		for (DTOFilesUser file : o.getFilesEmail())
			reportes.add(file.getPath());

		if (EnumWF.TIPO_WF.IDWF_1.getName().equals(o.getIdWf())) {
			Terceros tercero = tercerosRepository.findTerceroByFodaclasoAndPrestamoDP(o.getNumeroRadicacion() + "",
					o.getIdWf());
			if (null != tercero) {
				Parametro emailsCcDp = parametroRepository.findByParamIdAndParamtext("EMAILS_CC_DP", "CC");
				emailsCc = emailsCcDp.getValue();
				emailUser = tercero.getMailTer().trim();
			}

		}
		String asunto = String.format(asunto_email, o.getNumeroRadicacion() + "");
		sendEmail.Send(emailUser, asunto, Comunes.getTextoFormat(text_email, ""), reportes, emailsCc);

		return o;

	}

	public DTOWFPqr createMove(DTOWFPqr o, String user) {

		String docAdds = "";

		if (null != o.getFiles()) {
			for (int i = 0; i < o.getFiles().size(); i++) {

				String nameFile = o.getIdWf() + o.getNumeroRadicacion() + "_" + getType() + "_" + o.getNitter() + "_"
						+ o.getFiles().get(i).getIdDocumento() + "_" + o.getFiles().get(i).getNomDocumento()
						+ ".pdf - ";
				docAdds += nameFile;
				serviceFile.create(o.getIdWf() + o.getNumeroRadicacion() + "", getType(), o.getNitter(),
						o.getFiles().get(i));
			}
		}

		o.setComments(o.getComments() + " Docs: " + docAdds);

		DTOSolCredito out = utilsWkService.createSolCredito(o, o.getNumeroRadicacion(),
				EnumStates.TIPO_ESTADO.STATE_5.getName());

		if (o.getIsUpdate()) {
			wWfMovService.createMovOtherRecord(out, user, EnumSteps.TIPO_PASO.STEP_5.getName(), o.getIsUpdate(),
					o.getIdWf());
		} else {
			wWfMovService.createMovWithSteps(out, user, EnumSteps.TIPO_PASO.STEP_5.getName(), o.getIsUpdate(),
					o.getIdWf());
		}

		o.setNextStep(EnumSteps.TIPO_PASO.STEP_END.getName());

		return o;
	}

}
