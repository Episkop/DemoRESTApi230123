package test.courses.rest.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import test.courses.rest.Entity.ToDoEntity;

public interface ToDoRepository extends JpaRepository<ToDoEntity,Long> {
}
