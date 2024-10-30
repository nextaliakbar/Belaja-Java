package programmer.zaman.now.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.jpa.entity.Categorie;
import programmer.zaman.now.jpa.entity.Customer;
import programmer.zaman.now.jpa.util.JpaUtil;

import java.time.LocalDateTime;
import java.util.Calendar;

public class DateTest {

    @Test
    void testDate() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Categorie categorie = new Categorie();
        categorie.setName("food");
        categorie.setDescription("Description Food");
        categorie.setCreatedAt(Calendar.getInstance());
        categorie.setUpdatedAt(LocalDateTime.now());

        entityManager.persist(categorie);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
