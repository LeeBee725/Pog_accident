package pog.accident.Admin;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import pog.accident.accident.User;
import pog.accident.user.UserRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AdminControllerTest {
    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void before() {
        User user = new User();
        User user2 = new User();
        User user3 = new User();
        user.setName("user1");
        user2.setName("user2");
        user3.setName("user3");
        user.setAge(10);
        user2.setAge(20);
        user3.setAge(30);
        userRepository.save(user);
        userRepository.save(user2);
        userRepository.save(user3);
    }

    @AfterEach
    void after() {
        userRepository.deleteAll();
    }

    @Test
    @DisplayName("유저 삭제 테스트")
    void deleteUser() {
        List<User> users = userRepository.findAll();

        User user = users.get(0);
        userRepository.deleteById(user.getId());

        List<User> afterDelete = userRepository.findAll();
        Assertions.assertThat(users).isNotEqualTo(afterDelete);
    }
}