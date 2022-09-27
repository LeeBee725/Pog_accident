package pog.accident.user;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pog.accident.accident.AccidentDTO;
import pog.accident.accident.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    public List<AccidentDTO> getUserAccidents(Long userId) throws Exception {
        ModelMapper modelMapper = new ModelMapper();
        Optional<User> findUser = userRepository.findById(userId);
        if (findUser.isPresent()) {
            User user = findUser.get();
            List<AccidentDTO> accidentDTOList = user.getAccidents().stream()
                    .map(accident -> modelMapper.map(accident, AccidentDTO.class))
                    .collect(Collectors.toList());
            return accidentDTOList;
        }
        throw new Exception("UserService.getUserAccidents User is null");
    }

    // TODO jwt 기반으로 userId 받아오기
    public Long getUserIdByJWT(String jwt) {
        return null;
    }

}
