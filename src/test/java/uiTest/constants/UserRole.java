package uiTest.constants;

import com.fasterxml.jackson.annotation.JsonCreator;
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

    @JsonCreator
    public static UserRole fromString(String value) {
        String normalizedValue = value.replaceAll("\\s", "");
        for (UserRole role : UserRole.values()) {
            String normalizedRole = role.toString().replaceAll("\\s", "");
            if (normalizedRole.equalsIgnoreCase(normalizedValue)) {
                return role;
            }
        }
        throw new IllegalArgumentException("Unknown UserRole: " + value);
    }
}
