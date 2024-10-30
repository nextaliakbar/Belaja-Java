package programmer.zaman.now.application;

import programmer.zaman.now.generic.Person;

import java.util.Arrays;

public class ComparableApp {
    public static void main(String[] args) {
        Person[] persons = {
                new Person("John", "USA"),
                new Person("Joko", "Indonesia"),
                new Person("Alexandria", "Swiss")
        };

        Arrays.sort(persons);

        System.out.println(Arrays.toString(persons));
    }
}
