package ru.youwork.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.youwork.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
