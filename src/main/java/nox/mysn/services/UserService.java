package nox.mysn.services;

import nox.mysn.models.User;
import nox.mysn.repo.UserRepository;
import nox.mysn.security.MysnPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final MysnPasswordEncoder mysnPasswordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, MysnPasswordEncoder mysnPasswordEncoder) {
        this.userRepository = userRepository;
        this.mysnPasswordEncoder = mysnPasswordEncoder;
    }

    @Transactional()
    public List<User> findUsers() {
        return userRepository.findAll();
    }

    @Transactional
    public User save(User user) {
        user.setPassword(mysnPasswordEncoder.passwordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Transactional
    public User findUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Transactional
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
}
