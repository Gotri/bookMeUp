package michels.core.configuration;

import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@Profile("test")
@ComponentScan(basePackages = {"michels.core"})
public class TestApplicationContext {

    @Bean(name = "ds-book")
    public DataSource dataSource(){
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        builder.setType(EmbeddedDatabaseType.HSQL);
        builder.setName("book");
        builder.addScript("classpath:schema.sql");

        return builder.build();
    }

}
