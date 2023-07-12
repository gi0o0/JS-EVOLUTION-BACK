package com.jarzsoft.services.impl.wf.pqr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jarzsoft.dto.DTOWFPqr;
import com.jarzsoft.mapper.IWWfPrestamoMapper;
import com.jarzsoft.service.IStepPqrStrategy;
import com.jarzsoft.service.IWFPrestamoService;
import com.jarzsoft.service.IWWfMovService;
import com.jarzsoft.services.impl.wf.UtilsWkService;
import com.jarzsoft.util.EnumStates;
import com.jarzsoft.util.EnumSteps;

@Component
public class WFPqrStep_3Service implements IStepPqrStrategy {

	private final IWWfMovService wWfMovService;

	private final IWWfPrestamoMapper prestamoMapper;

	private final IWFPrestamoService wFPrestamoService;

	private final UtilsWkService utilsWkService;

	@Autowired
	public WFPqrStep_3Service(IWWfMovService wWfMovService, IWWfPrestamoMapper prestamoMapper,
			IWFPrestamoService wFPrestamoService, UtilsWkService utilsWkService) {
		super();

		this.wWfMovService = wWfMovService;
		this.prestamoMapper = prestamoMapper;
		this.wFPrestamoService = wFPrestamoService;
		this.utilsWkService = utilsWkService;
	}

	@Override
	public String getType() {
		return EnumSteps.TIPO_PASO.STEP_3.getName();
	}

	@Override
	public DTOWFPqr apply(DTOWFPqr o, String user) {

		for (String credito : o.getCredtis()) {
			this.wFPrestamoService.create(prestamoMapper.mapperEntitieWfToDao(o, credito));
		}

		wWfMovService.createMovWithSteps(
				utilsWkService.createSolCredito(o, o.getNumeroRadicacion(), EnumStates.TIPO_ESTADO.STATE_3.getName()),
				user, EnumSteps.TIPO_PASO.STEP_3.getName(), o.getIsUpdate(), o.getIdWf());
		o.setNextStep(EnumSteps.TIPO_PASO.STEP_4.getName());

		return o;
	}

}
