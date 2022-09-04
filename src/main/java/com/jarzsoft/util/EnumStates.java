package com.jarzsoft.util;

public class EnumStates {

	public enum TIPO_ESTADO
	{
		STATE_S("S"),
		STATE_1("1"),
		STATE_2("2"),
		STATE_3("3"),
		STATE_4("4");
		
		private final String name;

		TIPO_ESTADO(String s) {
            name = s;
        } 
	    
	    public String getName() {
	        return name;
	    }    
	    
	    
	}
	
}
