package programmer.zaman.now.test;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class MockTest {

    @Test
    public void mockTest() {
        List<String> list = Mockito.mock(List.class);

        // Memberikan behavior ke mock Object
        Mockito.when(list.get(0)).thenReturn("Ali");
        Mockito.when(list.get(100)).thenReturn("Akbar");
        System.out.println(list.get(0));
        //System.out.println(list.get(0));
        System.out.println(list.get(100));

        // Verifikasi pemanggilan method
        Mockito.verify(list, Mockito.times(1)).get(0);
    }
}
