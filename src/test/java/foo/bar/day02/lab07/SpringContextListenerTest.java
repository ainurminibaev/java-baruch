package foo.bar.day02.lab07;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {
        AppConfig.class
})
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringContextListenerTest extends TestCase {

    @Test
    public void testPersistMessage() throws Exception {
        //TODO some test
    }
}