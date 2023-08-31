package com.jarzsoft.reports.impl;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jarzsoft.dto.DTOWF;
import com.jarzsoft.service.IBaEntidadService;
import com.jarzsoft.service.IBasTTipCtaService;
import com.jarzsoft.service.ICiudadesService;
import com.jarzsoft.service.IDeptosService;
import com.jarzsoft.service.IFoclaasoService;
import com.jarzsoft.service.IParameterService;
import com.jarzsoft.service.IReportStrategy;
import com.jarzsoft.service.IUserWebService;
import com.jarzsoft.util.Comunes;
import com.jarzsoft.util.Constantes;
import com.jarzsoft.util.EnumReport;

@Component
public class WFCredit_Report implements IReportStrategy {

	private final IFoclaasoService foclaasoService;
	private final ICiudadesService ciudadesService;
	private final IDeptosService deptosService;
	private final IParameterService parameterService;
	private final IBasTTipCtaService basTTipCtaService;
	private final IBaEntidadService baEntidadService;
	private final IUserWebService userWebService;

	@Autowired
	public WFCredit_Report(IFoclaasoService foclaasoService, ICiudadesService ciudadesService,
			IDeptosService deptosService, IParameterService parameterService, IBasTTipCtaService basTTipCtaService,
			IBaEntidadService baEntidadService, IUserWebService userWebService) {
		super();
		this.foclaasoService = foclaasoService;
		this.ciudadesService = ciudadesService;
		this.deptosService = deptosService;
		this.parameterService = parameterService;
		this.basTTipCtaService = basTTipCtaService;
		this.baEntidadService = baEntidadService;
		this.userWebService = userWebService;
	}

	@Override
	public String getType() {
		return EnumReport.TIPO_REPORTE.REPORT_CREDIT.getName();
	}

	@Override
	public Boolean create(DTOWF o, String user, String path) {
		if (createPage1(o, user, path) && createPage2(o, user, path)) {
			join(o, path);
		}
		return null;
	}

	private Boolean createPage2(DTOWF o, String user, String path) {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("nitter", String.valueOf(o.getNitter()));
		param.put("priApellido", o.getPriApellido() + " " + o.getSegApellido());
		param.put("nomTer", o.getNomTer() + " " + o.getPriApellido() + " " + o.getSegApellido());

		param.put("name_asesor", userWebService.getUserById((user)).getNom_usuario());
		param.put("id_asesor", user);

		if (null != o.getCodeu()) {
			param.put("idConyuge_codeu", o.getCodeu().getIdConyuge());
			param.put("nomCony_codeu", o.getCodeu().getNomCony());
			param.put("emailConyuge_codeu", o.getCodeu().getEmailConyuge());
			param.put("celConyuge_codeu", o.getCodeu().getCelConyuge());
			param.put("refNombre1_codeu", o.getCodeu().getRefNombre1());
			param.put("refNombre2_codeu", o.getCodeu().getRefNombre2());
			param.put("refNombre3_codeu", o.getCodeu().getRefNombre3());
			param.put("refParen1_codeu", o.getCodeu().getRefParen1());
			param.put("refParen2_codeu", o.getCodeu().getRefParen2());
			param.put("refParen3_codeu", o.getCodeu().getRefParen3());
			param.put("refMail1_codeu", o.getCodeu().getRefMail1());
			param.put("refMail2_codeu", o.getCodeu().getRefMail2());
			param.put("refMail3_codeu", o.getCodeu().getRefMail3());
			param.put("refCel1_codeu", o.getCodeu().getRefCel1());
			param.put("refCel2_codeu", o.getCodeu().getRefCel2());
			param.put("refCel3_codeu", o.getCodeu().getRefCel3());
			param.put("bienNombre_codeu", o.getCodeu().getBienNombre());
			param.put("bienValor_codeu", o.getCodeu().getBienValor());
			param.put("bienAfecta_codeu", "0".equals(o.getCodeu().getBienAfecta()) ? "X" : "");
			param.put("bienAfecta_codeuNo", "1".equals(o.getCodeu().getBienAfecta()) ? "X" : "");
			param.put("bienHipoteca_codeu", "0".equals(o.getCodeu().getBienHipoteca()) ? "X" : "");
			param.put("bienHipoteca_codeuNo", "1".equals(o.getCodeu().getBienHipoteca()) ? "X" : "");
			param.put("bienHipAFavor_codeu", o.getCodeu().getBienHipAFavor());
			param.put("vehMarca_codeu", o.getCodeu().getVehMarca());
			param.put("vehClase_codeu", o.getCodeu().getVehClase());
			param.put("vehModelo_codeu", o.getCodeu().getVehModelo());
			param.put("vehPlaca_codeu", o.getCodeu().getVehPlaca());
			param.put("vehPignorado_codeu", "o".equals(o.getCodeu().getVehPignorado()) ? "X" : "");
			param.put("vehPignorado_codeuNo", "1".equals(o.getCodeu().getVehPignorado()) ? "X" : "");
			param.put("vehPigAFavor_codeu", o.getCodeu().getVehPigAFavor());
			param.put("vehValVomercial_codeu", o.getCodeu().getVehValVomercial());
			param.put("vehValVomercial", String.valueOf(o.getVehValVomercial()));

			param.put("priApellido_codeu", o.getCodeu().getPriApellido() + " " + o.getCodeu().getSegApellido());
			param.put("lugarDoc_codeu", String.valueOf(o.getCodeu().getFeExp()));
			param.put("nitter_codeu", String.valueOf(o.getCodeu().getNitter()));
			param.put("nomTer_codeu", o.getCodeu().getNomTer() + " " + o.getCodeu().getPriApellido() + " "
					+ o.getCodeu().getSegApellido());

		}

		Comunes.crearJasperReport(path, Constantes.REPORTE_CREDITO_SOL_PAGE_2, param,
				EnumReport.TIPO_REPORTE.REPORT_CREDIT2.getName(), o.getNumeroRadicacion() + "");

		return true;

	}

	public Boolean createPage1(DTOWF o, String user, String path) {

		Constantes constantes = new Constantes();
		String now = new SimpleDateFormat("yyyy-dd-MM").format(new Date());
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("numeroRadicacion", String.valueOf(o.getNumeroRadicacion()));
		param.put("entitie",
				(null != o.getEntitie() ? foclaasoService.getCompaniesByID(new BigInteger(o.getEntitie())).getName()
						: ""));
		param.put("sol_fe_sol", now);
		param.put("valorPress", String.valueOf(o.getValorPress()));
		param.put("perCuota",
				(null != o.getPerCuota()
						? parameterService.getSingleById(Constantes.PERIODICIDAD, o.getPerCuota()).getValue()
						: ""));
		if (null != o.getCodeu()) {
			param.put("is_cod", "X");
			param.put("no_cod", "");
		} else {
			param.put("is_cod", "");
			param.put("no_cod", "X");
		}

		if ("S".equals(o.getIndSolCredito())) {
			param.put("is_solcre", "X");
			param.put("no_solcre", "");
		} else {
			param.put("is_solcre", "");
			param.put("no_solcre", "X");
		}

		param.put("nroCuotas", String.valueOf(o.getNroCuotas()));
		param.put("monto_aprob", String.valueOf(o.getValorPress()));
		param.put("is_soli", "X");
		param.put("priApellido", o.getPriApellido() + " " + o.getSegApellido());
		param.put("nomTer", o.getNomTer());
		param.put("feExp", o.getFeExp());
		param.put("fecCump", o.getFecCump());
		param.put("nitter", String.valueOf(o.getNitter()));
		param.put("telTer", String.valueOf(o.getTelTer()) + " , " + String.valueOf(o.getTelTer1()) + " , "
				+ String.valueOf(o.getTelTer2()));
		param.put("mailTer", String.valueOf(o.getMailTer()));
		param.put("dirTerpal", String.valueOf(o.getDirTerpal()));
		param.put("barrio", String.valueOf(o.getBarrio()));
		param.put("codiCiud", ciudadesService.getCiudad(Integer.parseInt(o.getCodiCiud())).getName());
		param.put("codiDept", deptosService.getDep(Integer.parseInt(o.getCodiDept())).getName());
		param.put("antiEmpresa", String.valueOf(o.getAntiEmpresa()));
		param.put("tipVivienda", constantes.tipoVivienda.get(o.getTipVivienda()));
		param.put("dirTeralt", String.valueOf(o.getDirTeralt()));
		param.put("barrioTra", String.valueOf(o.getBarrioTra()));
		param.put("ciuDirTrabajo",
				null != o.getCiuDirTrabajo()
						? ciudadesService.getCiudad(Integer.parseInt(o.getCiuDirTrabajo())).getName()
						: "");
		param.put("deptDirTrabajo",
				null != o.getDeptDirTrabajo() ? deptosService.getDep(Integer.parseInt(o.getDeptDirTrabajo())).getName()
						: "");
		param.put("faxTer", String.valueOf(o.getFaxTer()));
		param.put("cargoWf", String.valueOf(o.getCargoWf()));
		param.put("indContrato",
				null != o.getIndContrato()
						? parameterService.getSingleById(Constantes.TIPO_CONTRATO, o.getIndContrato()).getValue()
						: "");
		param.put("paramText",
				null != o.getParamText() ? parameterService.getSingleById(Constantes.EPS, o.getParamText()).getValue()
						: "");
		param.put("tipCta", null != o.getTipCta() ? basTTipCtaService.getBasTTipCta(o.getTipCta()).getName() : "");
		param.put("entBan", null != o.getEntBan() ? baEntidadService.getBaentidad(o.getEntBan()).getName() : "");
		param.put("numCta", String.valueOf(o.getNumCta()));
		param.put("name_asesor", userWebService.getUserById((user)).getNom_usuario());
		param.put("sucu_banco", "");
		param.put("nomCony", String.valueOf(o.getNomCony()));
		param.put("emailConyuge", String.valueOf(o.getEmailConyuge()));
		param.put("celConyuge", String.valueOf(o.getCelConyuge()));
		param.put("refNombre1", String.valueOf(o.getRefNombre1()));
		param.put("refNombre2", String.valueOf(o.getRefNombre2()));
		param.put("refNombre3", String.valueOf(o.getRefNombre3()));
		param.put("refParen1", String.valueOf(o.getRefParen1()));
		param.put("refParen2", String.valueOf(o.getRefParen2()));
		param.put("refParen3", String.valueOf(o.getRefParen3()));
		param.put("refMail1", String.valueOf(o.getRefMail1()));
		param.put("refMail2", String.valueOf(o.getRefMail2()));
		param.put("refMail3", String.valueOf(o.getRefMail3()));
		param.put("refCel1", String.valueOf(o.getRefCel1()));
		param.put("refCel2", String.valueOf(o.getRefCel2()));
		param.put("refCel3", String.valueOf(o.getRefCel3()));
		param.put("bienNombre", String.valueOf(o.getBienNombre()));
		param.put("bienValor", String.valueOf(o.getBienValor()));
		param.put("bienAfecta", "0".equals(o.getBienAfecta()) ? "X" : "");
		param.put("bienAfectaNo", "1".equals(o.getBienAfecta()) ? "X" : "");
		param.put("bienHipoteca", "0".equals(o.getBienHipoteca()) ? "X" : "");
		param.put("bienHipotecaNo", "1".equals(o.getBienHipoteca()) ? "X" : "");
		param.put("bienHipAFavor", String.valueOf(o.getBienHipAFavor()));
		param.put("vehMarca", String.valueOf(o.getVehMarca()));
		param.put("vehClase", String.valueOf(o.getVehClase()));
		param.put("vehModelo", String.valueOf(o.getVehModelo()));
		param.put("vehPlaca", String.valueOf(o.getVehPlaca()));
		param.put("vehPignorado", "0".equals(o.getVehPignorado()) ? "X" : "");
		param.put("vehPignoradoNo", "1".equals(o.getVehPignorado()) ? "X" : "");
		param.put("vehPigAFavor", String.valueOf(o.getVehPigAFavor()));
		param.put("vehValVomercial", String.valueOf(o.getVehValVomercial()));
		if (null != o.getCodeu()) {
			param.put("priApellido_codeu", o.getCodeu().getPriApellido() + " " + o.getCodeu().getSegApellido());
			param.put("nomTer_codeu", String.valueOf(o.getCodeu().getNomTer()));
			param.put("lugarDoc_codeu", String.valueOf(o.getCodeu().getFeExp()));
			param.put("nitter_codeu", String.valueOf(o.getCodeu().getNitter()));
			param.put("telTer_codeu", String.valueOf(o.getCodeu().getTelTer()));
			param.put("mailTer_codeu", String.valueOf(o.getCodeu().getMailTer()));
			param.put("dirTerpal_codeu", String.valueOf(o.getCodeu().getDirTerpal()));
			param.put("barrio_codeu", String.valueOf(o.getCodeu().getBarrio()));
			param.put("tipVivienda_codeu", constantes.tipoVivienda.get(o.getCodeu().getTipVivienda()));
			param.put("antiEmpresa_codeu", String.valueOf(o.getCodeu().getAntiEmpresa()));
			param.put("telTer_codeu_resi", String.valueOf(o.getCodeu().getTelTer()));
			param.put("dirTeralt_codeu", String.valueOf(o.getCodeu().getDirTeralt()));
			param.put("barrioTra_codeu", String.valueOf(o.getCodeu().getBarrioTra()));
			param.put("deptDirTrabajo_codeu",
					(null != o.getCodeu().getDeptDirTrabajo()
							? deptosService.getDep(Integer.parseInt(o.getCodeu().getDeptDirTrabajo())).getName()
							: ""));
			param.put("ciuDirTrabajo_codeu",
					(null != o.getCodeu().getCiuDirTrabajo()
							? ciudadesService.getCiudad(Integer.parseInt(o.getCodeu().getCiuDirTrabajo())).getName()
							: ""));
			param.put("faxTer_codeu", String.valueOf(o.getCodeu().getFaxTer()));
			param.put("cargoWf_codeu", String.valueOf(o.getCodeu().getCargoWf()));
			param.put("indContrato_codeu",
					(null != o.getCodeu().getIndContrato()
							? parameterService.getSingleById(Constantes.TIPO_CONTRATO, o.getCodeu().getIndContrato())
									.getValue()
							: ""));
			param.put("paramText_codeu",
					(null != o.getCodeu().getParamText()
							? parameterService.getSingleById(Constantes.EPS, o.getCodeu().getParamText()).getValue()
							: ""));
			param.put("empresa_cod", String.valueOf(o.getCodeu().getEmpresaCod()));
		}

		Comunes.crearJasperReport(path, Constantes.REPORTE_CREDITO_SOL, param,
				EnumReport.TIPO_REPORTE.REPORT_CREDIT.getName(), o.getNumeroRadicacion() + "");

		return true;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Boolean join(DTOWF o, String path) {

		String page1 = EnumReport.TIPO_REPORTE.REPORT_CREDIT.getName() + "_" + o.getNumeroRadicacion() + ".pdf";
		String page2 = EnumReport.TIPO_REPORTE.REPORT_CREDIT2.getName() + "_" + o.getNumeroRadicacion() + ".pdf";
		File file1 = new File(path + page1);
		File file2 = new File(path + page2);

		PDFMergerUtility obj = new PDFMergerUtility();
		obj.setDestinationFileName(path + page1);

		try {
			obj.addSource(file1);
			obj.addSource(file2);
			obj.mergeDocuments();
			file2.delete();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}

}
