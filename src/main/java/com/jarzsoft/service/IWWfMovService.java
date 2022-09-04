package com.jarzsoft.service;

import com.jarzsoft.dto.DTOWWfMov;
import com.jarzsoft.entities.WWfMov;

public interface IWWfMovService {

	DTOWWfMov create(DTOWWfMov o);

	WWfMov findMovByNumRad(Integer numero_radicacion, String id_wf, String id_paso);

}
