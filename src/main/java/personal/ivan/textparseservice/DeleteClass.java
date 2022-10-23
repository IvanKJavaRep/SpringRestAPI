package personal.ivan.textparseservice;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteClass {
    public static void delete(int id, Statement statement)
    {
        String query = "DELETE FROM table3 WHERE id3=";
        query+=id;
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
