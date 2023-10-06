package kg.java.testtodo.data.repo;

import kg.java.testtodo.core.models.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<Task> findTaskByTitle(String title);
}
