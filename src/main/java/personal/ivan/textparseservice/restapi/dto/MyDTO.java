package personal.ivan.textparseservice.restapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;


@Getter
@Setter
@SuperBuilder
@NoArgsConstructor

public class MyDTO implements Serializable {


    Integer id;

    @JsonProperty("object_name")
    String name;

    String address;
    String status = "in_progress";

    public MyDTO(int id, String name, String address, String status) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.status = status;
    }

}
