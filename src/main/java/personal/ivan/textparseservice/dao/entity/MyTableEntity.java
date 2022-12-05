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
@Table(name = "table_with_time")

public class MyTableEntity implements Serializable {

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
    @Column(name = "creation_time")
    Timestamp creationTime = null;
    @Column(name = "update_time")
    Timestamp updateTime = null;
    String status;

    public MyTableEntity(int id, String name, String address, Timestamp creation, Timestamp update, String status) {
        super();
        this.id = id;
        this.name = name;
        this.address = address;
        this.status = status;
        creationTime = creation;
        updateTime = update;
    }

    @PrePersist
    void prePersist() {
        java.util.Date date = new java.util.Date();
        creationTime = new Timestamp(date.getTime());
        updateTime = new Timestamp(date.getTime());
    }

    @PreUpdate
    void preUpdate() {
        java.util.Date date = new java.util.Date();
        updateTime = new Timestamp(date.getTime());
    }
}
