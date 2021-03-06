package foo.bar.day01.lab08;

import foo.bar.day01.lab05.Subject;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ainurminibaev on 06.04.15.
 */
public class TransactionTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("day01/context07.xml");
        Subject subject = context.getBean(Subject.class);
        subject.call();
    }
}
