package uiTest.stepDef.projectRoleMgmt;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import uiTest.drivers.DriverFactory;
import uiTest.pageObjects.projectRoleMgmtPO.ProjectRolesPO;

import java.util.List;

public class CreateRoleSteps {
    private final WebDriver driver;
    private final ProjectRolesPO projectRolesPO;


    String roleName = "team lead";
    String roleDesc = "manage sprints, assign issues";

    public CreateRoleSteps(){
        driver = DriverFactory.getDriver();
        projectRolesPO = new ProjectRolesPO();

    }

    @Given("I am on the Project Role Browser page")
    public void I_am_on_the_Project_Role_Browser_page(){
        driver.navigate().to("http://localhost:8080/secure/project/ViewProjectRoles.jspa");
    }

    @When("I enter the valid Role Name and Description")
    public void I_enter_the_valid_Role_Name_and_Description(){
        projectRolesPO.enterRoleName(roleName);
        projectRolesPO.setInputRoleDescription(roleDesc);
    }

    @And("click the Add Project Role button")
    public void click_the_Add_Project_Role_button(){
        projectRolesPO.clickAddRoleBtn();
    }

    @Then("I should get a new role in Project Role Browser")
    public void I_should_get_a_new_role_in_Project_Role_Browser(){
        String xpathExpression = "//tbody/tr[.//td[contains(text(),'" + roleName + "')] and .//td[contains(text(),'" + roleDesc + "')]]";
        List<WebElement> matchingElements = driver.findElements(By.xpath(xpathExpression));
        Assert.assertFalse( matchingElements.isEmpty());
    }
}
