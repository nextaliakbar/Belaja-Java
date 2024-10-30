package programmer.zaman.now.io;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class PrintStreamTest {

    @Test
    void testPrintStream() {
        Path path = Path.of("print.txt");

        try(OutputStream stream = Files.newOutputStream(path);
        PrintStream print = new PrintStream(stream)) {
            print.println("Hello World");
            print.println("Hello World");
            print.println("Hello World");
        } catch (IOException e) {

        }

    }
}
