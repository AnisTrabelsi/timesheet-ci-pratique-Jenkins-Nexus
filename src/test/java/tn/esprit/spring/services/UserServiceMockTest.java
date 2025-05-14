package tn.esprit.spring.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepositoryMock;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test unitaire de UserServiceImpl avec un mock manuel (UserRepositoryMock)
 */
public class UserServiceMockTest {

    private UserServiceImpl userService;
    private User sampleUser;

    @BeforeEach
    void setUp() {
        // Création du service
        userService = new UserServiceImpl();

        // Injection du mock dans le service
        userService.setUserRepository(new UserRepositoryMock());

        // Préparation d’un utilisateur exemple
        sampleUser = new User();
        sampleUser.setFirstName("Anis");
        sampleUser.setLastName("Trabelsi");
    }

    @Test
    void testAddUser() {
        User added = userService.addUser(sampleUser);
        assertNotNull(added.getId(), "L’ID doit être automatiquement généré");
        assertEquals("Anis", added.getFirstName());
    }

    @Test
    void testRetrieveUser() {
        User added = userService.addUser(sampleUser);
        User retrieved = userService.retrieveUser(String.valueOf(added.getId()));
        assertNotNull(retrieved);
        assertEquals("Anis", retrieved.getFirstName());
    }

    @Test
    void testUpdateUser() {
        User added = userService.addUser(sampleUser);
        added.setLastName("Modifié");
        User updated = userService.updateUser(added);
        assertEquals("Modifié", updated.getLastName());
    }

    @Test
    void testDeleteUser() {
        User added = userService.addUser(sampleUser);
        userService.deleteUser(added);
        User deleted = userService.retrieveUser(String.valueOf(added.getId()));
        assertNull(deleted, "L'utilisateur doit être supprimé");
    }
}
