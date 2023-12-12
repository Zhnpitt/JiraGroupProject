package apiTest.niuAPI;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseAPI{
    protected RequestSpecification requestSpec = given()
          .baseUri("http://localhost:8080")
          .contentType(ContentType.JSON).auth().preemptive().basic("niushang1997", "qirV3*z!rWX2SGF");


    protected ResponseSpecification responseSpec = given().then()
          .response().log().body();

    protected Map<String, String> cookies;

    public void setCookie(Map<String, String> cookies){
        this.cookies = cookies;
    }

}