package foo.bar.lab04;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ainurminibaev on 06.04.15.
 */
public class InjectTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        RandomIntClazz bean = context.getBean(RandomIntClazz.class);
        bean.getRandomInt();
    }
}
