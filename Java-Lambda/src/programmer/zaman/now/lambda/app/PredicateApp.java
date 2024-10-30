package programmer.zaman.now.lambda.app;

import java.util.function.Predicate;

public class PredicateApp {
    public static void main(String[] args) {
        Predicate<String> booleanPredicate = value -> value.isEmpty();
        System.out.println(booleanPredicate.test(""));
        System.out.println(booleanPredicate.test(" "));
    }
}
