package foo.bar.day01.lab03;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by am on 06.04.2015.
 */
public class RobotTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Robot talkingRobot = context.getBean(Robot.class);
        System.out.println(talkingRobot);
    }
}
