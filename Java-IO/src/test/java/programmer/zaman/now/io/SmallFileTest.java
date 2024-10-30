package programmer.zaman.now.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SmallFileTest {

    @Test
    void testCreateSmallFile() throws IOException {
        Path path1 = Path.of("small1.txt");
        Files.write(path1, "Hello World".getBytes());
        Assertions.assertTrue(Files.exists(path1));

        Path path2 = Path.of("small2.txt");
        Files.writeString(path2, "Hello World");
        Assertions.assertTrue(Files.exists(path2));
    }

    @Test
    void testReadSmallFile() throws IOException {
        Path path1 = Path.of("small1.txt");
        byte[] data1 = Files.readAllBytes(path1);
        System.out.println(new String(data1));
        Assertions.assertEquals("Hello World", new String(data1));

        Path path2 = Path.of("small2.txt");
        String data2 = Files.readString(path2);
        System.out.println(data2);
        Assertions.assertEquals("Hello World", data2);

    }
}
