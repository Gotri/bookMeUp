package michels.core;

import michels.core.configuration.TestApplicationContext;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;

@ActiveProfiles("test")
@ContextConfiguration(classes = {TestApplicationContext.class})
public abstract class AbstractTest extends AbstractTransactionalJUnit4SpringContextTests {

    @PersistenceContext(unitName = "bookPU")
    protected EntityManager entityManager;
}
