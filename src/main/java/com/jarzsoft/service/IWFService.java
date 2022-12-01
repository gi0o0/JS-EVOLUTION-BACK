package com.jarzsoft.service;

import java.util.List;

import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.dto.DTOWFParameterStep;
import com.jarzsoft.dto.DTOWFParameterStepAut;

public interface IWFService {

	DTOWF create(DTOWF o, String user);

	DTOWF updateState(DTOWF o);

	DTOWF getByNumRadAndStep(Integer numRad, Integer idStep, Boolean isLight);

	DTOWF getById(Integer id);

	List<DTOWF> listAllByUser(String user);

	List<DTOWFParameterStep> stepsbyNumRad(Integer numRad);


}
