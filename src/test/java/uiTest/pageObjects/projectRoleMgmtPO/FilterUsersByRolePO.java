package uiTest.pageObjects.projectRoleMgmtPO;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilterUsersByRolePO {

    //String role = "Administrators";

    @FindBy(xpath = "//button[@class='_1tSDNSFo-vOBkDKqayIyHy css-18u3ks8']")
    private WebElement rolesButton;

    @FindBy(xpath = "//div[@role='menu']/div/span[contains(.,'Administrators')]")
    private WebElement roleElement;

    public void clickRolesButton(){
        rolesButton.click();
    }
    public void selectARole(){
        roleElement.click();
    }
}
