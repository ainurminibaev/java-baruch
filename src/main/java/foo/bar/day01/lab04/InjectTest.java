package foo.bar.day01.lab04;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ainurminibaev on 06.04.15.
 */
public class InjectTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("day01/context.xml");
        RandomIntClazz bean = context.getBean(RandomIntClazz.class);
        bean.getRandomInt();
    }
}
