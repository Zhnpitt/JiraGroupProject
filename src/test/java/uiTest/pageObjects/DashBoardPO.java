package uiTest.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashBoardPO extends BasePO{
    @FindBy(css = ".aui-icon.aui-icon-small.aui-iconfont-configure")
    public WebElement jiraSettingBtn;

    @FindBy(linkText = "User management")
    public WebElement userMgmtBtn;


    public void clickSettingBtn() {
        jiraSettingBtn.click();
    }

    public void clickUserMgmtBtn(){
        userMgmtBtn.click();
    }


}
