package foo.bar.day02.lab04;


import org.springframework.stereotype.Component;

/**
 * Created by am on 06.04.2015.
 */
@Component
public class ShakespeareQuoter implements Quoter {

    String quote;

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    @Override
    public String sayQuote() {
        return quote;
    }
}
