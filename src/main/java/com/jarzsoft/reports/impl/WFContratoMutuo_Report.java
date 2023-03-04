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

		param.put("valorPress", String.valueOf(o.getValorPress()));
		param.put("perCuota", o.getPerCuota());
		param.put("nroCuotas", o.getNroCuotas());
		param.put("monto_aprob", "");
		param.put("priApellido", o.getPriApellido() + " " + o.getSegApellido());
		param.put("nomTer", o.getNomTer() + " ");
		param.put("nitter", o.getNitter());
		param.put("telTer", o.getTelTer() + " , " + o.getTelTer1() + " , " + o.getTelTer2());
		param.put("mailTer", o.getMailTer());
		param.put("dirTerpal", o.getDirTerpal());
		param.put("codiCiud", ciudadesService.getCiudad(Integer.parseInt(o.getCodiCiud())).getName());
		param.put("priApellido_codeu", o.getCodeu().getPriApellido() + " " + o.getCodeu().getSegApellido());
		param.put("nomTer_codeu", o.getCodeu().getNomTer());
		param.put("lugarDoc_codeu", "");
		param.put("nitter_codeu", o.getCodeu().getNitter());
		param.put("telTer_codeu", o.getCodeu().getTelTer());
		param.put("mailTer_codeu", o.getCodeu().getMailTer());
		param.put("dirTerpal_codeu", o.getCodeu().getDirTerpal());
		param.put("telTer_codeu_resi", "");
		param.put("dirTeralt_codeu", o.getCodeu().getDirTeralt());
		param.put("codiCiud_codeu",
				ciudadesService.getCiudad(Integer.parseInt(o.getCodeu().getCiuDirTrabajo())).getName());
		param.put("vlrCuotas", "");
		param.put("codiCiud2", "");
		param.put("codiCiudDom", "");
		param.put("AsigMensual", "");
		param.put("AsigMensualDu", "");
		param.put("AsigMensualDu2", "");
		param.put("ApartirDe", "");
		param.put("pagar_a", "");
		param.put("dia_mes", "");
		param.put("año", "");

		Comunes.crearJasperReport(path, Constantes.REPORTE_CONTRATO_MUTUO, param,
				EnumReport.TIPO_REPORTE.REPORT_CONTRATO_MUTUO.getName(), o.getNumeroRadicacion() + "");

		return true;
	}

	@Override
	public Boolean join(DTOWF o, String path) {
		return false;
	}

}
