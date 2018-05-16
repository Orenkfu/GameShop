package main.helpers.validators.mailSystemValidation.validationRules;

import org.apache.commons.validator.routines.EmailValidator;

import main.exceptions.ExceptionMessage;
import main.exceptions.GameStoreException;
import main.exceptions.GameStoreMailingException;
import main.messaging.mail.beans.Mail;
import main.messaging.mail.beans.MailType;

public class PurchaseConfirmRule implements MailRule {

	@Override
	public void validate(Mail mail) throws GameStoreException {
		if (!EmailValidator.getInstance().isValid(mail.getRecipient()) || mail.getKeyCodeLocation() == null
				|| !MailType.PURCHASE.equals(mail.getType())) {
			throw new GameStoreMailingException(ExceptionMessage.MAILFAILURE);
		}
	}

}
