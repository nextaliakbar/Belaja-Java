package programmer.zaman.now.collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeApp {
    public static void main(String[] args) {
        Deque<String> stack = new LinkedList<>();
        stack.offerFirst("Ali");
        stack.offerFirst("Akbar");
        stack.offerFirst("Rafsanjani");

        System.out.println(stack.pollFirst());
        System.out.println(stack.pollFirst());
        System.out.println(stack.pollFirst());

        Deque<String> deque = new LinkedList<>();
        deque.offerFirst("Ali");
        deque.offerFirst("Akbar");
        deque.offerFirst("Rafsanjani");
        System.out.println(deque.pollLast());
        System.out.println(deque.pollLast());
        System.out.println(deque.pollLast());
    }
}
