package com.jarzsoft.services.impl.wf.pqr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jarzsoft.dto.DTOWFPqr;
import com.jarzsoft.entities.Parametro;
import com.jarzsoft.repository.ParametroRepository;
import com.jarzsoft.service.IStepPqrStrategy;
import com.jarzsoft.service.IWWfMovService;
import com.jarzsoft.services.impl.wf.UtilsWkService;
import com.jarzsoft.util.EnumStates;
import com.jarzsoft.util.EnumSteps;

@Component
public class WFPqrStep_1Service implements IStepPqrStrategy {

	private final IWWfMovService wWfMovService;

	private final ParametroRepository parametroRepository;

	private final UtilsWkService utilsWkService;

	@Autowired
	public WFPqrStep_1Service(IWWfMovService wWfMovService, ParametroRepository parametroRepository,
			UtilsWkService utilsWkService) {
		super();

		this.wWfMovService = wWfMovService;
		this.parametroRepository = parametroRepository;
		this.utilsWkService = utilsWkService;
	}

	@Override
	public String getType() {
		return EnumSteps.TIPO_PASO.STEP_1.getName();
	}

	@Override
	public DTOWFPqr apply(DTOWFPqr o, String user) {

		Integer numRad = 0;
		String consecutive = getConsecutiveWF(o.getIdWf());
		if (!o.getIsUpdate()) {

			Parametro parametroList = parametroRepository.findByParamIdAndParamtext(consecutive, "1");
			numRad = Integer.parseInt(parametroList.getValue());
		} else {
			numRad = o.getNumeroRadicacion();
		}

		wWfMovService.createMovWithSteps(
				utilsWkService.createSolCredito(o, numRad, EnumStates.TIPO_ESTADO.STATE_1.getName()), user,
				EnumSteps.TIPO_PASO.STEP_1.getName(), o.getIsUpdate(), o.getIdWf());
		parametroRepository.aumentarConsecutivoPagare(consecutive, "1");
		o.setNextStep(EnumSteps.TIPO_PASO.STEP_2.getName());
		o.setNumeroRadicacion(numRad);

		return o;
	}

	private String getConsecutiveWF(String idWf) {
		return idWf == "1" ? "CONSEC_SOLESTADO" : "CONSEC_SOLLLAMADA";
	}

}
