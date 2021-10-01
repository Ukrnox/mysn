package nox.mysn.validations;

import nox.mysn.exceptions.RegistrationException;
import nox.mysn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistrationValidations {

    private final UserService userService;

    @Autowired
    public RegistrationValidations(UserService userService) {
        this.userService = userService;
    }

    public void emailValidation(String email) throws RegistrationException {
        if (userService.findUserByEmail(email) != null) {
            throw new RegistrationException("User with mail " + email + "already exists.");
        }
    }

    public void passwordValidation(String password, String repeatedPassword) throws RegistrationException {
        if (!password.equals(repeatedPassword)) {
            throw new RegistrationException("Password mismatch.");
        }
    }
}
