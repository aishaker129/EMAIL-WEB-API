package com.emailapi;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        System.out.println("Hello AI");
        String message = "Hello this is Akhlakul Islam";
        String subject = "CodersArea: Confirmation";
        String to = "shaker209207@gmail.com";
        String from = "helloaishaker@gmail.com";
        
        
//        sendEmail(message,subject,to,from);
        sendAttachment(message,subject,to,from);
    }

	private static void sendAttachment(String message, String subject, String to, String from) {
		// variable for gmail
				String host = "smtp.gmail.com";
				
				// get the system properties
				Properties properties =  System.getProperties();
				System.out.println("PROPERTIES :" + properties);
				
				// setting important information to properties
				
				// host set
				properties.put("mail.smtp.host", host);
				properties.put("mail.smtp.port", "465");
				properties.put("mail.smtp.ssl.enable", "true");
				properties.put("mail.smtp.auth", "true");
				
				
				// Step 1: to get the session object
				Session session = Session.getInstance(properties, new Authenticator() {

					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						// TODO Auto-generated method stub
						return new PasswordAuthentication("helloaishaker@gmail.com", "********");
					}
					
				});
				
				session.setDebug(true);
				
				// Step 2: compose the message(text,multi media)
				
				MimeMessage m = new MimeMessage(session);
				
				try {
					// from email
					m.setFrom(from);
					
					// adding recipent to message
					m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
					
					// adding subject to message
					m.setSubject(subject);
					
					// adding test to message
//					m.setText(message);
					
					// attachment...
					// file path
					String path = "/home/ai-shaker/Pictures/shaker.jpg";
					
					MimeMultipart mimeMultipart = new MimeMultipart();
					// text
					// file
					
					MimeBodyPart textMime = new MimeBodyPart();
					
					MimeBodyPart fileMime = new MimeBodyPart();
					
					try {
						
						textMime.setText(message);
						
						File file = new File(path);
						fileMime.attachFile(file);
						
						mimeMultipart.addBodyPart(textMime);
						
						mimeMultipart.addBodyPart(fileMime);
						
						
						
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					
					// send message
					
					m.setContent(mimeMultipart);
					
					// Step 3: send the message using Transport class
					Transport.send(m);
					
					System.out.println("Sent successfully....");
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	}

	private static void sendEmail(String message, String subject, String to, String from) {
		
		
		// variable for gmail
		String host = "smtp.gmail.com";
		
		// get the system properties
		Properties properties =  System.getProperties();
		System.out.println("PROPERTIES :" + properties);
		
		// setting important information to properties
		
		// host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		
		
		// Step 1: to get the session object
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("helloaishaker@gmail.com", "********");
			}
			
		});
		
		session.setDebug(true);
		
		// Step 2: compose the message(text,multi media)
		
		MimeMessage m = new MimeMessage(session);
		
		try {
			// from email
			m.setFrom(from);
			
			// adding recipent to message
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			// adding subject to message
			m.setSubject(subject);
			
			// adding test to message
			m.setText(message);
			
			// send message
			
			// Step 3: send the message using Transport class
			Transport.send(m);
			
			System.out.println("Sent successfully....");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		  
	}
}
