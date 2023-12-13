package apiTest.niuAPI;

import apiTest.stepDef.a4workflowMgmt.WorkflowMgmtStepDef;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SearchAPI extends BaseAPI{

    public SearchAPI(){
        requestSpec.basePath("/rest/api/2/search");
    }

    public Response search(String jql, String... params){
        Response response = given(requestSpec)
              .auth().preemptive().basic(WorkflowMgmtStepDef.curUsername.get(), WorkflowMgmtStepDef.curPassword.get())
              .queryParam("jql", jql)
              .when()
              .get();

        return response;
    }
}