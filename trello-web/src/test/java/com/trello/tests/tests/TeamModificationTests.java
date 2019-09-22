package com.trello.tests.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamModificationTests extends TestBase {

    @Test
    public void modificationOldTeaM() throws InterruptedException {

    app.getTeamHelper().clickOnFirstTeam();
    app.getTeamHelper().clickOnSettingsButton2();
    app.getTeamHelper().editProfileButton();
    app.getTeamHelper().changeTeamProfile("team","new team for test");
    app.getTeamHelper().clickOnButtonSave();

    String name = "team";
    Thread.sleep(5000);
    Assert.assertEquals(name.toLowerCase(),app.getTeamHelper().getTeamNameFromTeamPage());

    }

}
