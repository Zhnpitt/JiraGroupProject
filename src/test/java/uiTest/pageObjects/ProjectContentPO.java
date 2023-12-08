package uiTest.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;;
import org.openqa.selenium.support.ui.WebDriverWait;
import uiTest.drivers.DriverFactory;
import java.time.Duration;


//When we click a project in project list, it will provide URL this is related to the project name
//So instead of using a URL as PO, we use the project content concept as a PO
public class ProjectContentPO extends BasePO {
    @FindBy(xpath = "//section[@id=\"sidebar\"]//a[span[text()='Issues']]")
    public WebElement IssuesBtnInSidebar;

   // @FindBy(xpath = "//*[@id=\"opsbar-transitions_more\"]")
    public WebElement issueStatusBtn;

    public void clickIssuesBtnInSidebar() {
        IssuesBtnInSidebar.click();
    }

    public void clickIssueInListPanel(String issueName) {
        String path = "//li[@title = '" + issueName + "']/a";
        WebElement issue = DriverFactory.getDriver().findElement(By.xpath(path));
        ((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView();", issue);
        Duration duration = Duration.ofSeconds(3);
        new WebDriverWait(DriverFactory.getDriver(), duration).until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading")));
        DriverFactory.getDriver().findElement(By.xpath(path)).click();

    }

    public void clickIssueStatusBtn() {
        String path = "//*[@id=\"opsbar-transitions_more\"]";
        issueStatusBtn = DriverFactory.getDriver().findElement(By.xpath(path));
        issueStatusBtn.click();
    }

    public String getIssueStatus() {
        String path = "//*[@id=\"opsbar-transitions_more\"]";
        issueStatusBtn = DriverFactory.getDriver().findElement(By.xpath(path));
        String s = issueStatusBtn.findElement(By.xpath("./span")).getText();
        return issueStatusBtn.findElement(By.xpath("./span")).getText();
    }

    public void clickStatusInStatusDropdown(String status){
        String path = "//*[@id=\"opsbar-transitions_more_drop\"]/aui-section[1]/div//a[div/div[3]/span[text() = '" + status + "']]";
        DriverFactory.getDriver().findElement(By.xpath(path)).click();
    }
}
