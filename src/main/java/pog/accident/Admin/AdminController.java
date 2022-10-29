package pog.accident.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pog.accident.accident.User;
import pog.accident.user.UserRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserRepository userRepository;

    public AdminController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/users")
    public String users(Model model) {
         constructTestUser();
        List<User> users = userRepository.findAll();

        model.addAttribute("users", users);
        return "users";
    }

    @PatchMapping("/users/{userId}")
    public String updateUser(@PathVariable Long userId, @ModelAttribute User user) {
        User findUser = userRepository.findById(userId).get();
        findUser.setName(user.getName());
        findUser.setAge(user.getAge());
        return "redirect:users";
    }

    /**
     * DB에서 유저를 완전히 삭제한다.
     * @param userId
     * @return
     */
    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        userRepository.deleteById(userId);
        return "redirect:users";
    }

    private void constructTestUser() {
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
}
