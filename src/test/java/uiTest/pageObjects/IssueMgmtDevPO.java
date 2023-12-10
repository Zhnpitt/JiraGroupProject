package uiTest.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IssueMgmtDevPO extends BasePO{
    @FindBy(id = "gadget-10002-title")
    public WebElement assignToMe;

    @FindBy(xpath = "(//a[normalize-space()='task1 by John'])[1]")
    public WebElement assignedTask;

    @FindBy(css = "a[id='comment-issue'] span[class='trigger-label']")
    public WebElement addComments;

    @FindBy(id = "comment")
    public WebElement commentArea;
    @FindBy(id = "comment-add-submit")
    public WebElement addBtn;

    @FindBy(xpath = "(//textarea[@id='comment'])[2]")
    public WebElement editCommentArea;
    @FindBy(xpath = "(//p[normalize-space()='message from Adam'])[1]")
    public WebElement addedComment;
    @FindBy(className = "edit-comment")
    public WebElement firstEditBtn;

    @FindBy(xpath = "(//p[normalize-space()='message from Adam'])[1]")
    public WebElement commentAreaToEdit;

    @FindBy(className = "update-info")
    public WebElement editedSign;

    @FindBy(id = "comment-edit-submit")
    public WebElement saveBtn;

    public void clickSaveBtn(){
        saveBtn.click();
    }

    public void sendToCommentAreaToEdit(String newMsg){
        commentAreaToEdit.sendKeys(newMsg);
    }
    public void clickFirstEditBtn(){
        firstEditBtn.click();
    }
    public void clickAddBtn(){
        addBtn.click();
    }
    public void leaveMessageInCommentArea(String message){
//        getDriver().switchTo().frame(0);
        commentArea.sendKeys(message);
//        getDriver().switchTo().defaultContent();
    }

    public void editMessageInCommentArea(String message){
//        getDriver().switchTo().frame(0);
        editCommentArea.sendKeys(message);
//        getDriver().switchTo().defaultContent();
    }
    public void clickAddComments(){
        addComments.click();
    }

    public void clickAssignedTask(){
        assignedTask.click();
    }
    public void clickAssignToMe(){
        assignToMe.click();
    }
}
