package com.trello.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDeleteBoards extends TestBase {

    @Test
    public void deleteBoardsFromPage() throws InterruptedException {
        int countBefore = app.getBoardHelper().getPersonalBoardsCount();
        while(countBefore != 3) {
            app.getBoardHelper().getBoardsForDelete();
            app.getBoardHelper().clickOnButtonShowMenu();
            app.getBoardHelper().clickOnCloseBoardButton();
            app.getBoardHelper().clickOnCloseButton();
            app.getBoardHelper().returnToHomePage();

            countBefore = app.getBoardHelper().getPersonalBoardsCount();
        }

        int counterAfter = app.getBoardHelper().getPersonalBoardsCount();
        Assert.assertEquals(counterAfter,countBefore);
    }


}
