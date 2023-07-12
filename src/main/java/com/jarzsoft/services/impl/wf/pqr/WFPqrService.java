package com.jarzsoft.services.impl.wf.pqr;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOWFParameterStep;
import com.jarzsoft.dto.DTOWFPqr;
import com.jarzsoft.dto.DTOWWfMov;
import com.jarzsoft.dto.DTOWalletUser;
import com.jarzsoft.mapper.IWfMapper;
import com.jarzsoft.service.IStepPqrStrategy;
import com.jarzsoft.service.IUserService;
import com.jarzsoft.service.IWFParameterService;
import com.jarzsoft.service.IWFPqrService;
import com.jarzsoft.service.IWWfMovService;

@Service
public class WFPqrService implements IWFPqrService {

	@PersistenceContext
	private EntityManager entityManager;

	private final Map<String, IStepPqrStrategy> map;

	private final IWWfMovService wWfMovService;

	private final IWFParameterService wpParameterService;

	private final IWfMapper mapper;

	private final IUserService userService;

	@Autowired
	public WFPqrService(List<IStepPqrStrategy> stepStrategies, Map<String, IStepPqrStrategy> map, IWfMapper mapper,
			IWWfMovService wWfMovService, IWFParameterService wpParameterService, IUserService userService) {
		super();
		this.map = map;
		this.mapper = mapper;
		this.wWfMovService = wWfMovService;
		this.wpParameterService = wpParameterService;
		this.userService = userService;
		stepStrategies.forEach(step -> map.put(step.getType(), step));
	}

	@Override
	public DTOWFPqr create(DTOWFPqr o, String user) {

		this.map.get(o.getNextStep()).apply(o, user);
		return o;
	}

	@Override
	public DTOWFPqr getById(Integer id) {
		return null;
	}

	@Override
	public List<DTOWFPqr> listAllByUser(String user) {

		List<DTOWFPqr> out = new ArrayList<>();
		List<DTOWWfMov> o = wWfMovService.findMovByUser(user);

		for (DTOWWfMov in : o) {
			out.add(mapper.mapperDaoToDto(in));
		}

		return out;

	}

	@Override
	public DTOWFPqr updateState(DTOWFPqr o) {
		wWfMovService.updateState(o.getNumeroRadicacion(), o.getState());
		return o;
	}

	@Override
	public DTOWFPqr getByNumRadAndStep(Integer numRad, Integer idStep, Integer idWf) {
		DTOWFPqr out = new DTOWFPqr();
		List<DTOWWfMov> movs = wWfMovService.findListMovByNumRad(numRad, idWf + "", idStep.toString());

		if (movs.size() > 0) {
			DTOWWfMov mov = movs.get(0);
			out = mapper.mapperDaoToDto(mov);
			out = mapper.mapperDaoTerceroToDto(userService.findByNiter(mov.getNitTer()), out);
			out.setMovs(movs);
		}

		return out;

	}

	@Override
	public List<DTOWFParameterStep> stepsbyNumRad(Integer numRad) {

		return wpParameterService.stepsbyNumRad(numRad);
	}

	@Override
	public List<DTOWalletUser> getPortafolio(String codTer, String wf) {

		if ("1".equals(wf)) {
			return wpParameterService.getPortafolioWk1(codTer);
		}

		return wpParameterService.getPortafolioWk2(codTer);
	}

}
