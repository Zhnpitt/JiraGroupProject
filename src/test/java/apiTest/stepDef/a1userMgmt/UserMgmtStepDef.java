package apiTest.stepDef.a1userMgmt;

import apiTest.enity.User;
import apiTest.niuAPI.BaseAPI;
import apiTest.niuAPI.UserAPI;
import apiTest.niuAPI.a1userMgmt.UserMgmtAPI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.Map;

public class UserMgmtStepDef{

    //public static final ThreadLocal<Response> loginResponse = new ThreadLocal<>();
    public static final ThreadLocal<Response> curResponse = new ThreadLocal<>();
    private static final ThreadLocal<User> curUser = new ThreadLocal<>();
    private static final ThreadLocal<Map<String, String>> cookie = new ThreadLocal<Map<String, String>>();
    private final BaseAPI baseAPI = new BaseAPI();
    private final UserMgmtAPI userMgmtAPI = new UserMgmtAPI();

    @When("the user logs in with with username {string} and password {string}")
    public void theUserLogsInWithCredentialsUsernameUsernameAndPasswordPassword(String username, String password){
        User user = User.builder()
              .username(username)
              .password(password)
              .build();

        curResponse.set(
              new UserAPI().loginWithCredential(user)
        );
        curUser.set(user);
        cookie.set(curResponse.get().cookies());
    }


    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int code){
        baseAPI.checkResponseStatusCode(curResponse.get(), code);
    }

    @When("I create a user {string} {string} {string} {string}")
    public void iCreateAUserUserNameFullNameEmailPassword(String userName, String fullName, String emailAddress, String password){
        //display name = full name
        String[] applicationKeys = {"jira-core"};
        JSONObject userJson = new JSONObject();
        userJson.put("userName", userName);
        userJson.put("password", password);
        userJson.put("emailAddress", emailAddress);
        userJson.put("displayName", fullName);
        userJson.put("applicationKeys", applicationKeys);

        curResponse.set(userMgmtAPI.createUser(cookie.get(), userJson));
    }
}