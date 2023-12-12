package apiTest.zhouAPI;

import apiTest.constants.ApiURL;
import apiTest.enity.Actor;
import apiTest.enity.ProjectRole;
import apiTest.niuAPI.BaseAPI;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.cucumber.java.bs.A;
import io.cucumber.java.en_old.Ac;
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
    public String getID(Response response, String roleName){
        JSONObject jsonObject = new JSONObject(response.asString());
        String roleURL = jsonObject.getString(roleName);
        String ID = roleURL.substring(roleURL.lastIndexOf('/') + 1);
        System.out.println(ID);
        return ID;
    }

    public Response addUserToRole(String userName, String id){

        String URL = "http://localhost:8080/rest/api/2/project/PROJ/role/" + id;

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

//        response.then()
//                .spec(responseSpec);



        return response;
    }

    public Response filterUserByRole(String id){
        String URL = "http://localhost:8080/rest/api/2/role/" + id +  "/actors";

        Response response = given(requestSpec)
                .auth().preemptive().basic("zhoulikekk", "Whou3344603~")
                .when()
                .post(URL);

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

        // 遍历数组查找 "name"
        for (int i = 0; i < actors.length(); i++) {
            JSONObject actor = actors.getJSONObject(i);
            String name = actor.getString("name");
            result.add(name);
        }
        return result;
    }
}
