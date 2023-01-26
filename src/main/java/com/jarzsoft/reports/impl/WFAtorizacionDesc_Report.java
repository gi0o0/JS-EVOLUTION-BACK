package com.jarzsoft.reports.impl;

import java.util.Calendar;
import java.util.Date;
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
public class WFAtorizacionDesc_Report implements IReportStrategy {

	private final ICiudadesService ciudadesService;

	@Autowired
	public WFAtorizacionDesc_Report(ICiudadesService ciudadesService) {
		super();
		this.ciudadesService = ciudadesService;

	}

	@Override
	public String getType() {
		return EnumReport.TIPO_REPORTE.REPORT_AUTO_DESC.getName();
	}

	@Async
	@Override
	public Boolean create(DTOWF o, String user, String path) {

		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);

		Map<String, Object> param = new HashMap<String, Object>();

		param.put("nomTer", o.getNomTer() + " " + o.getPriApellido() + " " + o.getSegApellido());
		param.put("nitter", o.getNitter());
		param.put("codiCiud", ciudadesService.getCiudad(Integer.parseInt(o.getCodiCiud())).getName());
		param.put("nomTer_codeu",
				o.getCodeu().getNomTer() + " " + o.getCodeu().getPriApellido() + " " + o.getCodeu().getSegApellido());
		param.put("nitter_codeu", o.getCodeu().getNitter());
		param.put("codiCiud2", ciudadesService.getCiudad(Integer.parseInt(o.getCodeu().getCodiCiud())).getName());
		param.put("año", calendar.get(Calendar.YEAR) + "");
		param.put("dia", calendar.get(Calendar.DAY_OF_MONTH) + "");
		param.put("mes", calendar.get(Calendar.MONTH) + 1 + "");
		param.put("ciudadautoriza", "");
		param.put("pagare", "");
		param.put("calidad", "");
		param.put("valorletras", "");
		param.put("valor", "");
		param.put("meses", "");
		param.put("mesesletras", "");
		param.put("fechainicio", "");

		Comunes.crearJasperReport(path, Constantes.REPORTE_AUTO_DESC, param,
				EnumReport.TIPO_REPORTE.REPORT_AUTO_DESC.getName(), o.getNumeroRadicacion() + "");

		return true;
	}

	@Override
	public Boolean join(DTOWF o, String path) {
		return false;
	}

}
