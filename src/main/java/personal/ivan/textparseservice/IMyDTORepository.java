package personal.ivan.textparseservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface IMyDTORepository extends JpaRepository<MyDTO, Integer> {

    public Optional<MyDTO> findById(Integer id);

    public List<MyDTO> findByidLessThanEqual(Integer id);

    @Query(value = "select * from my_table where address = ?1 ", nativeQuery = true)
    public List<MyDTO> findByAddress(String address);

    @Query("SELECT myDTO from MyDTO myDTO WHERE myDTO.name = ?1"  )
    public  List<MyDTO> findByName(String name);

}

