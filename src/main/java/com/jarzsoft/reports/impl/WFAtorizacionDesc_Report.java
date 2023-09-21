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

	@Override
	public Boolean create(DTOWF o, String user, String path) {

		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);

		Map<String, Object> param = new HashMap<String, Object>();

		param.put("nomTer", o.getNomTer() + " " + o.getPriApellido() + " " + o.getSegApellido());
		param.put("nitter", o.getNitter());
		param.put("codiCiud",
				(null != o.getCodiCiud() ? ciudadesService.getCiudad(Integer.parseInt(o.getCodiCiud())).getName()
						: ""));
		if (null != o.getCodeu() && null != o.getCodeu().getNitter()) {
			param.put("nomTer_codeu", o.getCodeu().getNomTer() + " " + o.getCodeu().getPriApellido() + " "
					+ o.getCodeu().getSegApellido());
			param.put("nitter_codeu", o.getCodeu().getNitter());
			param.put("codiCiud2",
					(null != o.getCodeu().getCodiCiud()
							? ciudadesService.getCiudad(Integer.parseInt(o.getCodeu().getCodiCiud())).getName()
							: ""));
		} else {
			param.put("nomTer_codeu", " ");
			param.put("nitter_codeu", " ");
			param.put("codiCiud2", " ");
		}

		param.put("año", " ");
		param.put("dia", " ");
		param.put("mes", " ");
		param.put("ciudadautoriza", " ");
		param.put("pagare", o.getSolPagare());
		param.put("calidad", " ");
		param.put("valorletras", " ");
		param.put("valor", " ");
		param.put("meses", " ");
		param.put("mesesletras", " ");
		param.put("fechainicio", " ");
		param.put("empresa", " ");

		Comunes.crearJasperReport(path, Constantes.REPORTE_AUTO_DESC, param,
				EnumReport.TIPO_REPORTE.REPORT_AUTO_DESC.getName(), o.getNumeroRadicacion() + "");

		return true;
	}

	@Override
	public Boolean join(DTOWF o, String path) {
		return false;
	}

}
