package foo.bar.day02.lab03;

/**
 * Created by ainurminibaev on 07.04.15.
 */
public abstract class SpeakingRobot implements Robot {

    public abstract RandomQuoter getQuoter();

    public String speak() {
        return getQuoter().getRandomQuote();
    }
}
