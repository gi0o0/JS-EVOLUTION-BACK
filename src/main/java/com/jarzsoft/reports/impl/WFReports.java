package com.jarzsoft.reports.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.service.IReportStrategy;

@Service
public class WFReports implements IReportesService {

	private final Map<String, IReportStrategy> map;

	@Autowired
	public WFReports(List<IReportStrategy> reportStrategies, Map<String, IReportStrategy> map) {
		super();
		this.map = map;
		reportStrategies.forEach(report -> map.put(report.getType(), report));
	}

	@Override
	public Boolean create(DTOWF o, String user, String typeReport,String path) {

		return this.map.get(typeReport).create(o, user,path);
	}

	@Override
	public Boolean join() {
		return null;
	}

}
