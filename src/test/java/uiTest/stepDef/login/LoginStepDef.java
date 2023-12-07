package uiTest.stepDef.login;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uiTest.constants.URL;
import uiTest.drivers.DriverFactory;
import uiTest.pageObjects.LoginPO;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class LoginStepDef {
    private final LoginPO loginPO = new LoginPO();
    @Given("I visit the login page")
    public void iVisitTheLoginPage() {
        DriverFactory.getDriver().manage().deleteAllCookies();
        DriverFactory.getDriver().navigate().to(URL.Login.toString());
        assertEquals(DriverFactory.getDriver().getCurrentUrl(), URL.Login.toString());
    }

    @When("I enter the admin username and password")
    public void iEnterTheAdminUsernameAndPassword(DataTable usercredentials) {
        List<Map<String, String>> data = usercredentials.asMaps(String.class, String.class);
        loginPO.enterUsername(data.get(0).get("username"));
        loginPO.enterPassword(data.get(0).get("password"));
    }

    @When("I enter the {string} and {string}")
    public void iEnterTheUsernameAndPassword(String username, String password) {
        loginPO.enterUsername(username);
        loginPO.enterPassword(password);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPO.clickLoginButton();
    }

    @Then("I should view the dashboard")
    public void iShouldViewTheDashBoardPage() {
        assertEquals(DriverFactory.getDriver().getCurrentUrl(),
              URL.DashBoard.toString());
    }
}
