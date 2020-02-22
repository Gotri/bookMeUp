package bookmeup.book;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookModelFactory {

    public BookModel fromBook(Book book) {
        BookModel bookModel = new BookModel();
        bookModel.setPages(book.getPages());
        bookModel.setRating(book.getRating());
        bookModel.setTitle(book.getTitle());
        bookModel.setAuthor(book.getAuthor());
        bookModel.setUserId(book.getUserId());
        bookModel.setState(book.getState());
        bookModel.setShelves(book.getShelves());
        bookModel.setDescription(book.getDescription());
        bookModel.setCoverReference(book.getCoverReference());
        bookModel.setGenres(book.getGenres());
        return bookModel;
    }

    public List<BookModel> fromBooks(List<Book> books) {
        List<BookModel> bookModels = new ArrayList<BookModel>();
        for (Book book : books) {
            bookModels.add(fromBook(book));
        }
        return bookModels;
    }

}
