package com.trello.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDeleteTeams extends TestBase {

    @Test
    public void deleteTeamsFromPage() throws InterruptedException {

        int countBefore = getTeamsCount();

        while(countBefore != 3){
            clickOnSettingsButton();
            clickOnDeleteButtonTeam();
            clickOnDeleteForeverButton();

            countBefore = getTeamsCount();
        }
        int countAfter = getTeamsCount();
        Assert.assertEquals(countAfter,countBefore);
    }

    public void clickOnDeleteForeverButton() {
        click(By.cssSelector("[value='Delete Forever']"));
    }

    public void clickOnDeleteButtonTeam() {
        click(By.cssSelector(".quiet-button"));
    }

    public void clickOnSettingsButton() {
        click(By.cssSelector("[class='icon-sm icon-gear boards-page-board-section-header-options-item-icon']"));
    }

}
