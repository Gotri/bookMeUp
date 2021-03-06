package bookmeup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping("/login")
    public String loginView() {
        return "login.html";
    }

    @GetMapping("/registration")
    public String registrationView() {
        return "registration.html";
    }

    @GetMapping("/myBooks")
    public String userView() {
        return "myBooks.html";
    }
}
