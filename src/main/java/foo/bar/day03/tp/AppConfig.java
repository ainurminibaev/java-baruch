package foo.bar.day03.tp;

import foo.bar.day03.tp.dao.MigrationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.annotation.PostConstruct;

/**
 * Created by ainurminibaev on 08.04.15.
 */
@Configuration
@ComponentScan("foo.bar.day03.tp")
public class AppConfig {

    @Autowired
    MigrationDao migrationDao;

    @Bean
    public javax.sql.DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(org.h2.Driver.class);
        dataSource.setUsername("sa");
        dataSource.setUrl("jdbc:h2:mem");
        dataSource.setPassword("");
        //inspection
        return dataSource;
    }

    @Bean
    public Jackson2ObjectMapperFactoryBean jackson2ObjectMapperFactoryBean() {
        return new Jackson2ObjectMapperFactoryBean();
    }


    @PostConstruct
    public void migrate() {
        migrationDao.migrate("day03/migrations/");
    }


}
