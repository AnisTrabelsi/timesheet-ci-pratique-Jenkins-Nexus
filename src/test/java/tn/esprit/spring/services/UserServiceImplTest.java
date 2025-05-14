package tn.esprit.spring.services;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Test unitaire pour la classe UserServiceImpl.
 * <p>
 * Ce test ne fait pas appel à Spring (pas d'annotation @SpringBootTest),
 * il reste donc léger et rapide à exécuter.
 * Il intègre aussi un mécanisme pour forcer l'échec via la variable d'environnement TIMESHEET_TESTS_FAIL.
 * </p>
 */
class UserServiceImplTest {

    /**
     * Test de la méthode addUser() de UserServiceImpl.
     * <ul>
     *   <li>Si TIMESHEET_TESTS_FAIL vaut "true", le test échoue volontairement.</li>
     *   <li>Sinon, il passe (TODO : ajouter de vraies assertions).</li>
     * </ul>
     */
    @Test
    void testAddUser() {
        // 1) Récupération de la variable d'environnement
        String failFlag = System.getenv("TIMESHEET_TESTS_FAIL");

        // 2) Si la variable existe et vaut "true" (insensible à la casse), on force l'échec
        if ("true".equalsIgnoreCase(failFlag)) {
            fail("Échec volontaire car TIMESHEET_TESTS_FAIL=true");
        }

        // 3) TODO : appeler la vraie méthode addUser et vérifier le résultat.
        // Exemple :
        // UserServiceImpl service = new UserServiceImpl();
        // User newUser = service.addUser(new User("prenom", "nom", "email@exemple.com"));
        // assertNotNull(newUser);
        // assertEquals("prenom", newUser.getFirstName());
    }
}

