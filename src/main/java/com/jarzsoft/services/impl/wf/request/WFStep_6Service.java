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
public class WFStep_6Service implements IStepStrategy {

	private final IWWfMovService wWfMovService;

	private final ISolCreditoService solCreditoService;

	private final IFilesUserService serviceFile;

	@Autowired
	public WFStep_6Service(IWWfMovService wWfMovService, ISolCreditoService solCreditoService,
			IFilesUserService serviceFile) {
		super();

		this.wWfMovService = wWfMovService;

		this.solCreditoService = solCreditoService;

		this.serviceFile = serviceFile;
	
	}

	@Override
	public DTOWF apply(DTOWF o, String user) {

		DTOSolCredito credito = solCreditoService.findBynumeroRadicacion(o.getNumeroRadicacion());
		if (null != credito) {

			if (null != o.getFiles()) {
				for (int i = 0; i < o.getFiles().size(); i++) {
					serviceFile.create(o.getNumeroRadicacion() + "", getType(), o.getNitter(), o.getFiles().get(i));
				}
			}

			solCreditoService.updateState(o.getNumeroRadicacion(), EnumStates.TIPO_ESTADO.STATE_9.getName());
			String state = EnumStates.TIPO_ESTADO.STATE_14.getName();
			credito.setEstado(state);
			credito.setObserva(o.getComments());
			wWfMovService.createMovWithSteps(credito, user, EnumSteps.TIPO_PASO.STEP_6.getName(), o.getIsUpdate(),
					o.getIdWf());
			o.setNextStep(EnumSteps.TIPO_PASO.STEP_7.getName());

		} else {
			throw new PageNoFoundException("Solicitud no Existe");
		}

		return o;

	}

	@Override
	public String getType() {
		return EnumSteps.TIPO_PASO.STEP_6.getName();
	}

}
