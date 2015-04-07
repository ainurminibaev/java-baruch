package foo.bar.day01.lab10;

import java.lang.annotation.*;

/**
 * Created by ainurminibaev on 07.04.15.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExtDeprecated {

    Class replacedWith();
}
