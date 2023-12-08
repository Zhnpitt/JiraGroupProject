package uiTest.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uiTest.pageObjects.BasePO;

public class SystemPagePO extends BasePO {

    @FindBy(xpath = "//a[@id='project_role_browser']")
    private WebElement projectRolesButton;

    @FindBy(xpath = "//input[@name='name']")
    private WebElement inputRoleName;

    @FindBy(xpath = "//input[@name='description']")
    private WebElement inputRoleDescription;

    @FindBy(xpath = "//input[@id='role_submit']")
    private WebElement roleSubmitButton;

    @FindBy(xpath = "//a[@id='manage_Team lead']")
    private WebElement manageTeamLeadMembersButton;

    @FindBy(xpath = "//a[@id='manage_Developer']")
    private WebElement manageDeveloperMembersButton;

    @FindBy(xpath = "//a[@id='manage_QA']")
    private WebElement manageQAMembersButton;

    @FindBy(xpath = "//a[@id='edit_10203_atlassian-user-role-actor']")
    private WebElement editRoleMemberButton;

    @FindBy(xpath = "//textarea[@id='userNames']")
    private WebElement userNameTextArea;

    @FindBy(xpath = "//div[@class='suggestions dropdown-ready']//ul")
    private WebElement userNameSuggestion;

    @FindBy(xpath = "//div[@class='buttons']")
    private WebElement addButton;

    @FindBy(xpath = "(//tbody)[2]")
    private WebElement usersInThisRole;



    public void clickProjectRolesButton(){
        projectRolesButton.click();
    }
    public void enterRoleName(String roleName){
        inputRoleName.sendKeys(roleName);
    }
    public void enterRoleDescription(String description){
        inputRoleDescription.sendKeys(description);
    }
    public void clickRoleSubmitButton(){
        roleSubmitButton.click();
    }
    public void clickManageTeamLeadMembersButton(){
        manageDeveloperMembersButton.click();
    }
    public void clickManageDeveloperMembersButton(){
        manageDeveloperMembersButton.click();
    }

    //lead
    public void clickManageQAMembersButton(){
        manageQAMembersButton.click();
    }
    public void clickEditRoleMemberButton(){
        editRoleMemberButton.click();
    }

    //John Doe
    public void enterUserNameTextArea(String name){
        userNameTextArea.sendKeys(name);
    }
    public void clickUserNameSuggestion(){
        userNameSuggestion.click();
    }
    public void clickAddButton(){
        addButton.click();
    }

}