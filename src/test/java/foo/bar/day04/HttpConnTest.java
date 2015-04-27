package foo.bar.day04;

import foo.bar.day03.tp.AppConfig;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;

/**
 * Created by ainurminibaev on 10.04.15.
 */
@ContextConfiguration(classes = {
        AppConfig.class
})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class HttpConnTest {
    CloseableHttpClient httpClient = HttpClients.createDefault();


    @Test
    public void test() throws IOException {
        HttpPost post = new HttpPost("http://localhost:8080/string");
        post.setEntity(new StringEntity("sdfd"));
        CloseableHttpResponse response = httpClient.execute(post);
        HttpEntity entity = response.getEntity();
        System.out.println(entity);
    }
}
