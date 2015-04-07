package foo.bar.day02.lab07;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by ainurminibaev on 07.04.15.
 */
@Component
public class PostInitComponent {

    @PostInitialized
    public void post() {
        System.out.println("Do some stuff: our class PostInitialized");
    }

    @PostConstruct
    public void post1() {
        System.out.println("Do some stuff: PostConstruct");
    }
}
