package com.jarzsoft.reports.impl;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.service.IBaEntidadService;
import com.jarzsoft.service.IBasTTipCtaService;
import com.jarzsoft.service.ICiudadesService;
import com.jarzsoft.service.IFoclaasoService;
import com.jarzsoft.service.IReportStrategy;
import com.jarzsoft.util.Comunes;
import com.jarzsoft.util.Constantes;
import com.jarzsoft.util.EnumReport;

@Component
public class WFAfianzamiento_Report implements IReportStrategy {

	private final ICiudadesService ciudadesService;
	private final IBasTTipCtaService basTTipCtaService;
	private final IBaEntidadService baEntidadService;
	private final IFoclaasoService foclaasoService;

	@Autowired
	public WFAfianzamiento_Report(ICiudadesService ciudadesService, IBasTTipCtaService basTTipCtaService,
			IBaEntidadService baEntidadService, IFoclaasoService foclaasoService) {
		super();
		this.ciudadesService = ciudadesService;
		this.basTTipCtaService = basTTipCtaService;
		this.baEntidadService = baEntidadService;
		this.foclaasoService = foclaasoService;
	}

	@Override
	public String getType() {
		return EnumReport.TIPO_REPORTE.REPORT_AFIANZAMIENTO.getName();
	}

	@Override
	public Boolean create(DTOWF o, String user, String path) {

		String now = new SimpleDateFormat("yyyy-dd-MM").format(new Date());
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("numeroRadicacion", String.valueOf(o.getNumeroRadicacion()));
		param.put("priApellido", o.getPriApellido() + " " + o.getSegApellido());
		param.put("nomTer", o.getNomTer() + " " + o.getPriApellido() + " " + o.getSegApellido());
		param.put("feExp", o.getFeExp());
		param.put("fecCump", o.getFecCump());
		param.put("nitter", o.getNitter());
		param.put("telTer", o.getTelTer() + " , " + o.getTelTer1() + " , " + o.getTelTer2());
		param.put("mailTer", o.getMailTer());
		param.put("dirTerpal", o.getDirTerpal());
		param.put("barrio", o.getBarrio());
		param.put("codiCiud",
				(null != o.getCodiCiud() ? ciudadesService.getCiudad(Integer.parseInt(o.getCodiCiud())).getName()
						: ""));
		param.put("tipCta", (null != o.getTipCta() ? basTTipCtaService.getBasTTipCta(o.getTipCta()).getName() : " "));
		param.put("entBan", (null != o.getEntBan() ? baEntidadService.getBaentidad(o.getEntBan()).getName() : " "));
		
		
		
		param.put("numCta", (null != o.getNumCta()? o.getNumCta() : " "));
		param.put("refNombre1", (null !=o.getRefNombre1()? o.getRefNombre1() : " "));
		param.put("refNombre2", (null !=o.getRefNombre2()? o.getRefNombre2() : " "));
		param.put("refNombre3", (null !=o.getRefNombre3()? o.getRefNombre3() : " "));
		
		param.put("refMail1", (null !=o.getRefMail1()? o.getRefMail1() : " "));
		param.put("refMail2", (null !=o.getRefMail2()? o.getRefMail2() : " "));
		param.put("refMail3", (null !=o.getRefMail3()? o.getRefMail3() : " "));
		
		param.put("refCel1", (null !=o.getRefCel1()? o.getRefCel1() : " "));
		param.put("refCel2", (null !=o.getRefCel2()? o.getRefCel2() : " "));
		param.put("refCel3", (null !=o.getRefCel3()? o.getRefCel3() : " "));
		
		param.put("lugar_nacimiento", "");
		param.put("sex_m", "1".equals(o.getSexo()) ? "X" : " ");
		param.put("sex_f", "2".equals(o.getSexo()) ? "X" : " ");

		param.put("empresa",
				(null != o.getEntitie() ? foclaasoService.getCompaniesByID(new BigInteger(o.getEntitie())).getName()
						: ""));
		param.put("telTers", o.getFaxTer());
		param.put("dirTerpalref1", "");
		param.put("ref1Cel2", "");
		param.put("dirTerpalref2", "");
		param.put("dirTerpalref3", "");
		param.put("ref2Cel2", "");
		param.put("ref3Cel2", "");
		param.put("fecha", now);

		Comunes.crearJasperReport(path, Constantes.REPORTE_AFI, param,
				EnumReport.TIPO_REPORTE.REPORT_AFIANZAMIENTO.getName(), o.getNumeroRadicacion() + "");

		return true;
	}

	@Override
	public Boolean join(DTOWF o, String path) {
		return false;
	}

}
