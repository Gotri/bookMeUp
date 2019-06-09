package bookmeup.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
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
}
