package foo.bar.day03.tp.annotation;

import java.lang.annotation.*;

/**
 * Created by ainurminibaev on 08.04.15.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Table {
    String value() default "";
}
