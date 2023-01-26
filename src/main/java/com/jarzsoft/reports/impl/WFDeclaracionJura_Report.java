package com.jarzsoft.reports.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.service.ICiudadesService;
import com.jarzsoft.service.IReportStrategy;
import com.jarzsoft.util.Comunes;
import com.jarzsoft.util.Constantes;
import com.jarzsoft.util.EnumReport;

@Component
public class WFDeclaracionJura_Report implements IReportStrategy {

	private final ICiudadesService ciudadesService;

	@Autowired
	public WFDeclaracionJura_Report(ICiudadesService ciudadesService) {
		super();
		this.ciudadesService = ciudadesService;

	}

	@Override
	public String getType() {
		return EnumReport.TIPO_REPORTE.REPORT_DECLARACION_JURA.getName();
	}

	@Async
	@Override
	public Boolean create(DTOWF o, String user, String path) {

		Map<String, Object> param = new HashMap<String, Object>();

		param.put("nomTer", o.getNomTer() + " " + o.getPriApellido() + " " + o.getSegApellido());
		param.put("ciudadautoriza", "");
		param.put("codiCiud", ciudadesService.getCiudad(Integer.parseInt(o.getCodiCiud())).getName());
		param.put("nitter", o.getNitter());
		param.put("pagare", "");
		param.put("valorletras", "");
		param.put("valor", "");

		Comunes.crearJasperReport(path, Constantes.REPORTE_DECLARACION_JURA, param,
				EnumReport.TIPO_REPORTE.REPORT_DECLARACION_JURA.getName(), o.getNumeroRadicacion() + "");

		return true;
	}

	@Override
	public Boolean join(DTOWF o, String path) {
		return false;
	}

}
