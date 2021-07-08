package audit.Authorization.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import audit.Authorization.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {
	Optional<User> findByUserName(String userName);
}