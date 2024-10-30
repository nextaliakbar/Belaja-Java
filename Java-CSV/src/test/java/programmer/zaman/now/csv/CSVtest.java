package programmer.zaman.now.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class CSVtest {

    @Test
    void testCreateCSV() throws IOException {
        StringWriter writer = new StringWriter();

        CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);

        printer.printRecord("Ali", "Akbar", 21);
        printer.printRecord("Budi", "Nugraha", 22);
        printer.printRecord("Akbar", "Rafsanjani", 23);
        printer.printRecord("Julian", "Romadhoni", 24);
        printer.flush();

        String csv = writer.getBuffer().toString();
        System.out.println(csv);
    }

    @Test
    void testCreateCSVInFile() throws IOException {
        Path path = Path.of("data.csv");
        BufferedWriter writer = Files.newBufferedWriter(path);

        CSVPrinter printer = new CSVPrinter(writer, CSVFormat.DEFAULT);
        printer.printRecord("Ali", "Akbar", 21);
        printer.printRecord("Budi", "Nugraha", 22);
        printer.printRecord("Akbar", "Rafsanjani", 23);
        printer.printRecord("Julian", "Romadhoni", 24);
        printer.flush();
    }

    @Test
    void testReadCSV() throws IOException {
        Path path = Path.of("data.csv");
        BufferedReader reader = Files.newBufferedReader(path);
        CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);

        parser.forEach(record -> {
            System.out.println("First Name " + record.get(0));
            System.out.println("Last Name " + record.get(1));
            System.out.println("Age " + record.get(2));
            System.out.println("===================");
        });
    }
    @Test
    void testReadCSVWithReader() throws IOException {
        Path path = Path.of("data.csv");
        BufferedReader reader = Files.newBufferedReader(path);

        CSVFormat format = CSVFormat.DEFAULT.builder().setHeader().build();

        CSVParser parser = new CSVParser(reader, format);

        parser.forEach(record -> {
            System.out.println("First Name " + record.get("First Name"));
            System.out.println("Last Name " + record.get("Last Name"));
            System.out.println("Age " + record.get("Age"));
            System.out.println("===================");
        });
    }

    @Test
    void testCreateCSVWithHeader() throws IOException {
        StringWriter writer = new StringWriter();

        CSVFormat format = CSVFormat.DEFAULT.builder()
                .setHeader("First Name", "Last Name", "Age").build();

        CSVPrinter printer = new CSVPrinter(writer, format);

        printer.printRecord("Ali", "Akbar", 21);
        printer.printRecord("Budi", "Nugraha", 22);
        printer.printRecord("Akbar", "Rafsanjani", 23);
        printer.printRecord("Julian", "Romadhoni", 24);
        printer.flush();

        String csv = writer.getBuffer().toString();
        System.out.println(csv);
    }
}
