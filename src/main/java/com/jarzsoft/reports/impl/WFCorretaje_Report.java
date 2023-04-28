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
import com.jarzsoft.service.IUserWebService;
import com.jarzsoft.util.Comunes;
import com.jarzsoft.util.Constantes;
import com.jarzsoft.util.EnumReport;

@Component
public class WFCorretaje_Report implements IReportStrategy {

	private final IUserWebService userWebService;
	private final ICiudadesService ciudadesService;
	
	@Autowired
	public WFCorretaje_Report(IUserWebService userWebService,ICiudadesService ciudadesService) {
		super();
		this.userWebService = userWebService;
		this.ciudadesService = ciudadesService;

	}

	@Override
	public String getType() {
		return EnumReport.TIPO_REPORTE.REPORT_CORRETAJE.getName();
	}

	
	@Override
	public Boolean create(DTOWF o, String user, String path) {

		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);

		Map<String, Object> param = new HashMap<String, Object>();

		param.put("nomTer", o.getNomTer() + " " + o.getPriApellido() + " " + o.getSegApellido());
		if (null != o.getCodeu()) {
			param.put("nomTer_codeu",o.getCodeu().getNomTer() + " " + o.getCodeu().getPriApellido() + " " + o.getCodeu().getSegApellido());
		}

		param.put("año", calendar.get(Calendar.YEAR) + "");
		param.put("dia", calendar.get(Calendar.DAY_OF_MONTH) + "");
		param.put("mes", calendar.get(Calendar.MONTH) + 1 + "");
		param.put("mandante", "");
		
		
		param.put("Nitter", o.getNitter() );
		param.put("name_asesor", userWebService.getUserById((user)).getNom_usuario());
		param.put("id_asesor", user);
		param.put("codiCiud", ciudadesService.getCiudad(Integer.parseInt(o.getCodiCiud())).getName());
		

		Comunes.crearJasperReport(path, Constantes.REPORTE_CORRETAJE, param,
				EnumReport.TIPO_REPORTE.REPORT_CORRETAJE.getName(), o.getNumeroRadicacion() + "");

		return true;
	}

	@Override
	public Boolean join(DTOWF o, String path) {
		return false;
	}

}
