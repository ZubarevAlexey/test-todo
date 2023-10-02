package kg.java.testtodo.repo;

import kg.java.testtodo.models.dtos.user.UserDto;
import kg.java.testtodo.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByName(String name);
}

