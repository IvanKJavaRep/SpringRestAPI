package personal.ivan.textparseservice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Repository
public interface studentRepository extends CrudRepository<MyDTO, Integer> {

    public Optional<MyDTO> findById(Integer id);

    public List<MyDTO> findByidLessThanEqual(Integer id);


}

