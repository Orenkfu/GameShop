package main.messaging.mail.jms;

public interface MailListener {
	public void readAndSendMail(String xml);
}
