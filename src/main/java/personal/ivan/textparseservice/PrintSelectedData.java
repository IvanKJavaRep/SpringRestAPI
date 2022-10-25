package personal.ivan.textparseservice;

import org.springframework.stereotype.Component;

import java.sql.ResultSet;

@Component
public class PrintSelectedData {
    public void printAll(ResultSet res) {
        try {
            while (res.next()) {
                System.out.println(res.getInt("id"));
                System.out.println(res.getString("name"));
                System.out.println(res.getString("address"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
