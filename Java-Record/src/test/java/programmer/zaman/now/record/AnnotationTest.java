package programmer.zaman.now.record;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.record.annotation.Valid;
import programmer.zaman.now.record.data.Point;

public class AnnotationTest {

    @Test
    void testAnnotation() throws NoSuchFieldException, NoSuchMethodException {
        Assertions.assertNotNull(Point.class.getDeclaredField("x").getAnnotation(Valid.class));
        Assertions.assertNotNull(Point.class.getDeclaredField("y").getAnnotation(Valid.class));

        Assertions.assertNotNull(Point.class.getDeclaredMethod("x").getAnnotation(Valid.class));
        Assertions.assertNotNull(Point.class.getDeclaredMethod("y").getAnnotation(Valid.class));

        Assertions.assertNotNull(Point.class.getConstructors()[0].getParameters()[0].getAnnotation(Valid.class));
        Assertions.assertNotNull(Point.class.getConstructors()[0].getParameters()[1].getAnnotation(Valid.class));
    }
}
