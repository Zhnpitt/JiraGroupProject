package uiTest.stepDef.workflowMgmt;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import uiTest.constants.URL;
import uiTest.drivers.DriverFactory;
import uiTest.pageObjects.BrowseProjectsPO;
import uiTest.pageObjects.DashBoardPO;
import uiTest.pageObjects.ProjectContentPO;

import static org.testng.Assert.*;

public class ColumnEditStepDef{
    DashBoardPO dashBoardPO = new DashBoardPO();
    BrowseProjectsPO browseProjectsPO = new BrowseProjectsPO();
    ProjectContentPO projectContentPO = new ProjectContentPO();

    @When("I click Backlog in sidebar")
    public void iClickBacklogInSidebar(){
        projectContentPO.clickBacklogInSideBar();
    }

    @And("I click Board btn in Backlog")
    public void iClickBoardBtnInBacklog(){
        projectContentPO.clickBoardBtn();
    }

    @And("I click Configure in Board drop down")
    public void iClickConfigureInBoardDropDown(){
        projectContentPO.clickConfigureOptionInBoardDropDown();
    }

    @Then("I should view Rapid View page")
    public void iShouldViewRapidViewPage(){
        //assertEquals(URL.removeQueryString(DriverFactory.getDriver().getCurrentUrl()), URL.RapidView.toString());
        assertTrue(DriverFactory.getDriver().getCurrentUrl().contains(URL.RapidView.toString()));
    }

    @When("I click Columns in Configuration sidebar")
    public void iClickColumnsInConfigurationSidebar(){
        projectContentPO.clickColumnsBtnInConfigNav();
    }

    @Then("I should see Column management content")
    public void iShouldSeeColumnManagementContent(){
        assertTrue(projectContentPO.isColumnMgmtTitleDisplayed());
    }

    @Then("I should see issue in different column")
    public void iShouldSeeIssueInDifferentColumn(){
        //TODO create a project with issue
    }

    @When("I add a new column with {string} and {string}")
    public void iAddANewColumnWithColumnNameAndCategory(String columnName, String category){
        projectContentPO.clickAddColumnBtn();
        projectContentPO.enterColumnName(columnName);
        projectContentPO.selectColumnCategory(category);
        projectContentPO.clickAddBtnInAddColumnDialog();
    }

    @Then("I should see column with name {string}")
    public void iShouldSeeColumnWithNameColumnName(String columnName){
        assertNotNull(projectContentPO.findColumnInMappingColumns(columnName));
    }


    @When("I change column {string} to {string}")
    public void iChangeColumnColumnNameToNewColumnName(String columnName, String newColumnName){
        projectContentPO.changeColumnNameInMappingColumns(columnName, newColumnName);
    }

    @When("I move column {string} to the leftmost position")
    public void iMoveColumnNewColumnNameToTheLeftmostPosition(String name){
        projectContentPO.dragAndDropColumnInMappingColumns(name, 0);
    }

    @Then("I can see column {string} at index {string}")
    public void iCanSeeColumnNewColumnNameAtIndex(String name, String index){
        assertEquals(projectContentPO.findColumnInMappingColumns(Integer.parseInt(index)).findElement(By.xpath(".//h3")).getText(), name);
    }

    @When("I delete column {string}")
    public void iDeleteColumnColumnName(String name){
        projectContentPO.deleteColumnInMappingColumns(name);
    }

    @Then("i should not see {string}")
    public void iShouldNotSeeColumnName(String name){
        assertNull(projectContentPO.findColumnInMappingColumns(name));
    }
}