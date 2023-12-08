package utils;

import lombok.Data;
import uiTest.constants.UserRole;

@Data
public class User {
    private String email;
    private String fullName;
    private String username;
    private String password;
    private UserRole role;
}