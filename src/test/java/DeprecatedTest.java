import foo.bar.day01.lab10.AwesomeClass;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ainurminibaev on 07.04.15.
 */
public class DeprecatedTest {

    @Test
    public void deprecatedTest() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context10.xml");
        Object replacedBean = context.getBean("replacedBean");
        Assert.assertEquals(AwesomeClass.class, replacedBean.getClass());

    }
}
