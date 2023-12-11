package apiTest.stepDef.a1userMgmt;

import apiTest.enity.User;
import apiTest.niuAPI.BaseAPI;
import apiTest.niuAPI.UserAPI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class UserMgmtStepDef{

    public static final ThreadLocal<Response> loginResponse = new ThreadLocal<>();
    private static final ThreadLocal<User> curUser = new ThreadLocal<>();
    private final BaseAPI baseAPI = new BaseAPI();

    @When("the user logs in with with username {string} and password {string}")
    public void theUserLogsInWithCredentialsUsernameUsernameAndPasswordPassword(String username, String password){
        User user = User.builder()
              .username(username)
              .password(password)
              .build();

        loginResponse.set(
              new UserAPI().loginWithCredential(user)
        );
        curUser.set(user);

    }


    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int code){
        baseAPI.checkResponseStatusCode(loginResponse.get(), code);
    }
}