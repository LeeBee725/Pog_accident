package pog.accident.accident;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import pog.accident.user.UserRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AccidentRepositoryTest {

    @Autowired
    private AccidentRepository accidentRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    void getAccidentsByUserId() {
        // given
        User user = new User();
        Accident accident = new Accident();
        Accident accident2 = new Accident();

        userRepository.save(user);
        accidentRepository.save(accident);
        accidentRepository.save(accident2);

        // when
        accident.changeUser(user);
        accident2.changeUser(user);
        List<Accident> accidents = accidentRepository.getAccidentsByUserId(user.getId());

        // then
        Assertions.assertThat(accidents).contains(accident, accident2);
    }
}