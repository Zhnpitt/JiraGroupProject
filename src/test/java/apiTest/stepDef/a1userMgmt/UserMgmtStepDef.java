package apiTest.stepDef.a1userMgmt;

import apiTest.niuAPI.GroupAPI;
import apiTest.niuAPI.SessionAPI;
import apiTest.niuAPI.UserAPI;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.Map;

import static org.testng.Assert.assertTrue;

public class UserMgmtStepDef{

    //public static final ThreadLocal<Response> loginResponse = new ThreadLocal<>();
    public static final ThreadLocal<Response> curResponse = new ThreadLocal<>();
    //private static final ThreadLocal<User> curUser = new ThreadLocal<>();
    private static final ThreadLocal<Map<String, String>> cookie = new ThreadLocal<Map<String, String>>();
    private final UserAPI userAPI = new UserAPI();
    private final SessionAPI sessionAPI = new SessionAPI();
    private final GroupAPI groupAPI = new GroupAPI();

    @When("the user logs in with with username {string} and password {string}")
    public void theUserLogsInWithCredentialsUsernameUsernameAndPasswordPassword(String username, String password){

        curResponse.set(new SessionAPI().loginWithCredential(username, password));
        cookie.set(curResponse.get().cookies());
        userAPI.setCookie(curResponse.get().cookies());
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
        userJson.put("userName", userName);
        userJson.put("password", password);
        userJson.put("emailAddress", emailAddress);
        userJson.put("displayName", fullName);
        userJson.put("applicationKeys", applicationKeys);
        userAPI.setCookie(curResponse.get().getCookies());
        curResponse.set(userAPI.createUser(userJson));
    }

    @When("the admin user login")
    public void theAdminUserLogIn(){
        curResponse.set(sessionAPI.adminLoginWithCredential());
        cookie.set(curResponse.get().cookies());
    }


    @When("I deactivate user {string}")
    public void iDeactivateUserUserName(String curName){
        JSONObject updateBody = new JSONObject();
        updateBody.put("active", "false");
        userAPI.setCookie(curResponse.get().getCookies());
        curResponse.set(userAPI.updateUser(curName, updateBody));
    }

    @When("the user login with {string} and {string}")
    public void theUserLoginWithUserNameAndPassword(String userName, String password){
        sessionAPI.setCookie(curResponse.get().getCookies());
        curResponse.set(sessionAPI.loginWithCredential(userName, password));
    }


    @When("I find user {string} by inactive status")
    public void iFindUsersByInactiveStatus(String user){
        userAPI.setCookie(curResponse.get().getCookies());
        curResponse.set(userAPI.findUsersByStatus(false, user));
    }

    @And("I should see {string} in result set")
    public void iShouldSeeUserNameInResultSet(String userName){
        assertTrue(curResponse.get() != null && curResponse.get().jsonPath().get("name") == userName);
    }

//    private boolean containUserWithName(String jsonArrayString, String username){
//        JSONArray jsonArray = new JSONArray(jsonArrayString);
//        return Arrays.stream(jsonArray.toList().toArray()).map(JSONObject::new).anyMatch(jsonObject -> jsonObject.getString("name").equals(username));
//    }

    @When("I add user {} to group {}")
    public void iAddTheUserUserNameToGroupUserGroup(String userName, String userGroup){
        groupAPI.setCookie(curResponse.get().getCookies());
        JSONObject body = new JSONObject();
        body.put("name", userName);
        groupAPI.setCookie(curResponse.get().getCookies());
        curResponse.set(groupAPI.addUserToGroup(userGroup, body));
    }

    @When("I get users from group {}")
    public void iGetUserUserNameFromGroupUserGroup(String userGroup){
        groupAPI.setCookie(curResponse.get().getCookies());
        curResponse.set(groupAPI.getUserToGroup(userGroup));
    }
}