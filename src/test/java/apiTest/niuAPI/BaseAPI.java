package apiTest.niuAPI;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class BaseAPI{
    protected RequestSpecification requestSpec = given()
          .baseUri("http://localhost:8080")
          .contentType(ContentType.JSON);


    protected ResponseSpecification responseSpec = given().then()
          .response().log().body();

    public void checkResponseStatusCode(Response response, int code){
        response.then().statusCode(code);
    }
}