package com.jarzsoft;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class dd {

	public static void main(String[] args) {

		/*
		 * String FORMAT_UTC = "yyyy-MM-dd'T'HH:mm:ss.SSS-ssss"; //RES
		 * 2022-09-30T21:59:59.999-0500 String FORMAT_DEFAULT =
		 * "yyyy-MM-dd'T'HH:mm:ss.SSSZ"; SimpleDateFormat FORMATTER_DEFAULT = new
		 * SimpleDateFormat(FORMAT_DEFAULT);
		 * 
		 * String sDate1 = "2022-08-31T11:09:50.000-0400"; Date baseDate = new
		 * SimpleDateFormat(FORMAT_UTC).parse(sDate1); //
		 * System.out.println(FORMATTER_DEFAULT.format(baseDate));
		 * 
		 * 
		 * 
		 * Locale locale = LocaleUtils.toLocale("es_AR"); TimeZone tz =
		 * TimeZone.getTimeZone("America/Buenos_Aires"); Calendar siteCalendar =
		 * GregorianCalendar.getInstance(tz, locale);
		 * 
		 * siteCalendar.setTime(baseDate); //
		 * System.out.println(FORMATTER_DEFAULT.format(siteCalendar.getTime())); //
		 * System.out.println(FORMATTER_DEFAULT.format(baseDate));
		 * siteCalendar.add(Calendar.DAY_OF_MONTH, 30);
		 * 
		 * System.out.println(FORMATTER_DEFAULT.format(siteCalendar.getTime()));
		 * siteCalendar.set(Calendar.HOUR_OF_DAY, 23); siteCalendar.set(Calendar.MINUTE,
		 * 59); siteCalendar.set(Calendar.SECOND, 59);
		 * siteCalendar.set(Calendar.MILLISECOND, 999); //
		 * System.out.println(siteCalendar); //
		 * System.out.println(siteCalendar.getTime());
		 * System.out.println(FORMATTER_DEFAULT.format(siteCalendar.getTime()));
		 * 
		 * //siteCalendar.withZone(DateTimeZone.UTC).print(siteCalendar.getTime().UTC(0,
		 * 0, 0, 0, 0, 0));
		 */

		/*
		 * BigDecimal montoSolicitado = new BigDecimal("2000000"); BigDecimal numCuotas
		 * = new BigDecimal("3"); BigDecimal valor2 = montoSolicitado.divide(numCuotas,
		 * RoundingMode.HALF_UP);
		 * 
		 * String a ="2.0";
		 * 
		 * int b=(int) Double.parseDouble(a);
		 */
		// System.out.println(b);

		/*
		 * ArrayList<String> key=new ArrayList<>();
		 * 
		 * File doc = new File("C:\\\\Users\\\\PC\\\\Desktop\\\\b.txt");
		 * 
		 * BufferedReader obj = new BufferedReader(new FileReader(doc));
		 * 
		 * int i =1; String strng; while ((strng = obj.readLine()) != null) {
		 * 
		 * String values[]=strng.split(";"); String
		 * keyy=values[4]+","+values[6]+","+values[8]+","+values[9];
		 * if(!key.contains(keyy)) { key.add(keyy); }else {
		 * System.out.println(values[4]+","+values[6]+","+values[8]+","+values[9]); }
		 * 
		 * 
		 * i++; }
		 * 
		 * 
		 * 
		 * }
		 */
		/*
		 * EMAIL ASUNTO REGISTRO WEB EMAIL FROM juridico@tecnicasygestiones.com.co EMAIL
		 * LINK http://localhost:4200/#/register-user?token= EMAIL PASS_SERVER
		 * 5m4iW&*T89nZ EMAIL PORT 465 EMAIL SERVER mail.tecnicasygestiones.com.co EMAIL
		 * TEXT texttoooo EMAIL TO jarzsoftgfi@gmail.com EMAIL USER_SERVER
		 * juridico@tecnicasygestiones.com.co
		 */

		/*
		 * String user_server_email = ""; String pass_server_email = ""; String
		 * server_email = ""; String port_email = ""; String from_email = "";
		 * 
		 * user_server_email = "validaciones@tecnicasygestiones.com.co";
		 * 
		 * pass_server_email = "87@P&fc66%BF";
		 * 
		 * server_email = "mail.tecnicasygestiones.com.co";
		 * 
		 * port_email = "587";
		 * 
		 * from_email = "validaciones@tecnicasygestiones.com.co";
		 * 
		 * final String username = user_server_email; final String password =
		 * pass_server_email;
		 * 
		 * Properties props = new Properties(); props.put("mail.smtp.auth", "true");
		 * props.put("mail.smtp.starttls.enable", "true");
		 * props.put("mail.smtp.ssl.protocols", "TLSv1.2"); props.put("mail.smtp.host",
		 * server_email); props.put("mail.smtp.port", port_email);
		 * props.put("mail.smtp.ssl.trust", "*");
		 * 
		 * Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		 * protected PasswordAuthentication getPasswordAuthentication() { return new
		 * PasswordAuthentication(username, password); } });
		 * 
		 * try { Message message = new MimeMessage(session); message.setFrom(new
		 * InternetAddress(from_email)); message.setRecipients(Message.RecipientType.TO,
		 * InternetAddress.parse("martinzodiacal1000@gmail.com"));
		 * message.setSubject("mi sunto"); message.setText("pruebbaaaa");
		 * System.out.println("Antes"); Transport.send(message);
		 * System.out.println("Despoues"); ; } catch (MessagingException e) {
		 * System.out.println("Antes error"); throw new RuntimeException(e); }
		 * 
		 * 
		 * }
		 
		  Integer s = 1032888511;
	
		  System.out.println(new Long(s));
		  
		  */
		
		LocalDateTime ahora = LocalDateTime.now();
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String now = ahora.format(formatter);
		
		

	}

}
