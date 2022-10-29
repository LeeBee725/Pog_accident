package pog.accident.report;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccidentReportRepository extends JpaRepository<AccidentReport, Long>, AccidentReportRepositoryCustom {
}
