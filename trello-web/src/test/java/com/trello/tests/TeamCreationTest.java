package com.trello.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TeamCreationTest extends TestBase {

    @Test
    public void testTeamCreation(){
        isUserLoggedIn();
    }

    public boolean isUserLoggedIn() {
        return isElementPresent(By.name("board"));
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }
}
