package config;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableWebMvc
@ComponentScan({"config", "controller", "service", "repository", "client"})
@EnableJpaRepositories({"repository"})
@EnableTransactionManagement
@PropertySource({"classpath:config.properties"})
public class AppConfig {
    private static final Log log = LogFactory.getLog(AppConfig.class);

    public static final String PERSISTENCE_UNIT = "persistenceUnit";

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        log.info("create entity manager factory");
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        EclipseLinkJpaVendorAdapter adapter = new EclipseLinkJpaVendorAdapter();
        factory.setPersistenceUnitName(PERSISTENCE_UNIT);
        factory.setJpaVendorAdapter(adapter);
        factory.setDataSource(dataSource());
        factory.setJpaProperties(new Properties());
        factory.afterPropertiesSet();
        EntityManagerFactory emf = factory.getObject();
        log.info("entity manager created");
        return emf;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5433/stock?autoReconnect=true");
        dataSource.setUsername("admin");
        dataSource.setPassword("password");
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        log.info("!!! transactionManager called");
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(this.entityManagerFactory());
        log.info("!!! txManager = " + txManager);
        return txManager;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
