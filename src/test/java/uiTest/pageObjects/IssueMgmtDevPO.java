package uiTest.pageObjects;

import org.openqa.selenium.By;
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

    @FindBy(xpath = "//div[@id='edit-comment']//button[@name = 'Save']")
    public WebElement saveBtn;

    public void clickSaveBtn(){
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
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
//        int frameCount = getDriver().findElements(By.tagName("iframe")).size();
//        getDriver().switchTo().frame(getDriver().findElement(By.tagName("iframe")));
//        WebElement paragraphElement = getDriver().findElement(By.tagName("p"));
//
//        // Get the current text of the <p> element
//        String currentText = paragraphElement.getText();
//        System.out.println("Current text of <p>: " + currentText);
//
//        String newText = currentText + message;
//        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].innerText = arguments[1];", paragraphElement, newText);
//
//        try{
//            Thread.sleep(2000);
//        } catch (InterruptedException e){
//            e.printStackTrace();
//        }
//
//        String updatedText = paragraphElement.getText();
//        System.out.println("Updated text of <p>: " + updatedText);
//        getDriver().switchTo().defaultContent();


        getDriver().findElement(By.xpath("//div[@id = \"comment-wiki-edit\"]/textarea")).sendKeys(message);
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