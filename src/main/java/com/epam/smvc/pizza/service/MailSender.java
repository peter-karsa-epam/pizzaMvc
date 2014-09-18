package com.epam.smvc.pizza.service;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
	private static final String TEST2000LUIGI_PW = "test2000LUIGI";
	private static final String TEST_FOR_LUIGI_PIZZA_GMAIL_COM = "testForLuigiPizza@gmail.com";
	private static final MailSender instance = new MailSender();

	private MailSender() {
		// nothing to do here
	}

	public static MailSender getInstance() {
		return instance;
	}

	public void send(final String mailTo, String customerName,
			String orderConfirmationId) {
		try {
			Properties props = new Properties();
			propertySetUp(props);

			Session mailSession = Session.getInstance(props,
					new javax.mail.Authenticator() {

						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(
									TEST_FOR_LUIGI_PIZZA_GMAIL_COM,
									TEST2000LUIGI_PW);
						}
					});

			mailSession.setDebug(true); // Enable the debug mode

			Message msg = new MimeMessage(mailSession);

			// --[ Set the FROM, TO, DATE and SUBJECT fields
			msg.setFrom(new InternetAddress(TEST_FOR_LUIGI_PIZZA_GMAIL_COM));
			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(mailTo));
			msg.setSentDate(new Date());
			msg.setSubject("Order response: " + orderConfirmationId);

			// --[ Create the body of the mail
			msg.setText("Dear "
					+ customerName
					+ ", \n"
					+ "Thank you for choosing Luigi!\nYour order has been registered, and will be delivered in 30-45 minutes!\n\n"
					+ "Ordered on: " + new Date());

			// --[ Ask the Transport class to send our mail message
			Transport.send(msg);

		} catch (Exception E) {
			System.out.println("Oops something has gone pearshaped!");
			System.out.println(E);
		}
	}

	private void propertySetUp(Properties props) {
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.socketFactory.fallback", "false");
	}

	public void send(String email, String name) {
		try {
			Properties props = new Properties();
			propertySetUp(props);

			Session mailSession = Session.getInstance(props,
					new javax.mail.Authenticator() {

						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(
									TEST_FOR_LUIGI_PIZZA_GMAIL_COM,
									TEST2000LUIGI_PW);
						}
					});

			mailSession.setDebug(true); // Enable the debug mode

			Message msg = new MimeMessage(mailSession);

			// --[ Set the FROM, TO, DATE and SUBJECT fields
			msg.setFrom(new InternetAddress(TEST_FOR_LUIGI_PIZZA_GMAIL_COM));
			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(email));
			msg.setSentDate(new Date());
			msg.setSubject("Successful registration");

			// --[ Create the body of the mail
			msg.setText("Bongiorno "
					+ name
					+ "! \n\n"
					+ "Thank you for choosing Luigi!\nYour profile has been registered, "
					+ "so you don't have to type in your city, address, etc. every time "
					+ "you order from Luigi! Furthermore Luigi will provide you with the "
					+ "latest discounts and new products!\n\nHave a nice day!\n\n"
					+ "Registered on: " + new Date());

			// --[ Ask the Transport class to send our mail message
			Transport.send(msg);

		} catch (Exception E) {
			System.out.println("Oops something has gone pearshaped!");
			System.out.println(E);
		}
	}
}
