package personal.ivan.textparseservice;

import org.postgresql.core.SetupQueryRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private Config config;

    @Autowired
    private PrintSelectedData printSelectedData;
    @Autowired
    private ConverterToDTO converterToDTO;

    @Autowired
    private InsertionClass insertionClass;


    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);


    }


    @Override
    public void run(String... strings) throws Exception {
        System.out.println(config);
        // create datasource
        Statement statement = dataSource.getConnection().createStatement();
        // create query
        String command = "SELECT * FROM table3 ";
        // return all selected data
        ResultSet res = statement.executeQuery(command);
        // print all selected objects
        printSelectedData.printAll(res);
        // mapping all to DTO
        List<MyDTO> lst = converterToDTO.convert(res);
        System.out.println(lst.size());
        // simple insertion into table3 of my localhost database
        MyDTO obj = new MyDTO(9, "ivan", "moscow");
        insertionClass.addObj(obj, dataSource);
        DeleteClass.delete(20, statement);

    }
}