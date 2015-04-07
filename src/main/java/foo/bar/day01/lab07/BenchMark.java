package foo.bar.day01.lab07;

import java.lang.annotation.*;

/**
 * Created by ainurminibaev on 06.04.15.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface BenchMark {
}
