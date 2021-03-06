package foo.bar.day03;

import foo.bar.day03.remote.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by ainurminibaev on 08.04.15.
 */
@ContextConfiguration(classes = {
        ClientAppConfig.class
})
@RunWith(SpringJUnit4ClassRunner.class)
public class RemoteServicesTest {

    @Autowired
    SimpleObject simpleObject;


    /**
     * Don't run this test without ServerStarter run
     */
    @Test
    //@Ignore
    public void test() {
        simpleObject.insert();
        List<Account> accounts = simpleObject.call();
        Assert.assertNotNull(accounts);
        Assert.assertEquals(1, accounts.size());
    }

    @Before
    public void setUp() throws Exception {
        ServerStarter.main(null);
    }
}
