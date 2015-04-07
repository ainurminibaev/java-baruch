package foo.bar.day01.lab05;

/**
 * Created by ainurminibaev on 06.04.15.
 */
class BenchMarkProxySubject implements Subject {
    Subject realSubject;

    public BenchMarkProxySubject(Subject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void call() {
        long start = System.currentTimeMillis();
        realSubject.call();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
