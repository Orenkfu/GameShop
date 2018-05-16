package main.helpers.validators.signUpValidation.validationRules;

import main.exceptions.ExceptionMessage;
import main.exceptions.IllegalRequestGameStoreException;
import main.helpers.validators.signUpValidation.RegistrationData;
import main.helpers.validators.signUpValidation.RegistrationRule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Yura Kourlyand
 */
public class PasswordValidatationRule implements RegistrationRule {
    @Override
    public void validate(RegistrationData regData) throws IllegalRequestGameStoreException {
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=\\S+$).{8,16}$";
        Matcher m = Pattern.compile(pattern).matcher(regData.getPassword());
        if(!m.matches()){
            throw new IllegalRequestGameStoreException(ExceptionMessage.BADPASSWORD);
        }
    }
}
