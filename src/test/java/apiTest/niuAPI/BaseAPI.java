package apiTest.niuAPI;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseAPI{
    protected RequestSpecification requestSpec = given()
          .baseUri("http://localhost:8080")
          .contentType(ContentType.JSON);

    protected ResponseSpecification responseSpec = given().then()
          .response().log().body();

    protected Map<String, String> cookies;

    public void setCookies(Map<String, String> cookies){
        this.cookies = cookies;
    }

}