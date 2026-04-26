import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchTest {
    WebDriver driver;

    @BeforeMethod
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.bing.com/");
    }

    @Test
    void searchTest() {
        WebElement search_bar = driver.findElement(By.id("sb_form_q"));
        search_bar.sendKeys("akmal");

        WebElement search_form = driver.findElement(By.id("sb_form"));
        search_form.submit();

        String title = driver.getTitle();
        String text = "akmal";

        assertTrue(title.contains(text), "Title tidak mengandung kata kunci!");
    }

    @AfterMethod
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}