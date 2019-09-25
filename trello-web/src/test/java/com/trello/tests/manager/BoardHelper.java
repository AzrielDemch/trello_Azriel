package com.trello.tests.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardHelper extends HelperBase{
    public BoardHelper(WebDriver driver) {
        super(driver);
    }

    public void fillBoardCreationForm(BoardData board) {
        type(By.cssSelector("[data-test-id='header-create-board-title-input']"), board.getBoardName());

        if(isElementPresent(By.cssSelector(".W6rMLOx8U0MrPx"))){
            click(By.cssSelector(".W6rMLOx8U0MrPx"));
            click(By.xpath("//nav[@class='SdlcRrTVPA8Y3K']//li[1]"));//no team
        }

    }

    public void selectCreateBoardFromDropDown() {
        click(By.cssSelector("[data-test-id='header-create-board-button']"));
    }

    public void confirmBoardCreation() {
        click(By.cssSelector("[data-test-id='header-create-board-submit-button']"));
    }

    public int getPersonalBoardsCount() {
        new WebDriverWait(driver,20)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")));
        return driver.findElements(By.xpath("//*[@class='icon-lg icon-member']/../../..//li")).size()-1;
    }

    public void clickOnCloseButton() {
        click(By.cssSelector("[class='js-confirm full negate']"));
    }

    public void clickOnCloseBoardButton() {
        click(By.cssSelector("[class='board-menu-navigation-item-link js-close-board']"));
    }

    public void clickOnButtonShowMenu() {
        if(!isElementPresent(By.cssSelector("[class='board-header-btn mod-show-menu js-show-sidebar']"))) {
            click(By.cssSelector("[class='board-header-btn mod-show-menu js-show-sidebar']"));
            click(By.cssSelector("[class='board-menu-navigation-item-link js-open-more']"));
        } else{ click(By.cssSelector("[class='board-menu-navigation-item-link js-open-more']")); }
    }

    public void getBoardsForDelete() {
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }

    public void getFirsTBoard(){
        click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
    }

    public void nameBoardField(String name) {
        clear(By.xpath("[class='board-name-input js-board-name-input']"));
    }

    public void clear(By locator) {
        driver.findElement(locator).clear();
    }

    public void createInvite(String email,String description){
        click(By.cssSelector("[title^='Invite To Board']"));
        type(By.cssSelector(".autocomplete-input"),email);
        click(By.cssSelector("[class='invitation-message-input js-invitation-message']"));
        clear(By.cssSelector("[class='invitation-message-input js-invitation-message']"));
        type(By.cssSelector("[class='invitation-message-input js-invitation-message']"),description);
        click(By.cssSelector("[class='autocomplete-btn primary']"));
    }

    public void createNewListInBoard(String name){
        click(By.cssSelector("[class='placeholder']"));
        type(By.cssSelector("[class='list-name-input']"),name);
        click(By.cssSelector("[class='primary mod-list-add-button js-save-edit']"));
    }

    public void changeBackGround(){
        if(!isElementPresent(By.cssSelector("[class='board-menu-navigation-item-link js-change-background']"))){
            click(By.cssSelector("[class='icon-sm icon-overflow-menu-horizontal board-header-btn-icon']"));
            click(By.cssSelector("[class='board-menu-navigation-item-link js-change-background']"));
        }else{
            click(By.cssSelector("[class='board-menu-navigation-item-link js-change-background']"));
            click(By.xpath("//div[@class='board-backgrounds-section-tiles u-clearfix']//div//div[1]"));
            click(By.xpath("//div[@class='photo-attribution-component large']"));
        }
    }

    public void changeBoardName(String newName) {
        driver.findElement(By.cssSelector(".js-rename-board")).click();
        driver.findElement(By.cssSelector("input.js-board-name-input")).sendKeys(newName);
    }

    public boolean getBoardNameFromPage(String newName){
        return driver.findElement(By.cssSelector("[class='js-board-editing-target board-header-btn-text']")).getText().equals(newName);
    }

    public boolean isBoardPresent() {
        return getPersonalBoardsCount() > 0;
    }

    public void createNewBoard() {
        clickOnPlusButtonOnHeader();
        selectCreateBoardFromDropDown();
        fillBoardCreationForm(new BoardData()
                .withBoardName("QA_21")
                .withS("QA_21 Descr"));
        confirmBoardCreation();
        returnToHomePage();
    }
}
