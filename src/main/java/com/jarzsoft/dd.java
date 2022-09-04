package com.jarzsoft;

public class dd {



    public static void main(String[] args) throws Exception {
        
    	
    	if(!productIsCovered()) {
    		System.out.println("entro");
    }else {
    	System.out.println("no entro");
    }
    }
    
    public static boolean productIsCovered() {
	
		boolean	isProductOP = "online_payments".equals("online_payments");
		return isProductOP;
	}

}
