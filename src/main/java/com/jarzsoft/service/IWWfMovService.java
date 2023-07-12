package com.jarzsoft.service;

import java.util.List;

import com.jarzsoft.dto.DTOSolCredito;
import com.jarzsoft.dto.DTOWWfMov;
import com.jarzsoft.entities.WWfMov;

public interface IWWfMovService {

	DTOWWfMov create(DTOWWfMov o);

	DTOWWfMov createOtherRecord(DTOWWfMov o);

	WWfMov findMovByNumRad(Integer numero_radicacion, String id_wf, String id_paso);

	List<DTOWWfMov> findListMovByNumRad(Integer numero_radicacion, String id_wf, String id_paso);

	DTOWWfMov findMovByNumRadAndStep(Integer numero_radicacion, String id_wf, String id_paso);

	DTOWWfMov createMovWithSteps(DTOSolCredito out, String user, String stepValue, Boolean isUpdate, String idWF);

	DTOWWfMov createMovOtherRecord(DTOSolCredito out, String user, String stepValue, Boolean isUpdate, String idWF);

	Integer findMaxMovByNumRad(Integer numero_radicacion, String id_wf);

	List<DTOWWfMov> findMovByUser(String user);

	Integer updateState(Integer numRad, String estado);

}
