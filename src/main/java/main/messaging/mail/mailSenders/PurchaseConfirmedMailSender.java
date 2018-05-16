package main.messaging.mail.mailSenders;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import main.exceptions.ExceptionMessage;
import main.exceptions.GameStoreException;
import main.exceptions.GameStoreMailingException;
import main.helpers.validators.mailSystemValidation.validationRules.PurchaseConfirmRule;
import main.io.CDKeyReaderImpl;
import main.messaging.mail.beans.Mail;

public class PurchaseConfirmedMailSender implements MailSender {

	private JavaMailSender sender;

	private CDKeyReaderImpl cdReader;

	public JavaMailSender getSender() {
		return sender;
	}

	public void setSender(JavaMailSender sender) {
		this.sender = sender;
	}

	public CDKeyReaderImpl getCdReader() {
		return cdReader;
	}

	public void setCdReader(CDKeyReaderImpl cdReader) {
		this.cdReader = cdReader;
	}

	@Override
	public void send(Mail mail) throws GameStoreException {

		new PurchaseConfirmRule().validate(mail);
		File cdkey = cdReader.getCDKeyFile(mail.getKeyCodeLocation());
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper;
		try {
			helper = new MimeMessageHelper(message, true);
			helper.setSubject(mail.getTitle());
			helper.setTo(mail.getRecipient());
			helper.setText(mail.getBody(), true);
			helper.addAttachment("Your CD Key", cdkey);
		} catch (MessagingException e) {

			throw new GameStoreMailingException(ExceptionMessage.MAILFAILURE);
		}

		sender.send(message);
	}

}
