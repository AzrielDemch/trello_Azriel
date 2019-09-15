package com.trello.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDeleteTeams extends TestBase {

    @Test
    public void deleteTeamsFromPage() throws InterruptedException {

        int countBefore = app.getTeamsCount();

        while(countBefore != 3){
            app.clickOnSettingsButton();
            app.clickOnDeleteButtonTeam();
            app.clickOnDeleteForeverButton();

            countBefore = app.getTeamsCount();
        }
        int countAfter = app.getTeamsCount();
        Assert.assertEquals(countAfter,countBefore);
    }

}
