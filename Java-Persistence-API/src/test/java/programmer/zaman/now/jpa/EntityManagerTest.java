package programmer.zaman.now.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.jpa.util.JpaUtil;

public class EntityManagerTest {

    @Test
    void testCreate() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // do something
        Assertions.assertNotNull(entityManager);

        entityManager.close();

        entityManagerFactory.close();
    }
}
