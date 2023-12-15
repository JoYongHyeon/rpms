package centralregion.userapi.healthCheck.repository;

import centralregion.userapi.healthCheck.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {


}
