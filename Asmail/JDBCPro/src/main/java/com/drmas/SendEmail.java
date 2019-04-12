package com.drmas;

import java.util.Properties;
import javax.mail.*;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	
	public static void main(String[] args) {
		String to = "imdrmas@gmail.com";
		
		Properties props = new Properties();
		props.put("mail.stmp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.stmp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smpt.auth", "true");
		props.put("mail.smtp.port", "465");
		
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("imdrmas@gmail.com", "10010164ISSAMDRMAS");
				
			}
		});
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("imdrmas@gmail.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Hello");
			message.setText("Testing Email ....");
			
			Transport.send(message);
			System.out.println("Message sent successfuly");
			
		}catch(Exception e) {
			
		}
	}

}
