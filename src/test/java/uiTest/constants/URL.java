package uiTest.constants;

import utils.ApplicationProperties;

public enum URL {
    Login("login.jsp"),
    Home("secure/Dashboard.jspa"),
    Administration("secure/PortfolioPermissions.jspa");

    private final String url;
    URL(String path) {
        this.url = ApplicationProperties.get("baseUrl") + path;
    }

    @Override
    public String toString() {
        return url;
    }
}
