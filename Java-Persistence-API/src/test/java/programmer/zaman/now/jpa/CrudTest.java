package programmer.zaman.now.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import programmer.zaman.now.jpa.entity.Customer;
import programmer.zaman.now.jpa.util.JpaUtil;

public class CrudTest {

    private static final Logger log = LoggerFactory.getLogger(CrudTest.class);
    private EntityManagerFactory entityManagerFactory;

    @BeforeEach
    public void setUp() {
        entityManagerFactory = JpaUtil.getEntityManagerFactory();

    }

    @Test
    void testInsert() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = new Customer();
        customer.setId("1");
        customer.setName("Akbar");

        entityManager.persist(customer); // menambahkan data ke database

        transaction.commit();
        entityManager.close();
    }

    @Test
    void testUpdate() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = entityManager.find(Customer.class, "1");
        Assertions.assertNotNull(customer);
        Assertions.assertEquals("1", customer.getId());
        Assertions.assertEquals("Rafsanjani", customer.getName());

        customer.setName("Ali");
        entityManager.merge(customer); // Merubah data di database

        transaction.commit();
        entityManager.close();
    }

    @Test
    void testDelete() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = entityManager.find(Customer.class, "1");
        entityManager.remove(customer); // menghapus data di database

        transaction.commit();
        entityManager.close();
    }

    @Test
    void testFind() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Customer customer = entityManager.find(Customer.class, "1"); // membaca data berdasarkan id
        Assertions.assertNotNull(customer);
        Assertions.assertEquals("1", customer.getId());
        Assertions.assertEquals("Akbar", customer.getName());

        log.info("Id {} ; Name {}", customer.getId(), customer.getName());

        transaction.commit();
        entityManager.close();
    }

    @AfterEach
    public void tearDown() {
        entityManagerFactory.close();
    }
}
