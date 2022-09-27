package pog.accident.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pog.accident.accident.AccidentDTO;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @GetMapping("/{userId}/accidents")
    public List<AccidentDTO> getUserAccidents(@PathVariable Long userId) throws Exception {
        return userService.getUserAccidents(userId);
    }
}
