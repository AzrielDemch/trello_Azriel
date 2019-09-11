package com.trello.tests;

import com.trello.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDeleteBoards extends TestBase {

    @Test
    public void deleteBoardsFromPage() throws InterruptedException {
        int countBefore = getPersonalBoardsCount();
        while(countBefore != 3) {
            getBoardsForDelete();
            clickOnButtonShowMenu();
            clickOnCloseBoardButton();
            clickOnCloseButton();
            returnToHomePage();

            countBefore = getPersonalBoardsCount();
        }

        int counterAfter = getPersonalBoardsCount();
        Assert.assertEquals(counterAfter,countBefore);
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

    private void getBoardsForDelete() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }


}
