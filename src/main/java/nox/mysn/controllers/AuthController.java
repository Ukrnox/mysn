package nox.mysn.controllers;

import nox.mysn.models.Role;
import nox.mysn.models.Status;
import nox.mysn.models.User;
import nox.mysn.repo.UserRepository;
import nox.mysn.security.MysnPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AuthController {

    UserRepository userRepository;

    MysnPasswordEncoder mysnPasswordEncoder;

    @Autowired
    public AuthController(UserRepository userRepository, MysnPasswordEncoder mysnPasswordEncoder) {
        this.userRepository = userRepository;
        this.mysnPasswordEncoder = mysnPasswordEncoder;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/main")
    public String getMain() {
        return "main";
    }

    @GetMapping("/success")
    public String getSuccessPage() {
        User user = new User();
        user.setEmail("user@gmail.com");
        user.setPassword(mysnPasswordEncoder.passwordEncoder().encode("user"));
        user.setRole(Role.ADMIN);
        user.setStatus(Status.ACTIVE);
        userRepository.save(user);
        System.out.println();
        return "login";
    }
}
