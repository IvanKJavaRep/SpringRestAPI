package personal.ivan.textparseservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import personal.ivan.textparseservice.data.BatchUpdate;
import personal.ivan.textparseservice.data.IMyDTORepository;
import personal.ivan.textparseservice.config.Config;

import javax.sql.DataSource;

@SpringBootApplication
@ComponentScan("personal.ivan.textparseservice")
public class Main implements CommandLineRunner {

    @Autowired
    @Qualifier("testSource")
    private DataSource testDataSource;

    @Autowired
    private BatchUpdate batchUpdate;

    @Autowired
    @Qualifier("hardcodeSource")
    private DataSource hardcodeDataSource;

    @Autowired
    private IMyDTORepository repo;

    @Autowired
    private Config config;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

    }
}