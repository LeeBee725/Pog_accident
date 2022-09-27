package pog.accident.accidents;


import org.springframework.data.jpa.repository.JpaRepository;

public interface AccidentRepository extends JpaRepository<Accident, Long> {
}
