package programmer.zaman.now.logging;

import org.junit.jupiter.api.Test;
import org.slf4j.MDC;

import java.util.UUID;

public class MyTest {

    @Test
    void testReqiestId() {
        String requestId = UUID.randomUUID().toString();

        MyController controller = new MyController(new MyService(new MyRepository()));

        // Jika beda thread maka data MDC tidak bisa di akses, karena data MDC disimpan didalam thread local
        MDC.put("requestId", requestId);
        controller.save();
        MDC.remove("requestId");

    }

    @Test
    void testReqiestIdWithMultipleThread() throws InterruptedException {
        MyController controller = new MyController(new MyService(new MyRepository()));

        for (int i = 0; i < 10; i++) {
            String requestId = UUID.randomUUID().toString();
            new Thread(()-> {
                MDC.put("requestId", requestId);
                controller.save();
                MDC.remove("requestId");
            }).start();
        }
        Thread.sleep(1000L);
    }
}
