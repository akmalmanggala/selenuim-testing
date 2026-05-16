import org.example.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTestPOM {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        // Inisialisasi objek halaman
        loginPage = new LoginPage(driver);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void standardUserTest() {
        loginPage.loginProcess("standard_user", "secret_sauce");
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Test
    void lockedOutTest() {
        loginPage.loginProcess("locked_out_user", "secret_sauce");
        assertTrue(loginPage.getErrorText().contains("Sorry, this user has been locked out."));
    }

    @Test
    void problemUserTest() {
        loginPage.loginProcess("problem_user", "secret_sauce");
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());

        String imageSrc = loginPage.getProductImage();
        assertTrue(imageSrc != null && imageSrc.contains("sl-404"));
    }

    @Test
    void performanceGlitchUserTest() {
        loginPage.loginProcess("performance_glitch_user", "secret_sauce");

        // Memanggil wait for URL yang sudah ada di BasePage
        loginPage.waitForUrl("https://www.saucedemo.com/inventory.html");

        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Test
    void errorUserTest() {
        loginPage.loginProcess("error_user", "secret_sauce");
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @Test
    void visualUserTest() {
        loginPage.loginProcess("visual_user", "secret_sauce");
        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        assertTrue(loginPage.isInventoryVisible());
    }
}