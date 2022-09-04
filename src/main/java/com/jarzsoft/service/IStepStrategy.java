package com.jarzsoft.service;

import com.jarzsoft.dto.DTOWF;

public interface IStepStrategy {

	DTOWF apply(DTOWF o, String user);

	String getType();

}
