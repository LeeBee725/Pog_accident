package pog.accident.report;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pog.accident.accident.AccidentRepository;

import java.util.Optional;

@Service
public class AccidentReportService {

    private AccidentReportRepository accidentReportRepository;
    private AccidentRepository accidentRepository;

    public AccidentReportDTO getAccidentReport(Long reportId) throws Exception {
        ModelMapper modelMapper = new ModelMapper();

        Optional<AccidentReport> reportRepositoryById = accidentReportRepository.findById(reportId);
        if (reportRepositoryById.isPresent()) {
            return modelMapper.map(reportRepositoryById.get(), AccidentReportDTO.class);
        }
        throw new Exception("AccidentReportService.getAccidentReport: AccidentReport is null");
    }
}
