package programmer.zaman.now.lambda.app;

import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionApp {
    public static void main(String[] args) {
        Function<String, Integer> function = value -> value.length();
        System.out.println(function.apply("Hello Ali Akbar"));

    }
}
