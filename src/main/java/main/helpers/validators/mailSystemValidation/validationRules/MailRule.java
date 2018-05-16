package main.helpers.validators.mailSystemValidation.validationRules;

import main.exceptions.GameStoreException;
import main.messaging.mail.beans.Mail;

public interface MailRule {
	void validate(Mail mail) throws GameStoreException;
}
