package apiTest.zhouAPI;

import apiTest.constants.ApiURL;
import apiTest.enity.Permission;
import apiTest.enity.PermissionScheme;
import apiTest.enity.ProjectRole;
import apiTest.niuAPI.BaseAPI;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProjectRoleAPI extends BaseAPI {

//    public ProjectRoleAPI(){
//        requestSpec.basePath("/rest/api/2/project");
//    }

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

    public Response getRolesResponse(){
        Response response = given(requestSpec)
                .auth().preemptive().basic("zhoulikekk", "Whou3344603~")
                .when()
                .get("http://localhost:8080/rest/api/2/project/PROJ/role");
        response.then()
                .spec(responseSpec);

        return response;
    }
    public String getRoleID(Response response, String roleName){
        JSONObject jsonObject = new JSONObject(response.asString());
        String roleURL = jsonObject.getString(roleName);
        String ID = roleURL.substring(roleURL.lastIndexOf('/') + 1);
        return ID;
    }

    public Response addUserToRole(String userName, String id){

        String[] applicationKeys = {userName};
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user", applicationKeys);

        Response response = given(requestSpec)//base + URL
                .auth().preemptive().basic("zhoulikekk", "Whou3344603~")
                .body(jsonObject.toString())
                .pathParam("projectIdOrKey", "PROJ")
                .pathParam("id",id)
                .when()
                .post(ApiURL.AddUserToRole.toString());
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
}
