import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestForgetPassword {

    private WebDriver driver;
    private HomePage homePage;
    @BeforeTest
    public void setup() {
        homePage = new HomePage(driver);
        homePage.open();
    }


    @Test
    public void testForgetPassword() {
        homePage.forgetPassword();
    }

    @AfterTest
    public void tearDown() {
        homePage.quitDriver();
    }
}
