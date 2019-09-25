package com.trello.tests.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase {
    @BeforeMethod
    public void preconditions(){
        if(!app.getBoardHelper().isBoardPresent()){
            app.getBoardHelper().createNewBoard();
        }
    }

    @Test
    public void modifyOldBoard() {

     app.getBoardHelper().getFirsTBoard();
     String name = "New Board_1";
     app.getBoardHelper().changeBoardName(name);
     app.getBoardHelper().createInvite("bendercom111@gmail.com","Test Site QA");
     app.getBoardHelper().changeBackGround();
     app.getBoardHelper().createNewListInBoard("New List");

     Assert.assertTrue(app.getBoardHelper().getBoardNameFromPage(name));


    }

}
