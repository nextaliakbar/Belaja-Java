package programmer.zaman.now.collection;

import programmer.zaman.now.data.Person;
import programmer.zaman.now.data.PersonComparator;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetApp {
    public static void main(String[] args) {
        SortedSet<Person> people = new TreeSet<>(new PersonComparator().reversed());
        people.add(new Person("Ali"));
        people.add(new Person("Akbar"));
        people.add(new Person("Rafsanjani"));

        for(var person : people) {
            System.out.println(person.getName());
        }

        SortedSet<Person> immutablePeople = Collections.unmodifiableSortedSet(people);
//        immutablePeople.add(new Person("Akbar"));
    }
}
