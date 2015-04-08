package foo.bar.day02.lab06;

import org.springframework.context.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ainurminibaev on 07.04.15.
 */
@Configuration
@ComponentScan("foo.bar.day02.lab06")
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public List<String> mailToList() {
        ArrayList<String> mailToList = new ArrayList<>();
        mailToList.add("sdfdsfds");
        mailToList.add("sdfdsfds1");
        mailToList.add("sdfdsfds2");
        mailToList.add("sdfdsfds3");
        return mailToList;
    }

}
