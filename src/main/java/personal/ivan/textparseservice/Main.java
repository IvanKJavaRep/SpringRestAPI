package personal.ivan.textparseservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

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
        //repo.save(new MyDTO());
        //repo.save(new MyDTO());
        /*repo.deleteById(10);
        MyDTO myDTO = new MyDTO();
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(myDTO));*/
    }
}