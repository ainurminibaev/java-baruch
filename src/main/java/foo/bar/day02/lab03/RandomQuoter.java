package foo.bar.day02.lab03;

import java.util.Random;

/**
 * Created by ainurminibaev on 07.04.15.
 */
public class RandomQuoter {
    private String num;

    public RandomQuoter() {
        Random random = new Random();
        num = Integer.toHexString(random.nextInt());
    }


    public String getRandomQuote() {
        return num;
    }
}
