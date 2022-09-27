package pog.accident.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pog.accident.accident.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
