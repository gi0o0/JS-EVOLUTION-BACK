package com.jarzsoft.services.impl.wf.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.exception.PageNoFoundException;
import com.jarzsoft.service.IFilesUserService;
import com.jarzsoft.service.ISolCreditoService;
import com.jarzsoft.service.IStepStrategy;
import com.jarzsoft.service.IWWfMovService;
import com.jarzsoft.util.EnumStates;
import com.jarzsoft.util.EnumSteps;

@Component
public class WFStep_4Service implements IStepStrategy {

	private final ISolCreditoService solCreditoService;

	private final IWWfMovService wWfMovService;

	private final IFilesUserService serviceFile;

	@Autowired
	public WFStep_4Service(ISolCreditoService solCreditoService, IWWfMovService wWfMovService,
			IFilesUserService serviceFile) {
		super();

		this.solCreditoService = solCreditoService;

		this.wWfMovService = wWfMovService;

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

			String state = EnumStates.TIPO_ESTADO.STATE_6.getName();
			credito.setEstado(state);
			credito.setObserva(o.getComments());
			wWfMovService.createMovWithSteps(credito, user, EnumSteps.TIPO_PASO.STEP_4.getName(), o.getIsUpdate(),
					o.getIdWf());

			solCreditoService.updateState(o.getNumeroRadicacion(), state);
			o.setNextStep(EnumSteps.TIPO_PASO.STEP_5.getName());

		} else {
			throw new PageNoFoundException("Solicitud no Existe");
		}

		return o;

	}

	@Override
	public String getType() {
		return EnumSteps.TIPO_PASO.STEP_4.getName();
	}

}
