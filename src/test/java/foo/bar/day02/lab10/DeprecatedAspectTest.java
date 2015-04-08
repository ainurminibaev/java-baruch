package foo.bar.day02.lab10;


import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {
        AppConfig.class
})
@RunWith(SpringJUnit4ClassRunner.class)
public class DeprecatedAspectTest extends TestCase {

    @Autowired
    Service service;

    @Test
    public void testAspect() {
        Assert.assertEquals(service.replace().getClass(), Integer.class);
        Assert.assertEquals(service.noReplace().getClass(), String.class);
    }
}