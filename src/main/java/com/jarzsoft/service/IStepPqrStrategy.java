package com.jarzsoft.service;

import com.jarzsoft.dto.DTOWFPqr;

public interface IStepPqrStrategy {

	DTOWFPqr apply(DTOWFPqr o, String user);

	String getType();

}
