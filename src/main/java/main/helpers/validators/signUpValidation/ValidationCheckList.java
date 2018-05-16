package main.helpers.validators.signUpValidation;

import java.util.ArrayList;
import java.util.List;

import main.beans.entities.GeneralClient;
import main.exceptions.IllegalRequestGameStoreException;
import main.helpers.validators.signUpValidation.validationRules.EmailValidatationRule;
import main.helpers.validators.signUpValidation.validationRules.PasswordValidatationRule;
import main.helpers.validators.signUpValidation.validationRules.UserNameValidatationRule;

public class ValidationCheckList {
	public static List<RegistrationRule> validationCheck() {
		List<RegistrationRule> rules = new ArrayList<>();
		rules.add(new EmailValidatationRule());
		rules.add(new PasswordValidatationRule());
		rules.add(new UserNameValidatationRule());
		return rules;
	}

	public static void validateClientFields(GeneralClient generalClient) throws IllegalRequestGameStoreException {
		for (RegistrationRule registrationRule : ValidationCheckList.validationCheck()) {
			registrationRule.validate(new RegistrationData(generalClient));
		}
	}
}
