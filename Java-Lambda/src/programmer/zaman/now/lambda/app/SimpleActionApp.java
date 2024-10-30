package programmer.zaman.now.lambda.app;

import programmer.zaman.now.lambda.SimpleAction;

public class SimpleActionApp {
    public static void main(String[] args) {

        /**
        SimpleAction action1 = new SimpleAction() {
            @Override
            public String action(String name) {
                return "Hello World";
            }
        };

        System.out.println(action1.action("Hello"));

        SimpleAction action2 = (String name) -> {
          return "Hello World";
        };

        System.out.println(action2.action("Hello"));
         **/

        SimpleAction simpleAction1 = (String name) -> {
            return "Hello".concat(" ").concat(name);
        };

        SimpleAction simpleAction2 = (name) -> {
            return "Hello".concat(" ").concat(name);
        };

        SimpleAction simpleAction3 = (String name) -> "Hello " + name;

        SimpleAction simpleAction4 = (name) -> "Hello " + name;

        SimpleAction simpleAction5 = name -> "Hello " + name;

        String result = simpleAction5.action("Ali Akbar");
        System.out.println(result);
    }
}
