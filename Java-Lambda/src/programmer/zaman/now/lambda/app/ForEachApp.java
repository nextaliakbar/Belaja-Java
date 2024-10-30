package programmer.zaman.now.lambda.app;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ForEachApp {
    public static void main(String[] args) {
        List<String> list = List.of("Ali ", "Akbar ", "Rafsanjani ", "Politeknik ", "Negeri ", "Jember\n");

        // for loop
        for(var value : list) {
            System.out.print(value);
        }

        // for each with anonymous
        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s);
            }
        });

        // lambda 1
        list.forEach(value -> System.out.print(value));

        // lmabda2
        list.forEach(System.out::print);
    }
}
