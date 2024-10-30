package programmer.zaman.now.application;

import programmer.zaman.now.generic.Pair;

public class PairApp {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("Ali Akbar", 500);
        System.out.println(pair.getFirst());
        System.out.println(pair.getSecond());
    }
}
