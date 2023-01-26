package com.jarzsoft.util;

public class EnumStates {

	public enum TIPO_ESTADO {
		STATE_S("S"), STATE_E("E"), STATE_P("P"), STATE_I("I"), STATE_1("1"), STATE_2("2"), STATE_3("3"), STATE_4("4"),
		STATE_5("5"), STATE_6("6"), STATE_7("7"), STATE_8("8"), STATE_9("9"), STATE_14("14"), STATE_18("18");

		private final String name;

		TIPO_ESTADO(String s) {
			name = s;
		}

		public String getName() {
			return name;
		}

	}

}
