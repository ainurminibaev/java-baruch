package foo.bar.day02.lab02;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ainurminibaev on 07.04.15.
 */
public class FactoryBeanTest {

    @Test
    public void testFactoryBean() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("day02/context0202.xml");
        StringBuilder bean = context.getBean(StringBuilder.class);
        Assert.assertNotNull(bean);
        Assert.assertEquals(bean.getClass(), StringBuilder.class);
    }
}
