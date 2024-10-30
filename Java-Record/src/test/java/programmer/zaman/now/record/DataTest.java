package programmer.zaman.now.record;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import programmer.zaman.now.record.data.Data;

public class DataTest {

    @Test
    void testGeneric() {
        Data<String> data1 = new Data<>("Akbar");
        Data<Integer> data2 = new Data<>(10);
        Assertions.assertEquals("Akbar", data1.data());
        Assertions.assertEquals(10, data2.data());
    }
}
