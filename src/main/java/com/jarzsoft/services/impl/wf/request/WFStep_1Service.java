package com.jarzsoft.services.impl.wf.request;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.jarzsoft.dto.DTOFodataso;
import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOTerceros;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.entities.Parametro;
import com.jarzsoft.mapper.IFodatasoMapper;
import com.jarzsoft.mapper.ISolCreditoMapper;
import com.jarzsoft.mapper.ITercerosMapper;
import com.jarzsoft.repository.ParametroRepository;
import com.jarzsoft.repository.W_Bas_UsuarioRepository;
import com.jarzsoft.service.IFodatasoService;
import com.jarzsoft.service.ISolCreditoService;
import com.jarzsoft.service.IStepStrategy;
import com.jarzsoft.service.ITercerosService;
import com.jarzsoft.service.IWWfMovService;
import com.jarzsoft.util.EnumStates;
import com.jarzsoft.util.EnumSteps;

@Component
public class WFStep_1Service implements IStepStrategy {

	private final ITercerosService tercerosService;

	private final ITercerosMapper tercerosMapper;

	private final ISolCreditoService solCreditoService;

	private final ISolCreditoMapper solCreditoMapper;

	private final W_Bas_UsuarioRepository usuarioRepository;

	private final IFodatasoService fodatasoService;

	private final IFodatasoMapper fodatasoMapper;

	private final IWWfMovService wWfMovService;

	private final ParametroRepository parametroRepository;
	
	private static final Logger LOGGER = LogManager.getLogger(WFStep_1Service.class);
	
	@Value("${database.scheme.1}")
	private String schemeFirst;


	@Autowired
	public WFStep_1Service(ITercerosService tercerosService, ITercerosMapper tercerosMapper,
			ISolCreditoService solCreditoService, ISolCreditoMapper solCreditoMapper,
			W_Bas_UsuarioRepository usuarioRepository, IFodatasoService fodatasoService, IFodatasoMapper fodatasoMapper,
			IWWfMovService wWfMovService, ParametroRepository parametroRepository) {
		super();
		this.tercerosService = tercerosService;
		this.tercerosMapper = tercerosMapper;
		this.solCreditoService = solCreditoService;
		this.solCreditoMapper = solCreditoMapper;
		this.usuarioRepository = usuarioRepository;
		this.fodatasoService = fodatasoService;
		this.fodatasoMapper = fodatasoMapper;
		this.wWfMovService = wWfMovService;
		this.parametroRepository = parametroRepository;

	}

	@Override
	public DTOWF apply(DTOWF o, String user) {

		
		LOGGER.info("Paso 1");
		
		DTOTerceros userCredit = tercerosService.create(tercerosMapper.mapperDaoToDtoUser(o), user,false);
		o.setCodTer(userCredit.getCodTer() + "");
		String idCodeudor = "";
		LOGGER.info("Paso 2");
		fodatasoService.create(fodatasoMapper.mapperDaoToDto(o, userCredit.getCodTer().toString()));
		LOGGER.info("Paso 3");
		if (null != o.getCodeu() && o.getCodeu().getNitter() != null) {
			DTOTerceros userCodeo = tercerosService.create(tercerosMapper.mapperDaoToDtoCodeo(o), user,true);
			idCodeudor = userCodeo.getCodTer().toString();
			o.getCodeu().setCodTer(idCodeudor);
			DTOFodataso codeoFodataso = fodatasoService.getByCodTer(idCodeudor);
			fodatasoService.create(fodatasoMapper.mapperDaoToDtoCodeo(o, idCodeudor,codeoFodataso));

		}
		LOGGER.info("Paso 4");
		List<Object[]> usuario = usuarioRepository.findByUsuario(user);

		String solPagare = "0";

		if (!o.getIsUpdate()) {
			LOGGER.info("Paso 5");
			Parametro parametroList = parametroRepository.findByParamIdAndParamtext("CONSEC_PAGARE", "1");
			//jarz 09/05/2025
			if (schemeFirst.equals("tecnicas.dbo.") ) {
				solPagare = "E" + parametroList.getValue();
			}else {
				solPagare = "AV" + parametroList.getValue();
			}
			LOGGER.info("Paso 6");
		}

		LOGGER.info("Paso 7");
		DTOSolCredito out = solCreditoService
				.create(solCreditoMapper.mapperDaoToDto(o, userCredit.getCodTer().toString(), idCodeudor,
						usuario.get(0)[2].toString(), EnumStates.TIPO_ESTADO.STATE_S.getName(), solPagare));

		LOGGER.info("Paso 8");
		if (EnumStates.TIPO_ESTADO.STATE_S.getName().equals(out.getEstado()) && !o.getIsUpdate()) {
			parametroRepository.aumentarConsecutivoPagare("CONSEC_PAGARE", "1");
			LOGGER.info("Paso 9");
			out.setEstado(EnumStates.TIPO_ESTADO.STATE_2.getName());
			LOGGER.info("Paso 10");
			wWfMovService.createMovWithSteps(out, user, EnumSteps.TIPO_PASO.STEP_1.getName(), o.getIsUpdate(),
					o.getIdWf());
			LOGGER.info("Paso 11");
			out.setEstado(EnumStates.TIPO_ESTADO.STATE_3.getName());
			wWfMovService.createMovWithSteps(out, user, EnumSteps.TIPO_PASO.STEP_2.getName(), o.getIsUpdate(),
					o.getIdWf());
			LOGGER.info("Paso 12");
		}

		o.setNextStep(EnumSteps.TIPO_PASO.STEP_2.getName());
		o.setNumeroRadicacion(out.getNumeroRadicacion());
		o.setSolPagare(solPagare);
		LOGGER.info("Paso 13");
		return o;
	}

	@Override
	public String getType() {
		return EnumSteps.TIPO_PASO.STEP_1.getName();
	}

}
