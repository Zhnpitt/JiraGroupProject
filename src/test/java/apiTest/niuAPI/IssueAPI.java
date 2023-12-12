package apiTest.niuAPI;

import io.restassured.response.Response;
import org.json.JSONObject;
import utils.AdminProperties;

import static io.restassured.RestAssured.given;

public class IssueAPI extends BaseAPI{

    public IssueAPI(){
        requestSpec.basePath("/rest/api/2/issue");
    }

    //POST /rest/api/2/issue
    public Response createIssue(JSONObject body){
        Response response = given(requestSpec)
              .auth().preemptive().basic(AdminProperties.getAdminUsername(), AdminProperties.getAdminPassword())
              .body(body.toString())
              .when()
              .post();
        response.then().statusCode(201);
        return response;
    }

    //GET /rest/api/2/issue/{issueIdOrKey}
    public Response getIssue(JSONObject body, String issueIdOrKey){
        Response response = given(requestSpec)
              .cookies(cookies)
              .pathParam("issueIdOrKey", issueIdOrKey)
              .body(body.toString())
              .when()
              .get("{issueIdOrKey}");

        response.then().statusCode(200);
        return response;
    }

    //GET /rest/api/2/issue/{issueIdOrKey}/transitions
    public Response getTransitions(String issueIdOrKey){
        Response response = given(requestSpec)
              .cookies(cookies)
              .pathParam("issueIdOrKey", issueIdOrKey)
              .when()
              .get("{issueIdOrKey}/transitions");
        response.then().statusCode(200);
        return response;
    }

    //POST /rest/api/2/issue/{issueIdOrKey}/transitions
    public Response doTransition(String issueIdOrKey, JSONObject body){
        Response response = given(requestSpec)
              .pathParam("issueIdOrKey", issueIdOrKey)
              .body(body)
              .when()
              .post("{issueIdOrKey}/transitions");
        response.then().statusCode(204);
        return response;
    }

}