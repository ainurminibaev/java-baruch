package foo.bar.day03.tp.annotation;

import java.lang.annotation.*;

/**
 * Created by ainurminibaev on 10.04.15.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ClassMapper {
}
