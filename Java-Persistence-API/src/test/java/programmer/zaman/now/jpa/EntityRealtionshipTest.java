package programmer.zaman.now.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import programmer.zaman.now.jpa.entity.*;
import programmer.zaman.now.jpa.util.JpaUtil;

import java.math.BigInteger;
import java.util.HashSet;

public class EntityRealtionshipTest {

    private static final Logger log = LoggerFactory.getLogger(EntityRealtionshipTest.class);

    @Test
    void testOneToOnePersist() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Credential credential = new Credential();
        credential.setId("akbar");
        credential.setEmail("akbar@gmail.com");
        credential.setPassword("akbar123");
        entityManager.persist(credential);

        User user = new User();
        user.setId("akbar");
        user.setName("Ali Akbar Rafsanjani");
        entityManager.persist(user);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testOneToOneFind() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        User user = entityManager.find(User.class, "akbar");
        log.info("id {}", user.getId());
        log.info("name {}", user.getName());
        log.info("email {}", user.getCredential().getEmail());
        log.info("password {}", user.getCredential().getPassword());
        log.info("Balance {}", user.getWallet().getBalance());

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testOneToOneJoinColumn() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        User user = entityManager.find(User.class, "akbar");
        Wallet wallet = new Wallet();
        wallet.setBalance(BigInteger.valueOf(1_000_000L));
        wallet.setUser(user);
        entityManager.persist(wallet);
        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testOneToManyInsert() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Brand brand = new Brand();
        brand.setId("samsung");
        brand.setName("Samsung");
        brand.setDescription("Description samsung");
        entityManager.persist(brand);

        Product product1 = new Product();
        product1.setId("p1");
        product1.setName("Samsung Galaxy A1 Series");
        product1.setPrice(BigInteger.valueOf(1_000_000L));
        product1.setDescription("Description Samsung Galaxy A Series");
        product1.setBrands(brand);
        entityManager.persist(product1);

        Product product2 = new Product();
        product2.setId("p2");
        product2.setName("Samsung Galaxy A2 Series");
        product2.setPrice(BigInteger.valueOf(1_100_000L));
        product2.setDescription("Description Samsung Galaxy A2 Series");
        product2.setBrands(brand);
        entityManager.persist(product2);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testOneToManyFind() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Brand brand = entityManager.find(Brand.class, "samsung");
        Assertions.assertNotNull(brand.getProducts());
        Assertions.assertEquals(2, brand.getProducts().size());

        brand.getProducts().forEach(product -> {
            System.out.println(product.getName());
        });

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testManyToManyInsert() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        User user = entityManager.find(User.class, "akbar");
        user.setLikes(new HashSet<>());

        Product p1 = entityManager.find(Product.class, "p1");
        Product p2 = entityManager.find(Product.class, "p2");

        user.getLikes().add(p1);
        user.getLikes().add(p2);

        entityManager.merge(user);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testManyToManyUpdate() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        User user = entityManager.find(User.class, "akbar");
        Product product = null;

        for (Product item : user.getLikes()) {
            product = item;
            break;
        }

        user.getLikes().remove(product);
        entityManager.merge(user);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void fecth() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Product product = entityManager.find(Product.class, "p1");
        System.out.println(product.getBrands().getName());
//        Brand brand = entityManager.find(Brand.class, "samsung");


        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
