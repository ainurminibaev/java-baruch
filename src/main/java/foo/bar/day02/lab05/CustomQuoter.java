package foo.bar.day02.lab05;

import foo.bar.day02.lab04.Quoter;

/**
 * Created by ainurminibaev on 07.04.15.
 */
public class CustomQuoter implements Quoter {

    private StringBuilder stringBuilder;

    public CustomQuoter(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    @Override
    public String sayQuote() {
        return null;
    }
}
