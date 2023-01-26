package com.jarzsoft.service;

import com.jarzsoft.dto.DTOWF;

public interface IReportStrategy {

	Boolean create(DTOWF o, String user, String path);

	Boolean join(DTOWF o, String path);

	String getType();

}
