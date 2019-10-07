import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import resources.BaseClass;

import java.io.IOException;

public class Verify extends BaseClass {
    @BeforeTest
    public void initialize() throws IOException {
        initializeMailServer();
    }

    @Test
    public void verifyRegisteredUser() {

    }

    @AfterTest
    public void closeBrowser() {
//        driver.close();
//        driver = null;
    }
}
