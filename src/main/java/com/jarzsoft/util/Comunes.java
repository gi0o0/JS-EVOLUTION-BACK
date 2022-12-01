package com.jarzsoft.util;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class Comunes {

	
	private static final Logger LOGGER = LogManager.getLogger(Comunes.class);
	
	public static String FORMAT_YYY_MM_DD = "yyyy-MM-dd";
	public static String FORMAT_MM_DD_YYYY = "yyyy-MM-dd";

	public static boolean validarNumerico(String cadena) {
		if (cadena.matches("[0-9]*")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean validarAlfanuericoAcento(String cadena) {
		Pattern patron = Pattern.compile("[A-Za-zñÑáéíóúÁÉÍÓÚ\\s]*");
		Matcher comprobacion = patron.matcher(cadena);
		if (comprobacion.matches()) {
			return true;
		}
		return false;
	}

	public static boolean isAlphanumeric(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c < 0x30 || (c >= 0x3a && c <= 0x40) || (c > 0x5a && c <= 0x60) || c > 0x7a)
				return false;
		}

		return true;
	}

	public boolean validarCorreo(String cadena) {

		Pattern pattern = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher comprobacion = pattern.matcher(cadena);
		if (comprobacion.matches()) {
			return true;
		}
		return false;
	}

	public static String convertirXls(String nombreArchivo) {
		return nombreArchivo.substring(0, nombreArchivo.length() - 3) + "xls";
	}

	public static String convertirXlsExcel(String nombreArchivo) {
		return nombreArchivo + "xls";
	}

	public static String cambiarFormatoFecha(String dateSample) {
		String FechaConvertida = "";
		String oldFormat = "yyyy-MM-dd HH:mm";
		String newFormat = "dd-MM-yyyy HH:mm";

		SimpleDateFormat sdf1 = new SimpleDateFormat(oldFormat);
		SimpleDateFormat sdf2 = new SimpleDateFormat(newFormat);
		try {
			FechaConvertida = sdf2.format(sdf1.parse(dateSample)).replace("-", "");
			FechaConvertida = FechaConvertida.replace(" ", "_");
			FechaConvertida = FechaConvertida.replace(":", "");
		} catch (ParseException e) {
			LOGGER.info("EXCEPTION:" + e.getMessage());
		}

		return FechaConvertida;
	}
	
	public static String cambiarFormatoFechaDinamic(String date,String oldFormat,String newFormat) {
		String FechaConvertida = "";
		SimpleDateFormat sdf1 = new SimpleDateFormat(oldFormat);
		SimpleDateFormat sdf2 = new SimpleDateFormat(newFormat);
		try {
			FechaConvertida = sdf2.format(sdf1.parse(date));
		} catch (ParseException e) {
			LOGGER.info("EXCEPTION:" + e.getMessage());
		}

		return FechaConvertida;
	}

	public static String getStringMessageDigest(String message, String algorithm) {

		String respuesta = "";
		byte[] digest = null;
		try {
			byte[] buffer = message.getBytes();

			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			messageDigest.reset();
			messageDigest.update(buffer);
			digest = messageDigest.digest();
			respuesta = toHexadecimal(digest);
		} catch (NoSuchAlgorithmException e) {
			LOGGER.info("EXCEPTION:" + e.getMessage());
		}

		return respuesta;

	}

	private static String toHexadecimal(byte[] digest) {

		String hash = "";
		try {
			for (byte aux : digest) {
				int b = aux & 0xff;
				if (Integer.toHexString(b).length() == 1)
					hash += "0";
				hash += Integer.toHexString(b);
			}
		} catch (Exception e) {

			LOGGER.info("EXCEPTION:" + e.getMessage());

		}

		return hash;
	}

	public String generarHashPassword(String passwordActual) {
		String hashGenerate = "";
		try {
			hashGenerate = (getStringMessageDigest(passwordActual, Constantes.SHA256));
		} catch (Exception e) {
			LOGGER.info("EXCEPTION:" + e.getMessage());
		}
		return hashGenerate;
	}

	public static String validIsNullNumber(BigDecimal value) {

		return (value != null) ? value.toString() : "0";
	}

	public static BigDecimal validIsNullNumberEmpty(BigDecimal value) {

		return (value != null) ? value : new BigDecimal("0");
	}

	public static String stringToInt(String value) {
		if (value == null || value.equals(""))
			return "0";

		return String.valueOf((int) Double.parseDouble(value));
	}

	public static int stringToInteger(String value) {
		if (value == null || value.equals(""))
			return 0;

		return (int) Double.parseDouble(value);
	}

	public static String stringClean(String value) {
		if (value == null || value.equals(""))
			return "";

		return value.trim();
	}

	public static BigDecimal validIsNullStringTonumber(String value) {

		return (value != null) ? new BigDecimal(value) : new BigDecimal("0");
	}

}
