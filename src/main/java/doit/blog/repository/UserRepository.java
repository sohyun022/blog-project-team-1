package doit.blog.repository;

import doit.blog.controller.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUserLoginId(String userLoginId);
    User findByUserLoginId(String loginId);
}
