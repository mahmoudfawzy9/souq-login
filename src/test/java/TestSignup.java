import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
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

    @AfterClass
    public void tearDown() {
        homePage.quitDriver();
    }
}
