package apiTest.constants;

import utils.ApplicationProperties;

public enum ApiURL{
    Login("rest/auth/1/session");


    private final String url;

    ApiURL(String path){
        this.url = ApplicationProperties.get("baseUrl") + path;
    }

    @Override
    public String toString(){
        return url;
    }


}