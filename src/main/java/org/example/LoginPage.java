package org.example;

import org.example.SauceDemoLocators;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginProcess(String user, String pass) {
        type(SauceDemoLocators.USERNAME_FIELD, user);
        type(SauceDemoLocators.PASSWORD_FIELD, pass);
        click(SauceDemoLocators.LOGIN_BUTTON);
    }

    public String getErrorText() {
        return getText(SauceDemoLocators.ERROR_MESSAGE);
    }

    public String getProductImage() {
        return waitForVisible(SauceDemoLocators.FIRST_IMAGE).getAttribute("src");
    }

    public boolean isInventoryVisible() {
        return waitForVisible(SauceDemoLocators.INVENTORY_LIST).isDisplayed();
    }
}