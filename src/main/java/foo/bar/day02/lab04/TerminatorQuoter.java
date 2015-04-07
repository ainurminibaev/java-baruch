package foo.bar.day02.lab04;

import org.springframework.stereotype.Component;

/**
 * Created by ainurminibaev on 07.04.15.
 */
@Component
public class TerminatorQuoter implements Quoter {
    @Override
    public String sayQuote() {
        return "I'll be back";
    }
}
