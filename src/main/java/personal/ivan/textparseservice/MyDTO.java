package personal.ivan.textparseservice;

import lombok.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Value
public class MyDTO {

    @Id
    @GeneratedValue
    Integer id;
    String name;
    String address;

    public MyDTO(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
