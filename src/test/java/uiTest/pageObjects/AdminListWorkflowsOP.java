package uiTest.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//http://localhost:8080/secure/admin/workflows/ListWorkflows.jspa
public class AdminListWorkflowsOP extends BasePO {

    @FindBy(xpath = "//a[@id = \"add-workflow\"]")
    public WebElement addWorkflowBtn;

    @FindBy(xpath = "//input[@id = \"add-workflow-newWorkflowName\"]")
    public WebElement workflowName;
    @FindBy(xpath = "//input[@id = \"add-workflow-description\"]")
    public WebElement description;

    @FindBy(xpath = "//button[@id = \"add-workflow-submit\"]")
    public WebElement workflowFormAddBtn;

    public void clickAddWorkflowBtn(){addWorkflowBtn.click();}

    public void enterWorkflowName(String s){
        workflowName.sendKeys(s);
    }

    public void  enterDescription(String s){
        description.sendKeys(s);
    }

    public void clickWorkflowFormAddBtn(){
        workflowFormAddBtn.click();
    }


}
