package programmer.zaman.now.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class ServletApp {

    public static void main(String[] args) {
        SpringApplication.run(ServletApp.class, args);
    }
}
