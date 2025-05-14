package tn.esprit.spring.services;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository; // ✅ interface

import java.util.Optional;

public class UserServiceImpl {

    private UserRepository userRepository;

    public void setUserRepository(UserRepository repo) {
        this.userRepository = repo;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User retrieveUser(String id) {
        try {
            Optional<User> u = userRepository.findById(Long.parseLong(id));
            return u.orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    public User updateUser(User user) {
        Optional<User> existing = userRepository.findById(user.getId());
        if (existing.isPresent()) {
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(User user) {
        try {
            userRepository.deleteById(user.getId());
        } catch (Exception e) {
            // log ici si besoin
        }
    }
}
