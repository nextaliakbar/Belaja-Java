package programmer.zaman.now.stream;

import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveStreamTest {

    @Test
    public void testCreate() {
        IntStream intStream = IntStream.range(1,100);
        intStream.forEach(System.out::println);

        LongStream longStream = LongStream.of(1,2,3,4,5);
        longStream.forEach(System.out::println);

        DoubleStream doubleStream = DoubleStream.builder().add(1.0).add(2.0).add(3.0).build();
        doubleStream.forEach(System.out::println);
    }

    @Test
    public void testOperation() {
        IntStream intStream = IntStream.range(1,100);
        OptionalDouble optionalDouble = intStream.average();
        optionalDouble.ifPresent(System.out::println);

        IntStream.range(0, 100)
                .mapToObj(number -> "Number " + number)
                .forEach(result -> System.out.println(result));
    }
}
