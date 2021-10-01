package nox.mysn.controllers;

import nox.mysn.models.User;
import nox.mysn.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public @ResponseBody
    List<User> getAllUsers() {
        return userService.findUsers();
    }

    @GetMapping("{userId}")
    public @ResponseBody
    User getUserById(@PathVariable("userId") Long userId) {
        return userService.findUserById(userId);
    }
}
