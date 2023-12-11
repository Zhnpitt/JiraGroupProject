package uiTest.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProjectPO extends BasePO{

    @FindBy(xpath = "//a[normalize-space()='Create project']")
    public WebElement createProjectButton;
    //a[normalize-space()='Create project']
    //a[@id='browse-projects-create-project']

    @FindBy(xpath = "//button[normalize-space()='Next']")
    public WebElement nextButton;

    @FindBy(xpath = "//button[normalize-space()='Select']")
    public WebElement selectButton;

    @FindBy(xpath = "//input[@id='name']")
    public WebElement projectName;

    @FindBy(xpath = "//input[@id='key']")
    public WebElement projectKey;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    public WebElement submitAProjectButton;

    @FindBy(xpath = "//table//tbody/tr/td/a")
    public WebElement projectLink;

    @FindBy(xpath = "//a[@id='view_project_roles']")
    public WebElement usersAndRolesButton;

    @FindBy(xpath = "//button[@class='css-1yx6h60']")
    public WebElement addUserToARoleButton;

    @FindBy(xpath = "//div[contains(@class,'css-1b6odlt')]//input ")
    public WebElement userNameTextBox;

    @FindBy(xpath = "(//div[@class=' css-1ljkvdv']/div)[1]")
    public WebElement nameSuggestion;

    @FindBy(xpath = "//div[@class=' css-2b097c-container']")
    public WebElement roleDropDownBox;

    @FindBy(xpath = "(//div[contains(@class,'css-2b097c-container')]//input)[2]")
    public WebElement roleNameTextBox;

    @FindBy(xpath = "//div[@class=' css-26l3qy-menu']/div/div")
    public WebElement roleSuggestion;

    @FindBy(xpath = "//button[@class='css-1l4j2co']")
    public WebElement addButton;

    @FindBy(xpath = "(//div[@class='sc-feJyhm dfkaKe']/span)[2]")
    public WebElement roleFilterMenu;

    @FindBy(xpath = "//div[@id='uid1']//div[@role='menu']/div/span")
    public WebElement developerRole;

    @FindBy(xpath = "(//div[@id='uid1']//div[@role='menu']/div/span)[2]")
    public WebElement QARole;

    @FindBy(xpath = "(//div[@id='uid1']//div[@role='menu']/div/span)[3]")
    public WebElement teamLeadRole;


    @FindBy(xpath = "//a[@id='view_project_permissions']")
    public WebElement permissionsButton;

    @FindBy(xpath = "//button[@id='project-config-tab-actions']")
    public WebElement actionsDropBox;

    @FindBy(xpath = "//a[@id='project-config-permissions-scheme-edit']")
    public WebElement editPermissionsButton;

    @FindBy(xpath = "//a[@id='project-config-permissions-scheme-change']")
    public WebElement useADifferentSchemeButton;

    @FindBy(xpath = "//select[@id='schemeIds_select']")
    public WebElement permissionSchemeDropBox;

    @FindBy(xpath = "//input[@id='associate_submit']")
    public WebElement associateButton;

    @FindBy(xpath = "//a[@id='view_project_issuetype_10001']")
    public WebElement epicButton;

    @FindBy(xpath = "//button[@id='edit_workflow']")
    public WebElement editWorkflowButton;

    @FindBy(xpath = "//button[@class='aui-button add-status']")
    public WebElement addStatusButton;

    @FindBy(xpath = "//input[@id='status-name-field']")
    public WebElement statusNameTextBox;

    @FindBy(xpath = "//a[@role='presentation']")
    public WebElement statusSuggestion;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement submitNewStatusButton;

    public void clickCreateProjectButton(){
        createProjectButton.click();
    }

    public void clickNextButton(){
        nextButton.click();
    }

    public void clickSelectButton(){
        selectButton.click();
    }

    public void createAProject(String nameOfProject, String keyOfProject) throws InterruptedException{
        projectName.sendKeys(nameOfProject);
        Thread.sleep(200);
        //projectKey.sendKeys(keyOfProject);
//        Thread.sleep(200);
        submitAProjectButton.click();
        Thread.sleep(200);
    }

    public void chooseAProject(){
        projectLink.click();
    }

    public void clickUsersAndRolesButton(){
        usersAndRolesButton.click();
    }

    public void clickAddUserToARoleButton(){
        addUserToARoleButton.click();
    }

    public void enterUserName(String userName) throws InterruptedException{
        userNameTextBox.sendKeys(userName);
        Thread.sleep(200);
        nameSuggestion.click();
        Thread.sleep(200);
    }

    public void chooseARole(String roleName) throws InterruptedException{
        roleDropDownBox.click();
        Thread.sleep(200);
        roleNameTextBox.sendKeys(roleName);
        Thread.sleep(200);
        roleSuggestion.click();
        Thread.sleep(200);
    }

    public void clickAddButton(){
        addButton.click();
    }

    public void filterDeveloper() throws InterruptedException{
        roleFilterMenu.click();
        developerRole.click();
        roleFilterMenu.click();
        Thread.sleep(2000);
    }

    public void filterQA() throws InterruptedException{
        roleFilterMenu.click();
        developerRole.click();
        QARole.click();
        roleFilterMenu.click();
        Thread.sleep(2000);
    }

    public void filterTeamLead() throws InterruptedException{
        roleFilterMenu.click();
        QARole.click();
        teamLeadRole.click();
        roleFilterMenu.click();
        Thread.sleep(2000);
    }

    public void setRoleFilter(){
        developerRole.click();
    }

    public void clickPermissionsButton(){
        permissionsButton.click();
    }

    public void editPermissions() throws InterruptedException{
        actionsDropBox.click();
        Thread.sleep(200);
        editPermissionsButton.click();

    }

    public void editPermissionsScheme() throws InterruptedException{
        actionsDropBox.click();
        Thread.sleep(200);
        useADifferentSchemeButton.click();
    }

    public void selectAPermissionScheme(){
        Select select = new Select(permissionSchemeDropBox);
        select.selectByVisibleText("PS-1");
    }

    public void clickAssociateButton(){
        associateButton.click();
    }

    public void clickEpicButton(){
        epicButton.click();
    }

    public void clickEditWorkflowButton(){
        editWorkflowButton.click();
    }

    public void addStatus(String statusName) throws InterruptedException{
        addStatusButton.click();
        Thread.sleep(200);
        statusNameTextBox.sendKeys(statusName);
        Thread.sleep(200);
        statusSuggestion.click();
        Thread.sleep(200);
        submitNewStatusButton.click();
    }
}