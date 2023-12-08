package uiTest.constants;

import utils.ApplicationProperties;

public enum UserRole {
    Developer("Developer"),
    TeamLead("Team lead"),
    QA("QA");


    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return role;
    }
}
