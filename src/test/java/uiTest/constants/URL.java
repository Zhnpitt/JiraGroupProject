package uiTest.constants;

import utils.ApplicationProperties;

import java.util.List;

public enum URL {
    Login("login.jsp"),
    DashBoard("secure/Dashboard.jspa"),
    UserMgmt("secure/admin/user/UserBrowser.jspa"),
    CreateUser("secure/admin/user/AddUser!default.jspa");

    private final String url;
    URL(String path) {
        this.url = ApplicationProperties.get("baseUrl") + path;
    }

    @Override
    public String toString() {
        return url;
    }
}
