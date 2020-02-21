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

    private final BookModelFactory bookModelFactory;

    @Autowired
    public BookController(BookRepository bookRepository, UserController userController, BookModelFactory bookModelFactory) {
        this.bookRepository = bookRepository;
        this.userController = userController;
        this.bookModelFactory = bookModelFactory;
    }

    @GetMapping("/by/id/{id}")
    public @ResponseBody
    BookModel getById(@PathVariable Long id) {
        if (bookRepository.findById(id).isPresent()) {
            return bookModelFactory.fromBook(bookRepository.findById(id).get());
        }
        return null;
    }

    @GetMapping("/by/user/{userId}")
    public @ResponseBody
    List<BookModel> getByUserId(@PathVariable Long userId) {
        return bookModelFactory.fromBooks(bookRepository.findByUserId(userId));
    }

    @GetMapping("/by/user/current")
    public @ResponseBody
    List<BookModel> getByCurrentUser(Authentication authentication) {
        return bookModelFactory.fromBooks(bookRepository.findByUserId(userController.getCurrentUser(authentication).getId()));
    }
}
