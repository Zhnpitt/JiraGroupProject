package apiTest.stepDef.a1userMgmt;

import apiTest.niuAPI.GroupAPI;
import apiTest.niuAPI.SessionAPI;
import apiTest.niuAPI.UserAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertTrue;

public class UserMgmtStepDef{

    public static final ThreadLocal<Response> curResponse = new ThreadLocal<>();
    private static final ThreadLocal<Map<String, String>> cookie = new ThreadLocal<Map<String, String>>();
    private final UserAPI userAPI = new UserAPI();
    private final SessionAPI sessionAPI = new SessionAPI();
    private final GroupAPI groupAPI = new GroupAPI();

    @When("the user logs in with with username {string} and password {string}")
    public void theUserLogsInWithCredentialsUsernameUsernameAndPasswordPassword(String username, String password){
        curResponse.set(new SessionAPI().loginWithCredential(username, password));
        cookie.set(curResponse.get().cookies());
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int code){
        curResponse.get().then().statusCode(code);
    }

    @When("I create a user {string} {string} {string} {string}")
    public void iCreateAUserUserNameFullNameEmailPassword(String userName, String fullName, String emailAddress, String password){
        //display name = full name
        String[] applicationKeys = {"jira-core"};
        JSONObject userJson = new JSONObject();
        userJson.put("name", userName);
        userJson.put("password", password);
        userJson.put("emailAddress", emailAddress);
        userJson.put("displayName", fullName);
        userJson.put("applicationKeys", applicationKeys);
        curResponse.set(userAPI.createUser(userJson));
    }

    @When("I log in as admin user")
    public void iLogInAsAdminUser(){
        curResponse.set(sessionAPI.adminLoginWithCredential());
    }

    @When("I deactivate user {string}")
    public void iDeactivateUserUserName(String curName){
        JSONObject updateBody = new JSONObject();
        updateBody.put("active", "false");
        curResponse.set(userAPI.updateUser(curName, updateBody));
    }

    @When("the user login with {string} and {string}")
    public void theUserLoginWithUserNameAndPassword(String userName, String password){
        curResponse.set(sessionAPI.loginWithCredential(userName, password));
    }


    @When("I find user {string} by inactive status")
    public void iFindUsersByInactiveStatus(String user){
        curResponse.set(userAPI.findUsersByStatus(false, user));
    }

    @And("I should see {string} in status result set")
    public void iShouldSeeUserNameInResultSet(String userName){
        JsonPath jsonPath = curResponse.get().jsonPath();
        boolean isExisted = false;
        for (int i = 0; i < jsonPath.getInt("size()"); i++){
            if (jsonPath.getString("[" + i + "].name").equals(userName)){
                isExisted = true;
            }
        }
        assertTrue(isExisted);
    }

    @When("I add user {string} to group {string}")
    public void iAddTheUserUserNameToGroupUserGroup(String userName, String userGroup){
        JSONObject body = new JSONObject();
        body.put("name", userName);
        curResponse.set(groupAPI.addUserToGroup(userGroup, body));
    }

    @When("I get users from group {string}")
    public void iGetUserUserNameFromGroupUserGroup(String userGroup){
        curResponse.set(groupAPI.getUserFromGroup(userGroup));
    }

    @Then("I should see {string} in group result set")
    public void iShouldSeeUserNameInGroupResultSet(String username){
        List<String> names = curResponse.get().jsonPath().getList("values.name", String.class);
        assertTrue(names.contains(username));
    }
}