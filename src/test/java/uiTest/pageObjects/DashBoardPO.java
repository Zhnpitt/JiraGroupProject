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
    @FindBy(xpath = "//a[@id = 'admin_issues_menu']")
    public WebElement adminIssuesBtn;
    @FindBy(xpath = "//a[@id=\"browse_link\"]")
    public WebElement projectsBtn;
    @FindBy(xpath = "//a[@id=\"project_view_all_link_lnk\"]")
    public WebElement allProjectBtn;

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

    public void clickAdminIssuesBtn() {
        adminIssuesBtn.click();
    }

    public void clickProjectsBtn() {
        projectsBtn.click();
    }

    public void clickAllProjectBtn() {
        allProjectBtn.click();
    }


/*
    public void click() {
        .click();
    }
    */
}
