package uiTest.pageObjects.projectRoleMgmtPO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uiTest.pageObjects.BasePO;

public class CreateRolePO extends BasePO {
    @FindBy(xpath = "//input[@name='name']")
    private WebElement inputRoleName;

    @FindBy(xpath = "//input[@name='description']")
    private WebElement inputRoleDescription;

    @FindBy(xpath = "//input[@id='role_submit']")
    private WebElement buttonAddRole;

    public void enterRoleName(String roleName){
        inputRoleName.sendKeys(roleName);
    }
    public void setInputRoleDescription(String description){
        inputRoleDescription.sendKeys(description);
    }
    public void clickAddRoleBtn(){
        buttonAddRole.click();
    }
}