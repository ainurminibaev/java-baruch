package foo.bar.day02.lab07;

import java.lang.annotation.*;

/**
 * Created by ainurminibaev on 07.04.15.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface PostInitialized {
}
