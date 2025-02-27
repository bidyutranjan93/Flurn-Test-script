import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://pp-web.flurn.in/login");
        System.out.println(driver.getTitle());

        WebElement mobileNoText = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains (@name,'phone')]")));
        mobileNoText.sendKeys("9758966650");

        // Verify if the mobile number is entered correctly
        System.out.println("Entered mobile number:"  +mobileNoText.getAttribute("value"));


        WebElement getOtpBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains (@type,'submit')]")));
        getOtpBtn.click();

        // verify if the submit button is clicked.
        System.out.println(getOtpBtn.getText());


        System.out.println(driver.getTitle());

        WebElement otpInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains (@name,'otp')]")));
        otpInput.sendKeys("565656");

        // Verify if the OTP is entered correctly
        System.out.println("Entered OTP: " + otpInput.getAttribute("value"));


        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Login']")));
        loginBtn.click();


        WebElement parentsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@name,'name')]")));
        parentsBtn.sendKeys("John Goyal");
        System.out.println("Parents/Your Name:" + parentsBtn.getAttribute("value"));

        WebElement emailBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@name,'email')]")));
        emailBtn.sendKeys("abc@example.com");
        System.out.println("Email id:" + emailBtn.getAttribute("value"));


        WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Next']")));
        nextBtn.click();

        System.out.println(driver.getTitle());

        driver.quit();

    }
}
