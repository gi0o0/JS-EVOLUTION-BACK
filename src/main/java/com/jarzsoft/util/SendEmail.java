package com.jarzsoft.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

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

	public String Send(String emailTo, String asunto_email, String text_email, ArrayList<String> adjuntos,
			String emailsCc) {

		String resultado = "NOK";
		String user_server_email = "";
		String pass_server_email = "";
		String server_email = "";
		String port_email = "";
		String from_email = "";

		if (emailTo == null || "".equals(emailTo) || asunto_email == null || "".equals(asunto_email)
				|| text_email == null || "".equals(text_email)) {
			return "";
		}

		List<Parametro> parametroList = parametroRepository.findByParamId("EMAIL");

		for (Parametro parametro : parametroList) {
			String value = parametro.getParametroKey().getParam_text();
			if ("USER_SERVER".equals(value)) {
				user_server_email = parametro.getValue().trim();
			} else if ("PASS_SERVER".equals(value)) {
				pass_server_email = parametro.getValue().trim();
			} else if ("SERVER".equals(value)) {
				server_email = parametro.getValue().trim();
			} else if ("PORT".equals(value)) {
				port_email = parametro.getValue().trim();
			} else if ("FROM".equals(value)) {
				from_email = parametro.getValue().trim();
			}
		}

		final String username = user_server_email;
		final String password = pass_server_email;

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		props.put("mail.smtp.host", server_email);
		props.put("mail.smtp.port", port_email);
		props.put("mail.smtp.ssl.trust", "*");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from_email));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));

			if (null != emailsCc && !"".equals(emailsCc))
				message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(emailsCc));

			message.setSubject(asunto_email);
			
			MimeBodyPart mimeBodyPart = new MimeBodyPart();
            mimeBodyPart.setContent(text_email,"text/html; charset=utf-8");
        	Multipart multipart = new MimeMultipart();
        	multipart.addBodyPart(mimeBodyPart);
        	
			if (null != adjuntos && adjuntos.size() > 0) {
			
				for (String pathFile : adjuntos) {
					MimeBodyPart messageBodyPart = new MimeBodyPart();
					DataSource source = new FileDataSource(pathFile);
					messageBodyPart.setDataHandler(new DataHandler(source));
					messageBodyPart.setFileName(pathFile);
					multipart.addBodyPart(messageBodyPart);
				}
				
			}
			message.setContent(multipart);
			Transport.send(message);
			resultado = "OK";
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return resultado;
	}
}