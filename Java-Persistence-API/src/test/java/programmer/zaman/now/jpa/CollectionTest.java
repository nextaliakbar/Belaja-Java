package programmer.zaman.now.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.jpa.embeddable.Name;
import programmer.zaman.now.jpa.entity.Customer;
import programmer.zaman.now.jpa.entity.Member;
import programmer.zaman.now.jpa.util.JpaUtil;

import java.util.ArrayList;
import java.util.HashMap;

public class CollectionTest {

    @Test
    void testCreate() {
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
        member.setEmail("ali@gmail.com");
        member.setName(name);
        member.setHobbies(new ArrayList<>());
        member.getHobbies().add("Hobbie 1");
        member.getHobbies().add("Hobbie 2");
        member.getHobbies().add("Hobbie 3");

        entityManager.persist(member);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testUpdate() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Member member = entityManager.find(Member.class, 2);
        member.getHobbies().add("Hobbie 4");
        member.getHobbies().add("Hobbie 5");

        entityManager.merge(member);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testSkills() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Member member = entityManager.find(Member.class, 2);
        member.setSkills(new HashMap<>());
        member.getSkills().put("Java", 80);
        member.getSkills().put("PHP", 75);
        member.getSkills().put("Golang", 70);
        member.getSkills().put("JavaScript", 65);

        entityManager.merge(member);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
