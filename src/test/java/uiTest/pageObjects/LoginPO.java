package uiTest.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    @FindBy(xpath = "//input[@id='login-form-username']")
    public WebElement inputUsername;

    @FindBy(xpath = "//input[@id='login-form-password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@id = 'login-form-submit']")
    public WebElement buttonLogin;

    public void enterUsername(String username) {
        inputUsername.clear();
        inputUsername.sendKeys(username);
    }

    public void enterPassword(String password) {
        inputPassword.clear();
        inputPassword.sendKeys(password);
    }

    public void clickLoginButton() {
        buttonLogin.click();
    }

}
