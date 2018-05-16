package main.messaging.mail.mailSenders;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import main.exceptions.ExceptionMessage;
import main.exceptions.GameStoreException;
import main.exceptions.GameStoreMailingException;
import main.messaging.mail.beans.Mail;

public class RegistationMailSender implements MailSender {
	private JavaMailSender sender;

	public JavaMailSender getSender() {
		return sender;
	}

	public void setSender(JavaMailSender sender) {
		this.sender = sender;
	}

	// TODO: ACTIVATION AUTHORIZATION
	@Override
	public void send(Mail mail) throws GameStoreException {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true);
			helper.setSubject(mail.getTitle());
			helper.setTo(mail.getRecipient());
			helper.setText(mail.getBody() + mail.getUrl(), true);
		} catch (MessagingException e) {
			throw new GameStoreMailingException(ExceptionMessage.MAILFAILURE);
		}

		sender.send(message);

	}

}
