package com.jarzsoft.services.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOStepsState;
import com.jarzsoft.dto.DTOTerceros;
import com.jarzsoft.dto.DTOWFParameter;
import com.jarzsoft.dto.DTOWFParameterEst;
import com.jarzsoft.dto.DTOWFParameterStep;
import com.jarzsoft.dto.DTOWFParameterStepAut;
import com.jarzsoft.dto.DTOWFParameterStepDoc;
import com.jarzsoft.dto.DTOWalletUser;
import com.jarzsoft.entities.W_Wf_Est;
import com.jarzsoft.entities.W_Wf_EstPK;
import com.jarzsoft.entities.W_Wf_Pasos;
import com.jarzsoft.entities.W_Wf_PasosPK;
import com.jarzsoft.exception.UnauthorizedException;
import com.jarzsoft.mapper.IWfEstParameterMapper;
import com.jarzsoft.mapper.IWfParameterMapper;
import com.jarzsoft.mapper.IWfStepAutParameterMapper;
import com.jarzsoft.mapper.IWfStepDocParameterMapper;
import com.jarzsoft.mapper.IWfStepParameterMapper;
import com.jarzsoft.repository.W_WfRepository;
import com.jarzsoft.repository.W_Wf_EstRepository;
import com.jarzsoft.repository.W_Wf_Pas_AutRepository;
import com.jarzsoft.repository.W_Wf_Pas_DocRepository;
import com.jarzsoft.repository.W_Wf_PasosRepository;
import com.jarzsoft.service.IUserService;
import com.jarzsoft.service.IWFParameterService;
import com.jarzsoft.util.Constantes;

@Service
public class WFParameterService implements IWFParameterService {

	private final W_WfRepository dao;

	private final W_Wf_PasosRepository daoStep;

	private final W_Wf_Pas_DocRepository daoStepDoc;

	private final W_Wf_Pas_AutRepository daoStepAut;

	private final W_Wf_EstRepository daoEst;

	private final IWfParameterMapper mapper;

	private final IWfStepParameterMapper mapperStep;

	private final IWfStepDocParameterMapper mapperStepDoc;

	private final IWfStepAutParameterMapper mapperStepAut;

	private final IWfEstParameterMapper mapperEst;

	private final IUserService usuarioService;

	@Value("${database.scheme.1}")
	private String schemeFirst;

	@Value("${database.scheme.2}")
	private String schemeSecond;

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	public WFParameterService(W_WfRepository repository, W_Wf_PasosRepository daoStep, IWfParameterMapper mapper,
			IWfStepParameterMapper mapperStep, IUserService usuarioService, IWfStepDocParameterMapper mapperStepDoc,
			IWfStepAutParameterMapper mapperStepAut, W_Wf_Pas_DocRepository daoStepDoc,
			W_Wf_Pas_AutRepository daoStepAut, W_Wf_EstRepository daoEst, IWfEstParameterMapper mapperEst) {
		super();
		this.dao = repository;
		this.daoStep = daoStep;
		this.mapper = mapper;
		this.mapperStep = mapperStep;
		this.usuarioService = usuarioService;
		this.mapperStepDoc = mapperStepDoc;
		this.mapperStepAut = mapperStepAut;
		this.daoStepDoc = daoStepDoc;
		this.daoStepAut = daoStepAut;
		this.daoEst = daoEst;
		this.mapperEst = mapperEst;

	}

	@Override
	public List<DTOWFParameter> listAll() {
		return mapper.mapperList(dao.findAll());
	}

	@Override
	public List<DTOWFParameterStep> listSteps(String id) {
		return mapperStep.mapperList(daoStep.findByWf(id));
	}

	@Override
	public DTOWFParameterStep create(DTOWFParameterStep o) {

		long idPaso = (long) daoStep.getKey();
		o.setUsuCrea(usuarioService.getInternalUser(o.getUsuCrea()));
		o.setIdPaso(idPaso);
		DTOWFParameterStep response = mapperStep.mapperDaoToDto(daoStep.save(mapperStep.mapperDtoToDao(o)));

		updateDocs(o);
		updateAut(o.getAuts());
		return response;
	}

	@Override
	public DTOWFParameterStepAut createAut(DTOWFParameterStepAut o) {

		o.setUsuCrea(usuarioService.getInternalUser(o.getUsuCrea()));
		DTOWFParameterStepAut response = mapperStepAut.mapperDaoToDto(daoStepAut.save(mapperStepAut.mapperDtoToDao(o)));
		return response;
	}

	@Override
	public DTOWFParameterStep delete(DTOWFParameterStep o) {
		daoStep.delete(mapperStep.mapperDtoToDao(o));
		return o;
	}

	@Override
	public DTOWFParameterStep update(DTOWFParameterStep o) {

		Optional<W_Wf_Pasos> old = daoStep.findById(new W_Wf_PasosPK((long) o.getIdWf(), (long) o.getIdPaso()));
		o.setFecUltMod(new Date());
		o.setFecCrea(old.get().getFecCrea());
		o.setUsuCrea(old.get().getUsuCrea());
		o.setUsuUltMod(usuarioService.getInternalUser(o.getUsuUltMod()));

		DTOWFParameterStep response = mapperStep.mapperDaoToDto(daoStep.save(mapperStep.mapperDtoToDao(o)));
		updateDocs(o);
		return response;
	}

	private void updateDocs(DTOWFParameterStep o) {
		if (o.getDocs() != null && o.getDocs().size() > 0) {
			for (DTOWFParameterStepDoc doc : o.getDocs()) {
				if (doc.getIdDocumento() == null) {
					long id = (long) daoStepDoc.getKey();
					doc.setIdDocumento(id);
					doc.setIdWf(o.getIdWf());
					doc.setIdPaso(o.getIdPaso());
					doc.setUsuCrea((o.getUsuCrea()));
					doc.setIndObligatorio(
							(null != doc.getIndObligatorio() && doc.getIndObligatorio().equals("true")) ? "S" : "N");
					doc.setEnvRec((null != doc.getEnvRec() && doc.getEnvRec().equals("true")) ? "S" : "N");
					daoStepDoc.save(mapperStepDoc.mapperDtoToDao(doc));
				}
			}
		}
	}

	private void updateAut(ArrayList<DTOWFParameterStepAut> auts) {
		if (auts != null && auts.size() > 0) {
			for (DTOWFParameterStepAut aut : auts) {
				daoStepAut.save(mapperStepAut.mapperDtoToDao(aut));
			}
		}
	}

	@Override
	public List<DTOWFParameterStepDoc> listStepsDoc(String id, String ipStep) {
		return mapperStepDoc.mapperList(daoStepDoc.findByWfAndStep(id, ipStep));
	}

	@Override
	public List<DTOWFParameterStepAut> listStepsAut(String id, String ipStep) {
		List<Object[]> users = daoStepAut.findByUsuarioByStep(id, ipStep);
		List<DTOWFParameterStepAut> response = new ArrayList<>();
		for (Object[] obj : users) {
			response.add(new DTOWFParameterStepAut(Long.parseLong(id), Long.parseLong(ipStep), obj[0] + "", obj[1] + "",
					"", null, null, "", Boolean.parseBoolean(obj[2] + "")));
		}
		return response;
	}

	@Override
	public DTOWFParameterStepDoc deleteDoc(String id, String ipStep, String idDoc) {
		DTOWFParameterStepDoc doc = new DTOWFParameterStepDoc(Long.parseLong(id), Long.parseLong(ipStep),
				Long.parseLong(idDoc), "", "", "", null, null, "", "");
		daoStepDoc.delete(mapperStepDoc.mapperDtoToDao(doc));
		return doc;
	}

	@Override
	public DTOWFParameterStepAut deleteAut(String id, String ipStep, String idAut) {
		DTOWFParameterStepAut o = new DTOWFParameterStepAut(Long.parseLong(id), Long.parseLong(ipStep), idAut, "", "",
				null, null, "", false);
		daoStepAut.delete(mapperStepAut.mapperDtoToDao(o));
		return o;
	}

	@Override
	public List<DTOWFParameterEst> listEsts(String id) {
		return mapperEst.mapperList(daoEst.findByWf(id));
	}

	@Override
	public DTOWFParameterEst createEst(DTOWFParameterEst o) {
		long id = (long) daoEst.getKey();
		o.setUsuCrea(usuarioService.getInternalUser(o.getUsuCrea()));
		o.setIdEstado(id);
		o.setFecCrea(new Date());
		return mapperEst.mapperDaoToDto(daoEst.save(mapperEst.mapperDtoToDao(o)));
	}

	@Override
	public DTOWFParameterEst updateEst(DTOWFParameterEst o) {
		Optional<W_Wf_Est> old = daoEst.findById(new W_Wf_EstPK((long) o.getIdWf(), (long) o.getIdEstado()));

		o.setFecUltMod(new Date());
		o.setFecCrea(old.get().getFecCrea());
		o.setUsuCrea(old.get().getUsuCrea());
		o.setUsuUltMod(usuarioService.getInternalUser(o.getUsuUltMod()));

		return mapperEst.mapperDaoToDto(daoEst.save(mapperEst.mapperDtoToDao(o)));
	}

	@Override
	public DTOWFParameterEst deleteEst(String id, String ipEst) {
		DTOWFParameterEst est = new DTOWFParameterEst(Long.parseLong(id), Long.parseLong(ipEst), "", false, false, null,
				"", null, null, "");
		daoEst.delete(mapperEst.mapperDtoToDao(est));
		return est;
	}

	@Override
	public List<DTOWFParameterStep> stepsbyNumRad(Integer wf, Integer numRad) {
		return mapperStep.mapperList(daoStep.findByWfByNumRad(wf, numRad));

	}

	@Override
	public DTOWFParameterStepAut validStepByUser(String wf, String step, String user) {
		Boolean userHasStep = daoStepAut.findByUserByStep(wf, step, user);
		if (null == userHasStep)
			throw new UnauthorizedException(Constantes.MESSAGE_USER_NO_FOUND);
		return new DTOWFParameterStepAut();
	}

	@Override
	public List<DTOWalletUser> getPortafolio(String codTer) {
		return mapperStep.mapperEntitiePortafolioToDto(dao.findPortafolio(codTer));

	}

	@Override
	public List<DTOWalletUser> getPortafolioWk1(String codTer) {
		return mapperStep.mapperEntitiePortafolioToDto(dao.findPortafolioWf1(codTer));
	}

	@Override
	public List<DTOWalletUser> getPortafolioWk2(String codTer) {
		return mapperStep.mapperEntitiePortafolioToDto(dao.findPortafolioWf2(codTer));
	}

	@Override
	public List<DTOStepsState> getStepsState(String codTer, String numRad, String idWf) {
		return mapperStep.mapperEntitieSteptStateToDto(dao.findSteptsState(codTer, numRad, idWf));
	}

	@Override
	public List<DTOWalletUser> getBriefcase(String user) {

		List<Object[]> briefcase = new ArrayList<>();
		briefcase.addAll(getPortafolioByScheme(schemeFirst, user));
		briefcase.addAll(getPortafolioByScheme(schemeSecond, user));
		List<DTOWalletUser> portafoleoBeforeFees = mapperStep.mapperEntitiePortafolioToDtoFull(briefcase);
		return addDues(portafoleoBeforeFees);
	}

	@SuppressWarnings({ "unchecked" })
	private List<Object[]> getPortafolioByScheme(String scheme, String user) {

		List<Object[]> portafolio = new ArrayList<>();
		DTOTerceros tercero = usuarioService.findByNiterAndSchema(scheme, user);
		if (tercero != null) {
			Query querySchemeSecond = entityManager
					.createNativeQuery(W_WfRepository.getQueryBriefcase(scheme, tercero.getCodTer().toString()));
			portafolio = querySchemeSecond.getResultList();
		}

		return portafolio;

	}

	private List<DTOWalletUser> addDues(List<DTOWalletUser> wallet) {
		LocalDateTime ahora = LocalDateTime.now();
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String now = ahora.format(formatter);

		for (DTOWalletUser w : wallet) {
			Query query = entityManager.createNativeQuery(W_WfRepository.getFeesCaused(w.getScheme(), w.getNumeroCredito(), now));
			long cuoCau = ((Number) query.getSingleResult()).longValue();
			w.setCuoCau(cuoCau + "");
			
			Query queryFeesCollected = entityManager.createNativeQuery(W_WfRepository.getFeesCollected(w.getScheme(), w.getNumeroCredito(), now));
			long cuoPag = ((Number) queryFeesCollected.getSingleResult()).longValue();
			w.setCuoPag(cuoPag + "");
		
			long cuoMora=0;
			if(cuoPag<cuoCau) {
				cuoMora =cuoCau - cuoPag;
			}
			
			w.setCuoMora(cuoMora+"");
			
	
			
		}
		return wallet;
	}}
