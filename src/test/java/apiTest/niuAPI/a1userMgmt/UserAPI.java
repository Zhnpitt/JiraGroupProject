package apiTest.niuAPI.a1userMgmt;

import apiTest.niuAPI.BaseAPI;
import io.restassured.response.Response;
import org.json.JSONObject;
import utils.AdminProperties;

import static io.restassured.RestAssured.given;

public class UserAPI extends BaseAPI{

    public UserAPI(){
        requestSpec.basePath("/rest/api/2/user");
    }

    //POST /rest/api/2/user
    public Response createUser(JSONObject userJson){
        Response response = given(requestSpec)
              .cookies(this.cookies)
              .auth().preemptive().basic("niushang1997", "qirV3*z!rWX2SGF")
              .body(userJson.toString())
              .when()
              .post();
        response.then().log().body();
        return response;
    }

    //PUT /rest/api/2/user
    public Response updateUser(String username, JSONObject updateBody){
        Response response = given(requestSpec)
              .cookies(cookies)
              .queryParam("name", username)
              .auth().preemptive().basic(AdminProperties.getAdminUsername(), AdminProperties.getAdminPassword())
              .body(updateBody)
              .when()
              .put();
        return response;
    }


    //GET /rest/api/2/user/search
    public Response findUsersByStatus(boolean status){
        String param = status ? "includeActive" : "includeInactive";
        Response response = given(requestSpec)
              .cookies(cookies)
              .queryParam(param, true)
              .auth().preemptive().basic(AdminProperties.getAdminUsername(), AdminProperties.getAdminPassword())
              .when()
              .post("search");
        return response;
    }
}