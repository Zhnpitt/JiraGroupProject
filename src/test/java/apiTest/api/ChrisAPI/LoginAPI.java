package apiTest.api.ChrisAPI;

import apiTest.api.BaseAPI;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.apache.poi.poifs.crypt.agile.AgileEncryptionVerifier;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginAPI extends BaseAPI {
    public LoginAPI(){
        requestSpec.basePath("/rest/auth/1/session");
    }

    public static Response loginAsAdmin(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", "zhangchris280");
        jsonObject.put("password", "Zhn122737");

        Response response = given(requestSpec)
                .when()
                .body(jsonObject.toString())
                .post();
        response.then().log().body();
        return response;
    }

}
