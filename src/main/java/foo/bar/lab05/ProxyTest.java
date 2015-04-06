package foo.bar.lab05;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ainurminibaev on 06.04.15.
 */
public class ProxyTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Subject subject = (Subject) context.getBean("subject");
        subject.call();
    }
}
