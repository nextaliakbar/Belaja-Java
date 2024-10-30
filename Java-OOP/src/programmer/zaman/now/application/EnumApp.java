package programmer.zaman.now.application;

import programmer.zaman.now.data.Customer;
import programmer.zaman.now.data.Level;

public class EnumApp {
    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setName("Ali Akbar");
        customer.setLevel(Level.VIP);
        System.out.println(customer.getName());
        System.out.println(customer.getLevel());
        System.out.println(customer.getLevel().getDescription());

//      Konversi Enum
        String levelName = Level.VIP.name(); // Enum to String
        System.out.println(levelName);

        Level level = Level.valueOf("PREMIUM"); // String to Enum
        System.out.println(level);

        System.out.println("Jumlah Level");
        for(Level sumLevel : Level.values()) {
            System.out.println(sumLevel);
        }
    }
}
