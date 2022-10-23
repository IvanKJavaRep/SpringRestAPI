package personal.ivan.textparseservice;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Component
public class InsertionClass {
    public SimpleJdbcInsert createInserter(DataSource dataSource) {
        SimpleJdbcInsert simpleJdbcInsert =
                new SimpleJdbcInsert(dataSource).withTableName("table3");
        return simpleJdbcInsert;
    }

    public int addObj(MyDTO obj, DataSource dataSource) {
        SimpleJdbcInsert simpleJdbcInsert = createInserter(dataSource);
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("id3", obj.id);
        parameters.put("name", obj.name);
        parameters.put("address", obj.address);

        return simpleJdbcInsert.execute(parameters);
    }
}
