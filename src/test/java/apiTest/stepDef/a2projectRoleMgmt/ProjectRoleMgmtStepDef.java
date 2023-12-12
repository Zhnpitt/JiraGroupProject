package apiTest.stepDef.a2projectRoleMgmt;

import apiTest.enity.Actor;
import apiTest.enity.ProjectRole;
import apiTest.niuAPI.BaseAPI;
import apiTest.zhouAPI.ProjectRoleAPI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.JSONArray;

public class ProjectRoleMgmtStepDef {

    public static final ThreadLocal<Response> curResponse = new ThreadLocal<>();
    public static final ThreadLocal<Response> addActorToARoleResponse = new ThreadLocal<>();
    private static final ThreadLocal<ProjectRole> curRole = new ThreadLocal<>();
    private final BaseAPI baseAPI = new BaseAPI();
    private final ProjectRoleAPI projectRoleAPI = new ProjectRoleAPI();

    //create project role
    @When("Admin send request with role name {} and role description {}")
    public void adminSendRoleNameAndDescription(String roleName, String roleDescription ){
        ProjectRole role = ProjectRole.builder()
                .name(roleName)
                .description(roleDescription)
                .build();

        curResponse.set(
                new ProjectRoleAPI().sendNewRole(role)
        );
        curRole.set(role);
    }
    @Then("the project role mgmt response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int code){
        baseAPI.checkResponseStatusCode(curResponse.get(), code);
    }


    //add existing user to a project role
    @When("Admin send a request with User Name {} and role name {}")
    public void adminSendUserNameAndRoleID(String userName, String roleName){
        Response response = projectRoleAPI.getRolesResponse();
        String ID = projectRoleAPI.getID(response, roleName);

        Response role = projectRoleAPI.addUserToRole(userName, ID);
        curResponse.set(role);
    }

    @When("Admin filter users with role name {}")
    public void adminFilterUsersWithRoleName(String roleName){
        Response response = projectRoleAPI.getRolesResponse();
        String ID = projectRoleAPI.getID(response, roleName);

        Response response2 = projectRoleAPI.filterUserByRole(ID);
        projectRoleAPI.findNameInResponse(response2.asString());

    }

}
