package com.spinach.bean;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class MailUtil {
	
	private static String host = "smtp.gmail.com";
	private static String username = "spinachstore@gmail.com";
	private static String password = "spinachpolid";
	private static int port = 587;
	
	public static void sendEmail(String address, String name, String webname, String title, String content, String headerHost, Long shipId, String totalPrice) {
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", port);

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		content = content.replace("\n", "<br>");
		address += ", spinachstore@gmail.com";
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username, "Spinach Store"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(address));
			message.setSubject(title);
			message.setContent(content, "text/html;charset=utf-8");
			Transport transport = session.getTransport("smtp");
			transport.connect(host, port, username, password);

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Send complete.");
	}
	
	public static String getHost() {
		return host;
	}

	public static void setHost(String host) {
		MailUtil.host = host;
	}

	public static String getUsername() {
		return username;
	}

	public static void setUsername(String username) {
		MailUtil.username = username;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		MailUtil.password = password;
	}

	public static int getPort() {
		return port;
	}

	public static void setPort(int port) {
		MailUtil.port = port;
	}

}
