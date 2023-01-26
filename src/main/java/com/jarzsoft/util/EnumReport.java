package com.jarzsoft.util;

public class EnumReport {

	public enum TIPO_REPORTE {

		REPORT_CREDIT("credit"), REPORT_CREDIT2("credit2"), REPORT_AFIANZAMIENTO("afianzamiento"),
		REPORT_AVISO_PRI("aviso_privacidad"), REPORT_CONTRATO_MUTUO("contrato_mutuo"), REPORT_CORRETAJE("corretaje")
		, REPORT_DECLARACION_INFO("declaracion_info"), REPORT_DECLARACION_RECEP("declaracion_recepcion"),
		 REPORT_DECLARACION_JURA("declaracion_juramentada"), REPORT_AUTO_DESC("autorizacion_descuento");

		private final String name;

		TIPO_REPORTE(String s) {
			name = s;
		}

		public String getName() {
			return name;
		}

	}

}