package foo.bar.day02.lab05;

import foo.bar.day01.lab01.Robot;
import foo.bar.day02.lab02.StringBuilderFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.*;

/**
 * Created by ainurminibaev on 07.04.15.
 */
@PropertySource(value = "classpath:day02/file.properties")
@Configuration
public class ApplicationConfig {

    @Autowired
    private StringBuilder stringBuilder;

    @Bean
    public PropertyPlaceholderConfigurer placeholderConfigurer() {
        return new PropertyPlaceholderConfigurer();
    }

    @Bean(name = "sdfdsf")
    @DependsOn("getMFileWriter")
    public MFileReader getMFileReader() {
        return new MFileReader();
    }

    @Bean
    public StringBuilderFactoryBean stringBuilder() throws Exception {
        StringBuilderFactoryBean factoryBean = new StringBuilderFactoryBean();
        factoryBean.setStart("start ");
        factoryBean.setFinish(" finish");
        factoryBean.setMiddle(" middle");
        return factoryBean;
    }


    @Bean
    public foo.bar.day02.lab04.Quoter terminatorQuoter() {
        return new CustomQuoter(stringBuilder);
    }

    @Bean
    public Robot robot() {
        return new Robot();
    }

    @Bean
    public MFileWriter getMFileWriter() {
        return new MFileWriter();
    }

}
