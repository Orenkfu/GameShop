package main.helpers.validators.signUpValidation;

import main.beans.entities.GeneralClient;
import main.exceptions.IllegalRequestGameStoreException;
import main.helpers.validators.Validator;

/**
 * @author Yura Kourlyand
 */
public class RegistrationData {
    private String name;
    private String username;
    private String password;
    private String email;

    public RegistrationData(GeneralClient generalClient) throws IllegalRequestGameStoreException {
        Validator.GeneralClientNoNullsChecker(generalClient);
        this.name = generalClient.getName();
        this.username = generalClient.getUsername();
        this.email = generalClient.getEmail();
        this.password = generalClient.getPassword();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "RegistrationData{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
