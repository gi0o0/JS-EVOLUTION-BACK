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
import com.jarzsoft.service.ICiudadesService;

@Component
public class WFContratoMutuo_Report implements IReportStrategy {
	private final ICiudadesService ciudadesService;

	@Autowired
	public WFContratoMutuo_Report(ICiudadesService ciudadesService) {
		super();
		this.ciudadesService = ciudadesService;
	}

	@Override
	public String getType() {
		return EnumReport.TIPO_REPORTE.REPORT_CONTRATO_MUTUO.getName();
	}

	@Override
	public Boolean create(DTOWF o, String user, String path) {

		Map<String, Object> param = new HashMap<String, Object>();

		param.put("monto_aprob", "");
		param.put("priApellido", o.getPriApellido() + " " + o.getSegApellido());
		param.put("nomTer", o.getNomTer() + " " + o.getPriApellido() + " " + o.getSegApellido());
		param.put("nitter", o.getNitter());
		param.put("codiCiud",
				(null != o.getCodiCiud() ? ciudadesService.getCiudad(Integer.parseInt(o.getCodiCiud())).getName()
						: " "));
		if (null != o.getCodeu() && null != o.getCodeu().getNitter()) {
			param.put("priApellido_codeu", o.getCodeu().getPriApellido() + " " + o.getCodeu().getSegApellido());
			param.put("nomTer_codeu", o.getCodeu().getNomTer() + " " + o.getCodeu().getPriApellido() + " "
					+ o.getCodeu().getSegApellido());
			param.put("nitter_codeu", o.getCodeu().getNitter());
			param.put("codiCiud_codeu",
					(null != o.getCodeu().getCodiCiud()
							? ciudadesService.getCiudad(Integer.parseInt(o.getCodeu().getCodiCiud())).getName()
							: " "));
		} else {
			param.put("priApellido_codeu", " ");
			param.put("nomTer_codeu", " ");
			param.put("nitter_codeu", " ");
			param.put("codiCiud_codeu", " ");
		}

		param.put("lugarDoc_codeu", " ");
		param.put("vlrCuotas", " ");
		param.put("codiCiud2", " ");
		param.put("codiCiudDom", " ");
		param.put("AsigMensual", " ");
		param.put("AsigMensualDu", " ");
		param.put("AsigMensualDu2", " ");
		param.put("ApartirDe", " ");
		param.put("pagar_a", " ");
		param.put("dia_mes", " ");
		param.put("año", " ");
		param.put("solpagare", o.getSolPagare());
		param.put("valorPress", " ");
		param.put("nroCuotas", " ");
		param.put("perCuota", " ");
		param.put("dirTerpal", " ");

		Comunes.crearJasperReport(path, Constantes.REPORTE_CONTRATO_MUTUO, param,
				EnumReport.TIPO_REPORTE.REPORT_CONTRATO_MUTUO.getName(), o.getNumeroRadicacion() + "");

		return true;
	}

	@Override
	public Boolean join(DTOWF o, String path) {
		return false;
	}

}
