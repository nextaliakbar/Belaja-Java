package programmer.zaman.now.lambda.app;

import programmer.zaman.now.lambda.util.StringUtil;

import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferncesApp {
    public static void main(String[] args) {
        Predicate<String> predicateIsLowerCase1 = (value) -> StringUtil.isLowerCare(value);
        Predicate<String> predicateIsLowerCase2 = StringUtil :: isLowerCare;
        System.out.println(predicateIsLowerCase1.test("AKBAR"));
        System.out.println(predicateIsLowerCase2.test("akbar"));

        MethodReferncesApp app = new MethodReferncesApp();
        app.run1();
        app.run2();

        // Method reference di paramater
        Function<String, String> function1 = new Function<String, String>() {
            @Override
            public String apply(String value) {
                return value.toUpperCase();
            }
        };

        Function<String, String> function2 = (String value) -> value.toUpperCase();

        Function<String, String> function3 = value -> value.toUpperCase();

        Function<String, String> function4 = String::toUpperCase;
        System.out.println(function1.apply("hello"));
        System.out.println(function2.apply("hai"));
        System.out.println(function3.apply("ali akbar"));
        System.out.println(function4.apply("rafsanjani"));
    }

    private  void run1() {
        Predicate<String> predicateIsLowerCase1 = (value) -> this.isLowerCase(value);
        Predicate<String> predicateIsLowerCase2 = this::isLowerCase;
        System.out.println(predicateIsLowerCase1.test("AKBAR"));
        System.out.println(predicateIsLowerCase2.test("akbar"));
    }

    private  void run2() {
        MethodReferncesApp app = new MethodReferncesApp();
        Predicate<String> predicateIsLowerCase1 = (value) -> app.isLowerCase(value);
        Predicate<String> predicateIsLowerCase2 = app::isLowerCase;
        System.out.println(predicateIsLowerCase1.test("AKBAR"));
        System.out.println(predicateIsLowerCase2.test("akbar"));
    }

    private boolean isLowerCase(String value) {
        char[] chars = value.toCharArray();
        for(char c : chars) {
            if(!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }
}
