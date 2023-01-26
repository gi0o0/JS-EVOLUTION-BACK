package com.jarzsoft.util;

import java.util.ArrayList;
import java.util.HashMap;

public class Constantes {

	public static final String PATH_AUTH = "/auth";
	public static final String PATH_SECURITY = "/security";
	public static final String PATH_PROFILE = "/profile";
	public static final String PATH_FOCLAASO = "/foclaaso";
	public static final String PATH_FOTIPCRE = "/fotipcre";
	public static final String PATH_CLADOC = "/cladoc";
	public static final String PATH_COUNTRIES = "/countries";
	public static final String PATH_USER = "/user";
	public static final String PATH_SYSTEM = "/system";
	public static final String PATH_REPORTONLINE = "/reportonline";
	public static final String PATH_PARAMETER = "/parameter";
	public static final String PATH_DEPTOS = "/deptos";
	public static final String PATH_CITIES = "/cities";
	public static final String PATH_ECONOMICSECTOR = "/economicsector";
	public static final String PATH_FOTABPRO = "/fotabpro";
	public static final String PATH_BAENTIDAD = "/baentidad";
	public static final String PATH_ACCOUNT_TYPE = "account_type";
	public static final String PATH_WFPARAMETER = "/wfparameter";
	public static final String PATH_WF = "/wf";
	public static final String PATH_FILESUSERS = "/filesusers";
	public static final String PATH_USERWEB = "/webuser";

	public static final String ERROR_USUARIO_EXISTENTE = "El usuario que quieres crear ya existe.";
	public static final String ERROR_TOKEN_INVALIDO = "Token invaalido";

	public static final String MESSAGE_USER_NO_PASSWORD_HIS = "Clave ya registrada en historico";

	public static final String MESSAGE_USER_NO_FOUND = "No se ha podido encontrar tu cuenta";

	public static final String MESSAGE_EMAIL_NO_FOUND = "No se ha podido encontrar tu email";

	public static final String MESSAGE_USER_BLOCKED = "No se ha podido encontrar tu cuenta";

	public static final String MESSAGE_PASSWPRD_EXPIRED = "No se ha podido encontrar tu cuenta";

	public static final String MESSAGE_OK_REGISTER_EMAIL = "Se ha enviado un enlace de generación de clave al correo ";

	public static final String MESSAGE_OK_REGISTER_CLAVE = "Password Actualizada Correctamente";

	public static final String MESSAGE_REGISTER_DELETE = "Registro eliminado con éxito.";

	public static final String MESSAGE_DEFAULT_ERROR = "Error General. Contactar al Administrador del Sistema.";
	public static final String MESSAGE_PERSIST_ERROR = "Error Actualizando información. Verifique la información ingresada o contactar al Administrador del Sistema.";
	
	public static final String MESSAGE_USER_WITH_SANCTION = "Se ha encontrado registros en las listas negras";

	public static String SHA256 = "SHA-256";

	public static String STATE_UMBRAL_4 = "4";

	public static String STATE_UMBRAL_0 = "0";

	public static String STATE_UMBRAL_1 = "1";

	public static String HEADER_DEFAULT_NAME = "MENU PRINCIPAL";
	public static String HEADER_DEFAULT_URL = "/dashboard";
	public static String HEADER_DEFAULT_ICON = "icon-speedometer";

	// Documento
	public static final String PA_NOMBRE_SOLI = "PA_NOMBRE_SOLI";
	public static final String PA_MUT_INFO_HEADER = "PA_MUT_INFO_HEADER";
	public static final String PA_TIPOIDENT = "PA_TIPOIDENT";
	public static final String PA_MATRI = "PA_MATRI";
	public static final String PA_TEXT_FOOTER = "PA_TEXT_FOOTER";
	public static final String PA_REGISTRO = "PA_REGISTRO";
	public static final String PA_MUT_DBASIC_DIR_JU = "PA_MUT_DBASIC_DIR_JU";
	public static final String PA_MUT_DBASIC_CODP_JU = "PA_MUT_DBASIC_CODP_JU";
	public static final String PA_MUT_DBASIC_CIUD_JU = "PA_MUT_DBASIC_CIUD_JU";
	public static final String PA_MUT_DBASIC_DEP_JU = "PA_MUT_DBASIC_DEP_JU";
	public static final String PA_MUT_DBASIC_BAR_JU = "PA_MUT_DBASIC_BAR_JU";
	public static final String PA_MUT_DBASIC_TEL_1_JU = "PA_MUT_DBASIC_TEL_1_JU";
	public static final String PA_MUT_DBASIC_TEL_2_JU = "PA_MUT_DBASIC_TEL_2_JU";
	public static final String PA_MUT_DBASIC_TEL_3_JU = "PA_MUT_DBASIC_TEL_3_JU";
	public static final String PA_MUT_DBASIC_EMAIL_JU = "PA_MUT_DBASIC_EMAIL_JU";
	public static final String PA_MUT_DBASIC_DIR = "PA_MUT_DBASIC_DIR";
	public static final String PA_MUT_DBASIC_CODP = "PA_MUT_DBASIC_CODP";
	public static final String PA_MUT_DBASIC_CIUD = "PA_MUT_DBASIC_CIUD";
	public static final String PA_MUT_DBASIC_DEP = "PA_MUT_DBASIC_DEP";
	public static final String PA_MUT_DBASIC_BAR = "PA_MUT_DBASIC_BAR";
	public static final String PA_MUT_DBASIC_TEL_1 = "PA_MUT_DBASIC_TEL_1";
	public static final String PA_MUT_DBASIC_TEL_2 = "PA_MUT_DBASIC_TEL_2";
	public static final String PA_MUT_DBASIC_TEL_3 = "PA_MUT_DBASIC_TEL_3";
	public static final String PA_MUT_DBASIC_EMAIL = "PA_MUT_DBASIC_EMAIL";
	public static final String PA_MUT_DBASIC_PREG_JU = "PA_MUT_DBASIC_PREG_JU";
	public static final String PA_MUT_DBASIC = "PA_MUT_DBASIC";
	public static final String PA_MUT_NOM = "PA_MUT_NOM";
	public static final String PA_MUT_NOM_TITU = "PA_MUT_NOM_TITU";
	public static final String PA_MUT_NOM_TEXT = "PA_MUT_NOM_TEXT";
	public static final String PA_MUT_CIUU_TIP = "PA_MUT_CIUU_TIP";
	public static final String PA_MUT_CIUU_TIP2 = "PA_MUT_CIUU_TIP2";
	public static final String PA_MUT_CIUU_TIP3 = "PA_MUT_CIUU_TIP3";
	public static final String PA_MUT_CIUU_TIP4 = "PA_MUT_CIUU_TIP4";
	public static final String PA_MUT_DESCRIP_CIIU = "PA_MUT_DESCRIP_CIIU";
	public static final String PA_MUT_CIUU = "PA_MUT_CIUU";
	public static final String PA_MUT_CIUU_TEXT = "PA_MUT_CIUU_TEXT";
	public static final String TIPO_REPORTE = "cae.jasper";

	public static final String REPORTE_CREDITO_SOL = "solicitud.jasper";
	public static final String REPORTE_CREDITO_SOL_PAGE_2 = "solicitud_2.jasper";
	public static final String REPORTE_AFI = "afianzamiento.jasper";
	public static final String REPORTE_AVISO_PRI = "aviso_privacidad.jasper";
	public static final String REPORTE_CONTRATO_MUTUO = "contrato_mutuo.jasper";
	public static final String REPORTE_CORRETAJE = "corretaje.jasper";
	public static final String REPORTE_DECLARACION_INFO = "declaracion_info.jasper";
	public static final String REPORTE_DECLARACION_RECEPCION = "declaracion_recepcion.jasper";
	public static final String REPORTE_DECLARACION_JURA = "declaracionjuramentada.jasper";
	public static final String REPORTE_AUTO_DESC = "autorizaciondescuento.jasper";
	public static final String isOK = "S";
	public static final String isNOK = "N";

	public static final String TIPO_CONTRATO = "TIPO_CONTRATO";
	public static final String EPS = "EPS";

	public static final String EMAIL_ASUNTO = "REPORTES WORK FLOW";

	public static final String EMAIL_TEXTO = "Documentos Generados.";

	public final HashMap<String, String> tipoVivienda = new HashMap<String, String>();

	public final ArrayList<String> REPORTS_OF_WF_4 = new ArrayList<String>();

	public Constantes() {

		tipoVivienda.put("0", "Propia");
		tipoVivienda.put("1", "Familar");
		tipoVivienda.put("2", "Arriendo");

		REPORTS_OF_WF_4.add(EnumReport.TIPO_REPORTE.REPORT_CREDIT.getName());
		REPORTS_OF_WF_4.add(EnumReport.TIPO_REPORTE.REPORT_AFIANZAMIENTO.getName());
		REPORTS_OF_WF_4.add(EnumReport.TIPO_REPORTE.REPORT_AVISO_PRI.getName());
		REPORTS_OF_WF_4.add(EnumReport.TIPO_REPORTE.REPORT_CONTRATO_MUTUO.getName());
		REPORTS_OF_WF_4.add(EnumReport.TIPO_REPORTE.REPORT_CORRETAJE.getName());
		REPORTS_OF_WF_4.add(EnumReport.TIPO_REPORTE.REPORT_DECLARACION_INFO.getName());
		REPORTS_OF_WF_4.add(EnumReport.TIPO_REPORTE.REPORT_DECLARACION_RECEP.getName());
		REPORTS_OF_WF_4.add(EnumReport.TIPO_REPORTE.REPORT_DECLARACION_JURA.getName());
		REPORTS_OF_WF_4.add(EnumReport.TIPO_REPORTE.REPORT_AUTO_DESC.getName());

	}
}
