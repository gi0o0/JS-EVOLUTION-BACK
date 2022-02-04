package com.jarzsoft.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FechaUtils {

	public static String getFechaStringTimestamp(Date fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSZ");
		return sdf.format(fecha);
	}

	public static Date getFechaStringToDate(String fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSZ");
		try {
			return sdf.parse(fecha);
		} catch (ParseException e) {
			System.err.println("Formato de fecha para Log incorrecta, se retorna fecha actual");
			e.printStackTrace();
			return new Date();
		}
	}

	public static String getFechaActualString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return sdf.format(new Date());
	}
	
	public static String getFechaActualStringAStringYYYYMMDD(String fecha) {
		SimpleDateFormat parseador = new SimpleDateFormat("dd-MM-yy");
		SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		String response = "";
		try {
            date = parseador.parse(fecha);
            response = formateador.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
		return response;
	}

	public static String getFechaActualSinHoraString() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(new Date());
	}
	
	public static String getFechaActualStringOtroFormato() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSSZ");
		return sdf.format(new Date());
	}
}
