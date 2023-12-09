package uiTest.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TeamLeadPO extends BasePO{
    @FindBy(xpath = "//a[@id='browse_link']")
    public WebElement projectButton;

    @FindBy(xpath = "//div[@id='project_current']//a")
    public WebElement currentProject;

    @FindBy(xpath = "//button[normalize-space()='Create sprint']")
    public WebElement createSprintButton;

    @FindBy(xpath = "//input[@id='ghx-sprint-name']")
    public WebElement sprintNameInput;

    @FindBy(xpath = "//button[normalize-space()='Create']")
    public WebElement submitSprintButton;

    @FindBy(xpath = "//div[@class='iic-trigger']//button[@type='button']")
    public WebElement createIssueButton;
    //div[@class='iic-trigger']//button[@type='button']

    @FindBy(xpath = "//button[normalize-space()='Open in dialog']")
    public WebElement openInDialogButton;

    @FindBy(css = "#issuetype-field")
    public WebElement issueTypeBox;
    //#issuetype-field

    @FindBy(xpath = "//ul[@class='aui-last']/li")
    public WebElement epicOption;
    //a[normalize-space()='Epic'])[1]


    @FindBy(xpath = "//input[@id='customfield_10104']")
    public WebElement epicNameInput;

    @FindBy(xpath = "//input[@id='summary']")
    public WebElement epicSumInput;

    @FindBy(xpath = "//input[@id='create-issue-submit']")
    public WebElement createIssueSubmitButton;


    public void clickProjectButton(){
        projectButton.click();
    }
    public void chooseCurrentProject(){
        currentProject.click();
    }
    public void clickCreateSprintButton(){
        createSprintButton.click();
    }
    public void setSprintName(String name){
        sprintNameInput.sendKeys(name);
    }
    public void subMitSprint(){
        submitSprintButton.click();
    }


    public void createIssue(){
        createIssueButton.click();
        openInDialogButton.click();
    }
    public void selectEpic(){
        issueTypeBox.click();
        //epicOption.click();
        issueTypeBox.sendKeys("Epic");
        epicOption.click();
    }

    public void createEpic(String epicName, String epicSummary){
        epicNameInput.sendKeys(epicName);
        epicSumInput.sendKeys(epicSummary);
    }
    public void submitIssue(){
        createIssueSubmitButton.click();
    }

}
