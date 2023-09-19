package com.jarzsoft.reports.impl;

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
public class WFDeclaracionRecep_Report implements IReportStrategy {

	private final ICiudadesService ciudadesService;

	@Autowired
	public WFDeclaracionRecep_Report(ICiudadesService ciudadesService) {
		super();
		this.ciudadesService = ciudadesService;

	}

	@Override
	public String getType() {
		return EnumReport.TIPO_REPORTE.REPORT_DECLARACION_RECEP.getName();
	}

	@Override
	public Boolean create(DTOWF o, String user, String path) {

		Map<String, Object> param = new HashMap<String, Object>();

		param.put("priApellido", o.getPriApellido() + " " + o.getSegApellido());
		param.put("nomTer", o.getNomTer() + " " + o.getPriApellido() + " " + o.getSegApellido());
		param.put("nitter", o.getNitter());
		param.put("tasa", o.getTasaInt());

		if (null != o.getCodeu()) {
			param.put("priApellido_codeu", o.getCodeu().getPriApellido() + " " + o.getCodeu().getSegApellido());
			param.put("lugarDoc_codeu",
					(null != o.getCodeu().getCodiCiud()
							? ciudadesService.getCiudad(Integer.parseInt(o.getCodeu().getCodiCiud())).getName()
							: ""));
			param.put("nitter_codeu", o.getCodeu().getNitter());
			param.put("telTer_codeu", o.getCodeu().getTelTer());
			param.put("mailTer_codeu", o.getCodeu().getMailTer());
			param.put("nomTer_codeu", o.getCodeu().getNomTer() + " " + o.getCodeu().getPriApellido() + " "
					+ o.getCodeu().getSegApellido());

		}else
		{
			param.put("priApellido_codeu", " ");
			param.put("lugarDoc_codeu"," ");
			param.put("nitter_codeu", " ");
			param.put("telTer_codeu", " ");
			param.put("mailTer_codeu", " ");
			param.put("nomTer_codeu", " ");
		}

		Comunes.crearJasperReport(path, Constantes.REPORTE_DECLARACION_RECEPCION, param,
				EnumReport.TIPO_REPORTE.REPORT_DECLARACION_RECEP.getName(), o.getNumeroRadicacion() + "");

		return true;
	}

	@Override
	public Boolean join(DTOWF o, String path) {
		return false;
	}

}
