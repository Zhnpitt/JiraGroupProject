package apiTest.constants;

public enum ApiURL{
    Login("rest/auth/1/session"),
    CreateUser("rest/api/2/user");

    private final String url;

    ApiURL(String path){
        this.url = path;
    }

    @Override
    public String toString(){
        return url;
    }


}