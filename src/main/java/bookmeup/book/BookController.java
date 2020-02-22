package bookmeup.book;

import bookmeup.user.UserController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final static Logger LOGGER = LogManager.getLogger(BookController.class);

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
        LOGGER.info("Get Book by id: {}", id);
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            BookModel bookModel = bookModelFactory.fromBook(book.get());
            LOGGER.info("Got Book: {} for id: {}", bookModel, id);
            return bookModel;
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
