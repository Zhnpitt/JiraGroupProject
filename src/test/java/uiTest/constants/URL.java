package uiTest.constants;

import utils.ApplicationProperties;

public enum URL {
    Login("login.jsp"),
    DashBoard("secure/Dashboard.jspa"),
    userMgmt("secure/admin/user/UserBrowser.jspa");
    private final String url;
    URL(String path) {
        this.url = ApplicationProperties.get("baseUrl") + path;
    }

    @Override
    public String toString() {
        return url;
    }
}
