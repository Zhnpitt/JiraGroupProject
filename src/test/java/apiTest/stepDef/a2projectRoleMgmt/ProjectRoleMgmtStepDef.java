package apiTest.stepDef.a2projectRoleMgmt;

import apiTest.enity.Permission;
import apiTest.enity.PermissionScheme;
import apiTest.enity.Project;
import apiTest.enity.ProjectRole;
import apiTest.niuAPI.BaseAPI;
import apiTest.zhouAPI.ProjectRoleAPI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class ProjectRoleMgmtStepDef {

    public static final ThreadLocal<Response> curResponse = new ThreadLocal<>();
    private final BaseAPI baseAPI = new BaseAPI();
    private final ProjectRoleAPI projectRoleAPI = new ProjectRoleAPI();

    //create a project
    @When("Admin create a project with name {} and key {}")
    public void adminCreateProjectWithNameAndKey(String name, String key){

        Project project = Project.builder()
                .name(name)
                .key(key)
                .projectTypeKey("software")
                .lead("John Doe")
                .build();
        Response response = projectRoleAPI.createAProject(project);
        curResponse.set(response);
    }

    //assign a scheme to project
    @When("I can apply an existing permission scheme {} to a project {}")
    public void adminApplyAnPermissionScheme(String schemeName, String projectKey){
        //get scheme ID
        int schemeID = projectRoleAPI.getPermissionSchemeID(schemeName);
        System.out.println("Scheme ID is " + schemeID);

        Response response = projectRoleAPI.upDateProjectScheme(schemeID, projectKey);
        curResponse.set(response);
    }

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
    }

    @Then("the project role mgmt response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int code){
        baseAPI.checkResponseStatusCode(curResponse.get(), code);
    }

    //add existing user to a project role
    @When("Admin add a User Name {} to a role name {}")
    public void adminSendUserNameAndRoleID(String userName, String roleName){
        //get user key and role id
        String userKey = projectRoleAPI.getUserKey(userName);
        int ID = projectRoleAPI.getRoleID2(roleName);

        System.out.println(userName);
        System.out.println(userKey);
        System.out.println(roleName);
        System.out.println(ID);

        Response role = projectRoleAPI.addUserToRole(userKey, ID);

        curResponse.set(role);//set and get
    }

    //filter user by role
    @When("Admin filter users with role name {}")
    public void adminFilterUsersWithRoleName(String roleName){
        String ID = projectRoleAPI.getRoleID(roleName);

        Response response2 = projectRoleAPI.filterUserByRole(ID);
        curResponse.set(response2);

        projectRoleAPI.findNameInResponse(response2.asString());

    }

    //create permission scheme
    @When("Admin create permission scheme with scheme name {} and description {}")
    public void adminCreatePermission(String name, String description){
        PermissionScheme permissionScheme = PermissionScheme.builder()
                .name(name)
                .description(description)
                .build();

        Response response = projectRoleAPI.createPermissionScheme(permissionScheme);
        curResponse.set(response);
    }

    //grant permissions to certain project role
    @When("Admin grant a role permission with type {},  role name {} and permission {}")
    public void adminSendTypeRoleNamePermission(String type, String roleName, String permission){
        //get role ID
        String roleID = projectRoleAPI.getRoleID(roleName);
        System.out.println("role ID is " + roleID);
        //get scheme ID
        int schemeID = projectRoleAPI.getPermissionSchemeID("PS-1");
        System.out.println("Scheme ID is " + schemeID);

        Permission permissionOBJ = Permission.builder()
                .permission(permission)
                .holder(Permission.Holder.builder()
                        .type(type)
                        .parameter(roleID)
                        .build())
                .build();

        Response response2 = projectRoleAPI.createPermissionGrant(permissionOBJ, schemeID);
        curResponse.set(response2);
    }

    //grant default permissions to all
    @When("Admin grant a default permission with type {} and permission {}")
    public void adminSendTypeAndPrmission(String type, String permission){
        //get scheme ID
        int schemeID = projectRoleAPI.getPermissionSchemeID("PS-1");
        System.out.println("Scheme ID is " + schemeID);

        Permission permissionOBJ = Permission.builder()
                .permission(permission)
                .holder(Permission.Holder.builder()
                        .type(type)
                        .build())
                .build();

        Response response2 = projectRoleAPI.createPermissionGrant(permissionOBJ, schemeID);
        curResponse.set(response2);
    }

    //create epics
    @When("team lead send a request with issue type {} and summary {} and {}")
    public void teamLeadSendIssueTypeAndSummary(String type, String summary, String projectKey){
        Response response = projectRoleAPI.createEpic(type, summary, projectKey);

        if (response.getStatusCode() >= 400) {
            System.out.println("Error: " + response.getBody().asString());
        }

        curResponse.set(response);
    }

}
