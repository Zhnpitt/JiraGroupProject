package apiTest.niuAPI;

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
              .queryParam("groupname", groupName)
              .body(body.toString())
              .when()
              .post("user");
        return response;
    }

    //GET /rest/api/2/group/member
    public Response getUserFromGroup(String userGroup){
        Response response = given(requestSpec)
              .queryParam("groupname", userGroup)
              .when()
              .get("member");
        response.then().statusCode(200);
        return response;
    }
}