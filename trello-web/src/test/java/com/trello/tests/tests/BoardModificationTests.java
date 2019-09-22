package com.trello.tests.tests;

import org.testng.annotations.Test;

public class BoardModificationTests extends TestBase {

    @Test
    public void modifyOldBoard() {

     app.getBoardHelper().getFirsTBoard();
     // app.getBoardHelper().nameBoardField("New Board");
     app.getBoardHelper().createInvite("bendercom111@gmail.com","Test Site QA");
     app.getBoardHelper().changeBackGround();
     app.getBoardHelper().createNewListInBoard("New List");
     app.getBoardHelper().returnToHomePage();

    }

}
