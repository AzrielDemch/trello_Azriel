package com.trello.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDeleteTeams extends TestBase {

    @Test
    public void deleteTeamsFromPage() throws InterruptedException {

        int countBefore = app.getTeamHelper().getTeamsCount();

        while(countBefore != 3){
            app.getTeamHelper().clickOnSettingsButton();
            app.getTeamHelper().clickOnDeleteButtonTeam();
            app.getTeamHelper().clickOnDeleteForeverButton();

            countBefore = app.getTeamHelper().getTeamsCount();
        }
        int countAfter = app.getTeamHelper().getTeamsCount();
        Assert.assertEquals(countAfter,countBefore);
    }

}
