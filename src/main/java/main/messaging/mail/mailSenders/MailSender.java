package main.messaging.mail.mailSenders;

import main.exceptions.GameStoreException;
import main.messaging.mail.beans.Mail;

public interface MailSender {

	void send(Mail mail) throws GameStoreException;
}
