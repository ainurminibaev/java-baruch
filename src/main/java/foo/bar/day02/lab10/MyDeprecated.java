package foo.bar.day02.lab10;

import java.lang.annotation.*;

/**
 * Created by ainurminibaev on 08.04.15.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyDeprecated {

    Class replaceWith();
}
