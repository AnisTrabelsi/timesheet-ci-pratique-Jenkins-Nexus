package tn.esprit.spring.repository;

import tn.esprit.spring.entities.User;
import java.util.ArrayList;
import java.util.Optional;

public class UserRepositoryMock implements UserRepository {

    ArrayList<User> users = new ArrayList<>();
    long currentId = 0;

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            currentId++;
            user.setId(currentId);
            users.add(user);
        }
        return user;
    }

    @Override
    public void deleteById(Long id) {
        users.removeIf(user -> user.getId() != null && user.getId().equals(id));
    }

    @Override
    public Optional<User> findById(Long id) {
        return users.stream()
            .filter(user -> user.getId() != null && user.getId().equals(id))
            .findFirst();
    }
}
