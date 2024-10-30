package programmer.zaman.now.jpa;

import jakarta.persistence.*;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.jpa.entity.*;
import programmer.zaman.now.jpa.util.JpaUtil;

import java.util.List;

public class JpaQueryLanguangeTest {

    @Test
    void testSelect() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Brand> query = entityManager.createQuery("SELECT b FROM Brand b", Brand.class);
        List<Brand> brands = query.getResultList();
        for (Brand brand : brands) {
            System.out.println("Name : " + brand.getName());
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testWhereClause() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Member> query = entityManager.createQuery("SELECT m FROM Member m WHERE " +
                "m.name.firstName =: firstname AND m.name.lastName =: lastname " +
                "AND m.name.middleName =: middlename", Member.class);
        query.setParameter("firstname", "Ali");
        query.setParameter("middlename", "Akbar");
        query.setParameter("lastname", "Rafsanjani");

        List<Member> members = query.getResultList();

        for (Member member : members) {
            System.out.println("ID :" + member.getId() + "Fullname : " + member.getFullName());
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testJoinClause() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Product> query = entityManager.createQuery("SELECT p FROM Product p JOIN FETCH p.brands b WHERE " +
                "b.name =: brand", Product.class);
        query.setParameter("brand", "samsung");
        List<Product> products = query.getResultList();
        for (Product product : products) {
            System.out.println("ID :" + product.getId() + "Brand :" + product.getBrands().getName());
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testJoinFetchClause() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u JOIN FETCH u.likes p WHERE " +
                "p.name =: product", User.class);
        query.setParameter("product", "Samsung Galaxy A1 Series");
        List<User> users = query.getResultList();
        for (User user : users) {
            System.out.println(user.getName());
            for (Product product : user.getLikes()) {
                System.out.println("Product ID : " + product.getId());
                System.out.println("Product Name : " + product.getName());
            }
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testOrderClause() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Brand> query = entityManager.createQuery("SELECT b FROM Brand b ORDER BY b.name DESC ", Brand.class);
        List<Brand> brands = query.getResultList();
        for (Brand brand : brands) {
            System.out.println(brand.getName());
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testInsertRandomBrand() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        for (int i = 0; i < 100; i++) {
            Brand brand = new Brand();
            brand.setId(String.valueOf(i));
            brand.setName("Brand " + i);
            entityManager.persist(brand);
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testLimitOffset() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Brand> query = entityManager.createQuery("SELECT b FROM Brand b ORDER BY b.id", Brand.class);
        query.setFirstResult(2);
        query.setMaxResults(10);
        List<Brand> brands = query.getResultList();
        for (Brand brand : brands) {
            System.out.println(brand.getId());
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testNamedQuery() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Brand> query = entityManager.createNamedQuery("Brand.findAllByName", Brand.class);
        query.setParameter("name", "samsung");
        List<Brand> brands = query.getResultList();
        for (Brand brand : brands) {
            System.out.println(brand.getName());
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testSelectSomeFields() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Object[]> query = entityManager.createQuery("SELECT b.id, b.name FROM Brand b WHERE b.name=:name", Object[].class);
        query.setParameter("name", "Xiamoi Poco");
        List<Object[]> objects = query.getResultList();
        for (Object[] object : objects) {
            System.out.println(object[0] + ":" + object[1]);
        }
        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testNewConstructor() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<SimpleBrand> query = entityManager.createQuery("SELECT new programmer.zaman.now.jpa.entity.SimpleBrand(b.name, b.name) FROM Brand b " +
                " WHERE b.name=:name", SimpleBrand.class);
        query.setParameter("name", "Samsung");
        List<SimpleBrand> brands = query.getResultList();
        for (SimpleBrand brand : brands) {
            System.out.println(brand.getId());
            System.out.println(brand.getName());
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testAggregatQuery() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Object[]> query = entityManager.createQuery("SELECT min(p.price), max(p.price), avg (p.price) FROM Product p", Object[].class);
        Object[] result = query.getSingleResult();
        System.out.println("Min : " + result[0]);
        System.out.println("Max : " + result[1]);
        System.out.println("Avg : " + result[2]);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testGroupBy() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Object[]> query = entityManager.createQuery("SELECT b.id, min (p.price), max (p.price), avg (p.price) FROM Product p JOIN p.brands b " +
                "GROUP BY b.id HAVING min (p.price) > : min", Object[].class);
        query.setParameter("min", 500_000L);
        List<Object[]> products = query.getResultList();
        for (Object[] object : products) {
            System.out.println("ID : " + object[0]);
            System.out.println("Min : " + object[1]);
            System.out.println("Max : " + object[2]);
            System.out.println("Avg : " + object[3]);
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testNativeQuery() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Query nativeQuery = entityManager.createNativeQuery("SELECT * FROM brands WHERE created_at IS NOT NULL", Brand.class);
        List<Brand> brands = nativeQuery.getResultList();
        for (Brand brand : brands) {
            System.out.println(brand.getName());
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testNamedNativeQuery() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        TypedQuery<Brand> query = entityManager.createNamedQuery("Brand.native.findAll", Brand.class);
        List<Brand> brands = query.getResultList();
        for (Brand brand : brands) {
            System.out.println(brand.getName());
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testNonQuery() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Query query = entityManager.createQuery("UPDATE Brand b SET b.name=:name WHERE b.id=:id");
        query.setParameter("name", "Samsung Update");
        query.setParameter("id", "samsung");
        int impactUpdated = query.executeUpdate();
        System.out.println("Sukses : " + impactUpdated + " Updated");

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}

