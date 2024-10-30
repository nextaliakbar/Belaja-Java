package programmer.zaman.now.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class PathTest {

    @Test
    void testCreatePath() {
        Path path = Path.of("file.txt");

        Assertions.assertEquals("file.txt", path.toString());
        Assertions.assertFalse(path.isAbsolute());
    }

    @Test
    void testUsingFiles() {
        Path path = Path.of("pom.xml");
        Assertions.assertEquals("pom.xml", path.toString());
        Assertions.assertFalse(path.isAbsolute());
        Assertions.assertTrue(Files.exists(path));
    }

    @Test
    void testFileManipulation() throws IOException {
        Path path = Path.of("file.txt");
        Files.createFile(path);
        Assertions.assertTrue(Files.exists(path));

        Files.delete(path);
        Assertions.assertFalse(Files.exists(path));
    }

    @Test
    void testDirectoryManipulation() throws IOException {
        Path path = Path.of("contoh");
        Files.createDirectory(path);

        Assertions.assertTrue(Files.exists(path));
        Assertions.assertTrue(Files.isDirectory(path));

        Files.delete(path);
        Assertions.assertFalse(Files.exists(path));

    }
}
