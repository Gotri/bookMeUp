package bookmeup.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/all")
    public @ResponseBody
    Iterable<User> getAllCustomers() {
        return userRepository.findAll();
    }

    @GetMapping("/by/username/{username}")
    public @ResponseBody
    List<User> getByLastName(@PathVariable String username) {
        return userRepository.findByUsername(username);
    }

    @GetMapping("/current")
    public @ResponseBody
    User getCurrentUser(Authentication authentication) {
        if (isAuthenticated(authentication)) {
            return userRepository.findByEmail(authentication.getName());
        }
        return null;
    }

    @GetMapping("/current/is/authenticated")
    public @ResponseBody
    boolean isAuthenticated(Authentication authentication) {
        return authentication != null && authentication.isAuthenticated();
    }
}
