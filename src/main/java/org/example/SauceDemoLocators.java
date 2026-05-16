package org.example;

import org.openqa.selenium.By;

public class SauceDemoLocators {
    // Login Page
    public static final By USERNAME_FIELD = By.id("user-name");
    public static final By PASSWORD_FIELD = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test='error']");

    // Inventory Page
    public static final By INVENTORY_LIST = By.className("inventory_list");
    public static final By FIRST_IMAGE = By.cssSelector(".inventory_item_img img");
}