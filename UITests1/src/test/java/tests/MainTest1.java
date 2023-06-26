package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainTest1 {

    private ChromeDriver driver;
    By textInputLocator = By.id("my-text-id");
    By passwordInputLocator = By.xpath("//input[@name = 'my-password']");
    By submitLocator = By.xpath("//button[@type = 'submit']");
    By headerLocator = By.xpath("//h1[@class='display-6']");

    @BeforeEach
    public void startDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
    }

    @Test
    public void baseTest() throws InterruptedException {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.presenceOfElementLocated(headerLocator));

        var textInputElement = driver.findElement(textInputLocator);
        var passwordInputElement = driver.findElement(passwordInputLocator);
        var submitElement = driver.findElement(submitLocator);

        textInputElement.sendKeys("my test!");

        passwordInputElement.sendKeys("myNotCorrectPassword");

        textInputElement.clear();
        passwordInputElement.clear();
        textInputElement.sendKeys("Nex step!");
        passwordInputElement.sendKeys("My valid Password");


        var disabledElement = driver.findElement(By.xpath("//input[@name = 'my-disabled']"));
        Assertions.assertFalse(disabledElement.isEnabled(), "disabled Element is not disabled");


        submitElement.click();

        new WebDriverWait(driver, Duration.ofSeconds(2)).until(ExpectedConditions.textToBe(headerLocator, "Form submitted"));
        Assertions.assertEquals(driver.findElement(headerLocator).getText(), "Form submitted");
    }

    @AfterEach
    public void afterTest() {
        driver.close();
    }
}
