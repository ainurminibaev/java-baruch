package foo.bar.day02.lab05;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by ainurminibaev on 07.04.15.
 */
@ContextConfiguration(classes = {
        ApplicationConfig.class
})
@RunWith(SpringJUnit4ClassRunner.class)
public class FileSizeConfigTest {

    @Autowired
    MFileWriter fileWriter;

    @Autowired
    MFileReader fileReader;

    @Test
    public void test() {
        org.junit.Assert.assertEquals(fileReader.getFileSize(), fileWriter.getFileSize());
    }
}
