package uiTest.pageObjects;

import org.bouncycastle.jcajce.provider.asymmetric.X509;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import uiTest.drivers.DriverFactory;

public class IssuesPO extends BasePO{
    @FindBy(xpath = "//tr[@data-permission-key='MANAGE_SPRINTS_PERMISSION']//button[@class='aui-button aui-button-link add-trigger'][normalize-space()='Edit']")
    public WebElement manageSprintEditButton;

    @FindBy(xpath = "//li[@class='select2-search-field']/input")
    public WebElement searchBox;

    @FindBy(xpath = "//select[@id='permission-target-select']")
    public WebElement permissionSelectBox;

    @FindBy(xpath = "//label[normalize-space()='Project Role']")
    public WebElement projectRoleGrant;

    @FindBy(xpath = "//a[normalize-space()='team lead']")
    public WebElement teamLead;

    @FindBy(xpath = "//a[normalize-space()='QA']")
    public WebElement QA;

    @FindBy(xpath = "//button[@id='grant-permission-dialog-grant-button']")
    public WebElement grantButton;

    @FindBy(xpath = "//input[@id='projectrole-field']")
    public WebElement roleInputTextBox;

    @FindBy(xpath = "//ul[@role='listbox']/li")
    public WebElement roleSuggestion;

    @FindBy(xpath = "//input[@id='issuetype-field']")
    public WebElement issueTypeInputBox;

    @FindBy(xpath = "//ul[@class='aui-last']/li")
    public WebElement issueSuggestion;

    @FindBy(xpath = "//input[@id='customfield_10104']")
    public WebElement epicNameInput;

    @FindBy(xpath = "//input[@id='summary']")
    public WebElement epicSumInput;

    @FindBy(xpath = "//input[@id='create-issue-submit']")
    public WebElement submitIssueCreation;

    public void clickManageSprintEditButton(){
        manageSprintEditButton.click();
    }

    public void selectAPermission(String permission){
        Select select = new Select(permissionSelectBox);
        select.deselectAll();
        searchBox.sendKeys(permission);
        select.selectByVisibleText(permission);
    }

    public void selectProjectRoleGrant(){
        projectRoleGrant.click();
    }

    public void clickRoleInputTextBox(){
        roleInputTextBox.click();
    }

    public void chooseTeamLead(){
        teamLead.click();
    }

    public void chooseQA(){
        QA.click();
    }

    public void chooseDeveloper(){
    }

    public void clickGrantButton(){
        grantButton.click();
    }

    public void selectEpic(){
//        issueTypeInputBox.clear();
//        issueTypeInputBox.sendKeys("");
//        issueTypeInputBox.sendKeys("Epic");
//        issueSuggestion.click();
    }

    public void createEpic(String epicName, String epicSummary){
        epicNameInput.sendKeys(epicName);
        epicSumInput.sendKeys(epicSummary);
        submitIssueCreation.click();
    }

}
