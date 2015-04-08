package foo.bar.day03;

import foo.bar.day03.tp.AppConfig;
import foo.bar.day03.tp.domain.Guest;
import foo.bar.day03.tp.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ainurminibaev on 08.04.15.
 */
@ContextConfiguration(classes = {
        AppConfig.class
})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestTimePadService {

    @Autowired
    UserService userService;

    @Test
    public void testSaveUser() {
        Guest register = userService.register(new Guest());
        Assert.assertNotNull(register.getId());
        Guest byId = userService.findById(register.getId());
        Assert.assertNotNull(byId);
    }
}
