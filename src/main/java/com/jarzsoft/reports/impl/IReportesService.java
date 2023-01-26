package com.jarzsoft.reports.impl;

import com.jarzsoft.dto.DTOWF;

public interface IReportesService {

	Boolean create(DTOWF o, String user,String typeReport,String path);

	Boolean join();

}
