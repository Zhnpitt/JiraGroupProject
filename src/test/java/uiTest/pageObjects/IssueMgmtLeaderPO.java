package uiTest.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IssueMgmtLeaderPO extends BasePO {

    @FindBy(xpath = "(//a[normalize-space()='Projects'])[1]")
    public WebElement projectsBtn;

    @FindBy(linkText = "View All Projects")
    public WebElement viewAllProjectsBtn;

    @FindBy(linkText = "projectName")
    public WebElement scrumProject;

    public By backlogBtn = By.xpath("(//span[@class='aui-icon aui-icon-large agile-icon-plan aui-iconfont-backlog'])[1]");

    public By epicsBtn =By.xpath("(//span[normalize-space()='Epics'])[1]");

    @FindBy(css ="span[data-fieldvalue='Backend dev']")
    public WebElement backendEpic;

    @FindBy(css = "span[data-fieldvalue='Frontend dev']")
    public WebElement frontendEpic;

    @FindBy(xpath = "(//span[normalize-space()='All issues'])[1]")
    public WebElement allIssuesBtn;
    @FindBy(css = "button[class='aui-button aui-button-subtle']")
    public WebElement createIssueBtn;


    public By openInDialogBtn = By.cssSelector(".aui-button.aui-button-text.iic-widget__more");

    @FindBy(id ="summary")
    public WebElement summaryArea;

    @FindBy(id = "priority-field")
    public WebElement priorityOption;

    @FindBy(linkText = "High")
    public WebElement highPriority;

    @FindBy(id = "create-issue-submit")
    public WebElement createBtn;

    @FindBy(css = "div[title='story1 by John']")
    public WebElement newCreatedIssueStory;

    @FindBy(xpath = "(//input[@id='issuetype-field'])[1]")
    public WebElement issueTypeDropdown;

    @FindBy(xpath = "(//a[@role='presentation'][normalize-space()='Task'])[1]")
    public WebElement taskType;

    @FindBy(css = "div[title='task2 by John']")
    public WebElement newCreatedIssueTask2;

    @FindBy(css = "div[title='task1 by John']")
    public WebElement newCreatedIssueTask1;

    @FindBy(xpath = "(//span[@class='aui-icon ghx-iconfont aui-icon-small aui-iconfont-more'])[2]")
    public WebElement threeDotsBtn;

    @FindBy(css = "a[title='Link this issue to another issue or item']")
    public WebElement linkBtn;

    @FindBy(id = "link-type")
    public WebElement thisIssueArea;

    @FindBy(xpath = "(//textarea[@id='jira-issue-keys-textarea'])[1]")
    public WebElement issueArea;

    @FindBy(xpath = "(//a[@class='aui-list-item-link aui-iconised-link'])[1]")
    public WebElement firstIssue;

    @FindBy(css = "input[title='Press Ctrl+Alt+s to submit this form']")
    public WebElement linkIssueBtn;

    @FindBy(css = "dt[title='is blocked by']")
    public WebElement isBlockedByArea;

    @FindBy(css = "a[title='Assign this issue to someone']")
    public WebElement assignBtn;

    @FindBy(xpath = "(//input[@id='assignee-field'])[1]")
    public WebElement assigneeArea;

    @FindBy(xpath = "(//em[contains(text(),'Adam')])[1]")
    public WebElement adamSmith;

    @FindBy(xpath = "(//p)[1]")
    public WebElement commentArea;

    @FindBy(xpath = "(//button[@id='assign-issue-submit'])[1]")
    public WebElement assignConfirmBtn;

    @FindBy(xpath = "(//a[normalize-space()='Assign to me'])[1]")
    public WebElement assigneeCheckArea;

    public By assignedBy = By.cssSelector("label[for='assignee-field']");

    @FindBy(id = "issue_summary_assignee_Adam Smith")
    public WebElement assigneeAdamSmith;

    @FindBy(xpath = "(//input[@id='customfield_10102-field'])[1]")
    public WebElement epicLinkArea;

    @FindBy(xpath = "(//a[@role='presentation'])[3]")
    public WebElement frontendEpicSuggestion;

    @FindBy(xpath = "(//a[normalize-space()='Create'])[1]")
    public WebElement createBtnOnBlue;
    @FindBy(xpath = "(//span[normalize-space()='Issues without epics'])[1]")
    public WebElement issuesWithoutEpics;



    public void clickIssueWithoutEpics(){
        issuesWithoutEpics.click();
    }

    public void clickCreateBtnOnBlue(){
        createBtnOnBlue.click();
    }
    public void scrolltoEpicLinkAreaAndClick(){
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView(true);",epicLinkArea);
        epicLinkArea.click();
    }

    public void chooseFrontendEpicSuggestion(){
        frontendEpicSuggestion.click();
    }

//    public void clickAllIssuesBtn(){
//        allIssuesBtn.click();
//    }
    public void scrollToAssigneeCheckAreaAndCheck(){
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView(true);", assigneeCheckArea);
        new WebDriverWait(getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(assignedBy));
    }
    public void clickAssignConfirmBtn(){
        assignConfirmBtn.click();
    }
    public void leaveMessageInCommentArea(String message){
        getDriver().switchTo().frame(0);
        commentArea.sendKeys(message);
        getDriver().switchTo().defaultContent();
    }
    public void chooseAdamSmith(){
        adamSmith.click();
    }
    public void sendToAssigneeArea(String name){
        assigneeArea.sendKeys(name);
    }
    public void clickAssignBtn(){
        assignBtn.click();
    }
    public void clickLinkIssueBtn(){
        linkIssueBtn.click();
    }
    public void clickFirstIssue(){
        firstIssue.click();
    }
    public void setIssueArea(String str){
        issueArea.sendKeys(str);
    }
    public void thisIssueLinkType(){
        Select dropdown = new Select(thisIssueArea);
        dropdown.selectByValue("is blocked by");
    }

    public void clickLinkBtn(){
        linkBtn.click();
    }
    public void clickThreeDotsBtn(){
        threeDotsBtn.click();
    }
    public void clickNewCreatedIssueTask(){
        newCreatedIssueTask1.click();
    }

    public void chooseTaskType(){
        taskType.click();
    }
    public void clickIssueTypeDropdown(){
        issueTypeDropdown.click();
    }

    public void clickProjectsBtn(){
        projectsBtn.click();
    }

    public void clickViewAllProjectsBtn(){
        viewAllProjectsBtn.click();
    }

    public void chooseScrumProject() {
        scrumProject.click();
    }

    public void clickBacklogBtn(){
        new WebDriverWait(getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(backlogBtn))
                .click();
    }

    public void clickEpicsBtn() {
        new WebDriverWait(getDriver(),Duration.ofSeconds(5)).
                until(ExpectedConditions.presenceOfElementLocated(epicsBtn))
                .click();
    }

    public void clickBackendEpic(){
        backendEpic.click();
    }

    public void clickCreateIssueBtn(){
        createIssueBtn.click();
    }

    public void clickOpenInDialogBtn(){
        new WebDriverWait(getDriver(),Duration.ofSeconds(5))
                .until(ExpectedConditions.presenceOfElementLocated(openInDialogBtn))
                .click();
    }

    public void sendInSummaryArea(String summary){
        summaryArea.sendKeys(summary);
    }

    public void scrollToPriorityAndClick(){
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", priorityOption);
        priorityOption.click();
    }

    public void clickHighPriority(){
        highPriority.click();
    }

    public void clickCreateBtn(){
        createBtn.click();
    }

    public void clickFrontendEpic(){frontendEpic.click();}

}
