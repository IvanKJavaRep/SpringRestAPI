package personal.ivan.textparseservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Main implements CommandLineRunner {


    @Autowired
    private Config config;



    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);

    }


    @Override
    public void run(String... strings) throws Exception {
        System.out.println(config);
    }
}