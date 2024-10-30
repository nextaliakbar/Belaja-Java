package programmer.zaman.now.jpa;

import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.jpa.entity.Brand;
import programmer.zaman.now.jpa.entity.Product;
import programmer.zaman.now.jpa.entity.SimpleBrand;
import programmer.zaman.now.jpa.util.JpaUtil;

import java.util.List;

public class CriteriaTest {

    @Test
    void testCriteria() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Brand> criteria = builder.createQuery(Brand.class);
        Root<Brand> root = criteria.from(Brand.class);
        CriteriaQuery<Brand> criteriaQuery = criteria.select(root);

        TypedQuery<Brand> query = entityManager.createQuery(criteriaQuery);
        List<Brand> brands = query.getResultList();
        for (Brand brand : brands) {
            System.out.println(brand.getName());
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testCriteriaNonEntity() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
        Root<Brand> root = criteria.from(Brand.class);
        CriteriaQuery<Object[]> criteriaQuery = criteria.select(builder.array(root.get("id"), root.get("name")));

        TypedQuery<Object[]> query = entityManager.createQuery(criteriaQuery);
        List<Object[]> results = query.getResultList();
        for (Object[] result : results) {
            System.out.println(result[0] + " : " + result[1]);
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testCriteriaConstructor() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<SimpleBrand> criteria = builder.createQuery(SimpleBrand.class);
        Root<Brand> root = criteria.from(Brand.class);
        CriteriaQuery<SimpleBrand> criteriaQuery = criteria.select(builder.construct(SimpleBrand.class,
                root.get("id"), root.get("name")));
        TypedQuery<SimpleBrand> query = entityManager.createQuery(criteriaQuery);
        List<SimpleBrand> brands = query.getResultList();
        for (SimpleBrand brand : brands) {
            System.out.println(brand.getId() + " : " + brand.getName());
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testCriteriaWhereClause() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Brand> criteria = builder.createQuery(Brand.class);
        Root<Brand> root = criteria.from(Brand.class);
        CriteriaQuery<Brand> criteriaQuery = criteria.where(
                builder.equal(root.get("id"), "xiaomi"),
                builder.isNotNull(root.get("createdAt"))
        );

        TypedQuery<Brand> query = entityManager.createQuery(criteriaQuery);
        List<Brand> brands = query.getResultList();
        for (Brand brand : brands) {
            System.out.println(brand.getName() + " : " + brand.getId());
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testCriteriaWhereClauseUsingOr() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Brand> criteria = builder.createQuery(Brand.class);
        Root<Brand> root = criteria.from(Brand.class);
        CriteriaQuery<Brand> criteriaQuery = criteria.where(
                builder.or(
                        builder.equal(root.get("id"), "samsung"),
                        builder.isNotNull(root.get("createdAt"))
                )
        );

        TypedQuery<Brand> query = entityManager.createQuery(criteriaQuery);
        List<Brand> brands = query.getResultList();
        for (Brand brand : brands) {
            System.out.println(brand.getName() + " : " + brand.getId());
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testCriteriaJoinClause() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaProduct = builder.createQuery(Product.class);
        Root<Product> rootProduct = criteriaProduct.from(Product.class);
        Join<Product, Brand> rootBrand = rootProduct.join("brands");
        CriteriaQuery<Product> criteriaQuery = criteriaProduct.select(rootProduct)
                .where(
                        builder.equal(rootBrand.get("id"), "samsung")
                );
        List<Product> products = entityManager.createQuery(criteriaQuery)
                .getResultList();

        for (Product product : products) {
            System.out.println(product.getName() + " : " + product.getId());
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testCriteriaNamedParam() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaProduct = builder.createQuery(Product.class);
        Root<Product> rootProduct = criteriaProduct.from(Product.class);
        Join<Product, Brand> rootBrand = rootProduct.join("brands");

        ParameterExpression<String> brandParamater =
                builder.parameter(String.class);

        CriteriaQuery<Product> criteriaQuery = criteriaProduct.select(rootProduct)
                .where(
                        builder.equal(rootBrand.get("id"), brandParamater)
                );
        List<Product> products = entityManager.createQuery(criteriaQuery)
                .setParameter(brandParamater, "samsung")
                .getResultList();

        for (Product product : products) {
            System.out.println(product.getName() + " : " + product.getId());
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testCriteriaAggregatQuery() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
        Root<Product> rootProduct = criteria.from(Product.class);
        Join<Product, Brand> rootBrand = rootProduct.join("brands");

        CriteriaQuery<Object[]> criteriaQuery = criteria.select(
                        builder.array(
                                rootBrand.get("id"),
                                builder.min(rootProduct.get("price")),
                                builder.max(rootProduct.get("price")),
                                builder.avg(rootProduct.get("price"))
                        )
                ).groupBy(rootBrand.get("id"))
                .having(builder.greaterThan(builder.min(rootProduct.get("price")), 500_000L));

        List<Object[]> objects = entityManager.createQuery(criteriaQuery)
                .getResultList();
        for (Object[] object : objects) {
            System.out.println(object[0]);
            System.out.println(object[1]);
            System.out.println(object[2]);
            System.out.println(object[3]);
        }

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void testCriteriaNoQueryUpdated() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Brand> criteriaUpdate = builder.createCriteriaUpdate(Brand.class);
        Root<Brand> root = criteriaUpdate.from(Brand.class);

        criteriaUpdate.set(root.get("name"), "Apple Company")
                .set(root.get("description"), "Description Updated")
                .where(builder.equal(root.get("id"), "samsung"));

        int resultUpdated = entityManager.createQuery(criteriaUpdate).executeUpdate();
        System.out.println("Sukses : " + resultUpdated + " Updated");

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
