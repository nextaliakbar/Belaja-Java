package classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesApp {
    public static void main(String[] args) {
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("application.properties"));

            String host = prop.getProperty("database.host");
            String port = prop.getProperty("database.port");
            String username = prop.getProperty("database.username");
            String password = prop.getProperty("database.password");
            System.out.println(host);
            System.out.println(port);
            System.out.println(username);
            System.out.println(password);

        } catch(FileNotFoundException ex) {

        } catch(IOException ex) {

        }

        try {
            Properties prop = new Properties();
            prop.put("name.first", "Ali");
            prop.put("name.middle", "Akbar");
            prop.put("name.last", "Rafsanjani");

            prop.store(new FileOutputStream("name.properties"), "configure name");
        } catch(FileNotFoundException ex) {

        } catch(IOException ex) {

        }
    }
}
