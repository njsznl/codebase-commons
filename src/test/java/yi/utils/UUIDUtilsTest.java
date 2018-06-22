package yi.utils;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UUIDUtilsTest {

    @InjectMocks
    private UUIDUtils uuidUtils;

    @Test
    public void getUuid() {
        Assert.assertEquals(32, uuidUtils.getUuid().length());
    }
}