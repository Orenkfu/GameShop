package main.messaging;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import main.messaging.mail.beans.Mail;

@Component
public class JMSMessagePoster implements JMSSender {

	@Autowired
	private JmsTemplate jms;

	public void postMail(Mail mail) {
		System.err.println("posting...");
		jms.send("queue", new MessageCreator() {

			@Override
			public Message createMessage(Session session) throws JMSException {
				System.err.println("creating msg...");
				session.createQueue("queue");
				return session.createObjectMessage(mail);
			}
		});
		System.err.println("JMSMessagePoster.postMail() --- message sent");
	}

}
