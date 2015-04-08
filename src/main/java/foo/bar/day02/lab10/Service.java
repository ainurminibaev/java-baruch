package foo.bar.day02.lab10;

import org.springframework.stereotype.Component;

/**
 * Created by ainurminibaev on 08.04.15.
 */
@Component
public class Service {
    @MyDeprecated(replaceWith = Integer.class)
    public Number replace() {
        return 3;
    }

    public String noReplace() {
        return "";
    }
}
