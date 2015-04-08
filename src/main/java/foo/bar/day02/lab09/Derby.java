package foo.bar.day02.lab09;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by ainurminibaev on 08.04.15.
 */
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Derby {
}
