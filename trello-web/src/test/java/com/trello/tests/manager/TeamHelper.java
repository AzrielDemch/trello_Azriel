package com.trello.tests.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TeamHelper extends HelperBase {


    public TeamHelper(WebDriver driver) {
        super(driver);
    }

    public void clickContinueButton() {
        click(By.cssSelector("[type=submit]"));
    }

    public void fillTeamCreationForm(String teamName, String description) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamName);
        type(By.cssSelector("textarea"), description);
    }

    public void selectCreateTeamFromDropDown() {
        click(By.cssSelector("[data-test-id='header-create-team-button']"));
    }

    public String getTeamNameFromTeamPage() {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));
        return driver.findElement(By.cssSelector("h1")).getText();
    }

    public int getTeamsCount() throws InterruptedException {
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.presenceOfElementLocated(
                      By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li")));
        return driver.findElements(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li")).size();
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

    public boolean isTherePersonalBoards() {
        return isElementPresent(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
    }

    public void clickOnFirstTeam(){
        click(By.cssSelector("[data-test-id='home-team-tab-name']"));
    }

    public void clickOnSettingsButton2(){
        click(By.cssSelector("[class='_8N7ns-Iq6PpYlR _12muajD2WZ10TN _1KB3N96c5qvO4O _26_qDzDbk54XV4 _3Yj9q2I4BGFx4r']"));
    }

    public void editProfileButton(){
        click(By.cssSelector("[class='button-link tabbed-pane-header-details-edit js-edit-profile']"));
    }

    public void changeTeamProfile(String name,String description){
        type(By.cssSelector("[name='displayName']"),name);
        type(By.cssSelector("[name='desc']"),description);
    }

    public void clickOnButtonSave(){
        click(By.cssSelector("[type='submit']"));
    }

}
