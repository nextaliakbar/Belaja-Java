package programmer.zaman.now.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.jpa.util.JpaUtil;

public class TransactionTest {

    @Test
    void testTransaction() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EntityTransaction transaction = entityManager.getTransaction();
        Assertions.assertNotNull(transaction);

        try {
            transaction.begin();
            // manipulasi database
        } catch(Throwable throwable) {
            transaction.rollback();
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
