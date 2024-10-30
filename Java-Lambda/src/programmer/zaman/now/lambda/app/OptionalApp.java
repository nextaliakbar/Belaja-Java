package programmer.zaman.now.lambda.app;

import java.util.Optional;

public class OptionalApp {
    public static void main(String[] args) {
        sayHello("Ali Akbar");
        sayHello(null);
    }

    private static void sayHello(String name) {
        // Method 1
        /**
        Optional<String> optionalName = Optional.ofNullable(name);
        Optional<String> optionalNameUpper = optionalName.map(value -> value.toUpperCase());
        optionalNameUpper.ifPresent(value -> System.out.println(value));
        */

        // Method 2
        /**
        if(name != null) {
            System.out.println(name);
        }
        */

        // Method 3
        Optional.ofNullable(name)
                .map(String::toUpperCase)
                .ifPresentOrElse(value -> System.out.println(value) ,
                        () -> System.out.println("Data Kosong"));

        // Method 4
        String data = Optional.ofNullable(name)
                .map(String::toUpperCase)
                .orElse("Data Kosong");
        System.out.println(data);

    }
}
