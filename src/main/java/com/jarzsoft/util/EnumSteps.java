package com.jarzsoft.util;

public class EnumSteps{

	public enum TIPO_PASO {

		STEP_1("1"), STEP_2("2"), STEP_3("3");

		private final String name;

		TIPO_PASO(String s) {
            name = s;
        } 
	    
	    public String getName() {
	        return name;
	    }   

	}

}