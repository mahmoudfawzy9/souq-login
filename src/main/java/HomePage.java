import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://egypt.souq.com/eg-en/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    public void login(){
        // Wait for 1 second
        try {
            Thread.sleep(1000);  // Sleep for 1000 milliseconds (1 second)
        } catch (InterruptedException e) {
            e.printStackTrace();  // Handle the interrupted exception
        }

        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nav-icon")));
        // Create an instance of Actions
        Actions actions = new Actions(driver);

        // Hover over the web element
        actions.moveToElement(driver.findElement(By.className("nav-icon"))).perform();

        // Wait for the span to be visible
        WebElement loginSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nav-a")));

        // Click the span
        loginSpan.click();

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("a-button-input"))).click();

        driver.findElement(By.id("ap_email")).sendKeys("01006864224");

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("a-button-input"))).click();

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password"))).sendKeys("<my-password>");

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInSubmit"))).click();

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);

        // Wait for the link to be visible
        WebElement toysAndGamesLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Toys & Games')]")));

        // Click the link
        toysAndGamesLink.click();

        // Wait for the image to be visible
        WebElement magicWaterDrawingImage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Magic Water Drawing Coloring Book Doodle with Magic Pen Painting Toy']")));

        // Click the image
        magicWaterDrawingImage.click();

    }

    public void enterEmail(String email) {
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(50));

        // Try to locate the element using both IDs
        WebElement emailField;
        try {
            emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email")));
        } catch (TimeoutException e) {
            emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_email_login")));
        }

        // Enter the email
        emailField.sendKeys(email);
    }
    public void forgetPassword(){
        // Wait for 1 second
        try {
            Thread.sleep(1000);  // Sleep for 1000 milliseconds (1 second)
        } catch (InterruptedException e) {
            e.printStackTrace();  // Handle the interrupted exception
        }

        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nav-icon")));
        // Create an instance of Actions
        Actions actions = new Actions(driver);

        // Hover over the web element
        actions.moveToElement(driver.findElement(By.className("nav-icon"))).perform();

        // Wait for the span to be visible
        WebElement loginSpan = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nav-a")));

        // Click the span
        loginSpan.click();

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("a-button-input"))).click();
        // refactored email or phone number
        enterEmail("01006864224");

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("a-button-input"))).click();

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("auth-fpp-link-bottom"))).click();

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("continue"))).click();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("a-autoid-0-announce"))).click();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);

        // Click on the dropdown to open it
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("cu-select-firstNode")));
        dropdown.click();

        // Create a Select object and select by value
        Select select = new Select(dropdown);
        select.selectByValue("2"); // I cannot sign in to my account

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);

        // Wait for the link to be clickable
        WebElement resetPasswordLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("إعادة تعيين كلمة المرور الخاصة بك.")));

        // Click the link
        resetPasswordLink.click();

        //TODO in order to reset password you have to enter email address which is vulnerable to security details
    }
    public void signUpFailed(){
        // Wait for one second
        try {
            Thread.sleep(1000);  // Sleep for 1000 milliseconds (1 second)
        } catch (InterruptedException e) {
            e.printStackTrace();  // Handle the interrupted exception
        }

        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nav-icon")));
        // Create an instance of Actions
        Actions actions = new Actions(driver);

        // Hover over the web element
        actions.moveToElement(driver.findElement(By.className("nav-icon"))).perform();

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("nav-a"))).click();

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("a-button-input"))).click();

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("createAccountSubmit"))).click();

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);

        // Click and then send keys for each input field
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_customer_name"))).click();
        driver.findElement(By.id("ap_customer_name")).sendKeys("محمود فوزي محمد فهمي");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_phone_number"))).click();
        driver.findElement(By.id("ap_phone_number")).sendKeys("01027201640");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password"))).click();
        driver.findElement(By.id("ap_password")).sendKeys("striker@1234");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password_check"))).click();
        driver.findElement(By.id("ap_password_check")).sendKeys("striker@1234");

        // Final submission

        driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("continue"))).click();

        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);

        //used for logging data using System.out.println statement
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cvf-aamation-challenge-iframe"))).isDisplayed();

        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);

        WebElement iframe = driver.findElement(By.id("cvf-aamation-challenge-iframe"));

        driver.switchTo().frame(iframe);

        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        // used for logging data to conslole
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("aacb-arkose-frame"))).isDisplayed();

        driver.switchTo().frame(driver.findElement(By.id("aacb-arkose-frame")));

        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        // used for logging data to conslole
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@title='Verification challenge']"))).isDisplayed();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Verification challenge']")));

        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
        // used for logging data to conslole
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("game-core-frame"))).isDisplayed();

        driver.switchTo().frame(driver.findElement(By.id("game-core-frame")));

        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);

        WebElement btn = driver.findElement(By.tagName("button"));
        btn.click();

        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);

        // Wait for the button to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sc-99cwso-0")));

        // Locate the button using aria-label
        WebElement buttonOne = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='صورة 1 من 6']")));
        WebElement buttonTwo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='صورة 2 من 6']")));
        WebElement buttonThree = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='صورة 3 من 6']")));
        WebElement buttonFour = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='صورة 4 من 6']")));
        WebElement buttonFive = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='صورة 5 من 6']")));
        WebElement buttonSix = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='صورة 6 من 6']")));

        buttonThree.click();

        // First Attempt
        try {
            Thread.sleep(5000);  // Sleep for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();  // Handle the interrupted exception
        }

        // Second Attempt
        buttonSix.click();
        // Wait for 5 seconds
        try {
            Thread.sleep(5000);  // Sleep for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();  // Handle the interrupted exception
        }
        // Third Attempt
        buttonFour.click();
        // Wait for 5 seconds
        try {
            Thread.sleep(5000);  // Sleep for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();  // Handle the interrupted exception
        }
        // Fourth Attempt
        buttonFive.click();
        // Wait for 5 seconds
        try {
            Thread.sleep(5000);  // Sleep for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();  // Handle the interrupted exception
        }
        // Fifth Attempt
        buttonSix.click();
        // Wait for 5 seconds
        try {
            Thread.sleep(5000);  // Sleep for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();  // Handle the interrupted exception
        }
        // Sixth Attempt
        buttonThree.click();
        // Wait for 5 seconds
        try {
            Thread.sleep(5000);  // Sleep for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();  // Handle the interrupted exception
        }
        // Seventh Attempt
        buttonFour.click();// here
        // Wait for 5 seconds
        try {
            Thread.sleep(5000);  // Sleep for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();  // Handle the interrupted exception
        }
        // Eighth Attempt
        buttonFour.click();
        // Wait for 5 seconds
        try {
            Thread.sleep(5000);  // Sleep for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();  // Handle the interrupted exception
        }
        // Ninth Attempt
        buttonFour.click();
        // Wait for 5 seconds
        try {
            Thread.sleep(5000);  // Sleep for 5000 milliseconds (5 seconds)
        } catch (InterruptedException e) {
            e.printStackTrace();  // Handle the interrupted exception
        }
        // Tenth Attempt
        buttonSix.click();
    }

}
