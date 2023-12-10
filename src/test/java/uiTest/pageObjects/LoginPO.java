package uiTest.pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//page_url = http://localhost:8080/login.jsp
public class LoginPO extends BasePO{
    @FindBy(id = "login-form-username")
    public WebElement usernameInput;

    @FindBy(id = "login-form-password")
    public WebElement passwordInput;

    @FindBy(id = "login")
    public WebElement loginBtn;

    public void enterUsername (String username){
        usernameInput.sendKeys(username);
    }
    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton(){
        loginBtn.click();
    }
}
