package foo.bar.day02.lab03;

/**
 * Created by ainurminibaev on 07.04.15.
 */
public class SpeakingRobot {
    private RandomQuoter quoter;


    public RandomQuoter getQuoter() {
        return quoter;
    }

    public void setQuoter(RandomQuoter quoter) {
        this.quoter = quoter;
    }

    public String speak() {
        return quoter.getRandomQuote();
    }
}
