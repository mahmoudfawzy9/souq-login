import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestLogin {

    private WebDriver driver;
    @BeforeClass
    public void open() {
        System.setProperty("webdriver.chrome.driver", Configuration.getChromeDriverPath());
    }

    @Test
    public void testLogin() {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.login();
    }
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
