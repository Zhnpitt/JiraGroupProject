package uiTest.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

//http://localhost:8080/secure/admin/workflows/ViewWorkflowSteps.jspa
public class ViewWorkflowStepsPO extends BasePO {

    @FindBy(xpath = "//a[@id = \"workflow-text\"]")
    public WebElement workflowsTextBtn;

    @FindBy(xpath = "//form[@id=\"workflow-step-add\"]/div[1]/div[1]/input")
    public WebElement stepName;


    @FindBy(xpath = "//form[@id=\"workflow-step-add\"]/div[1]/div[2]/select")
    public WebElement linkedStatus;

    @FindBy(xpath = "//button[@id=\"workflow-step-add-submit\"]")
    public WebElement workflowStepAddSubmitBtn;

    @FindBy(xpath = "//a[@id = \"workflows\"]")
    public WebElement workflowsBtn;



    public void clickWorkflowsTextBtn(){
        workflowsTextBtn.click();
    }
    public void enterStepName(String s) {
        stepName.sendKeys(s);
    }
    public void enterLinkedStatus(String s){
        Select statusDropDownMenu = new Select(linkedStatus);
        statusDropDownMenu.selectByVisibleText(s);
    }
    public void clickWorkflowStepAddSubmitBtn(){
        workflowStepAddSubmitBtn.click();
    }
    public void clickWorkflowBtn(){workflowsBtn.click();}
    @FindBy(xpath = "//tbody/tr[last()]//a[text() = 'Add transition']")
    public WebElement lastStepTransitionBtn;

    @FindBy(xpath = "//*[@id=\"add-workflow\"]//label[text() = \"Transition Name\"]/parent::div/input")
    public WebElement workflowTransitionName;
    @FindBy(xpath = "//form[@id=\"add-workflow\"]//label[text() = 'Destination Step']/following-sibling::Select")
    public WebElement workflowDestStep;
    @FindBy(xpath = "//button[@id=\"add-workflow-submit\"]")
    public WebElement workflowTransitionAddBtn;
    public void setStepDestination(String dest,String transitionName){
        lastStepTransitionBtn.click();
        workflowTransitionName.sendKeys(transitionName);
        Select destDropDownMenu = new Select(workflowDestStep);
        destDropDownMenu.selectByVisibleText(dest);
        workflowTransitionAddBtn.click();
    }
}