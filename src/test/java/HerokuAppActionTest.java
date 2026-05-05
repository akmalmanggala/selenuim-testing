import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HerokuAppActionTest {
    WebDriver driver;
    Actions action;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        action = new Actions(driver);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void testHover() {
        driver.get("https://the-internet.herokuapp.com/hovers");

        WebElement firstImage = driver.findElement(By.xpath("(//img[@alt='User Avatar'])[1]"));

        action.moveToElement(firstImage).perform();

        WebElement caption = driver.findElement(By.xpath("(//h5[normalize-space()='name: user1'])[1]"));
        assertEquals("name: user1", caption.getText(), "Nama user tidak sesuai setelah hover!");
    }

    @Test
    void testKeyPresses() {
        driver.get("https://the-internet.herokuapp.com/key_presses");

        WebElement inputField = driver.findElement(By.id("target"));

        action.sendKeys(inputField, Keys.SHIFT).perform();

        WebElement resultText = driver.findElement(By.id("result"));
        assertEquals("You entered: SHIFT", resultText.getText());
    }

    @Test
    void testDragAndDrop() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement boxA = driver.findElement(By.id("column-a"));
        WebElement boxB = driver.findElement(By.id("column-b"));

        action.dragAndDrop(boxA, boxB).perform();

        assertEquals("A", boxB.getText(), "Box B seharusnya berisi teks 'A' setelah di-drag");
    }
}