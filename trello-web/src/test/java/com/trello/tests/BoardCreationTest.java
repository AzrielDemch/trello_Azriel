package com.trello.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase {

@Test
public void testCreationBoard() throws InterruptedException {
    createBoardByLocators("New Table 2");
    isBoardIsCreated();
    Thread.sleep(9000);
}

    public boolean isBoardIsCreated() {
        return isElementInPage(By.cssSelector("[class='board-header-btn board-header-btn-without-icon board-header-btn-text js-add-board-to-team']"));
    }

    public boolean isElementInPage(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void createBoardByLocators(String text) {
        driver.findElement(By.cssSelector("[class='MEu8ZECLGMLeab']")).click();
        driver.findElement(By.cssSelector("[data-test-id='header-boards-menu-create-board']")).click();
        driver.findElement(By.cssSelector("._23NUW98LaZfBpQ")).click();
        driver.findElement(By.cssSelector("._23NUW98LaZfBpQ")).clear();
        driver.findElement(By.cssSelector("._23NUW98LaZfBpQ")).sendKeys(text);
        driver.findElement(By.cssSelector("[style='background-image: url(\"https://images.unsplash.com/photo-1567475443875-1" +
                "" + "c698c245786?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&ixid=eyJhcHBfaWQiOjcwNjZ9\");']")).click();
        driver.findElement(By.cssSelector("[class='_3UeOvlU6B5KUnS uj9Ovoj4USRUQz _2MgouXHqRQDP_5']")).click();
    }

}
