package bookmeup.book;

import bookmeup.user.UserController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookControllerTest {

    @InjectMocks
    private BookController bookController;

    @Mock
    private BookRepository bookRepository;

    @Spy
    private BookModelFactory bookModelFactory;

    @Mock
    private UserController userController;

    private Book book;

    @BeforeEach
    public void setUp() {
        book = new Book();
        book.setPages(500);
        book.setRating(5);
        book.setTitle("title");
        book.setAuthor("author");
        book.setUserId(1L);
        book.setState("state");
        book.setShelves("shelves");
        book.setDescription("description");
        book.setCoverReference("coverReference");
        book.setGenres("genres");
    }

    @Test
    void getById() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        BookModel bookModel = bookController.getById(1L);
        assertThat(bookModel.getAuthor(), is(book.getAuthor()));
        assertThat(bookModel.getPages(), is(book.getPages()));
        assertThat(bookModel.getRating(), is(book.getRating()));
        assertThat(bookModel.getTitle(), is(book.getTitle()));
        assertThat(bookModel.getUserId(), is(book.getUserId()));
        assertThat(bookModel.getState(), is(book.getState()));
        assertThat(bookModel.getShelves(), is(book.getShelves()));
        assertThat(bookModel.getDescription(), is(book.getDescription()));
        assertThat(bookModel.getCoverReference(), is(book.getCoverReference()));
        assertThat(bookModel.getGenres(), is(book.getGenres()));
    }

    @Test
    void getByUserId() {
        when(bookRepository.findByUserId(1L)).thenReturn(Collections.singletonList(book));
        List<BookModel> bookModels = bookController.getByUserId(1L);
        assertThat(bookModels.size(), is(1));
        BookModel bookModel = bookModels.get(0);
        assertThat(bookModel.getAuthor(), is(book.getAuthor()));
        assertThat(bookModel.getPages(), is(book.getPages()));
        assertThat(bookModel.getRating(), is(book.getRating()));
        assertThat(bookModel.getTitle(), is(book.getTitle()));
        assertThat(bookModel.getUserId(), is(book.getUserId()));
        assertThat(bookModel.getState(), is(book.getState()));
        assertThat(bookModel.getShelves(), is(book.getShelves()));
        assertThat(bookModel.getDescription(), is(book.getDescription()));
        assertThat(bookModel.getCoverReference(), is(book.getCoverReference()));
        assertThat(bookModel.getGenres(), is(book.getGenres()));
    }
}