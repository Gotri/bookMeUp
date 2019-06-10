package bookmeup.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/add")
    public @ResponseBody
    String addNewCustomer(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
        User user = new User(username, passwordEncoder.encode(password), email);
        userRepository.save(user);
        return "You successfully created your new account";
    }

    @GetMapping("/current")
    public @ResponseBody
    UserModel getCurrentUser(Authentication authentication) {
        if (isAuthenticated(authentication)) {
            User user = userRepository.findByEmail(authentication.getName());
            UserModel userModel = new UserModel();
            userModel.setId(user.getId());
            userModel.setUsername(user.getUsername());
            return userModel;
        }
        return null;
    }

    @GetMapping("/current/is/authenticated")
    public @ResponseBody
    boolean isAuthenticated(Authentication authentication) {
        return authentication != null && authentication.isAuthenticated();
    }
}
