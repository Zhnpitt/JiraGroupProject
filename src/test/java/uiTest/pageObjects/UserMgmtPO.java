package uiTest.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class UserMgmtPO extends BasePO {
    @FindBy(xpath = "//input[@id='login-form-authenticatePassword']")
    public WebElement authenticatePassword;

    @FindBy(xpath = "//button[@id = 'login-form-submit']")
    public WebElement authenticateConfirmBtn;

    @FindBy(xpath = "//a[@id='create_user']")
    public WebElement createUserBtn;

    @FindBy(xpath = "//table[@id=\"user_browser_table\"]/tbody")
    public WebElement userBrowserTableBody;

    @FindBy(xpath = "//form[@id=\"user-edit\"]/div[1]/fieldset/div/label")
    public WebElement userEditActiveCheckedBox;

    @FindBy(xpath = "//input[@id=\"user-edit-active\"]")
    public WebElement userEditActiveCheckedBoxStatus;

    @FindBy(xpath = "//button[@id=\"user-edit-submit\"]")
    public WebElement userEditUpdateBtn;

    @FindBy(xpath = "//select[@id=\"user-filter-user-filter-active\"]")
    public WebElement statusFilter;

    @FindBy(xpath = "//button[@id=\"user-filter-submit\"]")
    public WebElement filterBtn;

    @FindBy(xpath = "//a[@id=\"user-filter-cancel\"]")
    public WebElement filterResetBtn;

    @FindBy(xpath = "//a[text()[normalize-space() = \"Edit user groups\"]]")
    public WebElement editUserGroupsBtn;

    @FindBy(xpath = "//textarea[@id=\"groupsToJoin-textarea\"]")
    public WebElement groupsToJoin;

    @FindBy(xpath = "//div[@class=\"aui-list-scroll\"]/ul[1]/li/a")
    public WebElement matchingGroup;

    @FindBy(xpath = "//input[@id=\"user-edit-groups-join\"]")
    public WebElement manageUserGroupJoinBtn;

    @FindBy(xpath = "//input[@id=\"user-filter-group-field\"]")
    public WebElement groupFilter;
    @FindBy(xpath = "//div[@class = 'group-suggestion-item']/span")
    public WebElement filterMatchingGroup;
    public void enterAuthenticatePassword(String password) {
        authenticatePassword.sendKeys(password);
    }

    public void clickAuthenticateConfirmBtn() {
        authenticateConfirmBtn.click();
    }

    public void clickCreateUserBtn() {
        createUserBtn.click();
    }

    //return 0-index of the searched user, return -1 if not found
    public int searchInUserBrowserTableBody(String username) {
        List<WebElement> rows = userBrowserTableBody.findElements(By.xpath("./tr"));
        for (int i = 0; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            WebElement rowUsername = row.findElement(By.xpath("./td[2]/div/span"));
            if (username.equals(rowUsername.getText())) {
                return i;
            }
        }
        return -1;
    }

    public WebElement findInactiveUserInUserBrowserTable(String username) {
        List<WebElement> rows = userBrowserTableBody.findElements(By.xpath(".//tr[td//del]"));
        for (WebElement row : rows) {
            WebElement rowUsername = row.findElement(By.xpath("./td[2]/div/span/del"));
            String s = rowUsername.getText();
            if (username.equals(rowUsername.getText())) {
                return row;
            }
        }
        return null;
    }

    public WebElement findUserRowInBrowserTable(String username) {
        List<WebElement> rows = userBrowserTableBody.findElements(By.xpath("./tr"));
        for (WebElement row : rows) {
            WebElement rowUsername = row.findElement(By.xpath("./td[2]/div/span"));
            if (username.equals(rowUsername.getText())) {
                return row;
            }
        }
        return null;
    }

    public void clickInactivatedUserBrowserTableEditBtn(String username) {
        WebElement row = findInactiveUserInUserBrowserTable(username);
        row.findElement(By.xpath(".//a[text()[normalize-space() = \"Edit\"]]")).click();
    }

    public void activateUser(String username) {
        clickInactivatedUserBrowserTableEditBtn(username);
        checkUserEditActiveCheckedBox();
        clickUserEditUpdateBtn();
    }

    public void clickUserBrowserTableMoreBtn(String username) {
        WebElement row = findUserRowInBrowserTable(username);
        row.findElement(By.xpath("./td[@data-cell-type=\"operations\"]/a[2]")).click();
    }

    public void clickUserBrowserTableEditBtn(String username) {
        WebElement row = findUserRowInBrowserTable(username);
        row.findElement(By.xpath(".//a[text()[normalize-space() = \"Edit\"]]")).click();
    }


    public void deactivateUser(String username) {
        clickUserBrowserTableEditBtn(username);
        uncheckUserEditActiveCheckedBox();
        clickUserEditUpdateBtn();
    }

    public void uncheckUserEditActiveCheckedBox() {
        if (userEditActiveCheckedBoxStatus.isSelected()) {
            userEditActiveCheckedBox.click();
        }
    }

    public void checkUserEditActiveCheckedBox() {
        if (!userEditActiveCheckedBoxStatus.isSelected()) {
            userEditActiveCheckedBox.click();
        }
    }

    public void clickUserEditUpdateBtn() {
        userEditUpdateBtn.click();
    }

    public void applyStatusFilter(String status) {
        Select statusDropDownMenu = new Select(statusFilter);
        statusDropDownMenu.selectByVisibleText(status);
    }

    public void clickFilterBtn() {
        filterBtn.click();
    }

    public void clickFilterRestBtn() {
        filterResetBtn.click();
    }

    public void clickEditUserGroupsBtn() {
        editUserGroupsBtn.click();
    }

    public void enterGroupsToJoin(String groupName) {
        groupsToJoin.sendKeys(groupName);
    }

    public void clickMatchingGroup() {
        matchingGroup.click();
    }

    public void clickManageUserGroupJoinBtn() {
        manageUserGroupJoinBtn.click();
    }

    public String[] getUserGroups(String username) {
        WebElement row = findUserRowInBrowserTable(username);
        String[] res = row.findElements(By.xpath("//td[@data-cell-type=\"user-groups\"]/ul/li/a"))
              .stream()
              .map(WebElement::getText)
              .toArray(String[]::new);
        return res;
    }

    public void applyGroupFilter(String groups) {
        groupFilter.clear();
        groupFilter.sendKeys(groupNamesProvider(groups)[0]);
        filterMatchingGroup.click();

    }

    public String[] groupNamesProvider(String groupNames) {
        return groupNames.split(";");
    }

}