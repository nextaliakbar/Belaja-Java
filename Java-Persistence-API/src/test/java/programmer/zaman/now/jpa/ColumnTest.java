package programmer.zaman.now.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.jpa.entity.Customer;
import programmer.zaman.now.jpa.util.JpaUtil;

public class ColumnTest {

    @Test
    void testColumn() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = new Customer();
        customer.setId("1");
        customer.setName("Ali");
        customer.setPrimaryEmail("ali@gmail.com");
        entityManager.persist(customer);

        Assertions.assertEquals("1", customer.getId());
        Assertions.assertEquals("Ali", customer.getName());
        Assertions.assertEquals("ali@gmail.com", customer.getPrimaryEmail());

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testTransient() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = new Customer();
        customer.setId("4");
        customer.setName("Rudi");
        customer.setPrimaryEmail("rudi@gmail.com");
        customer.setFullName("Rudi Ferdiansyah");
        entityManager.persist(customer);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

}
