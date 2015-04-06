package foo.bar.lab07;

import foo.bar.lab05.Subject;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ainurminibaev on 06.04.15.
 */
public class BeanchMarkTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context07.xml");
        Subject subject = context.getBean(Subject.class);
        subject.call();
    }
}
