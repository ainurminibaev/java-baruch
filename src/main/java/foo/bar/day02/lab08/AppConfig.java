package foo.bar.day02.lab08;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.*;

/**
 * Created by ainurminibaev on 07.04.15.
 */
@Configuration
@ComponentScan("foo.bar.day02.lab08")
public class AppConfig {

//    @Autowired
//    FiveMinScope fiveMinScope;

    @Bean
    @DependsOn("fiveMinScope")
    public CustomScopeConfigurer scopeConfigurer(FiveMinScope fiveMinScope) {
        CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();
        customScopeConfigurer.addScope("fiveMinScope", fiveMinScope);
        return customScopeConfigurer;
    }
}
