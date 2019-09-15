package com.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver driver;

    public void init() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        openSite("https://trello.com");
        login("bendercom111@gmail.com", "1S234567");
    }

    public void login(String email, String password) {
        click(By.cssSelector("[href='/login']"));
        type(By.cssSelector("[type=email]"), email);
        type(By.cssSelector("[type=password]"),password);
        click(By.id("login"));
    }

    public void waitForElementAndClick(By locator, int time){
        new WebDriverWait(driver,time).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text){
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void openSite(String url) {
        driver.get(url);
    }

    public void stop() {
        driver.quit();
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size()>0;
    }

    public void clickContinueButton() {
        click(By.cssSelector("[type=submit]"));
    }

    public void fillTeamCreationForm(String teamName, String description) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamName);
        type(By.cssSelector("textarea"), description);
    }

    public void selectCreateTeamFromDropDown() {
        click(By.cssSelector("[data-test-id='header-create-team-button']"));
    }

    public void clickOnPlusButtonOnHeader() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
    }

    public void fillBoardCreationForm(String boardName, String s) {
        type(By.cssSelector("[data-test-id='header-create-board-title-input']"), boardName);

        if(isElementPresent(By.cssSelector(".W6rMLOx8U0MrPx"))){
            click(By.cssSelector(".W6rMLOx8U0MrPx"));
            click(By.xpath("//nav[@class='SdlcRrTVPA8Y3K']//li[1]"));//no team
        }

    }

    public void selectCreateBoardFromDropDown() {
        click(By.cssSelector("[data-test-id='header-create-board-button']"));
    }

    public void confirmBoardCreation() {
        click(By.cssSelector("[data-test-id='header-create-board-submit-button']"));
    }

    protected String getTeamNameFromTeamPage() {
        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));
        return driver.findElement(By.cssSelector("h1")).getText();
    }

    public void returnToHomePage() {
        if(isElementPresent(By.cssSelector("._3gUubwRZDWaOF0._2WhIqhRFBTG7Ry._2NubQcQM83YCVV"))){
            new WebDriverWait(driver, 15)
                    .until(ExpectedConditions.stalenessOf(driver.findElement(By.cssSelector("._3gUubwRZDWaOF0._2WhIqhRFBTG7Ry._2NubQcQM83YCVV"))));
            click(By.cssSelector("[aria-label='Back to Home']"));
            click(By.cssSelector("[aria-label='Back to Home']"));
        } else {
            waitForElementAndClick(By.cssSelector("[aria-label='Back to Home']"),15); }
    }

    public int getTeamsCount()  {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li")));
        return driver.findElements(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li")).size();
    }

    public void clickXButton() {

    }

    public int getPersonalBoardsCount() {
        new WebDriverWait(driver,10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")));
        return driver.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
    }

    public void clickOnDeleteForeverButton() {
        click(By.cssSelector("[value='Delete Forever']"));
    }

    public void clickOnDeleteButtonTeam() {
        click(By.cssSelector(".quiet-button"));
    }

    public void clickOnSettingsButton() {
        click(By.cssSelector("[class='icon-sm icon-gear boards-page-board-section-header-options-item-icon']"));
    }

    public void clickOnCloseButton() {
        click(By.cssSelector("[class='js-confirm full negate']"));
    }

    public void clickOnCloseBoardButton() {
        click(By.cssSelector("[class='board-menu-navigation-item-link js-close-board']"));
    }

    public void clickOnButtonShowMenu() {
        if(!isElementPresent(By.cssSelector("[class='board-header-btn mod-show-menu js-show-sidebar']"))) {
            click(By.cssSelector("[class='board-header-btn mod-show-menu js-show-sidebar']"));
            click(By.cssSelector("[class='board-menu-navigation-item-link js-open-more']"));
        } else{ click(By.cssSelector("[class='board-menu-navigation-item-link js-open-more']")); }
    }

    protected void getBoardsForDelete() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }
}
