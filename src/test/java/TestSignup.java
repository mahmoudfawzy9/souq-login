import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestSignup {

    private WebDriver driver;
    private HomePage homePage;
    @BeforeTest
    public void setup() {
        homePage = new HomePage(driver);
        homePage.open();
    }

    @Test
    public void testSignUp() {
        homePage.signUpFailed();
    }

    @AfterTest
    public void tearDown() {
        homePage.quitDriver();
    }
}
