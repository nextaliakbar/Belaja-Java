package programmer.zaman.now.application;

import programmer.zaman.now.data.City;

public class LocationApp {
    public static void main(String[] args) {
//    var location = new Location(); // Tidak bisa diintansiate karena berupa kelas abstract
    var city = new City();
    city.name = "Jember";
    System.out.println(city.name);
    }
}
