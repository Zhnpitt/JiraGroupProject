package apiTest.niuAPI.a1userMgmt;

import apiTest.constants.ApiURL;
import apiTest.niuAPI.BaseAPI;
import io.restassured.response.Response;
import org.json.JSONObject;
import utils.AdminProperties;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserMgmtAPI extends BaseAPI{

    public Response createUser(Map<String, String> cookie, JSONObject userJson){
        Response response = given(requestSpec)
              .cookies(cookie)
              .auth().preemptive().basic(AdminProperties.getAdminUsername(), AdminProperties.getAdminPassword())
              .body(userJson)
              .when()
              .post(ApiURL.CreateUser.toString());

        return response;
    }
}