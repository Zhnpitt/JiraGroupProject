package uiTest.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class IssuesPO extends BasePO{
    @FindBy(xpath = "(//div[@class='aui-page-header-actions'])[2]/div/button")
    public WebElement grantPermissionButton;

    @FindBy(xpath = "//li[@class='select2-search-field']/input")
    public WebElement searchBox;

    //Grant permission

    @FindBy(xpath = "//select[@id='permission-target-select']")
    public WebElement permissionSelectBox;

    @FindBy(xpath = "//label[normalize-space()='Project Role']")
    public WebElement projectRoleGrant;

    @FindBy(xpath = "//a[normalize-space()='team lead']")
    public WebElement teamLead;

    @FindBy(xpath = "//a[normalize-space()='QA']")
    public WebElement QA;

    @FindBy(xpath = "//label[normalize-space()='Application access']")
    public WebElement applicationAccessGrant;




    @FindBy(xpath = "//button[@id='grant-permission-dialog-grant-button']")
    public WebElement grantButton;

    //





    @FindBy(xpath = "//input[@id='projectrole-field']")
    public WebElement roleInputTextBox;

    @FindBy(xpath = "//ul[@role='listbox']/li")
    public WebElement roleSuggestion;






    @FindBy(xpath = "//a[@id='permission_schemes']")
    public WebElement permissionSchemesButton;

    @FindBy(xpath = "//div[@class='aui-buttons']")
    public WebElement addPermissionSchemeButton;

    @FindBy(xpath = "//input[@id='add-permissions-scheme-newSchemeName']")
    public WebElement inputNewSchemeName;

    @FindBy(xpath = "//button[@id='add-permissions-scheme-submit']")
    public WebElement newPermissionSchemeSubmit;

    @FindBy(xpath = "//tr[contains(.,'PS-1')]/td/ul/li/a[contains(.,'Permissions')]")
    public WebElement editPermissionButton;

    public void clickGrantPermissionButton(){
        grantPermissionButton.click();
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
    public void selectApplicationAccessGrant(){
        applicationAccessGrant.click();
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

    public void clickGrantButton() throws InterruptedException {
        grantButton.click();
        Thread.sleep(500);
    }

    public void clickPermissionSchemesButton(){
        permissionSchemesButton.click();
    }

    public void clickAddPermissionSchemeButton(){
        addPermissionSchemeButton.click();
    }

    public void nameANewScheme(String name){
        inputNewSchemeName.sendKeys(name);
    }

    public void submitANewScheme(){
        newPermissionSchemeSubmit.click();
    }

    public void editPermission(){
        editPermissionButton.click();
    }

}
