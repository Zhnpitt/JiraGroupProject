package apiTest.niuAPI.a1userMgmt;

import apiTest.niuAPI.BaseAPI;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class GroupAPI extends BaseAPI{

    public GroupAPI(){
        requestSpec.basePath("/rest/api/2/group");
    }

    //POST /rest/api/2/group/user
    public Response addUserToGroup(String groupName, JSONObject body){
        Response response = given(requestSpec)
              .cookies(cookies)
              .queryParam("groupname", groupName)
              .body(body)
              .when()
              .post("user");
        return response;
    }

    //GET /rest/api/2/group/member
    public Response getUserToGroup(String userGroup){
        Response response = given(requestSpec)
              .cookies(cookies)
              .queryParam("groupname", userGroup)
              .when()
              .get("member");
        return response;
    }
}