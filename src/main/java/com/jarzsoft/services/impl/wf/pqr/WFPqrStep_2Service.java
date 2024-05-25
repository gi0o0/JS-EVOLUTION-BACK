package com.jarzsoft.services.impl.wf.pqr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jarzsoft.dto.DTOTerceros;
import com.jarzsoft.dto.DTOWFPqr;
import com.jarzsoft.repository.ParametroRepository;
import com.jarzsoft.service.IStepPqrStrategy;
import com.jarzsoft.service.ITercerosService;
import com.jarzsoft.service.IWWfMovService;
import com.jarzsoft.services.impl.wf.UtilsWkService;
import com.jarzsoft.util.Comunes;
import com.jarzsoft.util.EnumStates;
import com.jarzsoft.util.EnumSteps;
import com.jarzsoft.util.EnumSubSteps;

@Component
public class WFPqrStep_2Service implements IStepPqrStrategy {

	private final ITercerosService tercerosService;
	private final UtilsWkService utilsWkService;
	private final IWWfMovService wWfMovService;

	private final Comunes comunes;

	@Autowired
	public WFPqrStep_2Service(ITercerosService tercerosService,

			UtilsWkService utilsWkService, IWWfMovService wWfMovService, ParametroRepository parametroRepository,
			Comunes comunes) {
		super();
		this.tercerosService = tercerosService;
		this.utilsWkService = utilsWkService;
		this.wWfMovService = wWfMovService;
		this.comunes = comunes;

	}

	@Override
	public DTOWFPqr apply(DTOWFPqr o, String user) {
		if (o.getIdSubStep().equals(EnumSubSteps.TIPO_SUB_PASO.SUB_STEP_1.getName())) {
			return signature(o, user);
		}
		if (o.getIdSubStep().equals(EnumSubSteps.TIPO_SUB_PASO.SUB_STEP_2.getName())) {
			return check(o, user);
		}
		if (o.getIdSubStep().equals(EnumSubSteps.TIPO_SUB_PASO.SUB_STEP_3.getName())) {
			return createMove(o, user);
		}

		return o;
	}

	private DTOWFPqr signature(DTOWFPqr o, String user) {
		String codeLink = comunes.generarHashPassword(o.getNumeroRadicacion() + "");
		tercerosService.modificarClaveLink(o.getNitter(), codeLink);
		utilsWkService.sendEmail(o.getMailTer(), codeLink, o.getIdWf(), o.getNumeroRadicacion() + "");
		return o;
	}

	private DTOWFPqr check(DTOWFPqr o, String user) {

		DTOTerceros externalUser = tercerosService.findByHash(o.getToken());

		if (null != externalUser) {
			tercerosService.modificarClaveLink(externalUser.getNitTer(), "S");
		} else {
			throw new RuntimeException("Email verification error");
		}
		return o;
	}

	private DTOWFPqr createMove(DTOWFPqr o, String user) {

		if (null != o.getIsRequiredEmail() && o.getIsRequiredEmail()) {
			DTOTerceros externalUser = tercerosService.findByNiter(o.getNitter());
			if (!"S".equals(externalUser.getClaveLink())) {
				o.setState("4");
				return o;
			}
		}

		wWfMovService.createMovWithSteps(
				utilsWkService.createSolCredito(o, o.getNumeroRadicacion(), EnumStates.TIPO_ESTADO.STATE_2.getName()),
				user, EnumSteps.TIPO_PASO.STEP_2.getName(), o.getIsUpdate(), o.getIdWf());
		o.setNextStep(EnumSteps.TIPO_PASO.STEP_3.getName());
		o.setState("0");
		tercerosService.modificarClaveLink(o.getNitter(), "");

		return o;
	}

	@Override
	public String getType() {
		return EnumSteps.TIPO_PASO.STEP_2.getName();
	}

}
