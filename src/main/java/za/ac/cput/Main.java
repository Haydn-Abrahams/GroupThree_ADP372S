package za.ac.cput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@ComponentScan("za.ac.cput.service")
public class Main{
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
