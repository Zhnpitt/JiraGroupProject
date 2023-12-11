package apiTest.niuAPI;

import io.restassured.response.Response;
import org.json.JSONObject;
import utils.AdminProperties;

import static io.restassured.RestAssured.given;

public class SessionAPI extends BaseAPI{
    public SessionAPI(){
        requestSpec.basePath("/rest/auth/1/session");
    }

    public Response loginWithCredential(String username, String password){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", username);
        jsonObject.put("password", password);
        Response response = given(requestSpec)
              .body(jsonObject.toString())
              .when()
              .post();

        return response;
    }

    public Response adminLoginWithCredential(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", AdminProperties.getAdminUsername());
        jsonObject.put("password", AdminProperties.getAdminPassword());
        Response response = given(requestSpec)
              .body(jsonObject.toString())
              .when()
              .post();
        return response;
    }


}