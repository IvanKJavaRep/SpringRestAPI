package personal.ivan.textparseservice.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import personal.ivan.textparseservice.data.MyDTO;

import java.util.List;

@Repository
public interface IMyDTORepository extends JpaRepository<MyDTO, Integer> {


    public List<MyDTO> findByidLessThanEqual(Integer id);

    @Query(value = "select * from my_table where address = ?1 ", nativeQuery = true)
    public List<MyDTO> findByAddress(String address);

    @Query("SELECT myDTO from MyDTO myDTO WHERE myDTO.name = ?1"  )
    public  List<MyDTO> findByName(String name);

}

