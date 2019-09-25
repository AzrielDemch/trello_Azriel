package com.trello.tests.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {

    WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElementAndClick(By locator, int time){
        new WebDriverWait(driver,time).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;
    }

    public void clickXButton() {

    }

    public void clickOnPlusButtonOnLeftNavMenu() {
        click(By.cssSelector(".icon-add.icon-sm"));
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text){
        if(text != null){
            driver.findElement(locator).click();
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void clickOnPlusButtonOnHeader() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
    }

    public void returnToHomePage() {
        if (isElementPresent(By.cssSelector("._2ZNy4w8Nfa58d1._2ZNy4w8Nfa58d1._1WD42rQsKIT-I6"))) {
            new WebDriverWait(driver, 20)
                    .until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector("._2ZNy4w8Nfa58d1._2ZNy4w8Nfa58d1._1WD42rQsKIT-I6"))));
            click(By.cssSelector("a[href='/']"));
            click(By.cssSelector("a[href='/']"));
        } else
            waitForElementAndClick(By.cssSelector("a[href='/']"), 15);

    }

}
