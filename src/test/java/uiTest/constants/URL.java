package uiTest.constants;

import utils.ApplicationProperties;

import java.net.URI;
import java.net.URISyntaxException;

public enum URL {
    Login("login.jsp"),
    DashBoard("secure/Dashboard.jspa"),
    UserMgmt("secure/admin/user/UserBrowser.jspa"),
    CreateUser("secure/admin/user/AddUser!default.jspa"),
    ViewIssueTypes("secure/admin/ViewIssueTypes.jspa"),
    ListWorkflows("secure/admin/workflows/ListWorkflows.jspa"),
    ViewWorkflowSteps("secure/admin/workflows/ViewWorkflowSteps.jspa");

    private final String url;

    URL(String path) {
        this.url = ApplicationProperties.get("baseUrl") + path;
    }

    @Override
    public String toString() {
        return url;
    }
    public  static String removeQueryString(String urlString) {

        URI uri = null;
        try {
            uri = new URI(urlString);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        URI newUri = null;
        try {
            newUri = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), null, uri.getFragment());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return newUri.toString();
    }
}
