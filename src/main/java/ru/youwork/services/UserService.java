package ru.youwork.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.youwork.models.User;
import ru.youwork.models.enams.Role;
import ru.youwork.repositories.UserRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(User user){
        String email = user.getEmail();

        if (userRepository.findByEmail(email) != null) return false;

        user.setActive(true);
        user.getRoles().add(Role.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
        log.info("Savin new user with email {}", email);
        return true;
    }
}
