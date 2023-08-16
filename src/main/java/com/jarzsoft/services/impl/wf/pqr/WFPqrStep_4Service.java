package com.jarzsoft.services.impl.wf.pqr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jarzsoft.dto.DTOWFPqr;
import com.jarzsoft.service.IFilesUserService;
import com.jarzsoft.service.IStepPqrStrategy;
import com.jarzsoft.service.IWWfMovService;
import com.jarzsoft.services.impl.wf.UtilsWkService;
import com.jarzsoft.util.EnumStates;
import com.jarzsoft.util.EnumSteps;

@Component
public class WFPqrStep_4Service implements IStepPqrStrategy {

	private final IWWfMovService wWfMovService;

	private final IFilesUserService serviceFile;

	private final UtilsWkService utilsWkService;

	@Autowired
	public WFPqrStep_4Service(IWWfMovService wWfMovService, IFilesUserService serviceFile,
			UtilsWkService utilsWkService) {
		super();

		this.wWfMovService = wWfMovService;
		this.serviceFile = serviceFile;
		this.utilsWkService = utilsWkService;
	}

	@Override
	public String getType() {
		return EnumSteps.TIPO_PASO.STEP_4.getName();
	}

	@Override
	public DTOWFPqr apply(DTOWFPqr o, String user) {

		if (null != o.getFiles()) {
			for (int i = 0; i < o.getFiles().size(); i++) {
				serviceFile.create(o.getIdWf() + o.getNumeroRadicacion() + "", getType(), o.getNitter(),
						o.getFiles().get(i));
			}
		}

		wWfMovService.createMovWithSteps(
				utilsWkService.createSolCredito(o, o.getNumeroRadicacion(), EnumStates.TIPO_ESTADO.STATE_4.getName()),
				user, EnumSteps.TIPO_PASO.STEP_4.getName(), o.getIsUpdate(), o.getIdWf());
		o.setNextStep(EnumSteps.TIPO_PASO.STEP_5.getName());

		return o;
	}

}
