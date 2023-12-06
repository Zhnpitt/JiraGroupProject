package uiTest.pageObjects.projectRoleMgmtPO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import uiTest.pageObjects.BasePO;

public class AddUserToRolePO extends BasePO {

    String name;
    String role = "team lead";

    @FindBy(xpath = "//button[@class='css-1yx6h60']")
    private WebElement addUsersToARoleButton;

    //John Doe
    @FindBy(xpath = "(//div[contains(@class,'css-1b6odlt')])[1]")
    private WebElement nameBox;

    @FindBy(xpath = "//div[@id='react-select-2-option-0']")
    private WebElement nameInDropDownBox;

    @FindBy(xpath = "//div[@class=' css-2b097c-container']")
    private WebElement roleContainer;

    @FindBy(xpath = "//div[@class=' css-1ljkvdv']/descendant::div[text()='team lead']")
    private WebElement roleOption;

    @FindBy(xpath = "//button[@class='css-1l4j2co']")
    private WebElement addButton;

    public void clickAddUsersToARoleButton(){
        addUsersToARoleButton.click();
    }

    public void inputName(String name){
        nameInDropDownBox.sendKeys(name);
    }

    public void selectAName(){
        nameInDropDownBox.click();
    }

    public void selectRoleContainer(){
        roleContainer.click();
    }

    public void chooseARole(){
        roleOption.click();
    }

    public void clickAddButton(){
        addButton.click();
    }
}