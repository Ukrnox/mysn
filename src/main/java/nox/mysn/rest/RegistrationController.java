package nox.mysn.rest;

import nox.mysn.dto.NewUserDTO;
import nox.mysn.exceptions.RegistrationException;
import nox.mysn.models.Gender;
import nox.mysn.models.Role;
import nox.mysn.models.Status;
import nox.mysn.models.User;
import nox.mysn.services.UserService;
import nox.mysn.validations.RegistrationValidations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/reg")
public class RegistrationController {

    private final RegistrationValidations registrationValidations;
    private final UserService userService;

    @Autowired
    public RegistrationController(RegistrationValidations registrationValidations, UserService userService) {
        this.registrationValidations = registrationValidations;
        this.userService = userService;
    }

    @GetMapping()
    public String getRegPage() {
        return "registration";
    }

    @PostMapping()
    public ResponseEntity<?> postNewUser(@RequestBody NewUserDTO newUserDTO) {
        String email = newUserDTO.getEmail();
        String password = newUserDTO.getPassword();
        String repeatedPassword = newUserDTO.getRepeatedPassword();
        User newUser = new User();
        try {
            registrationValidations.emailValidation(email);
            registrationValidations.passwordValidation(password, repeatedPassword);
            newUser.setEmail(email);
            newUser.setFirstName(newUserDTO.getName());
            newUser.setMiddleName(newUserDTO.getMiddleName());
            newUser.setLastName(newUserDTO.getLastName());
            newUser.setGender(newUserDTO.getGender());
            newUser.setStatus(Status.ACTIVE);
            newUser.setRole(Role.USER);
            newUser.setAddress(newUserDTO.getAddress());
            newUser.setPassword(password);
            userService.save(newUser);
        }
        catch (RegistrationException exc) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, exc.getMessage(), exc);
        }
        System.out.println(newUser.toString());
        return ResponseEntity.ok("Welcome " + newUser.getFirstName());
//        String s = newUserDTO.toString();
//        User user = new User();
//        user.se
//
//        String name = newUserDTO.getName();
//        System.out.println(s);
//        if(name.equals("arra")){
//            return ResponseEntity.status(403).body(s.toString());
//        } else {
//            return ResponseEntity.ok().build();
//        }
//        throw new ResponseStatusException(
//                HttpStatus.NOT_FOUND, "Foo Not Found", exc);
    }

}
