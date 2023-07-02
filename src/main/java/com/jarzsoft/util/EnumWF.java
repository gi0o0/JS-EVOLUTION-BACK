package com.jarzsoft.util;

public class EnumWF {

	public enum TIPO_WF {

		IDWF_1("1"), IDWF_2("2"), IDWF_4("4");

		private final String name;

		TIPO_WF(String s) {
			name = s;
		}

		public String getName() {
			return name;
		}

	}

}
