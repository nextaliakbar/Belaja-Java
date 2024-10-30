package programmer.zaman.now.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReaderTest {

    @Test
    void testRead() {
        Path path = Path.of("output.txt");
        try (Reader reader = Files.newBufferedReader(path)) {
            StringBuilder build = new StringBuilder();
            int character;
            int count = 0;
            while((character = reader.read()) != -1) {
                build.append((char)character);
                count++;
            }
            System.out.println(build.toString());
            System.out.println(count);

        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void testReadArray() {
        Path path = Path.of("output.txt");
        try (Reader reader = Files.newBufferedReader(path)) {
            StringBuilder build = new StringBuilder();
            char[] chars = new char[1024];
            int character;
            int count = 0;
            while((character = reader.read(chars)) != -1) {
                build.append(chars, 0, character);
                count++;
            }
            System.out.println(build.toString());
            System.out.println(count);

        } catch (IOException e) {
            Assertions.fail(e);
        }
    }
}
