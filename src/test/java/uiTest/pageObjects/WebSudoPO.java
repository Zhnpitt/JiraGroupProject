package uiTest.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebSudoPO extends BasePO{
    @FindBy(name = "webSudoPassword")
    public WebElement webSudoPassword;

    @FindBy(xpath = "//button[@value='Confirm']")
    public WebElement confirmBtn;

    public void enterWebSudoPassword(String password){
        webSudoPassword.sendKeys(password);
    }

    public void clickConfirmBtn() {
        confirmBtn.click();
    }


}
