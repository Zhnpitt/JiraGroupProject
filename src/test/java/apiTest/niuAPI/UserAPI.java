package apiTest.niuAPI;

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
              .auth().preemptive().basic(AdminProperties.getAdminUsername(), AdminProperties.getAdminPassword())
              .auth().preemptive().basic("niushang1997", "qirV3*z!rWX2SGF")
              .body(userJson.toString())
              .when()
              .post();
        //response.then().log().body();
        return response;
    }

    //PUT /rest/api/2/user
    public Response updateUser(String username, JSONObject updateBody){
        Response response = given(requestSpec)
              .queryParam("username", username)
              .auth().preemptive().basic(AdminProperties.getAdminUsername(), AdminProperties.getAdminPassword())
              .body(updateBody.toString())
              .when()
              .put();
        //response.then().log().body();
        return response;
    }


    //GET /rest/api/2/user/search
    public Response findUsersByStatus(boolean status, String username){
        String param = status ? "includeActive" : "includeInactive";
        Response response = given(requestSpec)
              .auth().preemptive().basic(AdminProperties.getAdminUsername(), AdminProperties.getAdminPassword())
              .queryParam("username", username)
              .queryParam(param, true)
              .when()
              .get("search");
        return response;
    }
}