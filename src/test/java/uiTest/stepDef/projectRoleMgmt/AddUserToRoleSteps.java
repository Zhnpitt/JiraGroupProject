package uiTest.stepDef.projectRoleMgmt;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import uiTest.drivers.DriverFactory;
import uiTest.pageObjects.projectRoleMgmtPO.AddUserToRolePO;

import java.util.List;

public class AddUserToRoleSteps {
    WebDriver driver;
    AddUserToRolePO addUserToRolePO;
    String name;
    String role;
    String projectKey = "";
    String URL = "http://localhost:8080/plugins/servlet/project-config/" + projectKey + "/roles";
    public AddUserToRoleSteps(String name, String role ){
        this.name = name;
        this.role = role;
        driver = DriverFactory.getDriver();
        addUserToRolePO = new AddUserToRolePO();
    }

    @Given("I am on the Project settings page")
    public void I_am_on_the_Project_settings_page(){
        driver.navigate().to(URL);
    }

    @When("I click Add users to a role button")
    public void I_click_Add_users_to_a_role_button(){
        addUserToRolePO.clickAddUsersToARoleButton();
    }
    @And("select a user and a role")
    public void select_a_user_and_a_role (String name, String role){
        addUserToRolePO.inputName(name);
        addUserToRolePO.selectAName();
        addUserToRolePO.selectRoleContainer();
        addUserToRolePO.chooseARole();
    }
    @And("click Add button")
    public void click_Add_button(){
        addUserToRolePO.clickAddButton();
    }

    @Then("I can see user information and role in this page")
    public void I_can_see_user_information_and_role_in_this_page(){
        boolean find = false;
        String xpath = "//table[@class='sc-fAjcbJ hduqMu']/tbody/tr[.//div[contains(text(),'" +name+"')] and .//span[contains(text(),'" + role + "')]]";
        List<WebElement> matchingElements = driver.findElements(By.xpath(xpath));
        Assert.assertFalse(matchingElements.isEmpty());

    }

}
