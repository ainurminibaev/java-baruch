package foo.bar.day01.lab04;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface InjectRandomInt {

    int min() default 0;

    int max() default 100;
}