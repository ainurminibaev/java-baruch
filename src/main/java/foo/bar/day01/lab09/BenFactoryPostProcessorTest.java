package foo.bar.day01.lab09;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ainurminibaev on 06.04.15.
 */
public class BenFactoryPostProcessorTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("day01/context09.xml");
        DestroyablePrototype bean = context.getBean(DestroyablePrototype.class);
    }
}
