package com.jarzsoft.service;

import java.util.List;

import com.jarzsoft.dto.DTOWFParameter;
import com.jarzsoft.dto.DTOWFParameterEst;
import com.jarzsoft.dto.DTOWFParameterStep;
import com.jarzsoft.dto.DTOWFParameterStepAut;
import com.jarzsoft.dto.DTOWFParameterStepDoc;

public interface IWFParameterService {

	List<DTOWFParameter> listAll();

	List<DTOWFParameterStep> listSteps(String id);

	List<DTOWFParameterEst> listEsts(String id);

	List<DTOWFParameterStepDoc> listStepsDoc(String id, String ipStep);

	List<DTOWFParameterStepAut> listStepsAut(String id, String ipStep);

	DTOWFParameterStep create(DTOWFParameterStep o);

	DTOWFParameterStepAut createAut(DTOWFParameterStepAut o);

	DTOWFParameterEst createEst(DTOWFParameterEst o);

	DTOWFParameterStep update(DTOWFParameterStep o);

	DTOWFParameterEst updateEst(DTOWFParameterEst o);

	DTOWFParameterEst deleteEst(String id, String ipEst);

	DTOWFParameterStepDoc deleteDoc(String id, String ipStep, String idDoc);

	DTOWFParameterStepAut deleteAut(String id, String ipStep, String idAut);

	DTOWFParameterStep delete(DTOWFParameterStep o);

	List<DTOWFParameterStep> stepsbyNumRad(Integer numRad);

	DTOWFParameterStepAut validStepByUser(String wf,String step,String user);

}
