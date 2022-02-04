package com.jarzsoft.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class Comunes {

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
			e.printStackTrace();
		}

		return FechaConvertida;
	}

	public static String getStringMessageDigest(String message, String algorithm) {
		System.out.println("ENTRA Metodo getStringMessageDigest");
		String respuesta = "";
		byte[] digest = null;
		try {
			byte[] buffer = message.getBytes();

			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			messageDigest.reset();
			messageDigest.update(buffer);
			digest = messageDigest.digest();
			respuesta = toHexadecimal(digest);
		} catch (NoSuchAlgorithmException ex) {
			System.out.println("EXCEPTION: " + ex.getMessage());
		}
		System.out.println("SALE del metodo getStringMessageDigest");
		return respuesta;

	}

	private static String toHexadecimal(byte[] digest) {
		System.out.println("ENTRA Metodo toHexadecimal");
		String hash = "";
		try {
			for (byte aux : digest) {
				int b = aux & 0xff;
				if (Integer.toHexString(b).length() == 1)
					hash += "0";
				hash += Integer.toHexString(b);
			}
		} catch (Exception e) {
			System.out.println("EXCEPTION: " + e.getMessage());
		}
		System.out.println("SALE del metodo toHexadecimal");
		return hash;
	}

	public String generarHashPassword(String passwordActual) {
		System.out.println("ENTRA Metodo generarHashPassword");
		String hashGenerate = "";
		try {
			hashGenerate = (getStringMessageDigest(passwordActual, Constantes.SHA256));
		} catch (Exception e) {
			System.out.println("EXCEPTION: " + e.getMessage());
		}
		System.out.println("SALE del metodo generarHashPassword");
		return hashGenerate;
	}

}
