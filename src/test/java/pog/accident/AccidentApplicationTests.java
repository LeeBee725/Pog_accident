package pog.accident;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import pog.accident.accident.Accident;
import pog.accident.accident.AccidentRepository;

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

		Accident savedAccident = accidentRepository.save(accident);

	}
}
