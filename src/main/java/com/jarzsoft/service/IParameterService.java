package com.jarzsoft.service;

import com.jarzsoft.dto.DTOParameter;

public interface IParameterService extends ICRUD<DTOParameter> {
	
	DTOParameter delete(DTOParameter id);

}
