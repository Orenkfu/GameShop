package main.messaging.mail.mailSenders;

import org.springframework.mail.javamail.JavaMailSender;

import main.exceptions.GameStoreException;
import main.messaging.mail.beans.Mail;

public class NewsletterMailSender implements MailSender {
	JavaMailSender sender;

	public JavaMailSender getSender() {
		return sender;
	}

	public void setSender(JavaMailSender sender) {
		this.sender = sender;
	}

	@Override
	public void send(Mail mail) throws GameStoreException {

	}

}
