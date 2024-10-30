package programmer.zaman.now.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.jpa.entity.Customer;
import programmer.zaman.now.jpa.entity.CustomerType;
import programmer.zaman.now.jpa.util.JpaUtil;

public class EnumTest {

    @Test
    public void testEnum() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = new Customer();
        customer.setId("3");
        customer.setName("Joko");
        customer.setPrimaryEmail("joko@gmail.com");
        customer.setAge((byte)30);
        customer.setMerried(true);
        customer.setType(CustomerType.PREMIUM);

        entityManager.persist(customer);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
