package uiTest.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TeamLeadPO extends BasePO{


    @FindBy(xpath = "//a[@id='browse_link']")
    public WebElement projectButton;

    @FindBy(xpath = "//div[@id='project_current']//a")
    public WebElement currentProject;

    @FindBy(xpath = "//button[normalize-space()='Create sprint']")
    public WebElement createSprintButton;

    @FindBy(css = "#ghx-sprint-name")
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

    @FindBy(xpath = "//ul[@class='aui-last']/li")
    public WebElement epicOption;

    @FindBy(xpath = "//input[@id='customfield_10104']")
    public WebElement epicNameInput;

    @FindBy(xpath = "//input[@id='summary']")
    public WebElement epicSumInput;

    @FindBy(xpath = "//input[@id='create-issue-submit']")
    public WebElement createIssueSubmitButton;

    @FindBy(xpath = "//a[@aria-label='Backlog of projectName']")

    public WebElement backlogButton;


    @FindBy(xpath = "(//span[@class='ghx-type']/img)[1]")
    public WebElement issueAInBackLog;

    @FindBy(xpath = "(//span[@class='ghx-type']/img)[2]")
    public WebElement IssueBInBackLog;

    @FindBy(xpath = "//span[@class='ghx-type']")
    public List<WebElement> issuesInBackLog;

    @FindBy(xpath = "//div[@class='ghx-sprint-group']/div")
    public WebElement targetSprint;

    @FindBy(xpath = "//button[normalize-space()='Start sprint']")
    public WebElement startSprintButton;

    @FindBy(xpath = "//button[normalize-space()='Start']")
    public WebElement confirmStart;

    @FindBy(css = ".button-panel-button.aui-button")

    public WebElement confirmMoveMore;

    @FindBy(xpath = "(//div[@class='ghx-sprint-group']//span[@class='ghx-type']/img)[1]")
    public WebElement issueAInSprint;

    @FindBy(xpath = "(//div[@class='ghx-sprint-group']//span[@class='ghx-type']/img)[2]")
    public WebElement issueBInSprint;

    @FindBy(xpath = "//div[@class='ghx-sprint-group']//span[@class='ghx-type']/img")
    public List<WebElement> issuesInSprint;


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
        //sprintNameInput.click();
        sprintNameInput.clear();
        sprintNameInput.sendKeys(name);
    }

    public void subMitSprint(){
        submitSprintButton.click();
        submitSprintButton.click();
    }


    public void createIssue(){
        getDriver().findElement(By.xpath("//*[@id=\"ghx-content-group\"]")).click();
        createIssueButton.click();
        openInDialogButton.click();
    }

    public void selectEpic(){
        issueTypeBox.click();
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

    public void clickBacklogButton(){
        backlogButton.click();
    }

    public void startSprint(){
        startSprintButton.click();
        confirmStart.click();
    }

    public void viewIssuesInCurrentSprint() throws InterruptedException{
//        issueAInSprint.click();
//        Thread.sleep(2000);
//        issueBInSprint.click();
//        Thread.sleep(2000);
        for (WebElement issue : issuesInSprint){
            issue.click();
            Thread.sleep(2000);
        }
    }
}