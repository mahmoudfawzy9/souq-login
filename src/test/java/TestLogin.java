import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLogin {

    private WebDriver driver;
    HomePage homePage;

    @BeforeTest
    public void setup() {
        homePage = new HomePage(driver);
        homePage.open();
    }

    @Test
    public void testLogin() {
        homePage.login();
    }

    @AfterTest
    public void tearDown() {
        homePage.quitDriver();

    }
}
