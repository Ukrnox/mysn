package nox.mysn.dto;

import lombok.Data;

@Data
public class NewUserDTO {
    String name;
    String middleName;
    String lastName;
    String gender;
    String address;
    String email;
    String password;
    String repeatedPassword;
}
