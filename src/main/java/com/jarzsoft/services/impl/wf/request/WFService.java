package com.jarzsoft.services.impl.wf.request;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOFodataso;
import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOStepsState;
import com.jarzsoft.dto.DTOTerceros;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.dto.DTOWFFilter;
import com.jarzsoft.dto.DTOWFParameterStep;
import com.jarzsoft.dto.DTOWWfMov;
import com.jarzsoft.dto.DTOWalletUser;
import com.jarzsoft.mapper.ISolCreditoMapper;
import com.jarzsoft.mapper.IWfMapper;
import com.jarzsoft.service.IFodatasoService;
import com.jarzsoft.service.ISolCreditoService;
import com.jarzsoft.service.IStepStrategy;
import com.jarzsoft.service.ITercerosService;
import com.jarzsoft.service.IWFParameterService;
import com.jarzsoft.service.IWFService;
import com.jarzsoft.service.IWWfMovService;
import com.jarzsoft.util.EnumWF;

@Service
public class WFService implements IWFService {

	@PersistenceContext
	private EntityManager entityManager;

	private final Map<String, IStepStrategy> map;

	private final ISolCreditoService solCreditoService;

	private final IWWfMovService wWfMovService;

	private final ITercerosService tercerosService;

	private final IFodatasoService fodatasoService;

	private final IWFParameterService wpParameterService;

	private final ISolCreditoMapper mapperSolCredito;

	private final IWfMapper mapper;

	@Autowired
	public WFService(List<IStepStrategy> stepStrategies, Map<String, IStepStrategy> map,
			ISolCreditoService solCreditoService, IWfMapper mapper, IWWfMovService wWfMovService,
			ITercerosService tercerosService, IFodatasoService fodatasoService, IWFParameterService wpParameterService,
			ISolCreditoMapper mapperSolCredito) {
		super();
		this.map = map;
		this.solCreditoService = solCreditoService;
		this.mapper = mapper;
		this.wWfMovService = wWfMovService;
		this.tercerosService = tercerosService;
		this.fodatasoService = fodatasoService;
		this.wpParameterService = wpParameterService;
		this.mapperSolCredito = mapperSolCredito;
		stepStrategies.forEach(step -> map.put(step.getType(), step));
	}

	@Override
	public DTOWF create(DTOWF o, String user) {

		this.map.get(o.getNextStep()).apply(o, user);
		return o;
	}

	@Override
	public DTOWF getById(Integer id) {
		DTOSolCredito solCredito = solCreditoService.findBynumeroRadicacion(id);
		return mapper.mapperDaoToDto(solCredito, null, null, null, null, null, null);
	}

	@Override
	public List<DTOWF> listAllByUser(String user) {

		List<DTOWF> out = new ArrayList<>();
		List<DTOSolCredito> o = solCreditoService.findByUser(user);
		for (DTOSolCredito in : o) {
			out.add(getByNumRadAndStep(in.getNumeroRadicacion(), 1, true));
		}

		return out;

	}

	@Override
	public DTOWF updateState(DTOWF o) {
		solCreditoService.updateState(o.getNumeroRadicacion(), o.getEstado());
		return o;
	}

	@Override
	public DTOWF getByNumRadAndStep(Integer numRad, Integer idStep, Boolean isLight) {

		DTOSolCredito solCredito = solCreditoService.findBynumeroRadicacion(numRad);
		DTOWWfMov move = null;

		if (!isLight)
			move = wWfMovService.findMovByNumRadAndStep(numRad, EnumWF.TIPO_WF.IDWF_4.getName(), idStep.toString());

		DTOTerceros client = null;
		DTOFodataso foda = null;
		if (null != solCredito.getCodTer()) {
			client = tercerosService.findByCodter(solCredito.getCodTer());
			if (!isLight)
				foda = fodatasoService.getByCodTer(solCredito.getCodTer());
		}

		DTOTerceros codeo = null;
		DTOFodataso fodaCodeo = null;
		if (null != solCredito.getCodeudor1() && !solCredito.getCodeudor1().equals("0.0")) {
			if (!isLight)
				codeo = tercerosService.findByCodter(solCredito.getCodeudor1());
			if (!isLight)
				fodaCodeo = fodatasoService.getByCodTer(solCredito.getCodeudor1());
		}

		Integer StepNow = wWfMovService.findMaxMovByNumRad(numRad, EnumWF.TIPO_WF.IDWF_4.getName());

		return mapper.mapperDaoToDto(solCredito, client, codeo, move, foda, fodaCodeo, StepNow);
	}

	@Override
	public List<DTOWFParameterStep> stepsbyNumRad(Integer idWf, Integer numRad) {
		return wpParameterService.stepsbyNumRad(idWf, numRad);
	}

	@Override
	public List<DTOWalletUser> getPortafolio(String codTer) {
		return wpParameterService.getPortafolio(codTer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DTOWF> listAllByFilters(DTOWFFilter f, String user) {

		String consulta = "select DISTINCT s.numero_radicacion,s.estado from w_wf_mov w, SOL_CREDITO s where w.id_wf = 4 and w.numero_radicacion = s.numero_radicacion and (w.usu_movimiento = '"
				+ user + "' " + "or exists (select wu.codperfil from W_Bas_Usuario wu where wu.Usuario = '" + user
				+ "' and wu.codperfil = 1 ) " + ")";

		if (null != f.getEntitie() && !"".equals(f.getEntitie())) {
			consulta = " select s.* from SOL_CREDITO s ,FODATASO f WHERE s.codter = f.cod_ter  and f.cla_asoci ='"
					+ f.getEntitie() + "'";
		}

		if (null != f.getFechaInit() && !"".equals(f.getFechaInit()) && null != f.getFechaFin()
				&& !"".equals(f.getFechaFin())) {
			consulta += " AND fecha_soli BETWEEN CONVERT(SMALLDATETIME, '" + f.getFechaInit() + " 00:00:00'"
					+ ",120)  and CONVERT(SMALLDATETIME, '" + f.getFechaFin() + " 23:59:59'" + ",120) ";
		}

		if (null != f.getEstado() && !"".equals(f.getEstado())) {
			consulta += " AND estado = '" + f.getEstado() + "'";
		}

		if (null != f.getAsesor() && !"".equals(f.getAsesor())) {
			consulta += " AND codter_asesor = '" + f.getAsesor() + "'";
		}

		if (null != f.getSector() && !"".equals(f.getSector())) {
			consulta = " select s.* from SOL_CREDITO s ,FODATASO f where s.codter = f.cod_ter  and f.cla_asoci in (select cod_inter from foclaaso where codsec ='"
					+ f.getSector() + "')";
		}

		Query query = entityManager.createNativeQuery(consulta);

		List<DTOWF> out = new ArrayList<>();
		List<DTOSolCredito> o = mapperSolCredito.mapperEntitiesToDaos(query.getResultList());

		for (DTOSolCredito in : o) {
			out.add(getByNumRadAndStep(in.getNumeroRadicacion(), 1, true));
		}

		return out;
	}

	@Override
	public List<DTOStepsState> getStepsState(String codTer, String numRad, String idWf) {
		return wpParameterService.getStepsState(codTer, numRad, idWf);
	}

	@Override
	public List<DTOWalletUser> getBriefcase(String user) {
		return wpParameterService.getBriefcase(user);
	}

}
