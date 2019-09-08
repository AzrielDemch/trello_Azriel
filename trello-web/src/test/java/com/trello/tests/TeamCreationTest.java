package com.trello.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TeamCreationTest extends TestBase {

    @Test
    public void testTeamCreationFromPlusButtonOnHeader() throws InterruptedException {
        int before = getTeamsCount();
        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        String teamName = "qa21";
        fillTeamCreationForm(teamName,"QA_Testing");
        clickContinueButton();
        String createdTeamName = getTeamNameFromTeamPage();
        returnToHomePage();
        int after = getTeamsCount();
        Assert.assertEquals(after,before+1);
        Assert.assertEquals(createdTeamName.toLowerCase(),teamName.toLowerCase());

        // Assert.assertTrue(isUserLoggedIn());
    }

    @Test(enabled = false)
    public void testTeamCreationFromLeftMenu() throws InterruptedException {
        int before = getTeamsCount();
        click(By.cssSelector(".icon-add icon-sm OiX3P2i2J92Xat"));
        String teamName = "qa21";
        fillTeamCreationForm(teamName,"QA_Testing");
        clickContinueButton();
        String createdTeamName = getTeamNameFromTeamPage();

        returnToHomePage();

        int after = getTeamsCount();
        Assert.assertEquals(after,before+1);
        Assert.assertEquals(createdTeamName.toLowerCase(),teamName.toLowerCase());
    }


    @Test(enabled=false)
    public void testTeamCuncellCreationFromPlusButtonOnHeader() throws InterruptedException{
        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        String teamName = "qa21";
        fillTeamCreationForm(teamName,"QA_Testing");
        clickXButton();
}


}
