package foo.bar.day02.lab03;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ainurminibaev on 07.04.15.
 */
public class PrototypeTest {

    @Test
    public void test() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("day02/context03.xml");
        // SpeakingRobot bean = context.getBean(SpeakingRobot.class);
        // Assert.assertEquals(bean.speak(), bean.speak());
    }
}
