package uiTest.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminCreateUserPO extends BasePO {
    @FindBy(xpath = "//input[@id=\"user-create-email\"]")
    public WebElement userCreateEmail;

    @FindBy(xpath = "//input[@id=\"user-create-username\"]")
    public WebElement userCreateUsername;

    @FindBy(xpath = "//input[@id=\"user-create-fullname\"]")
    public WebElement userCreateFullname;

    @FindBy(xpath = "//input[@id=\"password\"]")
    public WebElement userCreatePassword;

    @FindBy(xpath = "//button[@id=\"user-create-submit\"]")
    public WebElement userCreateBtn;

    public void enterUserCreateEmail(String s) {
        userCreateEmail.sendKeys(s);
    }

    public void enterUserCreateUsername(String s) {
        userCreateUsername.sendKeys(s);
    }

    public void enterUserCreateFullname(String s) {
        userCreateFullname.sendKeys(s);
    }

    public void enterUserCreatePassword(String s) {
        userCreatePassword.sendKeys(s);
    }

    public void clickUserCreateBtn() {
        userCreateBtn.click();
    }

}
