package apiTest.constants;

public enum ApiURL {
    Login("rest/auth/1/session"),

    //create and assign role
    CreatePRJRole("/rest/api/2/role"),
    AddUserToRole("/rest/api/2/role/{id}/actors"),

    //filter users by role
    GetRolesInPRJ("/rest/api/2/project/{projectIdOrKey}/role"),
    GetUserInRole("/rest/api/2/project/{projectIdOrKey}/role/{id}"),
    GetUserKey("/rest/api/2/user/search"),

    //create permission scheme and grant
    CreatePermissionScheme("/rest/api/2/permissionscheme"),
    CreatePermissionGrant("/rest/api/2/permissionscheme/{schemeId}/permission"),

    //project mgmt
    CreateProject("/rest/api/2/project"),
    UpdateScheme("/rest/api/2/project/{projectIdOrKey}"),
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