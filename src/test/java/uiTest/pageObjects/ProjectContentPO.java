package uiTest.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uiTest.drivers.DriverFactory;

import java.time.Duration;
import java.util.List;

;


//When we click a project in project list, it will provide URL this is related to the project name
//So instead of using a URL as PO, we use the project content concept as a PO
//http://localhost:8080/secure/RapidBoard.jspa
//http://localhost:8080/projects/WP
//
public class ProjectContentPO extends BasePO{
    @FindBy(xpath = "//section[@id=\"sidebar\"]//a[span[text()='Issues']]")
    public WebElement IssuesBtnInSidebar;

    // @FindBy(xpath = "//*[@id=\"opsbar-transitions_more\"]")
    public WebElement issueStatusBtn;

    @FindBy(xpath = "//section[@id=\"sidebar\"]//a[span[text() = 'Backlog']]")
    public WebElement backlogBtn;

    @FindBy(xpath = "//*[@id=\"board-tools-section-button\"]")
    public WebElement boardBtn;


    @FindBy(xpath = "//*[@id=\"board-tools-section-content\"]//a[text() = 'Configure']")
    public WebElement configureOptionInBoardDropDown;

    @FindBy(xpath = " //nav//a[text() = 'Columns']")
    public WebElement columnsBtnInConfigNav;

    @FindBy(xpath = "//*[@id=\"ghx-config-columns\"]/h2")
    public WebElement columnMgmtTitle;
    @FindBy(xpath = "//*[@id=\"ghx-config-addcolumn\"]")
    public WebElement addColumnBtn;
    @FindBy(xpath = "//*[@id=\"ghx-column-name\"]")
    public WebElement columnName;
    @FindBy(xpath = "//*[@id=\"ghx-status-category-picker-field\"]")
    public WebElement columnCategory;
    @FindBy(xpath = "//*[@id=\"ghx-status-category-picker-suggestions\"]/div/ul")
    public WebElement columnCategoryDropDown;
    @FindBy(xpath = "//*[@id=\"ghx-dialog-add-column\"]//button[text() = 'Add']")
    public WebElement addBtnInAddColumnDialog;

    /*
    @FindBy(xpath = "")
    public WebElement ;
    * */
    public void clickIssuesBtnInSidebar(){
        IssuesBtnInSidebar.click();
    }

    public void clickIssueInListPanel(String issueName){
        String path = "//li[@title = '" + issueName + "']/a";
        WebElement issue = DriverFactory.getDriver().findElement(By.xpath(path));
        ((JavascriptExecutor) DriverFactory.getDriver()).executeScript("arguments[0].scrollIntoView();", issue);
        Duration duration = Duration.ofSeconds(3);
        new WebDriverWait(DriverFactory.getDriver(), duration).until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading")));
        DriverFactory.getDriver().findElement(By.xpath(path)).click();

    }

    public void clickIssueStatusBtn(){
        String path = "//*[@id=\"opsbar-transitions_more\"]";
        issueStatusBtn = DriverFactory.getDriver().findElement(By.xpath(path));
        issueStatusBtn.click();
    }

    public String getIssueStatus(){
        String path = "//*[@id=\"opsbar-transitions_more\"]";
        issueStatusBtn = DriverFactory.getDriver().findElement(By.xpath(path));
        String s = issueStatusBtn.findElement(By.xpath("./span")).getText();
        return issueStatusBtn.findElement(By.xpath("./span")).getText();
    }

    public void clickStatusInStatusDropdown(String status){
        String path = "//*[@id=\"opsbar-transitions_more_drop\"]/aui-section[1]/div//a[div/div[3]/span[text() = '" + status + "']]";
        DriverFactory.getDriver().findElement(By.xpath(path)).click();
    }

    public void clickBacklogInSideBar(){
        backlogBtn.click();
    }

    public void clickBoardBtn(){
        Duration duration = Duration.ofSeconds(3);
        new WebDriverWait(DriverFactory.getDriver(), duration).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"gh\"]/div[@class = 'ghx-throbber']")));
        boardBtn.click();
    }

    public void clickConfigureOptionInBoardDropDown(){
        configureOptionInBoardDropDown.click();
    }

    public void clickColumnsBtnInConfigNav(){
        columnsBtnInConfigNav.click();
    }

    public boolean isColumnMgmtTitleDisplayed(){
        return columnMgmtTitle.isDisplayed();
    }

    public void clickAddColumnBtn(){
        addColumnBtn.click();
    }

    public void enterColumnName(String name){
        columnName.sendKeys(name);
    }

    public void selectColumnCategory(String category){
        if (columnCategory.getText() != category){
            columnCategory.click();
            List<WebElement> options = columnCategoryDropDown.findElements(By.xpath("./li/a"));
            options.stream()
                  .filter(option -> option.getText().equals(category))
                  .findFirst()
                  .ifPresent(WebElement::click);
        }
    }

    public void clickAddBtnInAddColumnDialog(){
        addBtnInAddColumnDialog.click();
    }

    public WebElement findColumnInMappingColumns(String name){
        try{
            String path = "//*[@id=\"ghx-mapping-columns\"]/ul[.//h3[text() = '" + name + "']]";
            WebElement column = DriverFactory.getDriver().findElement(By.xpath(path));
            return column;
        } catch (NoSuchElementException e){
            return null;
        }
        //String path = "//*[@id=\"ghx-mapping-columns\"]/ul[.//h3[text() = '" + name + "']]";
        //return DriverFactory.getDriver().findElement(By.xpath(path));
    }


    public void changeColumnNameInMappingColumns(String src, String target){
        List<WebElement> columns = DriverFactory.getDriver().findElements(By.xpath("//*[@id=\"ghx-mapping-columns\"]/ul"));
        String path = ".//h3";
        for (WebElement column : columns){
            WebElement header = column.findElement(By.xpath(path));
            if (header.getText().equals(src)){
                header.click();
                WebElement columnNameInput = column.findElement(By.xpath(".//input"));
                columnNameInput.sendKeys(target);
                columnNameInput.sendKeys(Keys.RETURN);
                break;
            }
        }
    }

    // 0-index
    public void dragAndDropColumnInMappingColumns(String column, int index){
        String moveIconPath = ".//div[@class = \"ghx-config-operator\"]";
        String borderLinePath = ".//div[@class = \"ghx-border-bottom\"]";
        String deletePath = ".//div[@class = \"ghx-action ghx-config-delete\"]";
        WebElement sourceElement = findColumnInMappingColumns(column).findElement(By.xpath(deletePath));
        WebElement targetElement = findColumnInMappingColumns(index).findElement(By.xpath(borderLinePath));

        Actions action = new Actions(DriverFactory.getDriver());
        action.dragAndDrop(sourceElement, targetElement).perform();

//        // Create an instance of the Actions class
//        Actions actions = new Actions(DriverFactory.getDriver());
//
//        // Get the initial position of the source element
//        int startX = sourceElement.getLocation().getX();
//        int startY = sourceElement.getLocation().getY();
//
//        // Get the target position of the target element
//        int targetX = targetElement.getLocation().getX();
//        int targetY = targetElement.getLocation().getY();
//
//        // Calculate the offsets to move the cursor smoothly
//        int xOffset = (int) ((targetX - startX) / 10.0 * 1.5);
//        int yOffset = (int) ((targetY - startY) / 10.0 * 1.2);
//
//        // Perform smooth drag-and-drop
//        actions.clickAndHold(sourceElement);
//
//        for (int i = 0; i < 10; i++){
//            actions.moveByOffset(xOffset, yOffset).pause(300); // Adjust the duration of the pause as needed
//        }
//        actions.release().build().perform();


    }

    public WebElement findColumnInMappingColumns(int index){
        String path = "//*[@id=\"ghx-mapping-columns\"]/ul[" + (index + 1) + "]";
        return DriverFactory.getDriver().findElement(By.xpath(path));
    }

    public void deleteColumnInMappingColumns(String name){
        WebElement column = findColumnInMappingColumns(name);
        column.findElement(By.xpath(".//div[@class = 'ghx-action ghx-config-delete']")).click();
    }

        /*
    @FindBy(xpath = "")
    public WebElement ;
    * */
}
//*[@id="ghx-mapping-columns"]/ul[.//h3[text() = 'column 1']]