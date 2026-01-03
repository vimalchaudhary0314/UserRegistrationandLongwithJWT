package io.jwtusetologin.login.service;

import io.jwtusetologin.login.model.User;
import io.jwtusetologin.login.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repo;
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public UserService(UserRepository repo,
                       BCryptPasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    public void registerUser(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setRole("USER");
        repo.save(user);
    }

    public User findByUsername(String username) {
        return repo.findByUsername(username);
    }

    public boolean checkPassword(String raw, String encoded) {
        return encoder.matches(raw, encoded);
    }
}
