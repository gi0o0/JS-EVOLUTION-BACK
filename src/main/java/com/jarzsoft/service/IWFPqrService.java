package com.jarzsoft.service;

import java.util.List;

import com.jarzsoft.dto.DTOWFFilter;
import com.jarzsoft.dto.DTOWFParameterStep;
import com.jarzsoft.dto.DTOWFPqr;
import com.jarzsoft.dto.DTOWalletUser;

public interface IWFPqrService {

	DTOWFPqr create(DTOWFPqr o, String user);

	DTOWFPqr updateState(DTOWFPqr o);

	DTOWFPqr getByNumRadAndStep(Integer numRad, Integer idStep, Integer idWf);

	DTOWFPqr getById(Integer id);

	List<DTOWFPqr> listAllByUser(String user);

	List<DTOWFParameterStep> stepsbyNumRad(Integer idWf, Integer numRad);

	List<DTOWalletUser> getPortafolio(String codTer, String wf);
	
	List<DTOWFPqr> listAllByFilters(DTOWFFilter o, String user);

}
