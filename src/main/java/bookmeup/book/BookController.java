package bookmeup.book;

import bookmeup.user.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    private final UserController userController;

    @Autowired
    public BookController(BookRepository bookRepository, UserController userController) {
        this.bookRepository = bookRepository;
        this.userController = userController;
    }

    @GetMapping("/by/id/{id}")
    public @ResponseBody
    Book getById(@PathVariable Long id) {
        if (bookRepository.findById(id).isPresent()) {
            return bookRepository.findById(id).get();
        }
        return null;
    }

    @GetMapping("/by/user/{userId}")
    public @ResponseBody
    List<Book> getByUserId(@PathVariable Long userId) {
        return bookRepository.findByUserId(userId);
    }

    @GetMapping("/by/user/current")
    public @ResponseBody
    List<Book> getByCurrentUser(Authentication authentication) {
        return bookRepository.findByUserId(userController.getCurrentUser(authentication).getId());
    }
}
