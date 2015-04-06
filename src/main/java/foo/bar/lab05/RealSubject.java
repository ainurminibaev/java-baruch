package foo.bar.lab05;

import foo.bar.lab07.BenchMark;
import foo.bar.lab08.Transaction;

/**
 * Created by ainurminibaev on 06.04.15.
 */
@Transaction
public class RealSubject implements Subject {
    @Override
    @BenchMark
    public void call() {
        try {
            Thread.sleep(5 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
