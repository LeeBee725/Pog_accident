package pog.accident;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import pog.accident.accidents.Accident;
import pog.accident.accidents.AccidentRepository;

import javax.annotation.PostConstruct;
import java.util.Optional;

@SpringBootTest
@Transactional
class AccidentApplicationTests {

	@Autowired
	private AccidentRepository accidentRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void repositoryTest() {

		Accident accident = new Accident();
		Accident savedAccident = accidentRepository.save(accident); // 1차 캐시에 저장이 된 상태 Yes or No

		accidentRepository.flush();


	}
}
