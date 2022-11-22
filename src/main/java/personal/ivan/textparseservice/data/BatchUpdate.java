package personal.ivan.textparseservice.data;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import personal.ivan.textparseservice.dao.entity.MyTableEntity;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
public class BatchUpdate {
    String request1 = "INSERT INTO my_table (id, name, address) VALUES ('111', 'sasha', 'kazan')";
    String request2 = "INSERT INTO my_table (id, name, address) VALUES ('112', 'sasha', 'kazan')";
    String request3 = "INSERT INTO my_table (id, name, address) VALUES ('113', 'sasha', 'kazan')";
    String[] sqlArray = {
            "INSERT INTO my_table (id, name, address) VALUES ('114', 'sasha', 'kazan')",
            "INSERT INTO my_table (id, name, address) VALUES ('115', 'sasha', 'kazan')",
            "INSERT INTO my_table (id, name, address) VALUES ('116', 'sasha', 'kazan')",
    };


    void update(DataSource dataSource) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        template.batchUpdate(request1, request2, request3);
    }

    void updateWithArray(DataSource dataSource) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        template.batchUpdate(sqlArray);
    }

    void updateWithPreparedStatement(DataSource dataSource, List<MyTableEntity> lst) {
        String sql = "INSERT INTO my_table (id, name, address) VALUES (?, ?, ?)";
        JdbcTemplate template = new JdbcTemplate(dataSource);
        template.batchUpdate(sql,
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        MyTableEntity user = lst.get(i);
                        ps.setInt(1, user.getId());
                        ps.setString(2, user.getName());
                        ps.setString(3, user.getAddress());
                    }
                    @Override
                    public int getBatchSize() {
                        return lst.size();
                    }
                });
    }
}
