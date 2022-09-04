package com.jarzsoft.util;

public class EnumSubSteps{

	public enum TIPO_SUB_PASO {

		SUB_STEP_1("1"), SUB_STEP_2("2"), SUB_STEP_3("3");

		private final String name;

		TIPO_SUB_PASO(String s) {
            name = s;
        } 
	    
	    public String getName() {
	        return name;
	    }   

	}

}