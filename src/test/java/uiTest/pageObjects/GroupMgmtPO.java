package uiTest.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GroupMgmtPO extends BasePO{

    @FindBy(linkText = "Groups")
    public WebElement groupsBtn;
    @FindBy(name = "addName")
    public WebElement addGroupNameArea;

    @FindBy(name = "add_group")
    public WebElement addGroupBtn;

    @FindBy(linkText = "Jira-group-1")
    public WebElement group1;

    @FindBy(id = "bulk_edit_groups")
    public WebElement bulkEditGroupMemberBtn;

    @FindBy(id = "selectedGroupsStr-textarea")
    public WebElement textAreaGroup;

    @FindBy(id = "usersToAssignStr" )
    public WebElement textAreaUserNames;

    @FindBy(xpath = "(//option[@value='Adam Smith'])[1]")
    public WebElement adamUserPresence;

    @FindBy(xpath = "(//span[@class='group-suggestion-item__name'])[1]")
    public WebElement chooseGroup;
    @FindBy(id="add-users-to-selected-groups")
    public WebElement addSelectedUsersBtn;

    public void clickGroupsBtn() {
        groupsBtn.click();
    }

    public void setAddGroupNameArea(String groupName) {
        addGroupNameArea.sendKeys(groupName);
    }

    public void clickAddGroupBtn() {
        addGroupBtn.click();
    }

    public void clickBulkEditGroupMemberBtn() {
        bulkEditGroupMemberBtn.click();
    }

    public void setTextAreaGroup(String groupName){
        textAreaGroup.sendKeys(groupName);
    }

    public void setChooseGroup(){
        chooseGroup
                .click();
    }

    public void setTestAreaUserNames(String userNames){
        textAreaUserNames
                .sendKeys(userNames);
    }

    public void clickAddSelectedUsersBtn(){
        addSelectedUsersBtn.click();
    }

}
