import org.example.ResultPage;
import org.example.SearchPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestPage {
    private WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.bing.com");
    }

    @Test
    public void testBingSearch() {
        // 1. Buat objek dari kelas search page
        SearchPage searchPage = new SearchPage(driver);

        // 2. Akses elemen (isi search bar)
        searchPage.setSearch_bar("TRPL UGM");

        // 3. Submit dan pindah ke ResultPage
        ResultPage resultPage = searchPage.submitSearch();

        // 4. Assertion (memastikan title mengandung kata yang dicari)
        String title = resultPage.getPageTitle();
        System.out.println("Page Title: " + title);
        Assertions.assertTrue(title.contains("TRPL UGM"));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}