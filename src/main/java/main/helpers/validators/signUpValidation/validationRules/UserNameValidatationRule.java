package main.helpers.validators.signUpValidation.validationRules;

import main.exceptions.ExceptionMessage;
import main.exceptions.IllegalRequestGameStoreException;
import main.helpers.validators.signUpValidation.RegistrationData;
import main.helpers.validators.signUpValidation.RegistrationRule;

/**
 * @author Yura Kourlyand
 */
public class UserNameValidatationRule implements RegistrationRule {
    @Override
    public void validate(RegistrationData regData) throws IllegalRequestGameStoreException {
        String pattern = "^(?=\\S+$)[a-zA-Z0-9]{4,12}$";
        if(!regData.getName().matches(pattern)){
            throw new IllegalRequestGameStoreException(ExceptionMessage.BADEMAIL);
        }
    }
}
