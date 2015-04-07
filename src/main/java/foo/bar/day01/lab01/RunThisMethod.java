package foo.bar.day01.lab01;

import java.lang.annotation.*;

/**
 * Created by ainurminibaev on 06.04.15.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface RunThisMethod {

    int repeat() default 1;
}
