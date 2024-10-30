package programmer.zaman.now.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import programmer.zaman.now.jpa.entity.Categorie;
import programmer.zaman.now.jpa.entity.Customer;
import programmer.zaman.now.jpa.entity.Member;
import programmer.zaman.now.jpa.util.JpaUtil;

public class ListenerTest {

    private static final Logger log = LoggerFactory.getLogger(ListenerTest.class);

    @Test
    void testListener() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Categorie categorie = new Categorie();
        categorie.setName("Example");

        entityManager.persist(categorie);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testEntityListener() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Member member = entityManager.find(Member.class, 1);
        Assertions.assertEquals("Mr. Ali Akbar Rafsanjani", member.getFullName());

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

}
