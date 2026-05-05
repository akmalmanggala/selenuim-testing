import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class saucedemoLoginTest {
    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void loginStepByStepTest() {
        WebElement logoContainer = driver.findElement(By.tagName("div"));
        assertTrue(logoContainer.getText().contains("Swag Labs"), "Teks 'Swag Labs' tidak ditemukan di elemen div");

        WebElement usernameField = driver.findElement(By.name("user-name"));
        assertTrue(usernameField.isDisplayed(), "Field username tidak ditemukan");

        usernameField.clear();

        usernameField.sendKeys("standard_user");

        WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
        assertTrue(passwordField.isDisplayed(), "Field password tidak ditemukan");

        passwordField.clear();

        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.className("submit-button"));
        assertTrue(loginButton.isDisplayed(), "Tombol login tidak ditemukan");

        loginButton.click();
    }
}