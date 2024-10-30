package programmer.zaman.now.map;

import java.util.Stack;

public class StackApp {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("Hello");
        stack.push("World");
        stack.push("Java");

        for(var value=stack.pop(); value != null; value=stack.pop()) {
            System.out.println(value);
        }
    }
}
