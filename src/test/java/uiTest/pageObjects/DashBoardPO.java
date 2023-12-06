package uiTest.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uiTest.drivers.DriverFactory;

public class DashBoardPO extends BasePO {

    public WebElement adminMenu;

    @FindBy(xpath = "//a[@id = 'admin_users_menu']")
    public WebElement userMgmtBtn;


    public boolean checkIfAdminUser() {
        boolean isAdminUser = true;
        try {
            adminMenu = DriverFactory.getDriver().findElement(By.xpath("//a[@id = 'admin_menu']"));
        } catch (NoSuchElementException e) {
            isAdminUser = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdminUser;
    }

    public void clickAdminMenu() {
        if (checkIfAdminUser()) {
            adminMenu.click();
        }
    }

    public void clickUserMgmtLink() {
        userMgmtBtn.click();
    }


}
