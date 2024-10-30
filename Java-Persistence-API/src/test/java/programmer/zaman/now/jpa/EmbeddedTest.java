package programmer.zaman.now.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import programmer.zaman.now.jpa.embeddable.DepartementId;
import programmer.zaman.now.jpa.embeddable.Name;
import programmer.zaman.now.jpa.entity.Customer;
import programmer.zaman.now.jpa.entity.Departement;
import programmer.zaman.now.jpa.entity.Member;
import programmer.zaman.now.jpa.util.JpaUtil;

public class EmbeddedTest {

    private static final Logger log = LoggerFactory.getLogger(EmbeddedTest.class);

    @Test
    void testEmbedded() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Name name = new Name();
        name.setTitle("Mr");
        name.setFirstName("Ali");
        name.setMiddleName("Akbar");
        name.setLastName("Rafsanjani");

        Member member = new Member();
        member.setEmail("akbarexample@gmail.com");
        member.setName(name);

        entityManager.persist(member);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testInsertEmbeddedId() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        DepartementId departementId = new DepartementId();
        departementId.setCompanyId("tech");
        departementId.setDepartmentId("pzn");

        Departement departement = new Departement();
        departement.setDepartementId(departementId);
        departement.setName("Teknologi");

        entityManager.persist(departement);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testFindEmbeddedId() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        DepartementId departementId = new DepartementId();
        departementId.setCompanyId("tech");
        departementId.setDepartmentId("pzn");

        Departement departement = entityManager.find(Departement.class, departementId);
        log.info("Departement name {}",departement.getName());

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
