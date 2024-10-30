package programmer.zaman.now.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OpenOptionTest {

    @Test
    void testOpenOption() {
        Path path = Path.of("append.txt");

        try(Writer write = Files.newBufferedWriter(path,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {

            write.write("Hello World\n");
            write.flush();

        } catch (IOException e) {
            Assertions.fail(e);
        }
    }
}
