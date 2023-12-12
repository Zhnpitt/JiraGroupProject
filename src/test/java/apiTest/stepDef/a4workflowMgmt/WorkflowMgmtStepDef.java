package apiTest.stepDef.a4workflowMgmt;

import apiTest.niuAPI.IssueAPI;
import apiTest.niuAPI.SearchAPI;
import apiTest.niuAPI.SessionAPI;
import apiTest.niuAPI.UserAPI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

public class WorkflowMgmtStepDef{
    public static final ThreadLocal<Response> curResponse = new ThreadLocal<>();
    public static final ThreadLocal<String> issueKey = new ThreadLocal<>();
    public static final ThreadLocal<String> issueId = new ThreadLocal<>();
    private static final ThreadLocal<Map<String, String>> cookie = new ThreadLocal<Map<String, String>>();
    private final UserAPI userAPI = new UserAPI();
    private final SessionAPI sessionAPI = new SessionAPI();
    private final IssueAPI issueAPI = new IssueAPI();
    private final SearchAPI searchAPI = new SearchAPI();

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int code){
        curResponse.get().then().statusCode(code);
        Map<String, String> cookies = curResponse.get().getCookies();
    }


    @When("I login with {string} and {string}")
    public void theUserLoginWithUsernameAndPassword(String username, String password){
        curResponse.set(sessionAPI.loginWithCredential(username, password));
        Map<String, String> cookies = curResponse.get().getCookies();
        System.out.println(cookies);
    }

    @When("I log in as admin user")
    public void iLogInAsAdminUser(){
        curResponse.set(sessionAPI.adminLoginWithCredential());
    }

    @When("admin user create a issue in project with projectKey {}")
    public void adminUserCreateAIssueInProjectWithProjectKeyPROJ(String projectKey){
        curResponse.set(issueAPI.createIssue(sampleIssue(projectKey)));
    }

    private JSONObject sampleIssue(String projectKey){
        String issueSummary = "Your Issue Summary";
        String issueDescription = "Your Issue Description";
        String issueTypeName = "Task";
        String priorityName = "High";

        JSONObject jsonObject = new JSONObject();

        JSONObject fieldsObject = new JSONObject();

        JSONObject projectObject = new JSONObject();
        projectObject.put("key", projectKey);

        fieldsObject.put("project", projectObject);
        fieldsObject.put("summary", issueSummary);
        fieldsObject.put("description", issueDescription);

        JSONObject issuetypeObject = new JSONObject();
        issuetypeObject.put("name", issueTypeName);

        JSONObject priorityObject = new JSONObject();
        priorityObject.put("name", priorityName);

        fieldsObject.put("issuetype", issuetypeObject);
        fieldsObject.put("priority", priorityObject);

        // Add the "fields" object to the main JSONObject
        jsonObject.put("fields", fieldsObject);
        return jsonObject;
    }

    @When("I change the issue status from {string} to {string}")
    public void iChangeTheIssueStatusFromPrevStatusToNextStatus(String prevStatus, String nextStatus){
        issueAPI.setCookies(curResponse.get().getCookies());
        Response transitionsResponse = issueAPI.getTransitions(issueId.get());
        String transitionId = transitionsResponse.jsonPath().getString("transitions.find { it.name == '" + nextStatus + "' }.id");

        JSONObject transitionBody = new JSONObject();
        JSONObject idJson = new JSONObject();
        idJson.put("id", transitionId);
        transitionBody.put("transition", idJson);
        curResponse.set(issueAPI.doTransition(issueId.get(), transitionBody));
    }

    @When("I find the {string} status issue in project with projectKey {}")
    public void iFindThePrevStatusIssueInProjectWithProjectKeyPROJ(String prevStatus, String projectKey){
        findIssueInProject(prevStatus, projectKey);
        List<String> s = curResponse.get().jsonPath().getList("issues.key", String.class);
        issueId.set(curResponse.get().jsonPath().getList("issues.id", String.class).get(0));
    }

    private void findIssueInProject(String prevStatus, String projectKey){
        String status = "status = \"" + prevStatus + "\"";
        String project = "project = " + projectKey;
        String jql = status + " AND " + project;

        Map<String, String> cookies = curResponse.get().getCookies();
        searchAPI.setCookies(curResponse.get().getCookies());
        curResponse.set(searchAPI.search(jql));

    }
}