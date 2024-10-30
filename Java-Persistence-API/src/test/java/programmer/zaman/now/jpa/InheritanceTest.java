package programmer.zaman.now.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import programmer.zaman.now.jpa.entity.*;
import programmer.zaman.now.jpa.util.JpaUtil;

import java.time.LocalDateTime;
import java.util.UUID;

public class InheritanceTest {

    private static final Logger log = LoggerFactory.getLogger(InheritanceTest.class);

    @Test
    void testSingleInsert() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Employee employee = new Employee();
        employee.setId("rina");
        employee.setName("Rina Wati");
        entityManager.persist(employee);

        Manager manager = new Manager();
        manager.setId("joko");
        manager.setName("Joko Moro");
        manager.setTotalEmployee(10);
        entityManager.persist(manager);

        VicePriecident vp = new VicePriecident();
        vp.setId("budi");
        vp.setName("Budi Nugraha");
        vp.setTotalManager(5);
        entityManager.persist(vp);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testSingleFind() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        Manager manager = entityManager.find(Manager.class, "joko");
        System.out.println(manager.getName());

        Employee employee = entityManager.find(Employee.class, "budi");
        VicePriecident vp = (VicePriecident) employee;
        System.out.println(vp.getName());

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testJoinedTableInsert() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        PaymentGopay gopay = new PaymentGopay();
        gopay.setId("gopay1");
        gopay.setAmount(100_000l);
        gopay.setGopayId(UUID.randomUUID().toString());
        entityManager.persist(gopay);

        PaymentCreditCard creditCard = new PaymentCreditCard();
        creditCard.setId("creditCard1");
        creditCard.setAmount(200_000l);
        creditCard.setMaskedCard("4555-5555");
        creditCard.setBank("BCA");
        entityManager.persist(creditCard);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testJoinedTableFind() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        PaymentGopay gopay = entityManager.find(PaymentGopay.class, "gopay1");
        PaymentCreditCard creditCard = entityManager.find(PaymentCreditCard.class, "creditCard1");

        log.info("Gopay amount {}", gopay.getAmount());
        log.info("CreditCard amount {}", creditCard.getAmount());

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testJoinedTableFindParent() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Payment payment = entityManager.find(Payment.class, "gopay1");


        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testPerClassInsert() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Transaction transaction = new Transaction();
        transaction.setId("t1");
        transaction.setBalance(1_000_000L);
        transaction.setCreatedAt(LocalDateTime.now());
        entityManager.persist(transaction);

        TransactionCredit transactionCredit = new TransactionCredit();
        transactionCredit.setId("t2");
        transactionCredit.setBalance(1_000_000L);
        transactionCredit.setCreatedAt(LocalDateTime.now());
        transactionCredit.setCreditAmount(2_500_000L);
        entityManager.persist(transactionCredit);

        TransactionDebit transactionDebit = new TransactionDebit();
        transactionDebit.setId("t3");
        transactionDebit.setBalance(1_000_000L);
        transactionDebit.setDebitAmount(3_500_000L);
        transactionDebit.setCreatedAt(LocalDateTime.now());
        entityManager.persist(transactionDebit);

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testPerClassFindChild() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        TransactionCredit transactionCredit = entityManager.find(TransactionCredit.class, "t2");

        TransactionDebit transactionDebit = entityManager.find(TransactionDebit.class, "t3");

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testPerClassFindParent() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Transaction transaction = entityManager.find(Transaction.class, "t1");

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testMappedSuperClass() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Brand brand = new Brand();
        brand.setId("xiaomi");
        brand.setName("Xiamoi Poco");
        brand.setDescription("Description Xiamoi");
        brand.setCreatedAt(LocalDateTime.now());
        brand.setUpdatedAt(LocalDateTime.now());
        entityManager.persist(brand);

        entityTransaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
