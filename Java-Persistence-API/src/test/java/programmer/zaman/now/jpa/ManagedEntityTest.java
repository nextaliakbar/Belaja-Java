package programmer.zaman.now.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.LockModeType;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.jpa.entity.Brand;
import programmer.zaman.now.jpa.util.JpaUtil;

import java.time.LocalDateTime;

public class ManagedEntityTest {

    @Test
    void testManagedEntity() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        // unmanage entity -> tidak disimpan di dalam database
        Brand brand = new Brand();
        brand.setId("apple");
        brand.setName("Apple");

        entityManager.persist(brand); // manage entity -> disimpan di dalam database

        brand.setName("Apple International");

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testFindManagedEntity() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        // menage entity
        Brand brand = entityManager.find(Brand.class, "apple");
        brand.setName("Apple Indonesia");

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testDetachManagedEntity() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        // menage entity
        Brand brand = entityManager.find(Brand.class, "apple");
        entityManager.detach(brand); // unmanage entity
        brand.setName("Apple Indonesia");

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testFindManagedEntityAfterTransaction() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        // menage entity
        Brand brand = entityManager.find(Brand.class, "apple");

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();

        brand.setName("Apple Indonesia");
    }
}
