package apiTest.api;

import io.cucumber.java.en.Given;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class BaseAPI {
    protected static RequestSpecification requestSpec = given()
            .baseUri("http://localhost:8080")
            .contentType(ContentType.JSON);

    protected static ResponseSpecification responseSpec = given()
            .response()
            .time(Matchers.lessThan(10L), TimeUnit.SECONDS);

}
