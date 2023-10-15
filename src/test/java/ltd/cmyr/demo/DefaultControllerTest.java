package ltd.cmyr.demo;

import ltd.cmyr.demo.entity.ResponseData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//指定web环境，随机端口
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DefaultControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testHome() {
        ResponseData context = testRestTemplate.getForObject("/", ResponseData.class);
        Assert.assertEquals(200, context.getStatusCode());
        Assert.assertEquals("OK", context.getMessage());
    }
}
