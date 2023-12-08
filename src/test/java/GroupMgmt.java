import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import uiTest.constants.URL;
import uiTest.drivers.DriverFactory;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class GroupMgmt {
    public WebDriver driver = DriverFactory.getDriver();

    @Test
    public void groupMgmt() {
        DriverFactory.getDriver().manage().deleteAllCookies();
        driver.navigate().to(URL.DashBoard.toString());
        WebElement username = driver.findElement(By.id("login-form-username"));
        username.sendKeys("zhangchris280");
        WebElement password = driver.findElement(By.id("login-form-password"));
        password.sendKeys("Zhn122737");
        WebElement loginBtn = driver.findElement(By.id("login"));
        loginBtn.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement setting = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".aui-icon.aui-icon-small.aui-iconfont-configure")));
        setting.click();

        WebElement userMgmt = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("User management")));
        userMgmt.click();

        WebElement webSudo = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("webSudoPassword")));
        webSudo.sendKeys("Zhn122737");
        WebElement confirm = driver.findElement(By.xpath("//button[@value='Confirm']"));
        confirm.click();

        WebElement groups = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Groups")));
        groups.click();

        WebElement addGroupName = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("addName")));
        addGroupName.sendKeys("Jira-group-1");
        WebElement addGroup = driver.findElement(By.name("add_group"));
        addGroup.click();

        WebElement group1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Jira-group-1")));
        assertEquals(group1.getText(), "Jira-group-1");


        addGroupName = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("addName")));
        addGroupName.sendKeys("Jira-group-2");
        addGroup = driver.findElement(By.name("add_group"));
        addGroup.click();

        addGroupName = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("addName")));
        addGroupName.sendKeys("Jira-group-3");
        addGroup = driver.findElement(By.name("add_group"));
        addGroup.click();

        WebElement bulkEditGroupMember = driver.findElement(By.id("bulk_edit_groups"));
        bulkEditGroupMember.click();

        WebElement testAreaGroup = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("selectedGroupsStr-textarea")));
        testAreaGroup.sendKeys("Jira");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" (//span[@class='group-suggestion-item__name'])[1]"))).click();
        testAreaGroup.sendKeys("Jira");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" (//span[@class='group-suggestion-item__name'])[1]"))).click();

        WebElement testAreaName = driver.findElement(By.id("usersToAssignStr"));
        testAreaName.sendKeys("Adam Smith, Diana West");
        WebElement addSelectedUsers = driver.findElement(By.id("add-users-to-selected-groups"));
        addSelectedUsers.click();

        WebElement adam = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" (//option[@value='Adam Smith'])[1]")));

        assertEquals(adam.getText(), "Adam Smith");

        System.out.println();
    }
}
