package uiTest.stepDef.projectRoleMgmt;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import uiTest.drivers.DriverFactory;
import uiTest.pageObjects.projectRoleMgmtPO.FilterUsersByRolePO;

import java.util.List;

public class FilterUsersByRoleSteps {
    WebDriver driver;
    FilterUsersByRolePO filterUsersByRolePO;
    String name = "John Doe";
    String role = "Administrators";
    String projectKey = "";
    String URL = "http://localhost:8080/plugins/servlet/project-config/" + projectKey + "/roles";

    public FilterUsersByRoleSteps(){
        driver = DriverFactory.getDriver();
        filterUsersByRolePO = new FilterUsersByRolePO();
    }

    @Given("I am on the Project settings page")
    public void I_am_on_the_Project_settings_page(){
        driver.navigate().to(URL);
    }

    @When("I click the Roles button")
    public void I_click_the_Roles_button(){
        filterUsersByRolePO.clickRolesButton();
    }

    @And("select a role")
    public void select_a_role(){
        filterUsersByRolePO.selectARole();
        filterUsersByRolePO.clickRolesButton();
    }

    @Then("I can see users in the role in this project")
    public void I_can_see_users_in_the_role_in_this_project(){
        boolean allRight = true;
        String xpath = "//tr/td[position()=3]//span[@class = \"css-t5emrf\"]";
        List<WebElement> usersFound = driver.findElements(By.xpath(xpath));
        for (WebElement webElement : usersFound){
            if(!(webElement.getText().equals(role))){
                allRight = false;
                break;
            }
        }
        Assert.assertTrue(allRight);
    }
}
