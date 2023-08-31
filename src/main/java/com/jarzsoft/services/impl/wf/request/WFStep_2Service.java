package com.jarzsoft.services.impl.wf.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOTerceros;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.entities.WWfMov;
import com.jarzsoft.exception.PageNoFoundException;
import com.jarzsoft.mapper.IWWfMovMapper;
import com.jarzsoft.service.ISolCreditoService;
import com.jarzsoft.service.IStepStrategy;
import com.jarzsoft.service.ITercerosService;
import com.jarzsoft.service.IWWfMovService;
import com.jarzsoft.services.impl.wf.UtilsWkService;
import com.jarzsoft.util.Comunes;
import com.jarzsoft.util.EnumStates;
import com.jarzsoft.util.EnumSteps;
import com.jarzsoft.util.EnumSubSteps;
import com.jarzsoft.util.EnumWF;

@Component
public class WFStep_2Service implements IStepStrategy {

	private final ITercerosService tercerosService;

	private final ISolCreditoService solCreditoService;

	private final UtilsWkService utilsWkService;

	private final IWWfMovService wWfMovService;

	private final IWWfMovMapper wWfMovMapper;

	private final Comunes comunes;

	@Autowired
	public WFStep_2Service(ITercerosService tercerosService, ISolCreditoService solCreditoService,

			IWWfMovService wWfMovService, IWWfMovMapper wWfMovMapper, Comunes comunes, UtilsWkService utilsWkService) {
		super();
		this.tercerosService = tercerosService;
		this.solCreditoService = solCreditoService;
		this.utilsWkService = utilsWkService;
		this.wWfMovService = wWfMovService;
		this.wWfMovMapper = wWfMovMapper;
		this.comunes = comunes;

	}

	@Override
	public DTOWF apply(DTOWF o, String user) {
		if (o.getIdSubStep().equals(EnumSubSteps.TIPO_SUB_PASO.SUB_STEP_1.getName())) {
			return signature(o, user);
		}
		if (o.getIdSubStep().equals(EnumSubSteps.TIPO_SUB_PASO.SUB_STEP_2.getName())) {
			return check(o, user);
		}
		if (o.getIdSubStep().equals(EnumSubSteps.TIPO_SUB_PASO.SUB_STEP_3.getName())) {
			return updateStep(o, user);
		}

		return o;
	}

	private DTOWF signature(DTOWF o, String user) {
		Integer numRad = o.getNumeroRadicacion();
		DTOSolCredito externalUser = solCreditoService.findBynumeroRadicacion(o.getNumeroRadicacion());

		if (null != externalUser) {
			DTOTerceros ter = tercerosService.findByCodter(externalUser.getCodTer());
			String codeLink = comunes.generarHashPassword(numRad + "");
			solCreditoService.modificarClaveLink(numRad, codeLink);
			utilsWkService.sendEmail(ter.getMailTer().trim(), codeLink, o.getIdWf());
		}
		return o;
	}

	private DTOWF check(DTOWF o, String user) {

		DTOSolCredito externalUser = solCreditoService.findByHash(o.getToken());

		if (null != externalUser) {
			Integer numRad = externalUser.getNumeroRadicacion();

			WWfMov mov = wWfMovService.findMovByNumRad(numRad, EnumWF.TIPO_WF.IDWF_4.getName(),
					EnumSteps.TIPO_PASO.STEP_2.getName());
			if (null != mov) {
				String state = EnumStates.TIPO_ESTADO.STATE_4.getName();
				mov.setEstPaso(state);
				mov.setComentarios(o.getComments());
				wWfMovService.create(wWfMovMapper.mapperEntitieToDao(mov));
				solCreditoService.updateState(numRad, state);
				solCreditoService.modificarClaveLink(numRad, "");							
			} else {
				throw new RuntimeException("Email verification error");
			}

		} else {
			throw new RuntimeException("Email verification error");
		}
		return o;
	}

	private DTOWF updateStep(DTOWF o, String user) {

		DTOSolCredito credito = solCreditoService.findBynumeroRadicacion(o.getNumeroRadicacion());
		if (null != credito) {
			credito.setObserva(o.getComments());
			wWfMovService.createMovWithSteps(credito, user, EnumSteps.TIPO_PASO.STEP_2.getName(), o.getIsUpdate(),
					o.getIdWf());
			solCreditoService.updateState(o.getNumeroRadicacion(),  EnumStates.TIPO_ESTADO.STATE_S.getName());
			o.setNextStep(EnumSteps.TIPO_PASO.STEP_3.getName());
		} else {
			throw new PageNoFoundException("Solicitud no Existe");
		}

		return o;
	}

	@Override
	public String getType() {
		return EnumSteps.TIPO_PASO.STEP_2.getName();
	}

}
