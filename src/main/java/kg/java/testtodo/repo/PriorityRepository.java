package kg.java.testtodo.repo;

import kg.java.testtodo.models.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PriorityRepository  extends JpaRepository<Priority,Long> {

    Optional<Priority> findPriorityByName(String name);
}
