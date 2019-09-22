package com.trello.tests.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver driver;
    BoardHelper boardHelper;
    TeamHelper teamHelper;
    SessionHelper sessionHelper;
    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if(browser.equals(BrowserType.CHROME)){
            driver = new ChromeDriver();
        }if(browser.equals(BrowserType.FIREFOX)){
            driver = new FirefoxDriver();
        }


        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        boardHelper = new BoardHelper(driver);
        teamHelper = new TeamHelper(driver);
        sessionHelper = new SessionHelper(driver);


        sessionHelper.openSite("https://trello.com");
        sessionHelper.login("bendercom111@gmail.com", "1S234567");
    }

    public void stop() {
        driver.quit();
    }

    public BoardHelper getBoardHelper() {
        return boardHelper;
    }

    public TeamHelper getTeamHelper() {
        return teamHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}
