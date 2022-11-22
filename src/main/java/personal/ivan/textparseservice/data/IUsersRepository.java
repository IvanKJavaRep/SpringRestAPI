package personal.ivan.textparseservice.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import personal.ivan.textparseservice.dao.entity.UsersTableEntity;
@Repository
public interface IUsersRepository extends JpaRepository<UsersTableEntity, Integer> {
}
