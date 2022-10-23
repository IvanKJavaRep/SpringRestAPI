package personal.ivan.textparseservice;

import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class ConverterToDTO {
    public List<MyDTO> convert(ResultSet res) {
        List<MyDTO> lst = new ArrayList<>();
        try {
            while (res.next()) {
                lst.add(new MyDTO(res.getInt("id3"),
                        res.getString("name"),
                        res.getString("address")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return lst;
    }
}
