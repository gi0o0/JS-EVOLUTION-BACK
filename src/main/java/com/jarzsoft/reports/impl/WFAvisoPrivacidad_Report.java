package com.jarzsoft.reports.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.service.ICiudadesService;
import com.jarzsoft.service.IReportStrategy;
import com.jarzsoft.util.Comunes;
import com.jarzsoft.util.Constantes;
import com.jarzsoft.util.EnumReport;

@Component
public class WFAvisoPrivacidad_Report implements IReportStrategy {

	private final ICiudadesService ciudadesService;

	@Autowired
	public WFAvisoPrivacidad_Report(ICiudadesService ciudadesService) {
		super();
		this.ciudadesService = ciudadesService;
	}

	@Override
	public String getType() {
		return EnumReport.TIPO_REPORTE.REPORT_AVISO_PRI.getName();
	}

	@Override
	public Boolean create(DTOWF o, String user, String path) {

		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		String year = calendar.get(Calendar.YEAR) + "";

		Map<String, Object> param = new HashMap<String, Object>();

		param.put("nomTer", o.getNomTer() + " " + o.getPriApellido() + " " + o.getSegApellido());
		param.put("nitter", o.getNitter());
		if (null != o.getCodeu() && null != o.getCodeu().getNitter()) {
			param.put("nomTer_codeu", o.getCodeu().getNomTer() + " " + o.getCodeu().getPriApellido() + " "
					+ o.getCodeu().getSegApellido());		
			param.put("codiCiud2",(null != o.getCodeu().getLugarDoc() ? o.getCodeu().getLugarDoc()	: " "));			
			param.put("nitter_codeu", o.getCodeu().getNitter());
		} else {
			param.put("nomTer_codeu", " ");
			param.put("codiCiud2", " ");
			param.put("nitter_codeu", " ");
		}
		param.put("codiCiud",(null != o.getLugarDoc() ? o.getLugarDoc()	: " "));	
		param.put("año", year);
		param.put("empresa", "");
		param.put("dia", calendar.get(Calendar.DAY_OF_MONTH) + "");
		param.put("mes", calendar.get(Calendar.MONTH) + 1 + "");

		Comunes.crearJasperReport(path, Constantes.REPORTE_AVISO_PRI, param,
				EnumReport.TIPO_REPORTE.REPORT_AVISO_PRI.getName(), o.getNumeroRadicacion() + "");

		return true;
	}

	@Override
	public Boolean join(DTOWF o, String path) {
		return false;
	}

}
