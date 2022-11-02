package personal.ivan.textparseservice.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;


@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@Table(name = "my_table")

public class MyDTO implements Serializable {

    @Id
    @GeneratedValue(generator = "attSeq")
    @SequenceGenerator(
            name = "attSeq",
            sequenceName = "attendance_seq",
            allocationSize = 1
    )
    @Column(name = "id")
    Integer id;
    @Column(name = "name")
    @JsonProperty("object_name")
    String name;
    @Column(name = "address")
    String address;

    public MyDTO(int id, String name, String address) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @PrePersist
    void prePersist() {
        name = UUID.randomUUID().toString();
        address = UUID.randomUUID().toString();
    }
}
