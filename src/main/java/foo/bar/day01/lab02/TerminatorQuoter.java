package foo.bar.day01.lab02;

import foo.bar.day01.lab01.RunThisMethod;

import java.util.List;

/**
 * Created by am on 06.04.2015.
 */
public class TerminatorQuoter implements Quoter {
    List<String> quotes;

    public List<String> getQuotes() {
        return quotes;
    }

    public void setQuotes(List<String> quotes) {
        this.quotes = quotes;
    }

    @Override
    @RunThisMethod(repeat = 4)
    public void sayQuote() {
        System.out.println(quotes);
    }
}
