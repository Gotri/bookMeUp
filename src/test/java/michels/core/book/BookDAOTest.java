package michels.core.book;

import michels.core.AbstractTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.inject.Inject;

public class BookDAOTest extends AbstractTest {

    @Inject
    private BookDAO bookDAO;

    @Test
    public void testGetByKey() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setRating(5);
        bookEntity.setAuthor("Marek");
        bookEntity.setName("Marek´s Fantastische Reisen");
        entityManager.persist(bookEntity);

        int id = bookEntity.getId();

        bookEntity = bookDAO.getByKey(id);

        Assert.assertEquals(bookEntity.getRating(), 5);
        Assert.assertEquals(bookEntity.getAuthor(), "Marek");
        Assert.assertEquals(bookEntity.getName(), "Marek´s Fantastische Reisen");
    }

    @Test
    public void testSave(){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setRating(5);
        bookEntity.setAuthor("Marek");
        bookEntity.setName("Marek´s Fantastische Reisen");
        bookDAO.save(bookEntity);

        int id = bookEntity.getId();

        bookEntity = entityManager.find(BookEntity.class, id);

        Assert.assertEquals(bookEntity.getRating(), 5);
        Assert.assertEquals(bookEntity.getAuthor(), "Marek");
        Assert.assertEquals(bookEntity.getName(), "Marek´s Fantastische Reisen");
    }
}
