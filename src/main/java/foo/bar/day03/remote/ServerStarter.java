package foo.bar.day03.remote;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by ainurminibaev on 08.04.15.
 */
public class ServerStarter {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServerAppConfig.class);
    }
}
