package com.trello.tests.tests;

import com.trello.tests.manager.BoardData;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoardCreationTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> validBoards(){
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[] {"name","descr"});
        list.add(new Object[] {"qa_test","site"});
        list.add(new Object[] {"NAME","DESCR"});
        list.add(new Object[] {"@Test1","7777"});
        list.add(new Object[] {"@Test1"," "});

        return list.iterator();
    }

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
        app.getBoardHelper().fillBoardCreationForm(new BoardData()
                .withBoardName("QA_21")
                .withS("QA_21 Descr"));
        app.getBoardHelper().confirmBoardCreation();
        app.getBoardHelper().returnToHomePage();

        int afterCreation = app.getBoardHelper().getPersonalBoardsCount();

        Assert.assertEquals(afterCreation, beforeCreation + 1);
    }

    @Test(dataProvider = "validBoards")
    public void testBoardCreationWithDataProvider(String boardName,String s) throws InterruptedException {

        BoardData board = new BoardData().withBoardName(boardName).withS(s);

        int beforeCreation = app.getBoardHelper().getPersonalBoardsCount();
        app.getBoardHelper().clickOnPlusButtonOnHeader();
        app.getBoardHelper().selectCreateBoardFromDropDown();
        app.getBoardHelper().fillBoardCreationForm(board);
        app.getBoardHelper().confirmBoardCreation();
        app.getBoardHelper().returnToHomePage();

        int afterCreation = app.getBoardHelper().getPersonalBoardsCount();

        Assert.assertEquals(afterCreation, beforeCreation + 1);
    }


}
