package apiTest.stepDef.a2projectRoleMgmt;

import apiTest.enity.Permission;
import apiTest.enity.PermissionScheme;
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
    @When("Admin send a request with User Name {} and role name {}")
    public void adminSendUserNameAndRoleID(String userName, String roleName){
        Response response = projectRoleAPI.getRolesResponse();
        String ID = projectRoleAPI.getRoleID(response, roleName);

        Response role = projectRoleAPI.addUserToRole(userName, ID);
        curResponse.set(role);//set and get
    }

    //filter user by role
    @When("Admin filter users with role name {}")
    public void adminFilterUsersWithRoleName(String roleName){
        Response response = projectRoleAPI.getRolesResponse();
        String ID = projectRoleAPI.getRoleID(response, roleName);

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
    @When("Admin send request with type {},  role name {} and permission {}")
    public void adminSendTypeRoleNamePermission(String type, String roleName, String permission){
        //get role ID
        Response response = projectRoleAPI.getRolesResponse();
        String roleID = projectRoleAPI.getRoleID(response, roleName);
        System.out.println("role ID is " + roleID);
        //get scheme ID
        int schemeID = projectRoleAPI.getPermissionSchemeID("asdasdw");
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
    @When("Admin send request with type {} and permission {}")
    public void adminSendTypeAndPrmission(String type, String permission){
        //get scheme ID
        int schemeID = projectRoleAPI.getPermissionSchemeID("asdasdw");
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

}
