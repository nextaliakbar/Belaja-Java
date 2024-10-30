package programmer.zaman.now.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.jpa.entity.Customer;
import programmer.zaman.now.jpa.util.JpaUtil;

public class DataTypeTest {

    @Test
    void testDataType() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = new Customer();
        customer.setId("2");
        customer.setName("Budi");
        customer.setPrimaryEmail("budi@gmail.com");
        customer.setAge((byte)21);
        customer.setMerried(false);
        entityManager.persist(customer);

        Assertions.assertEquals("2", customer.getId());
        Assertions.assertEquals("Budi", customer.getName());
        Assertions.assertEquals("budi@gmail.com", customer.getPrimaryEmail());
        Assertions.assertEquals((byte)21, customer.getAge());
        Assertions.assertFalse(customer.getMerried());

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
