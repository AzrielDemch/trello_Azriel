package com.trello.tests.tests;

import com.trello.tests.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase {

        @BeforeClass
        public void ensurePreconditionLogin(){
        if(!byPlusButton()){
            app.getSessionHelper().login("bendercom111@gmail.com", "1S234567");
        }
    }

        public boolean byPlusButton() {
        return app.getBoardHelper().isElementPresent(By.cssSelector("[data-test-id='home-navigation-create-team-button']"));
    }

        @BeforeMethod
        public void isOnHomePage(){
        if(!byTeamsCount()){
           app.getBoardHelper().returnToHomePage();
        }
   }

        public boolean byTeamsCount() {
        return app.getBoardHelper().isElementPresent(By.xpath("//div[@class='_2zEdWKjwDvxZHR dG8NJxS20S4HJ2']/../..//li"));
    }

    @Test
    public void testBoardCreation() throws InterruptedException {
        int beforeCreation = app.getBoardHelper().getPersonalBoardsCount();
        app.getBoardHelper().clickOnPlusButtonOnHeader();
        app.getBoardHelper().selectCreateBoardFromDropDown();
        app.getBoardHelper().fillBoardCreationForm("qa21", "descr qa 21");
        app.getBoardHelper().confirmBoardCreation();
        app.getBoardHelper().returnToHomePage();

        int afterCreation = app.getBoardHelper().getPersonalBoardsCount();

        Assert.assertEquals(afterCreation, beforeCreation + 1);
    }



}
