package com.jarzsoft.reports.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.service.IReportStrategy;
import com.jarzsoft.util.Comunes;
import com.jarzsoft.util.Constantes;
import com.jarzsoft.util.EnumReport;

@Component
public class WFDeclaracionInfo_Report implements IReportStrategy {

	@Autowired
	public WFDeclaracionInfo_Report() {
		super();
	}

	@Override
	public String getType() {
		return EnumReport.TIPO_REPORTE.REPORT_DECLARACION_INFO.getName();
	}

	
	@Override
	public Boolean create(DTOWF o, String user, String path) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("nomTer", o.getNomTer() + " " + o.getPriApellido() + " " + o.getSegApellido());
		param.put("nitter", o.getNitter());
		param.put("mandante", "");
		Comunes.crearJasperReport(path, Constantes.REPORTE_DECLARACION_INFO, param,
				EnumReport.TIPO_REPORTE.REPORT_DECLARACION_INFO.getName(), o.getNumeroRadicacion() + "");
		return true;
	}

	@Override
	public Boolean join(DTOWF o, String path) {
		return false;
	}

}
