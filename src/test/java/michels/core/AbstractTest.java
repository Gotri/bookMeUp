package michels.core;

import michels.core.configuration.TestApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ActiveProfiles("test")
@ContextConfiguration(classes = {TestApplicationContext.class})
public class AbstractTest extends AbstractTransactionalJUnit4SpringContextTests {

    @PersistenceContext(unitName = "bookPU")
    protected EntityManager entityManager;

}
