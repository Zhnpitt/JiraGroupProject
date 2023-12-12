package apiTest.constants;

public enum ApiURL {
    Login("rest/auth/1/session"),

    //role mgmt
    CreatePRJRole("/rest/api/2/role"),
    AddUserToRole("/rest/api/2/project/{projectIdOrKey}/role/{id}"),


    GetRolesInPRJ("/rest/api/2/project/{projectIdOrKey}/role"),
    GetUserInRole("/rest/api/2/project/{projectIdOrKey}/role/{id}"),
    CreatePermissionScheme("/rest/api/2/permissionscheme"),
    CreatePermissionGrant("/rest/api/2/permissionscheme/{schemeId}/permission"),

    //project mgmt
    CreateProject("/rest/api/2/project"),
    AssignPermissionScheme("Assign permission scheme"),
    CreateIssue("/rest/api/2/issue");






    private final String url;

    ApiURL(String path){
        this.url = path;
    }

    @Override
    public String toString(){
        return url;
    }


}