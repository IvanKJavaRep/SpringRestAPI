package personal.ivan.textparseservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

import java.io.ObjectInputFilter;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@PropertySource(value = "classpath:application.yaml")
public class Main implements CommandLineRunner {

    @Value("${server.port}")
    private static String port;

    @Autowired
    private Config config;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println(port);

    }


    @Override
    public void run(String... strings) throws Exception {
        System.out.println(config);
    }
}