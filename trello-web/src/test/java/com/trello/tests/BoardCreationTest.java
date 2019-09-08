package com.trello.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase {

@Test
public void testCreationBoard() throws InterruptedException {
    int before = boardsCount();
    clickOnBoardsButton();
    createNewBoardButton();
    addBoardTitleField();
    clearField();
    String boardName = "New Table 2";
    typeTextInField(boardName);
    choosePictureForNewBoard();
    createNewBoardButton_2();
  //  isBoardIsCreated();
    returnToHomePage();
    int after = boardsCount();
    Assert.assertEquals(after,before+1);
}

    private int boardsCount() {
      return driver.findElements(By.xpath("//ul[@class='boards-page-board-section-list']//li")).size();
    }

  /*  public boolean isBoardIsCreated() {
        return isElementInPage(By.cssSelector("[class='board-header-btn board-header-btn-without-icon board-header-btn-text js-add-board-to-team']"));
    }

    public boolean isElementInPage(By locator) {
        return isElementPresent(locator);
    } */


}
