package potato.study.lec03study.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import potato.study.lec03study.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
}
