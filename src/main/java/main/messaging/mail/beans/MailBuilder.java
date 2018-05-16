package main.messaging.mail.beans;

import main.beans.entities.GeneralClient;
import main.beans.entities.User;

public class MailBuilder {
	private static final String PURCHASE_BODY = ", Thank you for buying through GameShop inc! please use the cdkey attached to this mail to play the game.";
	private static final String PURCHASE_TITLE = " - Your purchase is confirmed";
	private static final String REGISTRATION_TITLE = "GameShop Signup Confirmation";
	private static final String REGISTRATION_BODY = ", Thank you for joining the Game Shop family! please click this link to confirm your registration.";
	private static final String NEWSLETTER_TITLE = "placeholder newsletter title";
	private static final String NEWSLETTER_BODY = "placeholder newsletter body";

	public static Mail buildPurchaseMail(User user, Long cdkeyCode) {
		return new Mail(user.getEmail(), user.getName() + PURCHASE_BODY, user.getUsername() + PURCHASE_TITLE, cdkeyCode,
				MailType.PURCHASE);
	}

	public static Mail buildGiftMail(String recipient, Long cdkeyCode) {
		// TODO: make a proper gift mail when gift feature is implemented
		return new Mail(recipient, PURCHASE_BODY, PURCHASE_TITLE, cdkeyCode, MailType.GIFT);
	}

	public static Mail buildNewsLetterMail(String recipient) {
		return new Mail(recipient, NEWSLETTER_TITLE, NEWSLETTER_BODY, MailType.NEWSLETTER);
	}

	public static Mail buildRegistrationMail(GeneralClient client, String url) {
		Mail mail = new Mail(client.getEmail(), client.getName() + REGISTRATION_BODY, REGISTRATION_TITLE,
				MailType.SIGNUP);
		mail.setUrl(url);
		return mail;
	}
}
