package programmer.zaman.now.collection;

import programmer.zaman.now.data.Person;

import java.util.List;

public class MutableApp {
    public static void main(String[] args) {
        Person person = new Person("Ali Akbar");
        person.addHobby("Football");
        person.addHobby("Badminton");
        person.addHobby("Golf");
         doSomething(person.getHobbies());
        for(var hobby : person.getHobbies()) {
            System.out.println(hobby);
        }
    }

    private static void doSomething(List<String> hobby) {
        hobby.add("Sepak Takraw");
    }
}
