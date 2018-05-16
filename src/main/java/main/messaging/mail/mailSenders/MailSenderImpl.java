package main.messaging.mail.mailSenders;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import main.exceptions.GameStoreException;
import main.io.CDKeyReaderImpl;
import main.messaging.mail.beans.Mail;
import main.messaging.mail.beans.MailType;

@Component
public class MailSenderImpl implements MailSender {

	List<MailType> types;
	@Autowired
	JavaMailSender sender;

	@Autowired
	CDKeyReaderImpl cdReader;

	public MailSenderImpl() {
		// senders.addAll(Arrays.asList(new GiftMailSender(), new
		// NewsletterMailSender(), new DefaultMailSender(),
		// new PurchaseConfirmedMailSender(), new RegistationMailSender()));
		types = Arrays.asList(MailType.values());
	}

	@Override
	public void send(Mail mail) throws GameStoreException {
		System.out.println("ACTIVATED MAIL SENDING METHOD, MAIL: " + mail);
		MailSender sender;
		switch (mail.getType()) {
		case PURCHASE:
			sender = new PurchaseConfirmedMailSender();
			((PurchaseConfirmedMailSender) sender).setSender(this.sender);
			((PurchaseConfirmedMailSender) sender).setCdReader(this.cdReader);
			sender.send(mail);
			break;
		case NEWSLETTER:
			sender = new NewsletterMailSender();
			((NewsletterMailSender) sender).setSender(this.sender);
			sender.send(mail);
			break;
		case SIGNUP:
			sender = new RegistationMailSender();
			((RegistationMailSender) sender).setSender(this.sender);
			sender.send(mail);
			break;
		case GIFT:
			sender = new GiftMailSender();
			((GiftMailSender) sender).setSender(this.sender);
			((GiftMailSender) sender).setReader(this.cdReader);
			sender.send(mail);
			break;
		default:
			sender = new DefaultMailSender();
			((DefaultMailSender) sender).setSender(this.sender);
			((DefaultMailSender) sender).setReader(this.cdReader);
			sender.send(mail);
			break;
		}
		// try {
		// sender.send(mail);
		// } catch (GameStoreException e) {
		// e.printStackTrace();
		// }

	}
}
