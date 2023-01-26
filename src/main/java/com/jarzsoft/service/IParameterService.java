package com.jarzsoft.service;

import java.util.List;

import com.jarzsoft.dto.DTOParameter;

public interface IParameterService extends ICRUD<DTOParameter> {

	DTOParameter delete(DTOParameter id);

	List<DTOParameter> getById(String paramId);

	DTOParameter getSingleById(String paramId, String paramText);

}
