package nox.mysn.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.Locale;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude = {})
@EqualsAndHashCode(exclude = {})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "address")
    private String address;
    @Column(name = "gender")
    private Gender gender;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;

    public void setGender(String gender) {
        gender = gender.toLowerCase(Locale.ROOT);
        if (gender.equals("male")) {
            this.gender = Gender.MALE;
        }
        if (gender.equals("female")) {
            this.gender = Gender.FEMALE;
        }
        else {
            this.gender = Gender.OTHER;
        }
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
