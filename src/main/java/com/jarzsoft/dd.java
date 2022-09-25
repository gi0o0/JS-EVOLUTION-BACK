package com.jarzsoft;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;
import java.util.TimeZone;

import org.apache.commons.lang.LocaleUtils;

import com.itextpdf.text.log.SysoCounter;

public class dd {

	public static void main(String[] args) throws Exception {
		
	/*	String FORMAT_UTC = "yyyy-MM-dd'T'HH:mm:ss.SSS-ssss";
		//RES 2022-09-30T21:59:59.999-0500
	    String FORMAT_DEFAULT = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
		SimpleDateFormat FORMATTER_DEFAULT = new SimpleDateFormat(FORMAT_DEFAULT);
		
		String sDate1 = "2022-08-31T11:09:50.000-0400";
		Date baseDate = new SimpleDateFormat(FORMAT_UTC).parse(sDate1);
	//	System.out.println(FORMATTER_DEFAULT.format(baseDate));
		
		
		
		Locale locale = LocaleUtils.toLocale("es_AR");
		TimeZone tz = TimeZone.getTimeZone("America/Buenos_Aires");
		Calendar siteCalendar = GregorianCalendar.getInstance(tz, locale);

		siteCalendar.setTime(baseDate);
	//	System.out.println(FORMATTER_DEFAULT.format(siteCalendar.getTime()));
	//	System.out.println(FORMATTER_DEFAULT.format(baseDate));
		siteCalendar.add(Calendar.DAY_OF_MONTH, 30);

		System.out.println(FORMATTER_DEFAULT.format(siteCalendar.getTime()));	
		siteCalendar.set(Calendar.HOUR_OF_DAY, 23);
		siteCalendar.set(Calendar.MINUTE, 59);
		siteCalendar.set(Calendar.SECOND, 59);
		siteCalendar.set(Calendar.MILLISECOND, 999);
	//	System.out.println(siteCalendar);	
	//	System.out.println(siteCalendar.getTime());	
		System.out.println(FORMATTER_DEFAULT.format(siteCalendar.getTime()));
		
		//siteCalendar.withZone(DateTimeZone.UTC).print(siteCalendar.getTime().UTC(0, 0, 0, 0, 0, 0));*/

		BigDecimal montoSolicitado = new BigDecimal("2000000");
		BigDecimal numCuotas = new BigDecimal("3");
		BigDecimal valor2 = montoSolicitado.divide(numCuotas, RoundingMode.HALF_UP);
		
		String a ="2.0";
		
		int b=(int) Double.parseDouble(a);
	//	System.out.println(b);
		
		
		
	        File doc =
	          new File("C:\\Users\\PC\\Desktop\\a.txt");
	        Scanner obj = new Scanner(doc);

	        while (obj.hasNextLine()) {
	        	String val=obj.nextLine();
	        	String filter="REQUEST_BODY";
	        	  if (val.contains(filter)) {   //si la línea contiene el texto buscado se muestra por pantalla         
	                //    System.out.println("Linea "  + val);
	                  
	                    if(val.indexOf("entity_id")>0) {
	                    	  System.out.println(val.substring(val.indexOf("entity_id"),val.indexOf("entity_id")+35));
	                    }

	        }
	        	
	        
	           
	        }
		

	
	}


}
