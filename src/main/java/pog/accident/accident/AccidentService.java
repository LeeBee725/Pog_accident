package pog.accident.accident;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pog.accident.user.UserRepository;
import pog.accident.user.UserService;

import java.util.Optional;

@Service
public class AccidentService {

    private AccidentRepository accidentRepository;
    private UserService userService;
    public AccidentDTO getAccident(Long accidentId) throws Exception {
        ModelMapper modelMapper = new ModelMapper();
        Optional<Accident> findAccident = accidentRepository.findById(accidentId);
        if (findAccident.isPresent()) {
            return modelMapper.map(findAccident.get(), AccidentDTO.class);
        }
        throw new Exception("AccidentService.getAccident: Accident is null");
    }

    // TODO setUser 해야함
    public void saveAccident(AccidentDTO accidentDTO, String jwt) {
        ModelMapper modelMapper = new ModelMapper();
        Accident accident = modelMapper.map(accidentDTO, Accident.class);

        Long userId = userService.getUserIdByJWT("jwt");
        //accident.setUser();
        accidentRepository.save(accident);
    }
}
