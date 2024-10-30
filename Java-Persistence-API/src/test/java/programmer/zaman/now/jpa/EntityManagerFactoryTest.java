package programmer.zaman.now.jpa;

import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.jpa.util.JpaUtil;

public class EntityManagerFactoryTest {

    @Test
    void testCreate() {
        EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
        Assertions.assertNotNull(emf);
    }
}
