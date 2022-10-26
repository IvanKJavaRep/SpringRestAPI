package personal.ivan.textparseservice;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

@Entity
//@Value
@Table(name = "my_table")
public class MyDTO implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    Integer id;
    @Column(name = "name")
    String name;
    @Column(name = "address")
    String address;

    public MyDTO(int id, String name, String address) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
    }
    public MyDTO()
    {
        super();
    }
    public Integer getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getAddress()
    {
        return address;
    }

}
