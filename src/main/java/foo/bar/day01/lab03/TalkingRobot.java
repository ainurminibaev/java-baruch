package foo.bar.day01.lab03;

import foo.bar.day01.lab02.Quoter;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by am on 06.04.2015.
 */
public class TalkingRobot implements Robot {

    private List<Quoter> quoters;

    public List<Quoter> getQuoters() {
        return quoters;
    }

    public void setQuoters(List<Quoter> quoters) {
        this.quoters = quoters;
    }

    @Override
    @PostConstruct
    public void talk() {
        for (Quoter quoter : quoters)
            quoter.sayQuote();
    }

}
