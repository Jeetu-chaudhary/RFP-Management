package com.util;

import java.io.UnsupportedEncodingException;
import java.util.Objects;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.dao.Dao;
import com.dao.MySQLDao;
import com.service.IServiceImpl;
import com.service.Service;

public class SessionFactory {
//	private static ControllerServlet controller;
	private static Service service;
	private static Dao dao;
 

	private SessionFactory() {
	}


	public static String getHashedValue(String code) {
		int hashCode = Objects.hashCode(code);
		String hashedValue = Integer.toHexString(hashCode);
		return hashedValue;
	}

	public static Service getService() {
		if (service == null)
			service = new IServiceImpl();
		return service;
	}

	public static Dao getDao() {
		if (dao == null)
			dao = new MySQLDao();
		return dao;
	}
	public static void SendMail(String id, String to, String from,
            String subject, String body, boolean content,
            String password) {
		
	
		String pass = "fxqz gjdr jlza kxas";

		 try {
			 
	            // acquire a secure SMTPs session
	            Properties pros = new Properties();
	            pros.put("mail.transport.protocol", "smtps");
	            pros.put("mail.smtps.host", "smtp.gmail.com");
	            pros.put("mail.smtps.port", "465");
	            pros.put("mail.smtps.auth", "true");
	            pros.put("mail.smtps.quitwait", "false");
	           Session session = Session.getDefaultInstance(pros);
	            session.setDebug(true);

	            // Wrap a message in session
	            Message message = new MimeMessage(session);
	            message.setSubject(subject);

	            if (content) {
	                message.setContent(body, "text/html");
	            } else {
	                message.setText(body);
	            }

	            // specify E-mail address of Sender and Receiver
	            Address sender = new InternetAddress(from, id);
	            Address receiver = new InternetAddress(to);
	            message.setFrom(sender);
	            message.setRecipient(Message.RecipientType.TO, receiver);

	            // sending an E-mail
	            try (Transport tt = session.getTransport("smtps")) {
	          
	                tt.connect("smtp.gmail.com", 465, from , password);
	                tt.sendMessage(message, message.getAllRecipients());
	                
	            }
	        } catch (MessagingException|UnsupportedEncodingException e) {
	           
	        }
		
	}
}
