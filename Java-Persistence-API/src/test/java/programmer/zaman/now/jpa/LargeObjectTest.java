package programmer.zaman.now.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import programmer.zaman.now.jpa.entity.Categorie;
import programmer.zaman.now.jpa.entity.Images;
import programmer.zaman.now.jpa.util.JpaUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Calendar;

public class LargeObjectTest {

    private static final Logger log = LoggerFactory.getLogger(LargeObjectTest.class);

    @Test
    void testLargeObject() throws IOException {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Images images = new Images();
        images.setName("Contoh image");
        images.setDescription("Description Images");
        byte[] bytes = Files.readAllBytes(Path.of("src/main/resources/images/1.png"));
        images.setImage(bytes);

        entityManager.persist(images);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    @Test
    void test() {
        String path = Path.of("src/main/resources/images/1.png").toString();
        log.info(path);
    }
}
