package uiTest.stepDef.login;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import uiTest.constants.URL;
import uiTest.drivers.DriverFactory;
import uiTest.pageObjects.LoginPO;

public class LoginStepDef {
    private LoginPO loginPO;

    @Given("I visit the Login page")
    public void iVisitTheLoginPage() {
        DriverFactory.getDriver().navigate().to(URL.DashBoard.toString());
        loginPO = new LoginPO();
    }

    @When("I enter the username {string}")
    public void iEnterTheUsername(String username) {
        loginPO.enterUsername(username);
    }

    @And("I enter the password {string}")
    public void iEnterThePassword(String password) {
        loginPO.enterPassword(password);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPO.clickLoginButton();
    }

}
