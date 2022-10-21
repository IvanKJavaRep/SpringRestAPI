package personal.ivan.textparseservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.Statement;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private Config config;



    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);


    }


    @Override
    public void run(String... strings) throws Exception {
        System.out.println(config);
        //DataSourceClass dt = new DataSourceClass();
        //DataSource dataSource = dt.dataSource();
        Statement statement = dataSource.getConnection().createStatement();
        String command = "SELECT * FROM table3 ";
        ResultSet res = statement.executeQuery(command);
        System.out.println(res.findColumn("name"));

    }
}