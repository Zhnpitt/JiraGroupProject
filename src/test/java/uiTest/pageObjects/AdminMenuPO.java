package uiTest.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminMenuPO extends BasePO{
    @FindBy(xpath = "//a[@id='admin_issues_menu']")
    public WebElement issueAdminButton;

    public void clickIssueAdminButton(){
        issueAdminButton.click();
    }
}
