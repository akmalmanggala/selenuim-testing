package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    private By search_bar = new By.ById("sb_form_q");
    private By form = new By.ById("sb_form");
    private WebDriver driver;

    public SearchPage(WebDriver driver){this.driver = driver;}

    public void setSearch_bar(String query)
    {
        driver.findElement(search_bar).sendKeys(query);
    }

    public ResultPage submitSearch(){
        driver.findElement(form).submit();
        return new ResultPage(driver);
    }
}
