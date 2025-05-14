package tn.esprit.spring.repository;

import tn.esprit.spring.entities.User;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long id);
    void deleteById(Long id);
}
