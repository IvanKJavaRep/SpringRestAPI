package personal.ivan.textparseservice.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import personal.ivan.textparseservice.dao.entity.MyTableEntity;
import personal.ivan.textparseservice.dao.entity.UsersTableEntity;

import java.util.List;

@Repository
public interface IMyDTORepository extends JpaRepository<MyTableEntity, Integer> {


    public List<MyTableEntity> findByidLessThanEqual(Integer id);

    @Query(value = "select * from my_table where address = ?1 ", nativeQuery = true)
    public List<MyTableEntity> findByAddress(String address);


    @Query("SELECT myTableEntity from MyTableEntity myTableEntity WHERE myTableEntity.name = ?1"  )
    public  List<MyTableEntity> findByName(String name);

}

