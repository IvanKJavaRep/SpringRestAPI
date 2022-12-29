package personal.ivan.textparseservice.dao.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import liquibase.pro.packaged.E;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
    @Enumerated(EnumType.STRING)
    Status status;


    public MyTableEntity(int id, String name, String address, Timestamp creation, Timestamp update, String status) {

        super();
        System.out.println(status);
        this.id = id;
        this.name = name;
        this.address = address;
        this.status = Status.valueOf(status);
        creationTime = creation;
        updateTime = update;
    }

    @PrePersist
    void prePersist() {
        LocalDateTime date = LocalDateTime.now();
        creationTime = Timestamp.valueOf(date);
        updateTime = Timestamp.valueOf(date);
    }

    @PreUpdate
    void preUpdate() {
        LocalDateTime date = LocalDateTime.now();
        updateTime = Timestamp.valueOf(date);
    }
}
