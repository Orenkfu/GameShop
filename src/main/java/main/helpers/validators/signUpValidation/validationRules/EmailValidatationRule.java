package main.helpers.validators.signUpValidation.validationRules;

import main.exceptions.ExceptionMessage;
import main.exceptions.IllegalRequestGameStoreException;
import main.helpers.validators.signUpValidation.RegistrationData;
import main.helpers.validators.signUpValidation.RegistrationRule;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Yura Kourlyand
 */
public class EmailValidatationRule implements RegistrationRule {
    @Override
    public void validate(RegistrationData regData) throws IllegalRequestGameStoreException {
      boolean emailIsValid = EmailValidator.getInstance().isValid(regData.getEmail());
        if(!emailIsValid){
            throw new IllegalRequestGameStoreException(ExceptionMessage.BADEMAIL);
        }
    }
}
