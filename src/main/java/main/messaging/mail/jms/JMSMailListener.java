package main.messaging.mail.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import main.exceptions.GameStoreException;
import main.messaging.mail.beans.Mail;
import main.messaging.mail.mailSenders.MailSender;

@Component
public class JMSMailListener implements MailListener {
	MailSender sender;

	@Autowired
	public void setMailSender(MailSender sender) {
		this.sender = sender;
	}

	@JmsListener(destination = "queue")
	public void readAndSendMail(String xml) {
		System.err.println("MESSAGE RECEIVED");
		Mail mail = Mail.fromXml(xml);
		System.err.println(mail.getBody());
		// if (mail == null) {
		// // LOG
		// return;
		// }
		try {
			sender.send(mail);
			System.out.println("JMSMailListener.readandSendMail() ---- mail sent");
		} catch (GameStoreException e) {
			// TODO LOG
			e.printStackTrace();
		}

	}

}
