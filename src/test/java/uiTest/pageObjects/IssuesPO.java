package uiTest.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IssuesPO extends BasePO{
    @FindBy(xpath = "//tr[@data-permission-key='MANAGE_SPRINTS_PERMISSION']//button[@class='aui-button aui-button-link add-trigger'][normalize-space()='Edit']")
    public WebElement manageSprintEditButton;

    @FindBy(xpath = "//input[@id='projectrole-security-type']")
    public WebElement projectRoleGrant;

    @FindBy(xpath = "//button[@id='grant-permission-dialog-grant-button']")
    public WebElement grantButton;

    public void clickManageSprintEditButton(){
        manageSprintEditButton.click();
    }
    public void selectProjectRoleGrant(){
        projectRoleGrant.click();
    }
    public void clickGrantButton(){
        grantButton.click();
    }
}
