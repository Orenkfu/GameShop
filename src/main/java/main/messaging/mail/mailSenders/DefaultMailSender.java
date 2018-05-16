package main.messaging.mail.mailSenders;

import org.springframework.mail.javamail.JavaMailSender;

import main.exceptions.GameStoreException;
import main.io.CDKeyReader;
import main.messaging.mail.beans.Mail;

public class DefaultMailSender implements MailSender {

	private JavaMailSender sender;
	private CDKeyReader reader;

	public JavaMailSender getSender() {
		return sender;
	}

	public void setSender(JavaMailSender sender) {
		this.sender = sender;
	}

	public CDKeyReader getReader() {
		return reader;
	}

	public void setReader(CDKeyReader reader) {
		this.reader = reader;
	}

	@Override
	public void send(Mail mail) throws GameStoreException {
		// TODO Auto-generated method stub

	}

}
