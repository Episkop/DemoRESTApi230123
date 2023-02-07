package test.courses.rest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.courses.rest.Entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByUsername(String username);
}
