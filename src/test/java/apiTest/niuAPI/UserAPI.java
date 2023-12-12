package apiTest.niuAPI;


import apiTest.constants.ApiURL;
import apiTest.enity.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserAPI extends BaseAPI{

    public Response loginWithCredential(User payload){

        Response response = given(requestSpec)
              .body(payload)
              .when()
              .post(ApiURL.Login.toString());
        response.then()
              .spec(responseSpec);

        return response;
    }


}