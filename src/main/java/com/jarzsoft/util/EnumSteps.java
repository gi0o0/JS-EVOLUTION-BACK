package com.jarzsoft.util;

public class EnumSteps {

	public enum TIPO_PASO {

		STEP_1("1"), STEP_2("2"), STEP_3("3"), STEP_4("4"), STEP_5("5"), STEP_6("6"), STEP_7("7"), STEP_8("8"),
		STEP_END("0");

		private final String name;

		TIPO_PASO(String s) {
			name = s;
		}

		public String getName() {
			return name;
		}

	}

}