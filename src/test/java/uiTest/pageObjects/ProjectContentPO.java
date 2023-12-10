package uiTest.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import uiTest.drivers.DriverFactory;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
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

    public void clickSprintMoreBtn(String sprintName){
        String path = "//*[@id=\"ghx-content-group\"]/div[1]/div[./div/div[@class = 'ghx-name']/span[text() = '" + sprintName + "']]//a[@aria-label= \"More actions for {0}\"]";
        DriverFactory.getDriver().findElement(By.xpath(path)).click();
    }

    @FindBy(xpath = "//*[@id=\"sidebar\"]//a[span[text() = 'Active sprints'] ]")
    public WebElement activeSprintsInSideBar;

    public void clickActiveSprintsInSideBar(){
        activeSprintsInSideBar.click();
    }

    @FindBy(xpath = "//*[@id=\"ghx-complete-sprint\"]")
    public WebElement completeSprintBtn;

    public void clickCompleteSprintBtn(){
        completeSprintBtn.click();
    }

    @FindBy(xpath = "//*[@id=\"ghx-dialog-complete-sprint\"]//button[text() = 'Complete']")
    public WebElement completeBtnInCompleteSprintDialog;

    public void clickCompleteBtnInCompleteSprintDialog(){
        completeBtnInCompleteSprintDialog.click();
    }

    @FindBy(xpath = "//*[@id=\"sidebar\"]//a[span[text() = 'Reports'] ]")
    public WebElement reportsInSidebar;

    public void clickReportsInSidebar(){
        reportsInSidebar.click();
    }

    @FindBy(xpath = "//*[@id='subnav-trigger-reports']")
    public WebElement switchReportBtn;

    public void clickSwitchReportBtn(){
        switchReportBtn.click();
    }

    @FindBy(xpath = "//*[@id=\"subnav-opts-reports\"]//ul/li/a[text() = 'Velocity Chart']")
    public WebElement velocityChartInSwitchReportDropdown;

    public void clickVelocityChartInSwitchReportDropdown(){
        velocityChartInSwitchReportDropdown.click();
    }

    public void changeTimeFrameInVelocityChart(String lengthInMonth){
        int length = Integer.parseInt(lengthInMonth);
        String path = "//*[@id='velocity-chart-timeframes']//aui-item-radio[span[text() = '" + length + " months']]";
        DriverFactory.getDriver().findElement(By.xpath(path)).click();

    }

    @FindBy(xpath = "//*[@id=\"js-apply-btn\"]")
    public WebElement timeframeApplyBtn;

    public void clickTimeframeApplyBtn(){
        timeframeApplyBtn.click();
    }

//    @FindBy(xpath = "")
//    public WebElement velocityChartCanvas;

    public void downloadVelocityChart(String filename){
        captureCanvasAsImage(DriverFactory.getDriver(), filename);
    }

    private static void captureCanvasAsImage(WebDriver driver, String imageName){
        // Use JavaScript to capture the canvas content as base64 image data
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String imageData = (String) js.executeScript(
              "var canvas = document.querySelector('[data-zr-dom-id=\"zr_0\"]');" +
                    "return canvas.toDataURL('image/png').replace(/^data:image\\/png;base64,/, '');");

        byte[] imageBytes = DatatypeConverter.parseBase64Binary(imageData);

        BufferedImage originalImage = null;
        try{
            originalImage = ImageIO.read(new ByteArrayInputStream(imageBytes));
            BufferedImage newImage = new BufferedImage(
                  originalImage.getWidth(), originalImage.getHeight(),
                  BufferedImage.TYPE_INT_RGB);

            Graphics2D graphics = newImage.createGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, newImage.getWidth(), newImage.getHeight());
            graphics.drawImage(originalImage, 0, 0, null);

            ImageIO.write(newImage, "png", new File(imageName));

        } catch (IOException e){
            e.printStackTrace();
        }
    }


    @FindBy(xpath = "//*[@id=\"configure-velocity-chart-form\"]/button[@aria-controls='velocity-chart-timeframe-dropdown']")
    public WebElement timeframeBtn;

    public void clickTimeframeBtn(){
        timeframeBtn.click();
    }
        /*
    @FindBy(xpath = "")
    public WebElement ;
    * */
}