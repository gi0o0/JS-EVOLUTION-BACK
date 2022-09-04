package com.jarzsoft.util;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarzsoft.entities.Parametro;
import com.jarzsoft.repository.ParametroRepository;


@Service
public class SendEmail {

	private final ParametroRepository parametroRepository;

	@Autowired
	public SendEmail(ParametroRepository parametroRepository) {
		super();
		this.parametroRepository = parametroRepository;
	}

	public String Send(String emailTo,String asunto_email, String text_email) {

		String resultado = "NOK";
		String user_server_email = "";
		String pass_server_email = "";
		String server_email = "";
		String port_email = "";
		String from_email = "";



		List<Parametro> parametroList = parametroRepository.findByParamId("EMAIL");

		for (Parametro parametro : parametroList) {
			String value = parametro.getParametroKey().getParam_text();
			if ("USER_SERVER".equals(value)) {
				user_server_email = parametro.getValue();
			} else if ("PASS_SERVER".equals(value)) {
				pass_server_email = parametro.getValue();
			} else if ("SERVER".equals(value)) {
				server_email = parametro.getValue();
			} else if ("PORT".equals(value)) {
				port_email = parametro.getValue();
			} else if ("FROM".equals(value)) {
				from_email = parametro.getValue();
			} 
		}

		final String username = user_server_email;
		final String password = pass_server_email;

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		//props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", server_email);
		props.put("mail.smtp.port", port_email);
		

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from_email));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
			message.setSubject(asunto_email);
			message.setText(text_email);
			Transport.send(message);
			resultado = "OK";
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

		return resultado;
	}
}