package com.jarzsoft.service;

import java.util.List;

import com.jarzsoft.dto.DTOStepsState;
import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.dto.DTOWFFilter;
import com.jarzsoft.dto.DTOWFParameterStep;
import com.jarzsoft.dto.DTOWalletUser;

public interface IWFService {

	DTOWF create(DTOWF o, String user);

	DTOWF updateState(DTOWF o);

	DTOWF getByNumRadAndStep(Integer numRad, Integer idStep, Boolean isLight);

	DTOWF getById(Integer id);

	List<DTOWF> listAllByUser(String user);

	List<DTOWFParameterStep> stepsbyNumRad(Integer numRad);

	List<DTOWalletUser> getPortafolio(String codTer);

	List<DTOStepsState> getStepsState(String codTer, String numRad, String idWf);

	List<DTOWF> listAllByFilters(DTOWFFilter o,String user);

}
