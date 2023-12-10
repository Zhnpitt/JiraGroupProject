package uiTest.pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uiTest.drivers.DriverFactory;

//page_url = http://localhost:8080/login.jsp
public class LoginPO extends BasePO{
    @FindBy(id = "login-form-username")
    public WebElement usernameInput;

    @FindBy(id = "login-form-password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@id = 'login-form-submit']")
    public WebElement loginBtn;


    @FindBy(xpath = "//*[@id=\"next\"]")
    public WebElement continueBtnInWelcomePage;

    @FindBy(xpath = "//*[@id=\"main\"]/form//input[@value = 'Next']")
    public WebElement nextBtnInWelcomePage;

    public void enterUsername(String username){
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton(){
        loginBtn.click();
    }

    public void clickContinueBtnInWelcomePage(){
        continueBtnInWelcomePage.click();
    }

    public void clickNextBtnInWelcomePage(){
        nextBtnInWelcomePage.click();
    }

    //div[@class = 'next-step-sequence-steps']/div[2]/a
    public void clickStepInNextStepSequence(int index){
        String path = "//div[@class = 'next-step-sequence-steps']/div[" + (index + 1) + "]/a";
        DriverFactory.getDriver().findElement(By.xpath(path)).click();
    }
}