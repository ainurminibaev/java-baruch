package foo.bar.lab08;

import java.lang.annotation.*;

/**
 * Created by ainurminibaev on 06.04.15.
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface Transaction {
}
