package com.jarzsoft.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.exception.PageNoFoundException;
import com.jarzsoft.reports.impl.IReportesService;
import com.jarzsoft.repository.W_Bas_UsuarioRepository;
import com.jarzsoft.service.IFilesUserService;
import com.jarzsoft.service.IParameterService;
import com.jarzsoft.service.ISolCreditoService;
import com.jarzsoft.service.IStepStrategy;
import com.jarzsoft.service.IWWfMovService;
import com.jarzsoft.util.Constantes;
import com.jarzsoft.util.EnumStates;
import com.jarzsoft.util.EnumSteps;
import com.jarzsoft.util.EnumSubSteps;
import com.jarzsoft.util.SendEmail;

@Component
public class WFStep_5Service implements IStepStrategy {

	private final IWWfMovService wWfMovService;

	private final ISolCreditoService solCreditoService;

	private final IFilesUserService serviceFile;

	private final IReportesService serviceReports;

	private final IParameterService parameterService;

	private final SendEmail sendEmail;

	private final W_Bas_UsuarioRepository usuarioRepository;

	@Autowired
	public WFStep_5Service(IWWfMovService wWfMovService, ISolCreditoService solCreditoService,
			IFilesUserService serviceFile, IReportesService serviceReports, IParameterService parameterService,
			SendEmail sendEmail, W_Bas_UsuarioRepository usuarioRepository) {
		super();

		this.wWfMovService = wWfMovService;

		this.solCreditoService = solCreditoService;

		this.serviceFile = serviceFile;

		this.serviceReports = serviceReports;

		this.parameterService = parameterService;

		this.sendEmail = sendEmail;

		this.usuarioRepository = usuarioRepository;

	}

	@Override
	public DTOWF apply(DTOWF o, String user) {

		if (o.getIdSubStep().equals(EnumSubSteps.TIPO_SUB_PASO.SUB_STEP_1.getName())) {
			return callReports(o, user);
		}
		if (o.getIdSubStep().equals(EnumSubSteps.TIPO_SUB_PASO.SUB_STEP_2.getName())) {
			return createStep(o, user);
		}

		return o;

	}

	private DTOWF createStep(DTOWF o, String user) {
		DTOSolCredito credito = solCreditoService.findBynumeroRadicacion(o.getNumeroRadicacion());
		if (null != credito) {

			if (null != o.getFiles()) {
				for (int i = 0; i < o.getFiles().size(); i++) {
					serviceFile.create(o.getNumeroRadicacion() + "", getType(), o.getNitter(), o.getFiles().get(i));
				}
			}

			solCreditoService.updateState(o.getNumeroRadicacion(), EnumStates.TIPO_ESTADO.STATE_P.getName());
			credito.setEstado(EnumStates.TIPO_ESTADO.STATE_18.getName());
			credito.setObserva(o.getComments());
			wWfMovService.createMovWithSteps(credito, user, EnumSteps.TIPO_PASO.STEP_5.getName(), o.getIsUpdate());
			o.setNextStep(EnumSteps.TIPO_PASO.STEP_6.getName());

		} else {
			throw new PageNoFoundException("Solicitud no Existe");
		}

		return o;
	}

	@Override
	public String getType() {
		return EnumSteps.TIPO_PASO.STEP_5.getName();
	}

	private DTOWF callReports(DTOWF o, String user) {
		String path = parameterService.getSingleById("PATH", "FILES_USERS").getValue();
		ArrayList<String> reportes = new ArrayList<>();
		Constantes constantes = new Constantes();

		for (String report : constantes.REPORTS_OF_WF_4) {
			serviceReports.create(o, user, report, path);
			reportes.add(path + report + "_" + o.getNumeroRadicacion() + ".pdf");
		}

		List<Object[]> usuario = usuarioRepository.findByUsuario(user);
		sendEmail.Send((String) usuario.get(0)[1], Constantes.EMAIL_ASUNTO, Constantes.EMAIL_TEXTO, reportes);

		return o;
	}

}
