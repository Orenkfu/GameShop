package main.helpers.validators.signUpValidation;

import main.exceptions.IllegalRequestGameStoreException;

/**
 * @author Yura Kourlyand
 */
public interface RegistrationRule {
    void validate(RegistrationData regData) throws IllegalRequestGameStoreException;
}
