package tests;


import org.example.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MainTest  {



        private ChromeDriver driver;
        private MainPage mainPage;

        @BeforeEach
        public void startDriver() {
            System.setProperty("webdriver.chrome.driver", "/Users/Olya/Downloads/chromedriver_mac64/chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

            mainPage = new MainPage(driver);
        }

        @Test
        public void baseTest() {
            mainPage.openPage();

            mainPage.enterText("my test!");

            mainPage.enterPassword("myNotCorrectPassword");

            mainPage.clearFields();
            mainPage.enterText("Next step!");
            mainPage.enterPassword("My valid Password");

            assertFalse(mainPage.isDisabledElementEnabled(), "Disabled element is not disabled");

            mainPage.submitForm();

            assertEquals("Form submitted", mainPage.getHeaderText());
        }

        @AfterEach
        public void afterTest() {
            driver.close();
        }
    }

