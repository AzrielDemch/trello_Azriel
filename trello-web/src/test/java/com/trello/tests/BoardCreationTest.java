package com.trello.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTest extends  TestBase {

        @BeforeClass
        public void ensurePreconditionLogin(){
        if(!byPlusButton()){
            login("bendercom111@gmail.com", "1S234567");
        }
    }

        public boolean byPlusButton() {
        return isElementPresent(By.cssSelector("[data-test-id='home-navigation-create-team-button']"));
    }

        @BeforeMethod
        public void isOnHomePage(){
        if(!byTeamsCount()){
           returnToHomePage();
        }
   }

        public boolean byTeamsCount() {
        return isElementPresent(By.xpath("//div[@class='_2zEdWKjwDvxZHR dG8NJxS20S4HJ2']/../..//li"));
    }

    @Test
    public void testBoardCreation() throws InterruptedException {
        int beforeCreation = getPersonalBoardsCount();
        clickOnPlusButtonOnHeader();
        selectCreateBoardFromDropDown();
        fillBoardCreationForm("qa21", "descr qa 21");
        confirmBoardCreation();
        returnToHomePage();

        int afterCreation = getPersonalBoardsCount();

        Assert.assertEquals(afterCreation, beforeCreation + 1);
    }



}
