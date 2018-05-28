package michels.core.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Profile({"production"})
@Configuration
public class DataSourceConfig {

    @Bean(name = "ds-book", destroyMethod = "close")
    public DataSource bookdataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("");
        dataSource.setJdbcUrl("localhost");
        dataSource.setDriverClass("org.gjt.mm.mysql.Driver");
        dataSource.setMinPoolSize(3);
        dataSource.setMaxPoolSize(15);
        dataSource.setMaxConnectionAge(0);
        dataSource.setMaxIdleTime(300);

        return dataSource;
    }
}
