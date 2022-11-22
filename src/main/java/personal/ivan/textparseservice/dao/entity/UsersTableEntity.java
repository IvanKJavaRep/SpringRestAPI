package personal.ivan.textparseservice.dao.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")

public class UsersTableEntity implements Serializable {

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
    String name;

    @Column(name = "date")
    Timestamp date = null;

    public UsersTableEntity(int id, String name, Timestamp date) {
        super();
        this.id = id;
        this.name = name;
        this.date = date;

    }

}
