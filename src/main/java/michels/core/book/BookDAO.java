package michels.core.book;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class BookDAO {

    @PersistenceContext(unitName = "bookPU")
    private EntityManager entityManager;

    public BookEntity getByKey(int key) {
        return entityManager.find(BookEntity.class, key);
    }

    public void save(BookEntity bookEntity) {
        entityManager.persist(bookEntity);
    }
}
