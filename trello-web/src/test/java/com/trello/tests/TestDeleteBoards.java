package com.trello.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDeleteBoards extends TestBase {

    @Test
    public void deleteBoardsFromPage() throws InterruptedException {
        int countBefore = app.getPersonalBoardsCount();
        while(countBefore != 3) {
            app.getBoardsForDelete();
            app.clickOnButtonShowMenu();
            app.clickOnCloseBoardButton();
            app.clickOnCloseButton();
            app.returnToHomePage();

            countBefore = app.getPersonalBoardsCount();
        }

        int counterAfter = app.getPersonalBoardsCount();
        Assert.assertEquals(counterAfter,countBefore);
    }


}
