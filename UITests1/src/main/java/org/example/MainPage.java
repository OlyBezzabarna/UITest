package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MainPage {


private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "my-text-id")
    private WebElement textInput;

    @FindBy(xpath = "//input[@name = 'my-password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//h1[@class='display-6']")
    private WebElement header;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='display-6']")));
    }

    public void enterText(String text) {
        textInput.sendKeys(text);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clearFields() {
        textInput.clear();
        passwordInput.clear();
    }

    public void submitForm() {
        submitButton.click();
        wait.until(ExpectedConditions.textToBePresentInElement(header, "Form submitted"));
    }

    public String getHeaderText() {
        return header.getText();
    }

    public boolean isDisabledElementEnabled() {
        WebElement disabledElement = driver.findElement(By.xpath("//input[@name = 'my-disabled']"));
        return disabledElement.isEnabled();
    }


}

