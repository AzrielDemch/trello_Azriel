package com.trello.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        openSite("https://trello.com");
        login("bendercom111@gmail.com","1S234567");

    }

    public void login(String email, String password) {
        click(By.cssSelector("[href='/login']"));
        type(By.cssSelector("[type=email]"),email);
        type(By.cssSelector("[type=password]"),password);
        click(By.id("login"));
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public void openSite(String url) {
        driver.get(url);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public void createNewBoardButton_2() {
        click(By.cssSelector("[type='button']"));
    }

    public void choosePictureForNewBoard() {
        driver.findElement(By.cssSelector("[style='background-image: url(\"https://images.unsplash.com/photo-1567788150222-c580695fa1d7?ixlib=rb-1.2" +
                ".1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&ixid=eyJhcHBfaWQiOjcwNjZ9\");']")).click();
    }

    public void typeTextInField(String text) {
        driver.findElement(By.cssSelector("._23NUW98LaZfBpQ")).sendKeys(text);
    }

    public void clearField() {
        driver.findElement(By.cssSelector("._23NUW98LaZfBpQ")).clear();
    }

    public void addBoardTitleField() {
        driver.findElement(By.cssSelector("._23NUW98LaZfBpQ")).click();
    }

    public void createNewBoardButton() {
        driver.findElement(By.cssSelector("[data-test-id='header-boards-menu-create-board']")).click();
    }

    public void clickOnBoardsButton() {
        driver.findElement(By.cssSelector("[class='MEu8ZECLGMLeab']")).click();
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.name("board"));
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void clickContinueButton() {
        click(By.cssSelector("[type='submit']"));
    }

    public void fillTeamCreationForm(String teamName, String description) {
        driver.findElement(By.cssSelector("[data-test-id='header-create-team-name-input']")).click();
        driver.findElement(By.cssSelector("[data-test-id='header-create-team-name-input']")).clear();
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"),teamName);
        driver.findElement(By.cssSelector("textarea")).click();
        driver.findElement(By.cssSelector("textarea")).clear();
        type(By.cssSelector("textarea"),description);
    }

    public void selectCreateTeamFromDropDown() {
        click(By.cssSelector("[data-test-id='header-create-team-button']"));
    }

    public void clickOnPlusButtonOnHeader() {
        click(By.cssSelector("[data-test-id='header-create-menu-button']"));
    }

    public String getTeamNameFromTeamPage() {
        return driver.findElement(By.cssSelector("h1")).getText();
    }

    public void returnToHomePage() throws InterruptedException {
        click(By.cssSelector("[href='/']"));
        click(By.cssSelector("[href='/']"));
        Thread.sleep(7000);
    }

    public int getTeamsCount(){
        return driver.findElements(By.xpath("//div[@class='_mtkwfAlvk6O3f']/../../..//li")).size();
    }

    public void clickXButton() {

    }
}
