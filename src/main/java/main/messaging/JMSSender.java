package main.messaging;

import main.messaging.mail.beans.Mail;

public interface JMSSender {
	public void postMail(Mail mail);
}
