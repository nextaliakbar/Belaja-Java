package programmer.zaman.now.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class InputStreamTest {

    @Test
    void testRead() {
        Path path = Path.of("src/main/resources/img/search.png");

        try(InputStream inputStream = Files.newInputStream(path)) {
            StringBuilder builder = new StringBuilder();
            int data;
            int count = 0;
            while((data = inputStream.read()) != -1) {
                builder.append((char)data);
                count++;
            }
            System.out.println(builder.toString());
            System.out.println(count);
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void testReadArrays() {
        Path path = Path.of("src/main/resources/img/search.png");

        try(InputStream inputStream = Files.newInputStream(path)) {
            StringBuilder builder = new StringBuilder();
            byte[] bytes = new byte[328];
            int lenth;
            int count = 0;
            while((lenth = inputStream.read(bytes)) != -1) {
                builder.append(new String(bytes, 0, lenth));
                count++;
            }
            System.out.println(builder.toString());
            System.out.println(count);
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

}
