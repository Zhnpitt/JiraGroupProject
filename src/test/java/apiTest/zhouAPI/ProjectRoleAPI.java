package apiTest.zhouAPI;

import apiTest.constants.ApiURL;
import apiTest.enity.Permission;
import apiTest.enity.PermissionScheme;
import apiTest.enity.Project;
import apiTest.enity.ProjectRole;
import apiTest.niuAPI.BaseAPI;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProjectRoleAPI extends BaseAPI {

//    public ProjectRoleAPI(){
//        requestSpec.basePath("/rest/api/2/project");
//    }

    //create a project
    public Response createAProject(Project project){
        Response response = given(requestSpec)
                .auth().preemptive().basic("zhoulikekk", "Whou3344603~")
                .body(project)
                .post(ApiURL.CreateProject.toString());
        response.then()
                .spec(responseSpec);
        return response;
    }
    public Response sendNewRole(ProjectRole projectRole){
        Response response = given(requestSpec)
                .auth().preemptive().basic("zhoulikekk", "Whou3344603~")
                .body(projectRole)
                .when()
                .post(ApiURL.CreatePRJRole.toString());
        response.then()
                .spec(responseSpec);
        System.out.println(projectRole);
        return response;
    }
    public String getRoleID(String roleName){
        Response response = given(requestSpec)
                .auth().preemptive().basic("zhoulikekk", "Whou3344603~")
                .when()
                .get("http://localhost:8080/rest/api/2/project/PROJ/role");

        JSONObject jsonObject = new JSONObject(response.asString());
        String roleURL = jsonObject.getString(roleName);
        String ID = roleURL.substring(roleURL.lastIndexOf('/') + 1);
        return ID;
    }
    public String getUserKey(String userName){
        String paramString = "?username=" + userName;
        Response response = given(requestSpec)
                .auth().preemptive().basic("zhoulikekk", "Whou3344603~")
                .when()
                .get(ApiURL.GetUserKey.toString()+paramString);

        JSONArray jsonArray = new JSONArray(response.asString());
        JSONObject jsonObject = (JSONObject) jsonArray.get(0);
        String userKey = jsonObject.getString("key");

        return userKey;

    }
    public Response addUserToRole(String userKey, String id){

        String[] applicationKeys = {userKey};
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user", applicationKeys);

        Response response = given(requestSpec)//base + URL
                .auth().preemptive().basic("zhoulikekk", "Whou3344603~")
                .body(jsonObject.toString())
                .pathParam("id",id)
                .when()
                .post(ApiURL.AddUserToRole.toString());
        //AddUserToRole("/rest/api/2/role/{id}/actors"),
        response.then().log().body();
        return response;
    }
    public Response filterUserByRole(String id){
        Response response = given(requestSpec)
                .auth().preemptive().basic("zhoulikekk", "Whou3344603~")
                .pathParam("projectIdOrKey", "PROJ")
                .pathParam("id", id)
                .when()
                .get(ApiURL.GetUserInRole.toString());
        response.then()
                .spec(responseSpec);
        return response;
    }
    public List<String> findNameInResponse(String response) {
        List<String> result = new ArrayList<>();
        // 将响应字符串转换为 JSONObject
        JSONObject responseObject = new JSONObject(response);
        // 访问 "actors" 数组
        JSONArray actors = responseObject.getJSONArray("actors");

        String roleName = responseObject.getString("name");
        // 遍历数组查找 "name"
        for (int i = 0; i < actors.length(); i++) {
            JSONObject actor = actors.getJSONObject(i);
            String name = actor.getString("name");
            result.add(name);
            System.out.println(name + " is " + roleName);
        }
        return result;
    }
    private static int permissionSchemeID;
    public Response createPermissionScheme(PermissionScheme permissionScheme){
        Response response = given(requestSpec)
                .auth().preemptive().basic("zhoulikekk", "Whou3344603~")
                .body(permissionScheme)
                .when()
                .post(ApiURL.CreatePermissionScheme.toString());
        response.then()
                .spec(responseSpec);

        JSONObject jsonObject = new JSONObject(response.asString());
        permissionSchemeID = jsonObject.getInt("id");
        System.out.println(permissionSchemeID);
        return response;
    }
    public int getPermissionSchemeID(String schemeName){
        Response response = given(requestSpec)
                .auth().preemptive().basic("zhoulikekk", "Whou3344603~")
                .when()
                .get("http://localhost:8080/rest/api/2/permissionscheme");

        JSONObject jsonObject = new JSONObject(response.asString());
        JSONArray jsonArray = jsonObject.getJSONArray("permissionSchemes");

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject scheme = jsonArray.getJSONObject(i);
            String name = scheme.getString("name");
            if (name.equals(schemeName)) {
                // 返回找到的 ID
                return scheme.getInt("id");
            }
        }
        return -1;
    }
    public Response createPermissionGrant(Permission permission, int schemeID){
        //CreatePermissionGrant("/rest/api/2/permissionscheme/{schemeId}/permission"),
        Response response = given(requestSpec)
                .auth().preemptive().basic("zhoulikekk", "Whou3344603~")
                .pathParam("schemeId", schemeID)
                .body(permission)
                .when()
                .post(ApiURL.CreatePermissionGrant.toString());
        response.then()
                .spec(responseSpec);

        return response;
    }
    public Response upDateProjectScheme(int SchemeID, String projectKey){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("permissionScheme", SchemeID);

        Response response = given(requestSpec)
                .auth().preemptive().basic("zhoulikekk", "Whou3344603~")
                .body(jsonObject.toString())
                .pathParam("projectIdOrKey", projectKey)
                .when()
                .put(ApiURL.UpdateScheme.toString());

        response.then()
                .spec(responseSpec);

        return response;

    }

    //create Epics
    public Response createEpic(String type, String summary, String projectKey){

        JSONObject jsonObject = new JSONObject();

        JSONObject fields = new JSONObject();
        JSONObject project = new JSONObject();
        JSONObject issueType = new JSONObject();


        project.put("key", projectKey);
        issueType.put("name", type);

        fields.put("project", project);
        fields.put("issuetype", issueType);
        fields.put("summary", summary);
        fields.put("customfield_10104",summary);
        jsonObject.put("fields",fields);


        Response response = given(requestSpec)
                .auth().preemptive().basic("John Doe", "password123")
                .body(jsonObject.toString())
                .when()
                .post(ApiURL.CreateIssue.toString());
        response.then().spec(responseSpec);
        return response;
    }

}
