package programmer.zaman.now.generic;

public class Person implements Comparable<Person> {

    private String name;
    private String addres;

    public Person(String name, String addres) {
        this.name = name;
        this.addres = addres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    @Override
    public int compareTo(Person o) {
        return this.addres.compareTo(o.addres);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", addres='" + addres + '\'' +
                '}';
    }
}
