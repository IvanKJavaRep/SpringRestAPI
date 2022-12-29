package personal.ivan.textparseservice.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import personal.ivan.textparseservice.dao.entity.MyTableEntity;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Repository
public interface IMyDTORepository extends JpaRepository<MyTableEntity, Integer> {

    @Transactional
    @Modifying
    @Query("from MyTableEntity m WHERE m.updateTime < ?1")
    public List<MyTableEntity> selectDataBase(Timestamp timestamp);

}

