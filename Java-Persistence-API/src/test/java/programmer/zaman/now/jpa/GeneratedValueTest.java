package programmer.zaman.now.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.jpa.entity.Categorie;
import programmer.zaman.now.jpa.util.JpaUtil;

public class GeneratedValueTest {

    @Test
    void testGeneratedValue() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Categorie categorie = new Categorie();
        categorie.setName("Gadget");
        categorie.setDescription("Gadget layar 5,1Inch");
        entityManager.persist(categorie);

        Assertions.assertEquals("Gadget", categorie.getName());
        Assertions.assertEquals("Gadget layar 5,1Inch", categorie.getDescription());

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
