package uiTest.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import uiTest.drivers.DriverFactory;

import java.util.List;

public class DashBoardPO extends BasePO {

    @FindBy(xpath = "//li[@id='system-admin-menu']")
    public WebElement adminMenu;

    @FindBy(xpath = "//a[@id = 'admin_users_menu']")
    public WebElement userMgmtBtn;
    ////li[@id='system-admin-menu']

    @FindBy(xpath = "//a[@id='admin_system_menu']")
    public WebElement systemButton;

    @FindBy(xpath = "//a[@id='admin_project_menu']")
    public WebElement projectsButton;

    @FindBy(xpath = "//input[@id='login-form-authenticatePassword']")
    public WebElement authenticatePassword;

    @FindBy(xpath = "//button[@id = 'login-form-submit']")
    public WebElement authenticateConfirmBtn;

    @FindBy(xpath = "//a[@id='create_user']")
    public WebElement createUserBtn;

    @FindBy(xpath = "//input[@id=\"user-create-email\"]")
    public WebElement userCreateEmail;

    @FindBy(xpath = "//input[@id=\"user-create-fullname\"]")
    public WebElement userCreateFullname;

    @FindBy(xpath = "//input[@id=\"user-create-username\"]")
    public WebElement userCreateUsername;

    @FindBy(xpath = "//input[@id=\"password\"]")
    public WebElement userCreatePassword;

    @FindBy(xpath = "//button[@id=\"user-create-submit\"]")
    public WebElement userCreateBtn;

    @FindBy(xpath = "//table[@id=\"user_browser_table\"]/tbody")
    public WebElement userBrowserTableBody;

    @FindBy(xpath = "//a[@id='create_link']") ///html/body/div[6]/aui-spinner////a[@id='create_link']
    public WebElement createButton;

    @FindBy(xpath = "//input[@id='issuetype-field']")
    public WebElement issueTypeBox;

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

    @FindBy(xpath = "//div[@class=\"aui-list-scroll\"]/ul[1]/li")
    public WebElement matchingGroup;

    @FindBy(xpath = "//input[@id=\"user-edit-groups-join\"]")
    public WebElement manageUserGroupJoinBtn;

    @FindBy(xpath = "//input[@id=\"user-filter-group-field\"]")
    public WebElement groupFilter;

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

    public void clickAdminMenu(){
        if (checkIfAdminUser()){
            adminMenu.click();
        }
    }

    public void clickSystemButton(){
        systemButton.click();
    }

    public void clickUserMgmtLink(){
        userMgmtBtn.click();
    }

    public void enterAuthenticatePassword(String password) {
        authenticatePassword.sendKeys(password);
    }

    public void clickAuthenticateConfirmBtn() {
        authenticateConfirmBtn.click();
    }

    public void clickCreateUserBtn(){
        createUserBtn.click();
    }

    public void enterUserCreateEmail(String s) {
        userCreateEmail.sendKeys(s);
    }

    public void enterUserCreateFullname(String s) {
        userCreateFullname.sendKeys(s);
    }

    public void enterUserCreateUsername(String s) {
        userCreateUsername.sendKeys(s);
    }

    public void enterUserCreatePassword(String s) {
        userCreatePassword.sendKeys(s);
    }

    //return 0-index of the searched user, return -1 if not found
    public int searchInUserBrowserTableBody(String username) {
        List<WebElement> rows = userBrowserTableBody.findElements(By.xpath("./tr"));
        for (int i =0; i < rows.size();i++) {
            WebElement row = rows.get(i);
            WebElement rowUsername = row.findElement(By.xpath("./td[2]/div/span"));

            if (username.equals(rowUsername.getText())) {
                return i;
            }
        }
        return -1;
    }

    public void clickUserCreateBtn() {
        userCreateBtn.click();
    }

    public void clickUserBrowserTableEditBtn(String username) {
        WebElement row = findUserRowInBrowserTable(username);
        row.findElement(By.xpath(".//a[text()[normalize-space() = \"Edit\"]]")).click();
    }

    public void clickInactivatedUserBrowserTableEditBtn(String username) {
        WebElement row = findInactiveUserInUserBrowserTable(username);
        row.findElement(By.xpath(".//a[text()[normalize-space() = \"Edit\"]]")).click();
    }

    public void clickProjectsButton(){
        projectsButton.click();
    }

    public void deactivateUser(String username){
        clickUserBrowserTableEditBtn(username);
        uncheckUserEditActiveCheckedBox();
        clickUserEditUpdateBtn();
    }

    public void activateUser(String username){
        clickInactivatedUserBrowserTableEditBtn(username);
        checkUserEditActiveCheckedBox();
        clickUserEditUpdateBtn();
    }

    public void uncheckUserEditActiveCheckedBox(){
        if (userEditActiveCheckedBoxStatus.isSelected()){
            userEditActiveCheckedBox.click();
        }
    }

    public void checkUserEditActiveCheckedBox(){
        if (!userEditActiveCheckedBoxStatus.isSelected()){
            userEditActiveCheckedBox.click();
        }
    }

    public void clickUserEditUpdateBtn(){
        userEditUpdateBtn.click();
    }

    public void applyStatusFilter(String status) {
        Select statusDropDownMenu = new Select(statusFilter);
        statusDropDownMenu.selectByVisibleText(status);
    }

    public void clickFilterBtn() {
        filterBtn.click();
    }

    public WebElement findInactiveUserInUserBrowserTable(String username) {
        List<WebElement> rows = userBrowserTableBody.findElements(By.xpath("./tr"));
        for (WebElement row : rows) {
            WebElement curUsername = row.findElement(By.xpath("./td[2]/div/span/del"));
            if (username.equals(curUsername.getText())) {
                return row;
            }
        }
        return null;
    }

    public void clickFilterRestBtn() {
        filterResetBtn.click();
    }

    public void clickUserBrowserTableMoreBtn(String username) {
        WebElement row = findUserRowInBrowserTable(username);
        row.findElement(By.xpath("./td[@data-cell-type=\"operations\"]/a[2]")).click();
    }

    public WebElement findUserRowInBrowserTable(String username){
        List<WebElement> rows = userBrowserTableBody.findElements(By.xpath("./tr"));
        for (WebElement row : rows) {
            WebElement rowUsername = row.findElement(By.xpath("./td[2]/div/span"));
            if (username.equals(rowUsername.getText())) {
                return row;
            }
        }
        return null;
    }

    public void clickEditUserGroupsBtn(){
        editUserGroupsBtn.click();
    }

    public void enterGroupsToJoin(String groupName) {
        groupsToJoin.sendKeys(groupName);
    }

    public void clickMatchingGroup(){
        matchingGroup.click();
    }

    public void clickManageUserGroupJoinBtn(){
        manageUserGroupJoinBtn.click();
    }

    public String[] getUserGroups(String username){
        WebElement row = findUserRowInBrowserTable(username);
        String[] res = row.findElements(By.xpath("//td[@data-cell-type=\"user-groups\"]/ul/li/a"))
              .stream()
              .map(WebElement::getText)
              .toArray(String[]::new);
        return res;
    }

    public void applyGroupFilter(String groups){
        groupFilter.clear();
        groupFilter.sendKeys(groupNamesProvider(groups)[0]);
        matchingGroup.click();

    }

    public String[] groupNamesProvider(String groupNames){
        return groupNames.split(";");
    }

    public void clickCreateButton(){
        createButton.click();
    }
    public void selectIssueType(String issue){
        issueTypeBox.sendKeys(issue);
    }
}
