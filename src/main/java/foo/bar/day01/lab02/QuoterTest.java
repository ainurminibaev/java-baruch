package foo.bar.day01.lab02;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by am on 06.04.2015.
 */
public class QuoterTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("day01/context.xml");
        Quoter quoter = context.getBean(Quoter.class);
        quoter.sayQuote();
    }
}
