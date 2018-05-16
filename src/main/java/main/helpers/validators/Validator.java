package main.helpers.validators;

import main.beans.entities.GeneralClient;
import main.exceptions.ExceptionMessage;
import main.exceptions.IllegalRequestGameStoreException;
import org.springframework.stereotype.Component;

//@Component
public class Validator {

	/**
	 * Runs all validation checks necessary to add game checks before delegating
	 * game creation to facade.
	 */
	public void validateGameCreate() {
		// TO DO: run game database save validations
		System.out.println("Validator.validateGameCreate() ---- does not do anything yet.");
	}


	public static void GeneralClientNoNullsChecker(GeneralClient g) throws IllegalRequestGameStoreException {
		 if(g.getUsername() == null || g.getPassword() == null || g.getEmail() == null || g.getName() == null) throw new IllegalRequestGameStoreException(ExceptionMessage.EMPTYFIELDSIGNUP);
	}
}
